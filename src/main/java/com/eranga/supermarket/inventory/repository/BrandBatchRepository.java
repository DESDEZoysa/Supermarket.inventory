package com.eranga.supermarket.inventory.repository;

import com.eranga.supermarket.inventory.model.entity.BrandBatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BrandBatchRepository extends JpaRepository<BrandBatchEntity,Integer> {

}
