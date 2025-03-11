package com.eranga.supermarket.inventory.model.mapper;

import com.eranga.supermarket.inventory.model.dto.ItemCategoryDto;
import com.eranga.supermarket.inventory.model.entity.ItemCategoryEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ItemCategoryMapper {

    public ItemCategoryEntity itemCategoryDtoToEntity(ItemCategoryDto itemCategoryDto){
        ItemCategoryEntity itemCategoryEntity = new ItemCategoryEntity();
        BeanUtils.copyProperties(itemCategoryDto,itemCategoryEntity);
        return itemCategoryEntity;
    }

    public ItemCategoryDto itemCategoryEntityToDto(ItemCategoryEntity itemCategoryEntity){
        ItemCategoryDto itemCategoryDto = new ItemCategoryDto();
        BeanUtils.copyProperties(itemCategoryEntity,itemCategoryDto);
        return itemCategoryDto;
    }
}
