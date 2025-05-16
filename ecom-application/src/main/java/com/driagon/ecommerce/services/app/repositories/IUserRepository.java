package com.driagon.ecommerce.services.app.repositories;

import com.driagon.ecommerce.services.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}