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
public class springSecurityConfigOracle extends WebSecurityConfigurerAdapter 
{
	    @Autowired
	    private DataSource ds;

	    /* Spring Security Configurations Start */
	    @Autowired
	    public void configureAMBuilder(AuthenticationManagerBuilder auth) throws Exception 
	    {
	    	System.out.println("Inside configureAMBuilder");
	        auth.jdbcAuthentication().dataSource(ds)
	        .authoritiesByUsernameQuery("select USERNAME, ROLE FROM USERS where USERNAME=?")
	        .usersByUsernameQuery("select USERNAME,PASSWORD, 1 FROM USERS where USERNAME=?");
	    	System.out.println("Inside configureAMBuilder - end");
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