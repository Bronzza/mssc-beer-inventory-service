package guru.sfg.beer.inventory.service.web.mappers;


import guru.sfg.beer.inventory.service.domain.BeerInventory;
import common.model.BeerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(uses = DateMapper.class)
@Component
public interface BeerDtoInventoryDtoMapper {

    @Mapping(target = "beerId", source = "id")
    BeerInventory beerDtoToInventory(BeerDto beerDto);

}
