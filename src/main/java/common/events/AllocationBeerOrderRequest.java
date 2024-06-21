package common.events;

import common.model.BeerOrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllocationBeerOrderRequest implements Serializable {

    private static final long serialVersionUID = -7571711683221690648L;
    private BeerOrderDto beerOrder;
}
