package com.example.diplomprojectmanagementprogramc51.repository;

import com.example.diplomprojectmanagementprogramc51.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PriorityRepository extends JpaRepository<Priority, Long> {
    Optional<Priority> findByName(String name);
    boolean existsByName(String name);
}
