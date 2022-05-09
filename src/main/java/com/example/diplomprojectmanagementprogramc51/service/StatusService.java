package com.example.diplomprojectmanagementprogramc51.service;


import com.example.diplomprojectmanagementprogramc51.dto.StatusDTO;
import com.example.diplomprojectmanagementprogramc51.entity.Status;
import com.example.diplomprojectmanagementprogramc51.mapper.StatusMapper;
import com.example.diplomprojectmanagementprogramc51.repository.StatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    StatusMapper statusMapper;


    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public boolean save(StatusDTO statusDTO){
        Status status = statusMapper.statusDTOToStatus(statusDTO);
        if(existsByName(status)){
            return false;
        }
        else {
            statusRepository.save(status);
            return true;
        }
    }

    public boolean delete(StatusDTO statusDTO){
        Status status = statusMapper.statusDTOToStatus(statusDTO);
        if(existsByName(status)){
            statusRepository.delete(status);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean update(Status status){
        Status statusCheck = statusRepository.saveAndFlush(status);
        return  status.equals(statusCheck);
    }

    public boolean existsByName(Status status){
        return statusRepository.existsByName(status.getName());
    }

    public List<Status> findAll(){
        return statusRepository.findAll();
    }

    public Optional<Status> findById(long id){
        return statusRepository.findById(id);
    }

    public Optional<Status> findByName(String name){
        return statusRepository.findByName(name);
    }
}
