//package com.example.diplomprojectmanagementprogramc51.entity;
//
////import com.example.diplomprojectmanagementprogramc51.hibernatelistener.GeneralCreateUpdateListener;
//import lombok.*;
//import lombok.experimental.SuperBuilder;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
////@EntityListeners(GeneralCreateUpdateListener.class)
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
////@SuperBuilder
//@Builder
//@Table
//@EqualsAndHashCode(callSuper = false, exclude = {"users"})
//public class Project extends BasicEntity {
//
//    @Column(unique = true, length = 45, nullable = false)
//    private String name;
//    @Column(nullable = false)
//    private String description;
//
//    @ManyToOne(targetEntity = User.class)
//    @JoinColumn(name = "creator_id", nullable = false)
//    private User user;
//
//    @ManyToMany(mappedBy = "projects")
//    private Set<User> users = new HashSet<>();
//
//}