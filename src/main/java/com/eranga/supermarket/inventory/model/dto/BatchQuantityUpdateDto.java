package com.eranga.supermarket.inventory.model.dto;

import com.eranga.supermarket.inventory.model.enums.QuantityUpdateTypeEnum;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchQuantityUpdateDto {

    private Integer batchId;
    private Integer quantity;
    private QuantityUpdateTypeEnum type;
}
