package com.example.diplomprojectmanagementprogramc51.entity;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

//@EntityListeners(GeneralCreateUpdateListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
//@SuperBuilder
@Builder
@Table(name = "categories")
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category extends BasicEntity{

    @EqualsAndHashCode.Include
    @Column(unique = true, length = 40, nullable = false)
    private String name;

}
