package com.example.diplomprojectmanagementprogramc51.controller;


import com.example.diplomprojectmanagementprogramc51.dto.CreatingTaskDTO;
import com.example.diplomprojectmanagementprogramc51.dto.TaskDTO;
import com.example.diplomprojectmanagementprogramc51.mapper.TaskMapper;
import com.example.diplomprojectmanagementprogramc51.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

import static com.example.diplomprojectmanagementprogramc51.controller.ExceptionHandlerController.ATTRIBUTE_ERROR;

@Controller
@RequestMapping("/task")
public class TaskController {

    public static final String ATTRIBUTE_TASK = "task";
    public static final String ATTRIBUTE_TASKS = "tasks";
    public static final String ATTRIBUTE_CATEGORIES = "categories";
    public static final String ATTRIBUTE_STATUSES = "statuses";
    public static final String ATTRIBUTE_PRIORITIES = "priorities";
    public static final String ATTRIBUTE_USERS = "users";
    public static final String ATTRIBUTE_MY_TASKS_CREATOR = "myTasksCreator";
    public static final String ATTRIBUTE_MY_TASKS_EXECUTOR = "myTasksExecutor";
    public static final String PATH_TASKS_TEMPLATE = "task/tasks";
    public static final String PATH_MY_TASKS_TEMPLATE = "task/my-tasks";
    public static final String PATH_TASK_CREATE_TEMPLATE = "task/create";
    public static final String PATH_TASK_DELETE_TEMPLATE = "task/delete";
    public static final String PATH_TASK_EDIT_TEMPLATE = "task/edit";
    public static final String REDIRECT_TO_CREATE_PAGE = "redirect:/task/create";
    public static final String REDIRECT_TO_MY_TASKS = "redirect:/task/my-tasks";
    public static final String REDIRECT_TO_EDIT_PAGE = "redirect:/task/edit";


    private final TaskService taskService;
    private final CategoryService categoryService;
    private final PriorityService priorityService;
    private final StatusService statusService;
    private final UserService userService;

    public TaskController(TaskService tasService, CategoryService categoryService, PriorityService priorityService, StatusService statusService, UserService userService) {
        this.taskService = tasService;
        this.categoryService = categoryService;
        this.priorityService = priorityService;
        this.statusService = statusService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String getTaskCreateTemplate(@ModelAttribute(ATTRIBUTE_TASK) CreatingTaskDTO creatingTaskDTO, Model model) {
        model.addAttribute(ATTRIBUTE_CATEGORIES, categoryService.findAll());
        model.addAttribute(ATTRIBUTE_PRIORITIES, priorityService.findAll());
        model.addAttribute(ATTRIBUTE_STATUSES, statusService.findAll());
        model.addAttribute(ATTRIBUTE_USERS, userService.findAll());
        return PATH_TASK_CREATE_TEMPLATE;
    }

    @PostMapping("/create")
    public String createTask(@ModelAttribute(ATTRIBUTE_TASK) @Valid CreatingTaskDTO creatingTaskDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(ATTRIBUTE_ERROR, "Something have gone wrong!");
            return PATH_TASK_CREATE_TEMPLATE;
        } else {
            boolean isRegistered = taskService.save(creatingTaskDTO);
            if (isRegistered) {
                return REDIRECT_TO_MY_TASKS;
            } else {
                model.addAttribute(ATTRIBUTE_ERROR, "Already exists!");
                return PATH_TASK_CREATE_TEMPLATE;
            }
        }
    }

//    edit
//    @GetMapping("/task/{id}role-assignment")
//    public String getRoleAssignmentTemplate(@ModelAttribute(ATTRIBUTE_USER) User user, Model model) {
//        model.addAttribute(ATTRIBUTE_ROLES, roleService.findAll());
//        return PATH_ROLE_ASSIGNMENT_TEMPLATE;
//    }
//
//    @PostMapping("/role-management/role-assignment")
//    public String assignRoleToUser(@ModelAttribute(ATTRIBUTE_USER) User user, BindingResult bindingResult, Model model) {
//        model.addAttribute(ATTRIBUTE_ROLES, roleService.findAll());
//        Optional<User> foundUser = Optional.ofNullable(userService.findByUsername(user.getUsername()));
//        if (!bindingResult.hasErrors()) {
//            if (foundUser.isPresent()) {
//                userService.assignRolesToUser(foundUser.get(), user.getRoles());
//            } else {
//                bindingResult.addError(new ObjectError(OBJECT_ERROR_GLOBAL, ERROR_USER_WITH_EMAIL_NOT_EXIST));
//            }
//        }
//        return PATH_ROLE_ASSIGNMENT_TEMPLATE;
//    }

    @GetMapping("/tasks")
    public String showAllTasks(Model model, HttpSession session) {
        List<TaskDTO> tasks = taskService.findAll();
        model.addAttribute(ATTRIBUTE_TASKS,
                tasks);

        return PATH_TASKS_TEMPLATE;
    }

    @GetMapping("/my-tasks")
    public String showMyTasks(Model model, HttpSession session) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<TaskDTO> myTasksCreator = taskService.findByCreatorUsername(userService.getCurrentUsername());
        model.addAttribute(ATTRIBUTE_MY_TASKS_CREATOR, myTasksCreator);
        List<TaskDTO> myTasksExecutor = taskService.findByExecutorUsername(userService.getCurrentUsername());
        model.addAttribute(ATTRIBUTE_MY_TASKS_EXECUTOR, myTasksExecutor);

        return PATH_MY_TASKS_TEMPLATE;
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") long id, Model model) {
        Optional<CreatingTaskDTO> optionalTask = Optional.of(TaskMapper.mapFromTaskToCreatingTaskDto(taskService.findById(id).get()));
        CreatingTaskDTO task = optionalTask.orElse(null);
        model.addAttribute(ATTRIBUTE_TASK, task);

        return "task/task";
    }
}

