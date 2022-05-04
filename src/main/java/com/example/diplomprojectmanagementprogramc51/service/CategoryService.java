package com.example.diplomprojectmanagementprogramc51.service;


import com.example.diplomprojectmanagementprogramc51.entity.Category;
import com.example.diplomprojectmanagementprogramc51.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@Transactional

public class CategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public boolean save(Category category){
        if(existsByName(category)){
            return false;
        }
        else {
            categoryRepository.save(category);
            return true;
        }
    }

    public boolean delete(Category category){
        if(existsByName(category)){
            return false;
        }
        else {
            categoryRepository.delete(category);
            return true;
        }
    }

    public boolean update(Category category){
        Category categoryCheck = categoryRepository.saveAndFlush(category);
        return  category.equals(categoryCheck);
    }

    public boolean existsByName(Category category){
        return categoryRepository.existsByName(category.getName());
    }

    public List<Category> findAllByName(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(long id){
        return categoryRepository.findById(id);
    }

    public Optional<Category> findByName(String name){
        return categoryRepository.findByName(name);
    }
}
