package com.example.diplomprojectmanagementprogramc51.service;


import com.example.diplomprojectmanagementprogramc51.dto.CategoryDTO;
import com.example.diplomprojectmanagementprogramc51.entity.Category;
import com.example.diplomprojectmanagementprogramc51.mapper.CategoryMapper;
import com.example.diplomprojectmanagementprogramc51.mapper.CategoryMapperImpl;
import com.example.diplomprojectmanagementprogramc51.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j


public class CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public boolean save(CategoryDTO categoryDTO){
        Category category = categoryMapper.categoryDTOToCategory(categoryDTO);
        if(existsByName(category)){
            return false;
        }
        else {
            categoryRepository.save(category);
            return true;
        }
    }

    public boolean delete(CategoryDTO categoryDTO){
        Category category = categoryMapper.categoryDTOToCategory(categoryDTO);
        if(existsByName(category)){
            return false;
        }
        else {
            categoryRepository.delete(category);
            return true;
        }
    }

    public boolean update(CategoryDTO categoryDTO){
        Category category = categoryMapper.categoryDTOToCategory(categoryDTO);
        Category categoryCheck = categoryRepository.saveAndFlush(category);
        return  category.equals(categoryCheck);
    }

    public boolean existsByName(Category category){
        return categoryRepository.existsByName(category.getName());
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(long id){
        return categoryRepository.findById(id);
    }

    public Optional<Category> findByName(String name){
        return categoryRepository.findByName(name);
    }
}
