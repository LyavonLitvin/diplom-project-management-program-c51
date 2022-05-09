package com.example.diplomprojectmanagementprogramc51.repository;

import com.example.diplomprojectmanagementprogramc51.entity.Task;
import com.example.diplomprojectmanagementprogramc51.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByName(String name);
    boolean existsByName(String name);

    @Query("SELECT tasks.id, u.username, us.username, categories.name, statuses.name, name, description, priorities.name from tasks INNER JOIN users u ON tasks.creator_id = u.id INNER JOIN users us ON tasks.executor_id = us.id INNER JOIN statuses ON tasks.status_id = statuses.id INNER JOIN categories ON tasks.category_id = categories.id INNER JOIN categories ON tasks.category_id = categories.id WHERE u.username = :username")
    Optional<Task> findByCreatorName(String username);
    @Query("SELECT tasks.id, u.username, us.username, categories.name, statuses.name, name, description, priorities.name from tasks INNER JOIN users u ON tasks.creator_id = u.id INNER JOIN users us ON tasks.executor_id = us.id INNER JOIN statuses ON tasks.status_id = statuses.id INNER JOIN categories ON tasks.category_id = categories.id INNER JOIN categories ON tasks.category_id = categories.id WHERE us.username = :username")
    Optional<Task> findByExecutorName(String username);

    @Query("SELECT tasks.id, u.username, us.username, categories.name, statuses.name, name, description, priorities.name from tasks" +
            " INNER JOIN users u ON tasks.creator_id = u.id" +
            " INNER JOIN users us ON tasks.executor_id = us.id" +
            " INNER JOIN statuses ON tasks.status_id = statuses.id" +
            " INNER JOIN categories ON tasks.category_id = categories.id" +
            " INNER JOIN priorities ON tasks.priority_id = priorities.id WHERE tasks.id = :id")
    Optional<Task> findById(long id);
}
//"select tasks.id_task, u.user_last_name, us.user_last_name, task_categories.name_task_category, " +
//        "task_statuses.task_status, task_topic, task_date_update, task_description from tasks " +
//        "inner join users u on tasks.id_task_creator = u.id_user " +
//        "inner join users us on tasks.id_task_executor = us.id_user " +
//        "inner join task_statuses on tasks.id_task_status = task_statuses.id_task_status " +
//        "inner join task_categories on tasks.id_task_category = task_categories.id_task_category " +
//        "where tasks.id_task = ?"