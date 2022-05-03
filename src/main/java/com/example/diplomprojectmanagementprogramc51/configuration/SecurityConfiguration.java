package com.example.diplomprojectmanagementprogramc51.configuration;

import com.example.diplomprojectmanagementprogramc51.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@PropertySource("classpath:security.properties")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Value("${permit.all}")
	private String[] permitAllPatterns;

	public SecurityConfiguration(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
//				.authorizeRequests()
//				.antMatchers("/", "/user/reg", "/db/**").permitAll()
//				//.antMatchers(permitAllPatterns).permitAll()
//				.anyRequest().authenticated()
//				.and()
//				.formLogin()
//				.loginPage("/user/login")
//				.permitAll()
//				.and()
//				.logout()
//				.permitAll();

				.csrf().disable()
				.authorizeRequests()
				.antMatchers(permitAllPatterns).permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/user/login")
				.usernameParameter("username").passwordParameter("password")
				.failureUrl("/user/login?failed=true")
				.and()
				.logout()
				.logoutUrl("/user/logout")
				.logoutSuccessUrl("/user/login")
				.invalidateHttpSession(true);

	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("test")
				.password(passwordEncoder().encode("test"))
				.roles("USER");
		//auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}
}
