package com.driagon.services.services;

import com.driagon.services.dto.requests.UserRequest;
import com.driagon.services.dto.responses.UserResponse;
import com.driagon.services.entities.User;
import com.driagon.services.mappers.UserMapper;
import com.driagon.services.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.driagon.services.mappers.UserMapper.mapUserRequestToUser;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository repository;

    @Override
    public List<UserResponse> fetchAllUsers() {
        return this.repository.findAll().stream().map(UserMapper::mapUserToUserResponse).toList();
    }

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        User user = new User();
        mapUserRequestToUser(user, userRequest);
        user = this.repository.save(user);
        return UserMapper.mapUserToUserResponse(user);
    }

    @Override
    public Optional<UserResponse> fetchUser(Long id) {
        return this.repository.findById(id).map(UserMapper::mapUserToUserResponse);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest userRequest) {
        return this.repository.findById(id)
                .map(user -> {
                    mapUserRequestToUser(user, userRequest);
                    user = this.repository.save(user);
                    return UserMapper.mapUserToUserResponse(user);
                })
                .orElse(null);
    }
}
