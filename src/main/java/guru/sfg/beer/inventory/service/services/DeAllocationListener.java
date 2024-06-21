package guru.sfg.beer.inventory.service.services;

import common.events.AllocationBeerOrderRequest;
import common.events.AllocationBeerOrderResponse;
import common.events.DeAllocationBeerOrderRequest;
import guru.sfg.beer.inventory.service.config.JmsConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeAllocationListener {
    private final AllocationService allocationService;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.DE_ALLOCATION_BEER_ORDER_REQUEST)
    public void listen(DeAllocationBeerOrderRequest event) {
            allocationService.deAllocateOrder(event.getBeerOrder());

    }
}
