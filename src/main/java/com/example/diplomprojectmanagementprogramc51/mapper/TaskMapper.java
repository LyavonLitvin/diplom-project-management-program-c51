package com.example.diplomprojectmanagementprogramc51.mapper;

import com.example.diplomprojectmanagementprogramc51.dto.CreatingTaskDTO;
import com.example.diplomprojectmanagementprogramc51.dto.TaskDTO;
import com.example.diplomprojectmanagementprogramc51.entity.Task;
import com.example.diplomprojectmanagementprogramc51.service.CategoryService;
import com.example.diplomprojectmanagementprogramc51.service.PriorityService;
import com.example.diplomprojectmanagementprogramc51.service.StatusService;
import com.example.diplomprojectmanagementprogramc51.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

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

    public static Task mapFromCreatingTaskDtoToTask(CreatingTaskDTO creatingTaskDTO) {
        if (creatingTaskDTO == null) {
            return null;
        } else {
            return Task.builder()
                    .creator(userService.findByUsername(creatingTaskDTO.getCreatorName()))
                    .executor(userService.findByUsername(creatingTaskDTO.getExecutorName()))
                    .category(categoryService.findByName(creatingTaskDTO.getCategoryName()).get())
                    .status(statusService.findByName(creatingTaskDTO.getStatusName()).get())
                    .name(creatingTaskDTO.getName())
                    .description(creatingTaskDTO.getDescription())
                    .priority(priorityService.findByName(creatingTaskDTO.getPriorityName()).get())
                    .build();
        }
    }

    public static CreatingTaskDTO mapFromTaskToCreatingTaskDto(Task task) {
        CreatingTaskDTO creatingTaskDTO = new CreatingTaskDTO();
        creatingTaskDTO.setCreatorName(task.getCreator().getUsername());
        creatingTaskDTO.setExecutorName(task.getExecutor().getUsername());
        creatingTaskDTO.setCategoryName(task.getCategory().getName());
        creatingTaskDTO.setStatusName(task.getStatus().getName());
        creatingTaskDTO.setName(task.getName());
        creatingTaskDTO.setDescription(task.getDescription());
        creatingTaskDTO.setPriorityName(task.getPriority().getName());
        return creatingTaskDTO;
    }

    public static Task mapFromTaskDtoToTask(TaskDTO taskDTO) {
        if (taskDTO == null) {
            return null;
        } else {
            return Task.builder()
                    .id(Long.parseLong(taskDTO.getId()))
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

    public static TaskDTO mapFromTaskToTaskDto(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(String.valueOf(task.getId()));
        taskDTO.setCreatorName(task.getCreator().getUsername());
        taskDTO.setExecutorName(task.getExecutor().getUsername());
        taskDTO.setCategoryName(task.getCategory().getName());
        taskDTO.setStatusName(task.getStatus().getName());
        taskDTO.setName(task.getName());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setPriorityName(task.getPriority().getName());
        return taskDTO;
    }


    public static List<CreatingTaskDTO> mapFromCreatingTaskDTOListFromTasks(List<Task> taskList) {
        if (taskList == null || taskList.isEmpty()) {
            return null;
        } else {
            return taskList.stream()
                    .map(TaskMapper::mapFromTaskToCreatingTaskDto)
                    .collect(Collectors.toList());
        }
    }

    public static List<TaskDTO> mapFromTaskDTOListFromTasks(List<Task> taskList) {
        if (taskList == null || taskList.isEmpty()) {
            return null;
        } else {
            return taskList.stream()
                    .map(TaskMapper::mapFromTaskToTaskDto)
                    .collect(Collectors.toList());
        }
    }
}
