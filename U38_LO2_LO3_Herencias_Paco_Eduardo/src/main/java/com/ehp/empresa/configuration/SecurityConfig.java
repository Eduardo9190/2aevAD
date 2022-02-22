package com.ehp.empresa.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/tareas").hasAnyAuthority("ADMIN")
		.antMatchers(HttpMethod.GET, "/tareas/*").hasAnyAuthority("ADMIN")
		.antMatchers(HttpMethod.GET, "/tareasUser/*").hasAnyAuthority("ADMIN", "USER")
		.antMatchers(HttpMethod.POST, "/tarea").hasAnyAuthority("ADMIN")
		.antMatchers(HttpMethod.PUT, "/tarea/*").hasAnyAuthority("ADMIN", "USER")
		.antMatchers(HttpMethod.DELETE, "/tarea/*").hasAnyAuthority("ADMIN")
		.antMatchers(HttpMethod.GET, "/empleados").hasAnyAuthority("ADMIN")
		.antMatchers(HttpMethod.POST, "/empleado").hasAnyAuthority("ADMIN")
		.and()
		.httpBasic();
	}
	

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
		String pwdEncode = new BCryptPasswordEncoder().encode("12345");
		
		authentication.inMemoryAuthentication()
		.withUser("Admin").password(pwdEncode).authorities("ADMIN")
		.and()
		.withUser("User").password(pwdEncode).authorities("USER");
	}
}
