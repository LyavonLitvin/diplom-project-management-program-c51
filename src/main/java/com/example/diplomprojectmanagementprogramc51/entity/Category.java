package com.example.diplomprojectmanagementprogramc51.entity;

//import com.example.diplomprojectmanagementprogramc51.hibernatelistener.GeneralCreateUpdateListener;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;

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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category extends BasicEntity{

    @EqualsAndHashCode.Include
    @Column(unique = true, length = 40, nullable = false)
    private String name;
//    @OneToMany
//    private Set<Task> tasks = new HashSet<>();

}
