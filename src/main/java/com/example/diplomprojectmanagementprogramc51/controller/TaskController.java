package com.example.diplomprojectmanagementprogramc51.controller;


import com.example.diplomprojectmanagementprogramc51.dto.TaskDTO;
import com.example.diplomprojectmanagementprogramc51.entity.User;
import com.example.diplomprojectmanagementprogramc51.service.TaskService;
import com.example.diplomprojectmanagementprogramc51.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.Optional;

import static com.example.diplomprojectmanagementprogramc51.controller.ExceptionHandlerController.ATTRIBUTE_ERROR;

@Controller
@RequestMapping("/task")
public class TaskController {

    public static final String ATTRIBUTE_TASK = "task";
    public static final String ATTRIBUTE_TASKS = "tasks";
    public static final String PATH_TASK_CREATE_TEMPLATE = "task/create";
    public static final String PATH_TASK_DELETE_TEMPLATE = "user/delete";
    public static final String PATH_TASK_EDIT_TEMPLATE = "user/edit";
    public static final String REDIRECT_TO_CREATE_PAGE = "redirect:/task/create";
    public static final String REDIRECT_TO_EDIT_PAGE = "redirect:/task/edit";
    private static final String MSG_USER_LOGIN_INVALID = "invalid user/login";


    private final TaskService taskService;

    public TaskController(TaskService tasService) {
        this.taskService = tasService;
    }

    @GetMapping("/create")
    public String getRegistrationTemplate(@ModelAttribute(ATTRIBUTE_TASK) TaskDTO registeringUserDTO) {
        return PATH_TASK_CREATE_TEMPLATE;
    }

    @PostMapping("/create")
    public String signup(@ModelAttribute(ATTRIBUTE_TASK) @Valid TaskDTO taskDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return PATH_TASK_CREATE_TEMPLATE;
        } else {
            boolean isRegistered = taskService.save(taskDTO);
            if (isRegistered) {
                return REDIRECT_TO_CREATE_PAGE;
            } else {
                model.addAttribute(ATTRIBUTE_ERROR, "Already exists!");
                return PATH_TASK_CREATE_TEMPLATE;
            }
        }
    }

    @GetMapping("/tasks")
    public String showAllUsers(Model model, HttpSession session) {
        model.addAttribute(ATTRIBUTE_TASKS, taskService.findAll());

        return "task/tasks";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") long id, Model model) {
        Optional<User> optionalUser = userService.findById(id);
        User user = optionalUser.orElse(null);
        model.addAttribute(ATTRIBUTE_TASK, task);

        return "task/task";
    }
}

