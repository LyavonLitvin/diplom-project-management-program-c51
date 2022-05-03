package com.example.diplomprojectmanagementprogramc51.entity;

import com.example.diplomprojectmanagementprogramc51.hibernatelistener.GeneralCreateUpdateListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@EntityListeners(GeneralCreateUpdateListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "work_times")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WorkTime extends BasicEntity{

    @ManyToOne(targetEntity = Task.class)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(length = 45, nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalTime time;
    @Column(nullable = false)
    private LocalDate date;

}
