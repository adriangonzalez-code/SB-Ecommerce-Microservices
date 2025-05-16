package com.driagon.ecommerce.services.app.mappers;

import com.driagon.ecommerce.services.app.dto.UserResponse;
import com.driagon.ecommerce.services.app.models.User;

public class MapToUser {

    public static UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .id(String.valueOf(user.getId()))
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .role(user.getRole())
                .address(user.getAddress() != null ? MapToAddress.mapToAddressResponse(user.getAddress()) : null)
                .build();
    }
}