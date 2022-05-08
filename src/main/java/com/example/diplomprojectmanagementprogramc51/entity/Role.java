package com.example.diplomprojectmanagementprogramc51.entity;


import lombok.*;

import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
@EqualsAndHashCode(callSuper = false, exclude = {"users"})
public class Role extends BasicEntity implements GrantedAuthority {
	@Column(unique = true, length = 250, nullable = false)
	private String name;
	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<>();

	@Override
	public String getAuthority() {
		return name;
	}
}
