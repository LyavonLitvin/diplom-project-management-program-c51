package com.example.diplomprojectmanagementprogramc51.entity;

import com.example.diplomprojectmanagementprogramc51.hibernatelistener.GeneralCreateUpdateListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(GeneralCreateUpdateListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "departments")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Department extends BasicEntity{

    @EqualsAndHashCode.Include
    @Column(unique = true, length = 40, nullable = false)
    private String name;
//    @OneToMany
//    private Set<User> employees = new HashSet<>();

}