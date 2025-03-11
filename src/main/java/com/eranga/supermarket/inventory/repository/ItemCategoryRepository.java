package com.eranga.supermarket.inventory.repository;

import com.eranga.supermarket.inventory.model.entity.ItemCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategoryEntity,Integer> {
}
