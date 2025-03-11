package com.eranga.supermarket.inventory.service;

import com.eranga.supermarket.inventory.model.dto.*;

public interface InventoryService {

    ItemCategoryDto createItemCategory(ItemCategoryDto itemCategoryDto);
    ItemDto createItem(ItemDto itemDto);
    ItemBrandDto createBrand(ItemBrandDto itemBrandDto);
    BrandBatchDto createBatch(BrandBatchDto brandBatchDto);
    void updateBatchQuantity(BatchQuantityUpdateDto batchQuantityUpdateDto);
}
