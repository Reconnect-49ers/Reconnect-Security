package com.reconnect.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig {

    private final UserDetailsService userDetailsService;

//    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz	
            	.requestMatchers("/").permitAll()
            	.requestMatchers("/index").permitAll()
            	.requestMatchers("/images/**").permitAll()
            	.requestMatchers("/styles/**").permitAll()
            	.requestMatchers(HttpMethod.GET, "/serv/imagem/**").permitAll()
            	.requestMatchers(HttpMethod.GET, "/user/imagem/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/usuario").hasAuthority("admin")
                .requestMatchers("/usuario/cadastrar").permitAll()
                .requestMatchers("/usuario/cadastrar").hasAuthority("admin")
                .requestMatchers("/faleconosco").hasAuthority("admin")
                .requestMatchers("/faleconosco/cadastrar").permitAll()
                .requestMatchers("/profissionais").permitAll()
                .requestMatchers("/servicos").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(formLogin -> formLogin
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/usuario/perfil", true)
                .permitAll()
            )
            .logout((logout) -> logout
            		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            		.logoutSuccessUrl("/login")
            		.permitAll()
            		);
        
        // http.csrf().disable();
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
