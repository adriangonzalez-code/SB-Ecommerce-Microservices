package com.driagon.ecommerce.services.app.mappers;

import com.driagon.ecommerce.services.app.dto.OrderItemDto;
import com.driagon.ecommerce.services.app.dto.OrderResponse;
import com.driagon.ecommerce.services.app.models.Order;

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
                            .productId(oi.getProduct().getId())
                            .quantity(oi.getQuantity())
                            .price(oi.getPrice())
                            .subtotal(oi.getPrice().multiply(new BigDecimal(oi.getQuantity())))
                            .build()
                ).toList())
                .build();
    }
}