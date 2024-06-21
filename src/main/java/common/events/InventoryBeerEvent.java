package common.events;

import common.model.BeerDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InventoryBeerEvent extends BeerEvent{

    public InventoryBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
