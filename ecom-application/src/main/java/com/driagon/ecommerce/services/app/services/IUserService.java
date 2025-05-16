package com.driagon.ecommerce.services.app.services;

import com.driagon.ecommerce.services.app.dto.UserResponse;
import com.driagon.ecommerce.services.app.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<UserResponse> fetchAllUsers();

    void addUser(User user);

    Optional<User> fetchUser(Long id);

    boolean updateUser(Long id, User user);
}