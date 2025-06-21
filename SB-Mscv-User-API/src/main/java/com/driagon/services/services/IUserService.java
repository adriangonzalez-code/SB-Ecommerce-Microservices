package com.driagon.services.services;

import com.driagon.services.dto.requests.UserRequest;
import com.driagon.services.dto.responses.UserResponse;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<UserResponse> fetchAllUsers();

    UserResponse addUser(UserRequest userRequest);

    Optional<UserResponse> fetchUser(Long id);

    UserResponse updateUser(Long id, UserRequest userRequest);
}