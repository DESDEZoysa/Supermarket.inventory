package com.eranga.supermarket.inventory.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemDto {

    private Long id;
    private Long orderId;
    @NotNull(message = "Batch id cannot be null")
    private Integer batchId;
    @NotNull(message = "Quantity cannot be null")
    private Integer quantity;
    private Double discount;
}
