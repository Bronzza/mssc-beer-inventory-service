package guru.sfg.beer.inventory.service.services;

import guru.sfg.beer.inventory.service.config.JmsConfig;
import guru.sfg.beer.inventory.service.domain.BeerInventory;
import common.events.InventoryBeerEvent;
import guru.sfg.beer.inventory.service.repositories.BeerInventoryRepository;
import guru.sfg.beer.inventory.service.web.mappers.BeerDtoInventoryDtoMapper;
import common.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BeerInventoryListener {

    private final BeerInventoryRepository repository;
    //    private final JmsTemplate jmsTemplate;
    private final BeerDtoInventoryDtoMapper dtoMapper;

    @Transactional
    @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
    public void listen(InventoryBeerEvent event) {
        BeerDto beerDto = event.getBeerDto();
        BeerInventory result = repository.save(dtoMapper.beerDtoToInventory(beerDto));
        log.info("Inventory has been created {}:", result);
    }
}
