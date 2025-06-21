package com.driagon.services.services;

import com.driagon.services.constants.OrderStatus;
import com.driagon.services.dto.OrderResponse;
import com.driagon.services.entities.CartItem;
import com.driagon.services.entities.Order;
import com.driagon.services.entities.OrderItem;
import com.driagon.services.repositories.IOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.driagon.services.mappers.OrderMapper.mapOrderToOrderResponse;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final ICartService cartService;

    private final IOrderRepository orderRepository;

    @Override
    public Optional<OrderResponse> createOrder(String userId) {
        // Validation for cart items
        List<CartItem> cartItems = this.cartService.getCart(userId);

        if (cartItems == null || cartItems.isEmpty()) {
            return Optional.empty();
        }

        // Create order
        Order order = new Order();
        order.setUserId(Long.valueOf(userId));
        order.setStatus(OrderStatus.CONFIRMED);
        List<OrderItem> orderItems = cartItems.stream()
                .map(cartItem -> OrderItem.builder()
                        .productId(cartItem.getProductId())
                        .quantity(cartItem.getQuantity())
                        .price(cartItem.getPrice())
                        .order(order)
                        .build())
                .toList();
        order.setTotalAmount(orderItems.stream().map(i -> {
            BigDecimal price = i.getPrice();
            int quantity = i.getQuantity();
            return price.multiply(BigDecimal.valueOf(quantity));
        }).reduce(BigDecimal.ZERO, BigDecimal::add));
        order.setOrderItems(orderItems);

        // Save order
        Order savedOrder = this.orderRepository.save(order);

        // Clear the cart
        this.cartService.clearCart(userId);

        return Optional.of(mapOrderToOrderResponse(savedOrder));
    }
}