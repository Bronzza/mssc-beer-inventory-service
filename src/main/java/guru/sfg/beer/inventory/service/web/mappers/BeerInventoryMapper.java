package guru.sfg.beer.inventory.service.web.mappers;

import guru.sfg.beer.inventory.service.domain.BeerInventory;
import common.model.BeerInventoryDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 2019-05-31.
 */
@Mapper(uses = {DateMapper.class})
@Component
public interface BeerInventoryMapper {

    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO);

    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
