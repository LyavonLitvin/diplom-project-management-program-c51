package com.example.diplomprojectmanagementprogramc51.entity;


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
@Table(name = "categories")
@EqualsAndHashCode(callSuper = false)
public class Category extends BasicEntity{

    @Column(unique = true, length = 40, nullable = false)
    private String name;

}
