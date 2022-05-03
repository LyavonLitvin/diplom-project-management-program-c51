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
@Table(name = "priorities")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Priority extends BasicEntity{

    @EqualsAndHashCode.Include
    @Column(unique = true, length = 45, nullable = false)
    private String name;
//    @OneToMany
//    private Set<Task> tasks = new HashSet<>();

}
