package com.w2m.superheroes.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user").password("{noop}password").roles("USER")
            .and()
            .withUser("admin").password("{noop}password").roles("USER", "ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/superheroes/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST, "/superheroes/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.PUT, "/superheroes/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.PATCH, "/superheroes/**").hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "/superheroes/**").hasRole("ADMIN")
            .and()
            .csrf().disable()
            .formLogin().disable();
    }
}