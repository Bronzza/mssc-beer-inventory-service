package guru.sfg.beer.inventory.service.web.mappers;

import common.model.BeerDto;
import guru.sfg.beer.inventory.service.domain.BeerInventory;
import guru.sfg.beer.inventory.service.domain.BeerInventory.BeerInventoryBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T16:35:42+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class BeerDtoInventoryDtoMapperImpl implements BeerDtoInventoryDtoMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerInventory beerDtoToInventory(BeerDto beerDto) {
        if ( beerDto == null ) {
            return null;
        }

        BeerInventoryBuilder beerInventory = BeerInventory.builder();

        beerInventory.beerId( beerDto.getId() );
        beerInventory.id( beerDto.getId() );
        if ( beerDto.getVersion() != null ) {
            beerInventory.version( beerDto.getVersion().longValue() );
        }
        beerInventory.createdDate( dateMapper.asTimestamp( beerDto.getCreatedDate() ) );
        beerInventory.lastModifiedDate( dateMapper.asTimestamp( beerDto.getLastModifiedDate() ) );
        beerInventory.upc( beerDto.getUpc() );
        beerInventory.quantityOnHand( beerDto.getQuantityOnHand() );

        return beerInventory.build();
    }
}
