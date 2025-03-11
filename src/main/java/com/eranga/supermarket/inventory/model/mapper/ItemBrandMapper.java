package com.eranga.supermarket.inventory.model.mapper;

import com.eranga.supermarket.inventory.model.dto.ItemBrandDto;
import com.eranga.supermarket.inventory.model.entity.ItemBrandEntity;
import com.eranga.supermarket.inventory.model.entity.ItemEntity;
import com.eranga.supermarket.inventory.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemBrandMapper {

    private final ItemRepository itemRepository;

    public ItemBrandEntity itemBrandDtoToEntity(ItemBrandDto itemBrandDto){
        ItemBrandEntity itemBrandEntity = new ItemBrandEntity();
        BeanUtils.copyProperties(itemBrandDto,itemBrandEntity);
        itemBrandEntity.setItemEntity(itemRepository.findById(itemBrandDto.getItemId()).orElseThrow());
        return itemBrandEntity;
    }

    public ItemBrandDto itemBrandEntityToDto(ItemBrandEntity itemBrandEntity){
        ItemBrandDto itemBrandDto = new ItemBrandDto();
        BeanUtils.copyProperties(itemBrandEntity,itemBrandDto);
        itemBrandDto.setItemId(itemBrandEntity.getItemEntity().getId());
        return itemBrandDto;
    }
}
