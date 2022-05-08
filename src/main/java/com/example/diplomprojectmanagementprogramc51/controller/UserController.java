package com.example.diplomprojectmanagementprogramc51.controller;

import com.example.diplomprojectmanagementprogramc51.dto.RegisteringUserDTO;
import com.example.diplomprojectmanagementprogramc51.entity.User;
import com.example.diplomprojectmanagementprogramc51.service.DepartmentService;
import com.example.diplomprojectmanagementprogramc51.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.Optional;

import static com.example.diplomprojectmanagementprogramc51.controller.ExceptionHandlerController.ATTRIBUTE_ERROR;

@Controller
@RequestMapping("/user")
public class UserController {

	public static final String ATTRIBUTE_USER = "user";
	public static final String PATH_INDEX_TEMPLATE = "/";
	public static final String PATH_REG_TEMPLATE = "user/reg";
	public static final String PATH_LOGIN_TEMPLATE = "user/login";
	public static final String REDIRECT_TO_LOGIN_PAGE = "redirect:/user/login";
	private static final String MSG_USER_LOGIN_INVALID = "invalid user/login";

	public static final String ATTRIBUTE_ROLES = "departments";

	private final UserService userService;
	@Autowired
	private DepartmentService departmentService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/reg")
	public String getRegistrationTemplate(@ModelAttribute(ATTRIBUTE_USER) RegisteringUserDTO registeringUserDTO, Model model) {
		model.addAttribute(ATTRIBUTE_ROLES, departmentService.findAll());
		return PATH_REG_TEMPLATE;
	}

	@PostMapping("/reg")
	public String signup(@ModelAttribute(ATTRIBUTE_USER) @Valid RegisteringUserDTO registeringUserDTO, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return PATH_REG_TEMPLATE;
		} else {
			boolean isRegistered = userService.registration(registeringUserDTO);
			if (isRegistered) {
				return REDIRECT_TO_LOGIN_PAGE;
			} else {
				model.addAttribute(ATTRIBUTE_ERROR, "Already exists!");
				return PATH_REG_TEMPLATE;
			}
		}
	}

	@GetMapping("/login")
	public String getLoginTemplate(@RequestParam(required = false) boolean failed, Model model) {
		if (failed) {
			model.addAttribute(ATTRIBUTE_ERROR, "User doesn't exist!");
		}
		return PATH_LOGIN_TEMPLATE;
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
