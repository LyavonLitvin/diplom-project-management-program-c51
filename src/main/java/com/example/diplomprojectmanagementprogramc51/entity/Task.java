package com.example.diplomprojectmanagementprogramc51.entity;

//import com.example.diplomprojectmanagementprogramc51.hibernatelistener.GeneralCreateUpdateListener;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
//@EntityListeners(GeneralCreateUpdateListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
//@SuperBuilder
@Builder
@Table(name = "tasks")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Task extends BasicEntity{

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "executor_id", nullable = false)
    private User executor;


    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    @ManyToOne(targetEntity = Status.class)
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;


    @Column(length = 40, nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;

    @ManyToOne(targetEntity = Priority.class)
    @JoinColumn(name = "priority_id", nullable = false)
    private Priority priority;

    private LocalTime time;
    @Column(name = "time_left")
    private LocalTime timeLeft;
    @Column(name = "start_date")
    private LocalDate startDate;

    @OneToMany
    private Set<WorkTime> workTimes = new HashSet<>();

}
