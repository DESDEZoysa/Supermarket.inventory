package com.eranga.supermarket.inventory.service;

public interface KafkaService {

    void consumeNewOrderEvent(String message);
}
