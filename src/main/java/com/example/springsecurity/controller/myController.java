package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.PasswordEncoderGenerator;

@RestController
@RequestMapping("/sample")
public class myController
{
    @RequestMapping("/test")
    public String testMethod()
    {
    	String str = "success";
        return str;
    }
    
    @RequestMapping("/password")
    public String genPassword()
    {
    	return PasswordEncoderGenerator.generate();
    }
}