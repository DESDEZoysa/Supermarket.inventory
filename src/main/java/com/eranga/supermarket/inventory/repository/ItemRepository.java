package com.eranga.supermarket.inventory.repository;

import com.eranga.supermarket.inventory.model.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity,Integer> {
}
