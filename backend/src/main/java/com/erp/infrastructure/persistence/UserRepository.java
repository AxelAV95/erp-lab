package com.erp.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional <User> findByUsername(String username);
}
