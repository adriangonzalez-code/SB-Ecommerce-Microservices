package com.driagon.ecommerce.services.app.services;

import com.driagon.ecommerce.services.app.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private List<User> userList = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<User> fetchAllUsers() {
        // Logic to fetch all users
        return this.userList;
    }

    @Override
    public List<User> addUser(User user) {
        // Logic to create a new user
        user.setId(this.nextId++);
        this.userList.add(user);
        return this.userList;
    }

    @Override
    public User fetchUser(Long id) {
        for (User user : this.userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
