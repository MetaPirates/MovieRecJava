package com.MovieRec.MovieRec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"Contracts","com.org.example"})

public class ProjectConfig {
	
	@Bean
	public RestTemplate r() { 
		return new RestTemplate();
	}
	
	
	
	

}
