package com.reconnect.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.reconnect.enums.Perfil;


@Configuration
public class WebSecurityConfig {
	@SuppressWarnings("removal")
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http. authorizeHttpRequests()
		.requestMatchers(HttpMethod.GET, "/usuario").hasAuthority(Perfil.ADMIN.toString())
		.anyRequest().permitAll();
		
//		 http .csrf().disable(); 
		return http.build();
	}
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

}