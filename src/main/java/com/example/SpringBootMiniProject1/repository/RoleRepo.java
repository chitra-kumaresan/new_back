package com.example.SpringBootMiniProject1.repository;
   import com.example.SpringBootMiniProject1.entity.Role;
   import org.springframework.data.jpa.repository.JpaRepository;
public interface RoleRepo extends JpaRepository<Role,Long> {
        Role findByName(String name);
   }

