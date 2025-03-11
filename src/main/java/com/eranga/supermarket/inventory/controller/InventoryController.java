package com.eranga.supermarket.inventory.controller;

import com.eranga.supermarket.inventory.model.dto.*;
import com.eranga.supermarket.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping("/category")
    public ItemCategoryDto createItemCategory(@RequestBody ItemCategoryDto itemCategoryDto){
        return inventoryService.createItemCategory(itemCategoryDto);
    }

    @PostMapping("/item")
    public ItemDto createItem(@RequestBody ItemDto itemDto){
        return inventoryService.createItem(itemDto);
    }

    @PostMapping("/brand")
    public ItemBrandDto createBrand(@RequestBody ItemBrandDto itemBrandDto){
        return inventoryService.createBrand(itemBrandDto);
    }

    @PostMapping("/batch")
    public BrandBatchDto createBatch(@RequestBody BrandBatchDto brandBatchDto){
        return inventoryService.createBatch(brandBatchDto);
    }

    @PutMapping("/batch/updateQuantity")
    public void getItemCategory(@RequestBody BatchQuantityUpdateDto batchQuantityUpdateDto){
        inventoryService.updateBatchQuantity(batchQuantityUpdateDto);
    }


}
