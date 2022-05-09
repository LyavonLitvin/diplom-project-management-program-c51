package com.example.diplomprojectmanagementprogramc51.mapper;

import com.example.diplomprojectmanagementprogramc51.dto.TaskDTO;
import com.example.diplomprojectmanagementprogramc51.entity.Task;
import com.example.diplomprojectmanagementprogramc51.service.CategoryService;
import com.example.diplomprojectmanagementprogramc51.service.PriorityService;
import com.example.diplomprojectmanagementprogramc51.service.StatusService;
import com.example.diplomprojectmanagementprogramc51.service.UserService;

import java.util.HashSet;

public class TaskMapper {
    private static UserService userService;
    private static CategoryService categoryService;
    private static StatusService statusService;
    private static PriorityService priorityService;

    public TaskMapper(UserService userService, CategoryService categoryService, StatusService statusService, PriorityService priorityService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.statusService = statusService;
        this.priorityService = priorityService;
    }

    public Task mapFromTaskDtoToTask(TaskDTO taskDTO) {
        if (taskDTO == null) {
            return null;
        } else {
            return Task.builder()
                    .creator(userService.findByUsername(taskDTO.getCreatorName()))
                    .executor(userService.findByUsername(taskDTO.getExecutorName()))
                    .category(categoryService.findByName(taskDTO.getCategoryName()).get())
                    .status(statusService.findByName(taskDTO.getStatusName()).get())
                    .name(taskDTO.getName())
                    .description(taskDTO.getDescription())
                    .priority(priorityService.findByName(taskDTO.getPriorityName()).get())
                    .build();
        }
    }

    public TaskDTO mapFromTaskToTaskDto(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setCreatorName(task.getCreator().getUsername());
        taskDTO.setExecutorName(task.getExecutor().getUsername());
        taskDTO.setCategoryName(task.getCategory().getName());
        taskDTO.setStatusName(task.getStatus().getName());
        taskDTO.setName(task.getName());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setPriorityName(task.getPriority().getName());
        return taskDTO;
    }

}
