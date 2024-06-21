package common.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidateBeerOrderRequest {

    private BeerOrderDto beerOrderDto;
}
