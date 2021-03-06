package com.example.diplomprojectmanagementprogramc51.service;

import com.example.diplomprojectmanagementprogramc51.dto.PriorityDTO;
import com.example.diplomprojectmanagementprogramc51.entity.Priority;
import com.example.diplomprojectmanagementprogramc51.mapper.PriorityMapper;
import com.example.diplomprojectmanagementprogramc51.repository.PriorityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PriorityService {
    @Autowired
    private PriorityRepository priorityRepository;
    @Autowired
    private PriorityMapper priorityMapper;

    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }


    public boolean save(PriorityDTO priorityDTO){
        Priority priority = priorityMapper.priorityDTOToPriority(priorityDTO);
        if(existsByName(priority)){
            return false;
        }
        else {
            priorityRepository.save(priority);
            return true;
        }
    }

    public boolean delete(PriorityDTO priorityDTO){
        Priority priority = priorityMapper.priorityDTOToPriority(priorityDTO);
        if(existsByName(priority)){
            return false;
        }
        else {
            priorityRepository.delete(priority);
            return true;
        }
    }

    public boolean update(PriorityDTO priorityDTO){

        Priority priority = priorityMapper.priorityDTOToPriority(priorityDTO);
        Priority priorityCheck = priorityRepository.saveAndFlush(priority);
        return  priority.equals(priorityCheck);
    }

    public boolean existsByName(Priority priority){
        return priorityRepository.existsByName(priority.getName());
    }

    public List<Priority> findAll(){
        return priorityRepository.findAll();
    }

    public Optional<Priority> findById(long id){
        return priorityRepository.findById(id);
    }

    public Optional<Priority> findByName(String name){
        return priorityRepository.findByName(name);
    }
}

