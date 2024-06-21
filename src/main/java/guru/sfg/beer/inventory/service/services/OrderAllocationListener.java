package guru.sfg.beer.inventory.service.services;

import common.events.AllocationBeerOrderRequest;
import common.events.AllocationBeerOrderResponse;
import common.events.InventoryBeerEvent;
import common.model.BeerDto;
import common.model.BeerOrderDto;
import guru.sfg.beer.inventory.service.config.JmsConfig;
import guru.sfg.beer.inventory.service.domain.BeerInventory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderAllocationListener {

    private final AllocationService allocationService;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.BEER_ORDER_ALLOCATION_REQUEST)
    public void listen(AllocationBeerOrderRequest event) {
        Boolean isError = false;
        Boolean allocationResult = false;
        try {
           allocationResult = allocationService.allocateOrder(event.getBeerOrder());
        } catch (Exception e) {
            isError = true;
            log.error("Allocation failed for Order Id: {}", event.getBeerOrder().getId());
        }
        boolean pendingInventory = !allocationResult;
        AllocationBeerOrderResponse response = new AllocationBeerOrderResponse(event.getBeerOrder(), isError, pendingInventory);
        jmsTemplate.convertAndSend(JmsConfig.BEER_ORDER_ALLOCATION_RESPONSE, response);
        log.info("Response has send to beer order service:  {}:", response);
    }
}
