package com.example.springsecurity.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableAutoConfiguration
public class springSecurityConfigInMem extends WebSecurityConfigurerAdapter 
{
    // Authentication : set user/password details and mention the role
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
            .withUser("user").password("pass").roles("USER")
            .and()
            .withUser("admin").password("pass").roles("USER", "ADMIN");
    }
}