package com.eranga.supermarket.inventory.model.mapper;

import com.eranga.supermarket.inventory.model.dto.ItemDto;
import com.eranga.supermarket.inventory.model.entity.ItemCategoryEntity;
import com.eranga.supermarket.inventory.model.entity.ItemEntity;
import com.eranga.supermarket.inventory.repository.ItemCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemMapper {

    private final ItemCategoryRepository itemCategoryRepository;

    public ItemEntity itemDtoToEntity(ItemDto itemDto){
        ItemEntity itemEntity = new ItemEntity();
        BeanUtils.copyProperties(itemDto,itemEntity);
        itemEntity.setItemCategoryEntity(itemCategoryRepository.findById(itemDto.getItemCategoryId()).orElseThrow());
        return itemEntity;
    }

    public ItemDto itemEntityToDto(ItemEntity itemEntity){
        ItemDto itemDto = new ItemDto();
        BeanUtils.copyProperties(itemEntity,itemDto);
        itemDto.setItemCategoryId(itemEntity.getItemCategoryEntity().getId());
        return itemDto;
    }
}
