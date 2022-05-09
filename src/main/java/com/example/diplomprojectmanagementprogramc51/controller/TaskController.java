package com.example.diplomprojectmanagementprogramc51.controller;

import com.example.diplomprojectmanagementprogramc51.dto.RegisteringUserDTO;
import com.example.diplomprojectmanagementprogramc51.entity.User;
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
    public static final String PATH_TASK_CREATE_TEMPLATE = "task/create";
    public static final String PATH_TASK_DELETE_TEMPLATE = "user/delete";
    public static final String PATH_TASK_EDIT_TEMPLATE = "user/edit";
    public static final String REDIRECT_TO_CREATE_PAGE = "redirect:/task/create";
    public static final String REDIRECT_TO_EDIT_PAGE = "redirect:/task/edit";
    private static final String MSG_USER_LOGIN_INVALID = "invalid user/login";

    public static final String ATTRIBUTE_DEPARTMENTS = "departments";

    private final UserService userService;

    public TaskController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/reg")
    public String getRegistrationTemplate(@ModelAttribute(ATTRIBUTE_TASK) RegisteringUserDTO registeringUserDTO) {
        return PATH_TASK_CREATE_TEMPLATE;
    }

    @PostMapping("/reg")
    public String signup(@ModelAttribute(ATTRIBUTE_TASK) @Valid RegisteringUserDTO registeringUserDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return PATH_TASK_CREATE_TEMPLATE;
        } else {
            boolean isRegistered = userService.registration(registeringUserDTO);
            if (isRegistered) {
                return REDIRECT_TO_CREATE_PAGE;
            } else {
                model.addAttribute(ATTRIBUTE_ERROR, "Already exists!");
                return PATH_TASK_CREATE_TEMPLATE;
            }
        }
    }

    @GetMapping("/users")
    public String showAllUsers(Model model, HttpSession session) {
        model.addAttribute("users", userService.findAll());

        return "user/users";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") long id, Model model) {
        Optional<User> optionalUser = userService.findById(id);
        User user = optionalUser.orElse(null);
        model.addAttribute("user", user);

        return "user/user";
    }
}
