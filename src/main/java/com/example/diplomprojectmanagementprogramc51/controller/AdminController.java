package com.example.diplomprojectmanagementprogramc51.controller;

import com.example.diplomprojectmanagementprogramc51.dto.CategoryDTO;
import com.example.diplomprojectmanagementprogramc51.dto.PriorityDTO;
import com.example.diplomprojectmanagementprogramc51.entity.Category;
import com.example.diplomprojectmanagementprogramc51.entity.Priority;
import com.example.diplomprojectmanagementprogramc51.entity.User;
import com.example.diplomprojectmanagementprogramc51.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.example.diplomprojectmanagementprogramc51.controller.ExceptionHandlerController.ATTRIBUTE_ERROR;
import static com.example.diplomprojectmanagementprogramc51.controller.UserController.ATTRIBUTE_USER;


@Controller
@RequestMapping("/admin")
public class AdminController {
    public static final String PATH_ADMIN_PANEL_TEMPLATE = "admin/admin-panel";
    public static final String PATH_ROLE_MANAGEMENT_TEMPLATE = "admin/role/role-management";
    public static final String PATH_ROLE_ASSIGNMENT_TEMPLATE = "admin/role/role-assignment";
    public static final String PATH_CATEGORY_CREATE_TEMPLATE = "admin/category/category-create";
    public static final String PATH_CATEGORY_DELETE_TEMPLATE = "admin/category/category-delete";
    public static final String PATH_CATEGORY_MANAGEMENT_TEMPLATE = "admin/category/category-management";
    public static final String PATH_PRIORITY_CREATE_TEMPLATE = "admin/priority/priority-create";
    public static final String PATH_PRIORITY_DELETE_TEMPLATE = "admin/priority/priority-delete";
    public static final String PATH_PRIORITY_MANAGEMENT_TEMPLATE = "admin/priority/priority-management";
    public static final String PATH_STATUS_CREATE_TEMPLATE = "admin/status/status-create";
    public static final String PATH_STATUS_DELETE_TEMPLATE = "admin/status/status-delete";
    public static final String PATH_STATUS_MANAGEMENT_TEMPLATE = "admin/status/status-management";
    //    public static final String REDIRECT_TO_ROLE_ASSIGNMENT_PAGE_URL = "redirect:/admin/role-assignment";
    public static final String REDIRECT_ADMIN_CATEGORY_MANAGEMENT_CATEGORY = "redirect:/admin/category-management";
    public static final String REDIRECT_ADMIN_PRIORITY_MANAGEMENT_PRIORITY = "redirect:/admin/priority-management";
    public static final String REDIRECT_ADMIN_STATUS_MANAGEMENT_STATUS = "redirect:/admin/status-management";

    public static final String ATTRIBUTE_ROLES = "roles";
    public static final String ATTRIBUTE_ROLE = "role";
    public static final String ATTRIBUTE_CATEGORIES = "categories";
    public static final String ATTRIBUTE_CATEGORY = "category";
    public static final String ATTRIBUTE_PRIORITY = "priority";
    public static final String ATTRIBUTE_PRIORITIES = "priorities";
    public static final String ERROR_USER_WITH_EMAIL_NOT_EXIST = "User with this email does not exist!";
    public static final String OBJECT_ERROR_GLOBAL = "global";
    public final UserService userService;
    public final RoleService roleService;
    public final CategoryService categoryService;
    public final PriorityService priorityService;
    public final StatusService statusService;


    public AdminController(UserService userService, RoleService roleService, CategoryService categoryService, PriorityService priorityService, StatusService statusService) {
        this.userService = userService;
        this.roleService = roleService;
        this.categoryService = categoryService;
        this.priorityService = priorityService;
        this.statusService = statusService;
    }

    @GetMapping
    public String getAdminPanelTemplate() {
        return PATH_ADMIN_PANEL_TEMPLATE;
    }

    @GetMapping("/role-management")
    public String getRoleManagementTemplate() {
        return PATH_ROLE_MANAGEMENT_TEMPLATE;
    }

    @GetMapping("/role-management/role-assignment")
    public String getRoleAssignmentTemplate(@ModelAttribute(ATTRIBUTE_USER) User user, Model model) {
        model.addAttribute(ATTRIBUTE_ROLES, roleService.findAll());
        return PATH_ROLE_ASSIGNMENT_TEMPLATE;
    }

    @PostMapping("/role-management/role-assignment")
    public String assignRoleToUser(@ModelAttribute(ATTRIBUTE_USER) User user, BindingResult bindingResult, Model model) {
        model.addAttribute(ATTRIBUTE_ROLES, roleService.findAll());
        Optional<User> foundUser = Optional.ofNullable(userService.findByUsername(user.getUsername()));
        if (!bindingResult.hasErrors()) {
            if (foundUser.isPresent()) {
                userService.assignRolesToUser(foundUser.get(), user.getRoles());
            } else {
                bindingResult.addError(new ObjectError(OBJECT_ERROR_GLOBAL, ERROR_USER_WITH_EMAIL_NOT_EXIST));
            }
        }
        return PATH_ROLE_ASSIGNMENT_TEMPLATE;
    }

    @GetMapping("/category-management")
    public String getCategoryManagementTemplate(Model model) {
        model.addAttribute(ATTRIBUTE_CATEGORIES, categoryService.findAll());
        return PATH_CATEGORY_MANAGEMENT_TEMPLATE;
    }

    @GetMapping("/category/category-create")
    public String getCategoryCreateTemplate(@ModelAttribute(ATTRIBUTE_CATEGORY) CategoryDTO categoryDTO) {
        return PATH_CATEGORY_CREATE_TEMPLATE;
    }

    @PostMapping("/category/category-create")
    public String assignNewCategory(@ModelAttribute(ATTRIBUTE_CATEGORY) @Valid CategoryDTO categoryDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return PATH_CATEGORY_CREATE_TEMPLATE;
        } else {
            boolean isRegistered = categoryService.save(categoryDTO);
            if (isRegistered) {
                return REDIRECT_ADMIN_CATEGORY_MANAGEMENT_CATEGORY;
            } else {
                model.addAttribute(ATTRIBUTE_ERROR, "Already exists!");
                return PATH_CATEGORY_CREATE_TEMPLATE;
            }
        }
    }

    @GetMapping("/category/category-delete")
    public String getPathCategoryDeleteTemplate(@ModelAttribute(ATTRIBUTE_CATEGORY) CategoryDTO categoryDTO) {
        return PATH_CATEGORY_DELETE_TEMPLATE;
    }

    @PostMapping("/category/category-delete")
    public String deletingCategory(@ModelAttribute(ATTRIBUTE_CATEGORY) @Valid CategoryDTO categoryDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(ATTRIBUTE_ERROR, "Something gone wrong!");
        } else {
            boolean isDeleted = categoryService.delete(categoryDTO);
            if (isDeleted) {
                model.addAttribute(ATTRIBUTE_ERROR, "Category has deleted successful!");
            } else {
                model.addAttribute(ATTRIBUTE_ERROR, "Category hasn't deleted successful!");
            }
        }
        return PATH_CATEGORY_DELETE_TEMPLATE;
    }

    @GetMapping("/priority-management")
    public String getPathPriorityManagementTemplate(Model model) {
        model.addAttribute(ATTRIBUTE_PRIORITIES, priorityService.findAll());
        return PATH_CATEGORY_MANAGEMENT_TEMPLATE;
    }

    @GetMapping("/priority/priority-create")
    public String getCategoryCreateTemplate(@ModelAttribute(ATTRIBUTE_PRIORITY) PriorityDTO priorityDTO) {
        return PATH_PRIORITY_CREATE_TEMPLATE;
    }

    @PostMapping("/priority/priority-create")
    public String assignNewCategory(@ModelAttribute(ATTRIBUTE_PRIORITY) @Valid PriorityDTO priorityDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return PATH_PRIORITY_CREATE_TEMPLATE;
        } else {
            boolean isRegistered = priorityService.save(priorityDTO);
            if (isRegistered) {
                return REDIRECT_ADMIN_PRIORITY_MANAGEMENT_PRIORITY;
            } else {
                model.addAttribute(ATTRIBUTE_ERROR, "Already exists!");
                return PATH_PRIORITY_CREATE_TEMPLATE;
            }
        }
    }

    @GetMapping("/priority/priority-delete")
    public String getPathCategoryDeleteTemplate(@ModelAttribute(ATTRIBUTE_PRIORITY) PriorityDTO priorityDTO) {
        return PATH_PRIORITY_DELETE_TEMPLATE;
    }

    @PostMapping("/priority/priority-delete")
    public String deletingCategory(@ModelAttribute(ATTRIBUTE_PRIORITY) @Valid PriorityDTO priorityDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(ATTRIBUTE_ERROR, "Something gone wrong!");
        } else {
            boolean isDeleted = priorityService.delete(priorityDTO);
            if (isDeleted) {
                model.addAttribute(ATTRIBUTE_ERROR, "Priority has deleted successful!");
            } else {
                model.addAttribute(ATTRIBUTE_ERROR, "Priority hasn't deleted successful!");
            }
        }
        return PATH_PRIORITY_DELETE_TEMPLATE;
    }


}
