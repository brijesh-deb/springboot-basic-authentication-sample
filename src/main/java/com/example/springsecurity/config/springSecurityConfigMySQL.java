package com.example.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableAutoConfiguration
public class springSecurityConfigMySQL extends WebSecurityConfigurerAdapter 
{
	    @Autowired
	    private DataSource ds;

	    /* Spring Security Configurations Start */
	    @Autowired
	    public void configureAMBuilder(AuthenticationManagerBuilder auth) throws Exception 
	    {
	    	System.out.println("Inside configureAMBuilder");
	        auth.jdbcAuthentication().dataSource(ds)
	        .authoritiesByUsernameQuery("select userName, role FROM USERS where userName=?")
	        .usersByUsernameQuery("select userName,userPassword,1 FROM USERS where userName=?");
	        System.out.println("Inside configureAMBuilder - END");
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .httpBasic()
	            .and()
	            .authorizeRequests()
	            .anyRequest().authenticated();
	        http.csrf().disable();
	    }
}