package com.example.diplomprojectmanagementprogramc51.service;

import com.example.diplomprojectmanagementprogramc51.entity.Category;
import com.example.diplomprojectmanagementprogramc51.entity.WorkTime;
import com.example.diplomprojectmanagementprogramc51.repository.WorkTimeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class WorkTimeService {
    @Autowired
    private WorkTimeRepository workTimeRepository;

    public WorkTimeService(WorkTimeRepository workTimeRepository) {
        this.workTimeRepository = workTimeRepository;
    }

    public boolean save(WorkTime workTime){
        if(existsByName(workTime)){
            return false;
        }
        else {
            workTimeRepository.save(workTime);
            return true;
        }
    }

    public boolean delete(WorkTime workTime){
        if(existsByName(workTime)){
            return false;
        }
        else {
            workTimeRepository.delete(workTime);
            return true;
        }
    }

    public boolean update(WorkTime workTime){
        WorkTime workTimeCheck = workTimeRepository.saveAndFlush(workTime);
        return  workTime.equals(workTimeCheck);
    }

    public boolean existsByName(WorkTime workTime){
        return workTimeRepository.existsByName(workTime.getName());
    }

    public List<WorkTime> findAllByName(){
        return workTimeRepository.findAll();
    }

    public Optional<WorkTime> findById(long id){
        return workTimeRepository.findById(id);
    }

    public Optional<WorkTime> findByName(String name){
        return workTimeRepository.findByName(name);
    }
}

