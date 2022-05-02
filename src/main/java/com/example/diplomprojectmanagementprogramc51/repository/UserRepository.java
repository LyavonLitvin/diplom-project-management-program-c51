package com.example.diplomprojectmanagementprogramc51.repository;

import com.example.diplomprojectmanagementprogramc51.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
