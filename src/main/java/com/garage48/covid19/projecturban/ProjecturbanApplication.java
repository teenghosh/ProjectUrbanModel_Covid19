package com.garage48.covid19.projecturban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EnableConfigurationProperties
public class ProjecturbanApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjecturbanApplication.class, args);
	}
	

}
