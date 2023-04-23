package com.svyatdanilov.investmentproject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/projects/list").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/projects/showFormForAdd").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/projects/showFormForUpdate").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/projects/delete").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/projects/save").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/users").hasRole("ADMIN"));
        http
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();

        return http.build();
    }





}
