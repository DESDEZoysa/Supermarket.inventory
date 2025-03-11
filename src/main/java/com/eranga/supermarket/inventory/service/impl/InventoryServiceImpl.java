package com.eranga.supermarket.inventory.service.impl;

import com.eranga.supermarket.inventory.model.dto.*;
import com.eranga.supermarket.inventory.model.entity.BrandBatchEntity;
import com.eranga.supermarket.inventory.model.entity.ItemBrandEntity;
import com.eranga.supermarket.inventory.model.entity.ItemCategoryEntity;
import com.eranga.supermarket.inventory.model.entity.ItemEntity;
import com.eranga.supermarket.inventory.model.enums.QuantityUpdateTypeEnum;
import com.eranga.supermarket.inventory.model.mapper.BrandBatchMapper;
import com.eranga.supermarket.inventory.model.mapper.ItemBrandMapper;
import com.eranga.supermarket.inventory.model.mapper.ItemCategoryMapper;
import com.eranga.supermarket.inventory.model.mapper.ItemMapper;
import com.eranga.supermarket.inventory.repository.BrandBatchRepository;
import com.eranga.supermarket.inventory.repository.ItemBrandRepository;
import com.eranga.supermarket.inventory.repository.ItemCategoryRepository;
import com.eranga.supermarket.inventory.repository.ItemRepository;
import com.eranga.supermarket.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final ItemCategoryRepository itemCategoryRepository;
    private final ItemRepository itemRepository;
    private final ItemBrandRepository itemBrandRepository;
    private final BrandBatchRepository brandBatchRepository;
    private final ItemCategoryMapper itemCategoryMapper;
    private final ItemMapper itemMapper;
    private final ItemBrandMapper itemBrandMapper;
    private final BrandBatchMapper brandBatchMapper;

    @Override
    public ItemCategoryDto createItemCategory(ItemCategoryDto itemCategoryDto) {
        ItemCategoryEntity itemCategoryEntity = itemCategoryRepository.save(itemCategoryMapper.itemCategoryDtoToEntity(itemCategoryDto));
        return itemCategoryMapper.itemCategoryEntityToDto(itemCategoryEntity);
    }

    @Override
    public ItemDto createItem(ItemDto itemDto) {
        ItemEntity itemEntity = itemRepository.save(itemMapper.itemDtoToEntity(itemDto));
        return itemMapper.itemEntityToDto(itemEntity);
    }

    @Override
    public ItemBrandDto createBrand(ItemBrandDto itemBrandDto) {
        ItemBrandEntity itemBrandEntity = itemBrandRepository.save(itemBrandMapper.itemBrandDtoToEntity(itemBrandDto));
        return itemBrandMapper.itemBrandEntityToDto(itemBrandEntity);
    }

    @Override
    public BrandBatchDto createBatch(BrandBatchDto brandBatchDto) {
        BrandBatchEntity brandBatchEntity = brandBatchRepository.save(brandBatchMapper.BrandBatchDtoToEntity(brandBatchDto));
        return brandBatchMapper.BrandBatchEntityToDto(brandBatchEntity);
    }

    @Override
    public void updateBatchQuantity(BatchQuantityUpdateDto batchQuantityUpdateDto) {
        BrandBatchEntity brandBatchEntity= brandBatchRepository.findById(batchQuantityUpdateDto.getBatchId()).orElseThrow();
        if(QuantityUpdateTypeEnum.Reduce.equals(batchQuantityUpdateDto.getType())){
            if(batchQuantityUpdateDto.getQuantity()<=brandBatchEntity.getQuantity()){
                brandBatchEntity.setQuantity(brandBatchEntity.getQuantity()-batchQuantityUpdateDto.getQuantity());
                brandBatchRepository.save(brandBatchEntity);
            }else{
                throw new RuntimeException();
            }
        }else if(QuantityUpdateTypeEnum.Increase.equals(batchQuantityUpdateDto.getType())){
            brandBatchEntity.setQuantity(brandBatchEntity.getQuantity()+batchQuantityUpdateDto.getQuantity());
            brandBatchRepository.save(brandBatchEntity);
        }
    }

}
