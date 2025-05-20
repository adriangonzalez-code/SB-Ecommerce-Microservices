package com.driagon.ecommerce.services.app.mappers;

import com.driagon.ecommerce.services.app.dto.UserRequest;
import com.driagon.ecommerce.services.app.dto.UserResponse;
import com.driagon.ecommerce.services.app.models.User;

public class UserMapper {

    public static UserResponse mapUserToUserResponse(User user) {
        return UserResponse.builder()
                .id(String.valueOf(user.getId()))
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .role(user.getRole())
                .address(user.getAddress() != null ? AddressMapper.mapAddressToAddressResponse(user.getAddress()) : null)
                .build();
    }

    public static User mapUserRequestToUser(User user, UserRequest userRequest) {
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        user.setAddress(userRequest.getAddress() != null ? AddressMapper.mapAddressRequestToAddress(userRequest.getAddress()) : null);
        return user;
    }
}