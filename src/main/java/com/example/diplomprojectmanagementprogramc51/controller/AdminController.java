package com.example.diplomprojectmanagementprogramc51.controller;

import com.example.diplomprojectmanagementprogramc51.dto.CategoryDTO;
import com.example.diplomprojectmanagementprogramc51.entity.Category;
import com.example.diplomprojectmanagementprogramc51.entity.User;
import com.example.diplomprojectmanagementprogramc51.service.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    public static final String PATH_DEPARTMENT_CREATE_TEMPLATE = "admin/department/department-create";
    public static final String PATH_DEPARTMENT_DELETE_TEMPLATE = "admin/department/department-delete";
    public static final String PATH_DEPARTMENT_MANAGEMENT_TEMPLATE = "admin/department/department-management";
//    public static final String REDIRECT_TO_ROLE_ASSIGNMENT_PAGE_URL = "redirect:/admin/role-management/role-assignment";
    public static final String REDIRECT_TO_CATEGORY_MANAGEMENT_PAGE_URL = "redirect:/admin/category-management/category-create";
//    public static final String REDIRECT_TO_ROLE_ASSIGNMENT_PAGE_URL = "redirect:/admin/category-management/category-create";

    public static final String ATTRIBUTE_ROLES = "roles";
    public static final String ATTRIBUTE_ROLE = "role";
    public static final String ATTRIBUTE_CATEGORIES = "categories";
    public static final String ATTRIBUTE_CATEGORY = "category";
    public static final String ATTRIBUTE_DEPARTMENTS = "departments";
    public static final String ATTRIBUTE_DEPARTMENT = "department";
    public static final String ATTRIBUTE_PRIORITY = "priority";
    public static final String ATTRIBUTE_PRIORITIES = "priorities";
    public static final String ERROR_USER_WITH_EMAIL_NOT_EXIST = "User with this email does not exist!";
    public static final String OBJECT_ERROR_GLOBAL = "global";
    public final UserService userService;
    public final RoleService roleService;

    public final CategoryService categoryService;
    public final DepartmentService departmentService;

    public AdminController(UserService userService, RoleService roleService, DepartmentService departmentService, PriorityService priorityService, StatusService statusService) {
        this.userService = userService;
        this.roleService = roleService;
        this.departmentService = departmentService;
        this.categoryService = categoryService;
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

    @GetMapping("/category")
    public String getCategoryManagementTemplate(@ModelAttribute(ATTRIBUTE_CATEGORIES) List<Category> categories, Model model) {
                model.addAttribute(ATTRIBUTE_CATEGORIES, categoryService.findAll());
        return PATH_ROLE_MANAGEMENT_TEMPLATE;
    }

    @GetMapping("/category/category-create")
    public String getCategoryCreateTemplate(@ModelAttribute(ATTRIBUTE_CATEGORY) CategoryDTO categoryDTO) {
        return PATH_ROLE_ASSIGNMENT_TEMPLATE;
    }

    @PostMapping("/category/category-create")
    public String assignNewCategory(@ModelAttribute(ATTRIBUTE_CATEGORY) @Valid CategoryDTO categoryDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return PATH_CATEGORY_CREATE_TEMPLATE;
        } else {
            boolean isRegistered = categoryService.save(categoryDTO);
            if (isRegistered) {
                return REDIRECT_TO_CATEGORY_MANAGEMENT_PAGE_URL;
            } else {
                model.addAttribute(ATTRIBUTE_ERROR, "Already exists!");
                return PATH_CATEGORY_CREATE_TEMPLATE;
            }
        }
    }

    @GetMapping("/category/category-delete")
    public String getPathCategoryDeleteTemplate(@ModelAttribute(ATTRIBUTE_CATEGORY) CategoryDTO categoryDTO) {
        return PATH_ROLE_ASSIGNMENT_TEMPLATE;
    }

    @PostMapping("/category/category-delete")
    public String deletingCategory(@ModelAttribute(ATTRIBUTE_CATEGORY) @Valid CategoryDTO categoryDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return PATH_CATEGORY_CREATE_TEMPLATE;
        } else {
            boolean isRegistered = categoryService.delete(categoryDTO);
            if (isRegistered) {
                return REDIRECT_TO_CATEGORY_MANAGEMENT_PAGE_URL;
            } else {
                model.addAttribute(ATTRIBUTE_ERROR, "Already exists!");
                return PATH_CATEGORY_CREATE_TEMPLATE;
            }
        }
    }
}
