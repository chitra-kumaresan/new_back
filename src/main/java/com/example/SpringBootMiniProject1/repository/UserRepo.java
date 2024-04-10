package com.example.SpringBootMiniProject1.repository;

import com.example.SpringBootMiniProject1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameOrEmail(String username,String email);


    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);
}
