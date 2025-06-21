package com.driagon.services.dto;

import com.driagon.services.constants.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1797846432114249428L;

    private Long id;
    private BigDecimal totalAmount;
    private OrderStatus status;
    private List<OrderItemDto> items;
    private LocalDateTime createdAt;
}