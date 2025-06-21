package com.driagon.services.mappers;

import com.driagon.services.dto.OrderItemDto;
import com.driagon.services.dto.OrderResponse;
import com.driagon.services.entities.Order;

import java.math.BigDecimal;

public class OrderMapper {

    public static OrderResponse mapOrderToOrderResponse(Order order) {
        if (order == null) {
            return null;
        }

        return OrderResponse.builder()
                .id(order.getId())
                .totalAmount(order.getTotalAmount())
                .status(order.getStatus())
                .createdAt(order.getCreatedAt())
                .items(order.getOrderItems().stream().map(oi -> OrderItemDto.builder()
                            .id(oi.getId())
                            .productId(oi.getProductId())
                            .quantity(oi.getQuantity())
                            .price(oi.getPrice())
                            .subtotal(oi.getPrice().multiply(new BigDecimal(oi.getQuantity())))
                            .build()
                ).toList())
                .build();
    }
}