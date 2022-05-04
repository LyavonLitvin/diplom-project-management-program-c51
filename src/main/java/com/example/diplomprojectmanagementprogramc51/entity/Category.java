package com.example.diplomprojectmanagementprogramc51.entity;


import lombok.*;

import javax.persistence.*;

@Entity

//@EntityListeners(GeneralCreateUpdateListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
//@SuperBuilder
@Builder
@Table(name = "categories")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category extends BasicEntity{

    @EqualsAndHashCode.Include
    @Column(unique = true, length = 40, nullable = false)
    private String name;
//    @OneToMany
//    private Set<Task> tasks = new HashSet<>();

}
