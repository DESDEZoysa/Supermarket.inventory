package com.eranga.supermarket.inventory.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemBrandDto {

    private Integer id;
    private Integer itemId;
    private String name;
}
