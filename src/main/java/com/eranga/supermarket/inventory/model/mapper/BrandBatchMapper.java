package com.eranga.supermarket.inventory.model.mapper;

import com.eranga.supermarket.inventory.model.dto.BatchQuantityUpdateDto;
import com.eranga.supermarket.inventory.model.dto.BrandBatchDto;
import com.eranga.supermarket.inventory.model.dto.OrderItemDto;
import com.eranga.supermarket.inventory.model.entity.BrandBatchEntity;
import com.eranga.supermarket.inventory.model.entity.ItemBrandEntity;
import com.eranga.supermarket.inventory.model.enums.QuantityUpdateTypeEnum;
import com.eranga.supermarket.inventory.repository.ItemBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BrandBatchMapper {

    private final ItemBrandRepository itemBrandRepository;

    public BrandBatchEntity BrandBatchDtoToEntity(BrandBatchDto brandBatchDto){
        BrandBatchEntity brandBatchEntity = new BrandBatchEntity();
        BeanUtils.copyProperties(brandBatchDto,brandBatchEntity);
        brandBatchEntity.setItemBrandEntity(itemBrandRepository.findById(brandBatchDto.getBrandId()).orElseThrow());
        return brandBatchEntity;
    }

    public BrandBatchDto BrandBatchEntityToDto(BrandBatchEntity brandBatchEntity){
        BrandBatchDto brandBatchDto = new BrandBatchDto();
        BeanUtils.copyProperties(brandBatchEntity,brandBatchDto);
        brandBatchDto.setBrandId(brandBatchEntity.getItemBrandEntity().getId());
        return brandBatchDto;
    }

    public BatchQuantityUpdateDto orderItemDtoToBatchQuantityUpdateDto(OrderItemDto orderItemDto, QuantityUpdateTypeEnum quantityUpdateTypeEnum){
        return BatchQuantityUpdateDto.builder()
                .batchId(orderItemDto.getBatchId())
                .quantity(orderItemDto.getQuantity())
                .type(quantityUpdateTypeEnum)
                .build();
    }
}
