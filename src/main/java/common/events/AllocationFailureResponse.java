package common.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllocationFailureResponse implements Serializable {

    private static final long serialVersionUID = -1744027147796369524L;
    private UUID orderId;
}
