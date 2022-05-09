package com.example.diplomprojectmanagementprogramc51.hibernatelistener;

import com.example.diplomprojectmanagementprogramc51.entity.BasicEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class GeneralCreateUpdateListener {

    @PrePersist
    private void setCreationAndUpdateDates(BasicEntity basicEntity) {
        basicEntity.setCreationDateTime(LocalDateTime.now());
        basicEntity.setUpdateDateTime(LocalDateTime.now());
    }

    @PreUpdate
    private void setUpdateDate(BasicEntity basicEntity) {
        basicEntity.setUpdateDateTime(LocalDateTime.now());
    }
}
