package com.eranga.supermarket.inventory.repository;

import com.eranga.supermarket.inventory.model.entity.ItemBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemBrandRepository extends JpaRepository<ItemBrandEntity,Integer> {
}
