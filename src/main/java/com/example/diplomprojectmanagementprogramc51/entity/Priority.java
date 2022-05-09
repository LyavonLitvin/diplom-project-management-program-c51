package com.example.diplomprojectmanagementprogramc51.entity;

//import com.example.diplomprojectmanagementprogramc51.hibernatelistener.GeneralCreateUpdateListener;
import com.example.diplomprojectmanagementprogramc51.hibernatelistener.GeneralCreateUpdateListener;
import lombok.*;
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
@EqualsAndHashCode(callSuper = false)
public class Priority extends BasicEntity{


    @Column(unique = true, length = 45, nullable = false)
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE})
    private Set<Task> tasks = new HashSet<>();

}
