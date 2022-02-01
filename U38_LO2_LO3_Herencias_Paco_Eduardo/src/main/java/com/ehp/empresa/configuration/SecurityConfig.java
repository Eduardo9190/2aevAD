package com.ehp.empresa.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/* http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/libro").permitAll()
		.antMatchers(HttpMethod.GET, "/libro/*").hasAnyAuthority("ADMIN","USER")
		.anyRequest().hasRole("ADMIN")
		.and()
		.httpBasic(); */
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
		//String pwdEncode = passwordEncoder().encode();
		
		authentication.inMemoryAuthentication()
		.withUser("Admin").password(null).authorities("ADMIN")
		.and()
		.withUser("User").password(null).authorities("USER");
	}
}
