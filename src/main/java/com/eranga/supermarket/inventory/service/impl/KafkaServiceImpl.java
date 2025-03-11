package com.eranga.supermarket.inventory.service.impl;

import com.eranga.supermarket.inventory.model.dto.OrderDto;
import com.eranga.supermarket.inventory.model.enums.QuantityUpdateTypeEnum;
import com.eranga.supermarket.inventory.model.mapper.BrandBatchMapper;
import com.eranga.supermarket.inventory.service.InventoryService;
import com.eranga.supermarket.inventory.service.KafkaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaServiceImpl implements KafkaService {

    private final InventoryService inventoryService;
    private final BrandBatchMapper brandBatchMapper;

    private static final Logger logger = LoggerFactory.getLogger(KafkaServiceImpl.class);

    @Override
    @RetryableTopic(
            attempts = "${spring.kafka.consumer.attempts}",
            backoff = @Backoff(delay = 6000, multiplier = 2,maxDelay = 100000)
    )
    @KafkaListener(topics = "${spring.kafka.topic.new_order}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeNewOrderEvent(String message) {
        logger.info("Receive new order event = {}", message);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            OrderDto orderDto = objectMapper.readValue(message, OrderDto.class);
            orderDto.getOrderItemDtoList().forEach(
                    orderItemDto ->
                            inventoryService.updateBatchQuantity(brandBatchMapper.orderItemDtoToBatchQuantityUpdateDto(orderItemDto, QuantityUpdateTypeEnum.Reduce))
            );
        }catch (Exception e){
            logger.error("Error while processing new order event {}", message);
            throw new RuntimeException();
        }
    }

    @DltHandler
    private void consumeNewOrderEventDLT(String message) {
        logger.info("Send new order event to dead letter topic= {}", message);
    }
}
