package com.example.diplomprojectmanagementprogramc51.service;

import com.example.diplomprojectmanagementprogramc51.dto.TaskDTO;
import com.example.diplomprojectmanagementprogramc51.entity.Task;
import com.example.diplomprojectmanagementprogramc51.mapper.TaskMapper;
import com.example.diplomprojectmanagementprogramc51.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    private final TaskMapper taskMapper;


    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public boolean save(TaskDTO taskDTO){
        Task task = taskMapper.mapFromTaskDtoToTask(taskDTO);
        if(existsByName(task)){
            return false;
        }
        else {
            taskRepository.save(task);
            return true;
        }
    }

    public boolean delete(Task task){
        if(existsByName(task)){
            return false;
        }
        else {
            taskRepository.delete(task);
            return true;
        }
    }

    public boolean update(Task task){
        Task taskCheck = taskRepository.saveAndFlush(task);
        return  task.equals(taskCheck);
    }

    public boolean existsByName(Task task){
        return taskRepository.existsByName(task.getName());
    }

    public List<Task> findAllByName(){
        return taskRepository.findAll();
    }

    public Optional<Task> findById(long id){
        return taskRepository.findById(id);
    }

    public Optional<Task> findByName(String name){
        return taskRepository.findByName(name);
    }
}

