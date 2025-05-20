package com.driagon.ecommerce.services.app.services;

import com.driagon.ecommerce.services.app.dto.UserRequest;
import com.driagon.ecommerce.services.app.dto.UserResponse;
import com.driagon.ecommerce.services.app.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<UserResponse> fetchAllUsers();

    UserResponse addUser(UserRequest userRequest);

    Optional<UserResponse> fetchUser(Long id);

    UserResponse updateUser(Long id, UserRequest userRequest);
}