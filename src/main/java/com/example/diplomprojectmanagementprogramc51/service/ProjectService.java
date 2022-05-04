package com.example.diplomprojectmanagementprogramc51.service;


import com.example.diplomprojectmanagementprogramc51.entity.Project;
import com.example.diplomprojectmanagementprogramc51.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public boolean save(Project project){
        if(existsByName(project)){
            return false;
        }
        else {
            projectRepository.save(project);
            return true;
        }
    }

    public boolean delete(Project project){
        if(existsByName(project)){
            return false;
        }
        else {
            projectRepository.delete(project);
            return true;
        }
    }

    public boolean update(Project project){
        Project projectCheck = projectRepository.saveAndFlush(project);
        return  project.equals(projectCheck);
    }

    public boolean existsByName(Project project){
        return projectRepository.existsByName(project.getName());
    }

    public List<Project> findAllByName(){
        return projectRepository.findAll();
    }

    public Optional<Project> findById(long id){
        return projectRepository.findById(id);
    }

    public Optional<Project> findByName(String name){
        return projectRepository.findByName(name);
    }
}
