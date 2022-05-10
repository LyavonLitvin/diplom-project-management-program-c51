package com.example.diplomprojectmanagementprogramc51.repository;

import com.example.diplomprojectmanagementprogramc51.entity.Task;
import com.example.diplomprojectmanagementprogramc51.entity.User;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {


    Optional<Task> findByName(String name);

    boolean existsByName(String name);


    @Query("select t from Task t where t.creator.username = ?1")
    List<Task> findByCreator_Username(String username);

    @Query("select t from Task t where t.executor.username = ?1")
    List<Task> findByExecutor_Username(String username);

    Optional<Task> findById(long id);

}
