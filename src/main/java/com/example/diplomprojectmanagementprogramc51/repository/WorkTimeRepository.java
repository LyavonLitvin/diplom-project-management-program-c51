package com.example.diplomprojectmanagementprogramc51.repository;

import com.example.diplomprojectmanagementprogramc51.entity.Project;
import com.example.diplomprojectmanagementprogramc51.entity.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkTimeRepository extends JpaRepository<WorkTime, Long> {
    Optional<WorkTime> findByName(String name);
    boolean existsByName(String username);
}
