package com.driagon.ecommerce.services.app.services;

import com.driagon.ecommerce.services.app.dto.UserResponse;
import com.driagon.ecommerce.services.app.mappers.MapToUser;
import com.driagon.ecommerce.services.app.models.User;
import com.driagon.ecommerce.services.app.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository repository;

    @Override
    public List<UserResponse> fetchAllUsers() {
        return this.repository.findAll().stream().map(MapToUser::mapToUserResponse).toList();
    }

    @Override
    public void addUser(User user) {
        this.repository.save(user);
    }

    @Override
    public Optional<User> fetchUser(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public boolean updateUser(Long id, User user) {
        return this.repository.findById(id)
                .map(u -> {
                    u.setFirstName(user.getFirstName());
                    u.setLastName(user.getLastName());
                    this.repository.save(u);
                    return true;
                })
                .orElse(false);
    }
}
