package com.example.diplomprojectmanagementprogramc51.service;

import com.example.diplomprojectmanagementprogramc51.dto.CreatingTaskDTO;
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




    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;

    }

    public boolean save(CreatingTaskDTO creatingTaskDTO){
        Task task = TaskMapper.mapFromCreatingTaskDtoToTask(creatingTaskDTO);
        if(existsByName(task)){
            return false;
        }
        else {
            taskRepository.save(task);
            return true;
        }
    }

    public boolean delete(CreatingTaskDTO creatingTaskDTO){
        Task task = TaskMapper.mapFromCreatingTaskDtoToTask(creatingTaskDTO);
        if(existsByName(task)){
            return false;
        }
        else {
            taskRepository.delete(task);
            return true;
        }
    }

    public boolean update(CreatingTaskDTO creatingTaskDTO){
        Task task = TaskMapper.mapFromCreatingTaskDtoToTask(creatingTaskDTO);
        Task taskCheck = taskRepository.saveAndFlush(task);
        return  task.equals(taskCheck);
    }

    public boolean existsByName(Task task){
        return taskRepository.existsByName(task.getName());
    }

    public List<TaskDTO> findAll(){
        List<TaskDTO> taskDTOList = TaskMapper.mapFromTaskDTOListFromTasks(taskRepository.findAll());
        return taskDTOList;
    }

    public Optional<Task> findById(long id){
        return taskRepository.findById(id);
    }

    public Optional<Task> findByName(String name){
        return taskRepository.findByName(name);
    }

    public List<TaskDTO> findByCreatorUsername(String username){
        List<TaskDTO> taskDTOListCreator = TaskMapper.mapFromTaskDTOListFromTasks(taskRepository.findByCreator_Username(username));
        return taskDTOListCreator;
    }

    public List<TaskDTO> findByExecutorUsername(String username){
        List<TaskDTO> taskDTOListExecutor = TaskMapper.mapFromTaskDTOListFromTasks(taskRepository.findByExecutor_Username(username));
        return taskDTOListExecutor;
    }
}

