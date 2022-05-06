package com.example.diplomprojectmanagementprogramc51;

import com.example.diplomprojectmanagementprogramc51.entity.*;
import com.example.diplomprojectmanagementprogramc51.enums.PriorityName;
import com.example.diplomprojectmanagementprogramc51.enums.StatusName;
import com.example.diplomprojectmanagementprogramc51.repository.CategoryRepository;
import com.example.diplomprojectmanagementprogramc51.repository.DepartmentRepository;
import com.example.diplomprojectmanagementprogramc51.repository.PriorityRepository;
import com.example.diplomprojectmanagementprogramc51.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DiplomProjectManagementProgramC51Application {

    @Autowired
    static
    CategoryRepository categoryRepository;

    @Autowired
    static
    DepartmentRepository departmentRepository;

    @Autowired
    static
    PriorityRepository priorityRepository;

    @Autowired
    static
    StatusRepository statusRepository;

    public static void main(String[] args) {
        SpringApplication.run(DiplomProjectManagementProgramC51Application.class, args);

//        Category category1 = new Category("front-end");
//        Category category2 = new Category("back-end");
//        List<Category> categories = Arrays.asList(category1, category2);
        //categoryRepository.saveAll(categories);

//        Department department1 = new Department("managers");
//        Department department2 = new Department("developers");
//        List<Department> departments = Arrays.asList(department1, department2);
        //departmentRepository.saveAll(departments);

//        Priority priority1 = new Priority(PriorityName.HIGH.name());
//        Priority priority2 = new Priority(PriorityName.NORMAL.name());
//        Priority priority3 = new Priority(PriorityName.LOW.name());
//        List<Priority> priorities = Arrays.asList(priority1, priority2, priority3);
        //priorityRepository.saveAll(priorities);

//        Status status1 = new Status(StatusName.TO_DO.name());
//        Status status2 = new Status(StatusName.IN_PROGRESS.name());
//        Status status3 = new Status(StatusName.DONE.name());
//        List<Status> statuses = Arrays.asList(status1, status2, status3);
        //statusRepository.saveAll(statuses);

    }

}
