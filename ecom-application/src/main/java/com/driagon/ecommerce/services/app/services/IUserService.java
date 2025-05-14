package com.driagon.ecommerce.services.app.services;

import com.driagon.ecommerce.services.app.dto.User;

import java.util.List;

public interface IUserService {

    List<User> fetchAllUsers();

    List<User> addUser(User user);

    User fetchUser(Long id);
}