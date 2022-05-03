package com.example.diplomprojectmanagementprogramc51.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false, exclude = {"roles","projects"})
public class User extends BasicEntity implements UserDetails {

	@Column(unique = true, length = 250, nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(unique = true, length = 250, nullable = false)
	private String email;
	@Column(length = 40)
	private String firstName;
	@Column(length = 40)
	private String lastName;
	@ManyToOne(targetEntity = Department.class)
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;

	@ManyToMany(cascade = {CascadeType.MERGE})
	@JoinTable(name="roles_users", joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@ManyToMany(cascade = {CascadeType.MERGE})
	@JoinTable(name="members", joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "project_id"))
	private Set<Project> projects = new HashSet<>();


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getAuthority()))
				.collect(Collectors.toList());
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


	public void addRole(Role role) {
		roles.add(role);
		role.getUsers().add(this);
	}

	public void removeRole(Role role) {
		roles.remove(role);
		role.getUsers().remove(this);
	}

	public void addProject(Project project) {
		projects.add(project);
		project.getUsers().add(this);
	}

	public void removeProject(Project project) {
		projects.remove(project);
		project.getUsers().remove(this);
	}
}
