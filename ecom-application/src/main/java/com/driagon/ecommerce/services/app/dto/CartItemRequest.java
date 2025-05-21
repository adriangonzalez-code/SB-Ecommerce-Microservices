package com.driagon.ecommerce.services.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * DTO for {@link com.driagon.ecommerce.services.app.models.CartItem}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CartItemRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 5461615352315206031L;

    private Long productId;
    private Integer quantity;
}