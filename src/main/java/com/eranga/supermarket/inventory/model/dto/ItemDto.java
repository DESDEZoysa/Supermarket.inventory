package com.eranga.supermarket.inventory.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemDto {

    private Integer id;
    private Integer itemCategoryId;
    private String name;
}
