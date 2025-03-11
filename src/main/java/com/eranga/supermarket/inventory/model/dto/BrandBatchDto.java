package com.eranga.supermarket.inventory.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BrandBatchDto {

    private Integer id;
    private Integer brandId;
    private String madeInDate;
    private String expairyDate;
    private Integer quantity;
    private Integer unitPrice;
}
