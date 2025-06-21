package com.driagon.services.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderItemDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 2646429820798386281L;

    private Long id;
    private Long productId;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subtotal;
}