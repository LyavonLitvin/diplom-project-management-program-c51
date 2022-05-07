//package com.example.diplomprojectmanagementprogramc51.service;
//
//
//import com.example.diplomprojectmanagementprogramc51.entity.Department;
//import com.example.diplomprojectmanagementprogramc51.repository.DepartmentRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Slf4j
//public class DepartmentService {
//    @Autowired
//    private DepartmentRepository departmentRepository;
//
//    public DepartmentService(DepartmentRepository departmentRepository) {
//        this.departmentRepository = departmentRepository;
//    }
//
//    public boolean save(Department department){
//        if(existsByName(department)){
//            return false;
//        }
//        else {
//            departmentRepository.save(department);
//            return true;
//        }
//    }
//
//    public boolean delete(Department department){
//        if(existsByName(department)){
//            return false;
//        }
//        else {
//            departmentRepository.delete(department);
//            return true;
//        }
//    }
//
//    public boolean update(Department department){
//        Department departmentCheck = departmentRepository.saveAndFlush(department);
//        return  department.equals(departmentCheck);
//    }
//
//    public boolean existsByName(Department department){
//        return departmentRepository.existsByName(department.getName());
//    }
//
//    public List<Department> findAllByName(){
//        return departmentRepository.findAll();
//    }
//
//    public Optional<Department> findById(long id){
//        return departmentRepository.findById(id);
//    }
//
//    public Optional<Department> findByName(String name){
//        return departmentRepository.findByName(name);
//    }
//}
