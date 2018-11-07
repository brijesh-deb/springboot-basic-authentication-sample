package com.example.springsecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderGenerator 
{
  public static String generate() 
  {
	  	String password = "userpassword";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		System.out.println(hashedPassword);
		return hashedPassword;
  }
}