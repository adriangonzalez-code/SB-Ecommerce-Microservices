package com.driagon.ecommerce.services.app.services;

import com.driagon.ecommerce.services.app.constants.OrderStatus;
import com.driagon.ecommerce.services.app.dto.OrderResponse;
import com.driagon.ecommerce.services.app.models.CartItem;
import com.driagon.ecommerce.services.app.models.Order;
import com.driagon.ecommerce.services.app.models.OrderItem;
import com.driagon.ecommerce.services.app.models.User;
import com.driagon.ecommerce.services.app.repositories.IOrderRepository;
import com.driagon.ecommerce.services.app.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.driagon.ecommerce.services.app.mappers.OrderMapper.mapOrderToOrderResponse;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final ICartService cartService;

    private final IUserRepository userRepository;

    private final IOrderRepository orderRepository;

    @Override
    public Optional<OrderResponse> createOrder(String userId) {
        // Validation for cart items
        List<CartItem> cartItems = this.cartService.getCartItems(userId);

        if (cartItems == null || cartItems.isEmpty()) {
            return Optional.empty();
        }

        // Validate for user
        Optional<User> userOpt = this.userRepository.findById(Long.valueOf(userId));
        if (userOpt.isEmpty()) {
            return Optional.empty();
        }

        User user = userOpt.get();

        // Create order
        Order order = new Order();
        order.setUser(user);
        order.setStatus(OrderStatus.CONFIRMED);
        List<OrderItem> orderItems = cartItems.stream()
                .map(cartItem -> OrderItem.builder()
                        .product(cartItem.getProduct())
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