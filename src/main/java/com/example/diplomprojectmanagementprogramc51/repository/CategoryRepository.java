package com.example.diplomprojectmanagementprogramc51.repository;

import com.example.diplomprojectmanagementprogramc51.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
    boolean existsByName(String name);
    boolean merge(Category category);
}
