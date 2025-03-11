package com.eranga.supermarket.inventory.model.dto;

import com.eranga.supermarket.inventory.model.enums.OrderFailReasonEnum;
import com.eranga.supermarket.inventory.model.enums.OrderStatusEnum;
import com.eranga.supermarket.inventory.model.enums.PaymentMethodEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private Integer customerId;
    @NotBlank(message = "orderDate cannot be blank")
    private String orderDate;
    @NotNull(message = "Order status cannot be blank")
    private OrderStatusEnum status;
    private OrderFailReasonEnum failReason;
    @NotNull(message = "Payment method cannot be null")
    private PaymentMethodEnum method;
    @NotNull(message = "Order amount cannot be blank")
    private Double amount;
    @NotEmpty(message = "Order item list cannot be blank")
    private List<OrderItemDto> orderItemDtoList;
}
