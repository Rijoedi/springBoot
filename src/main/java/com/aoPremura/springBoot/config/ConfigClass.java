package com.aoPremura.springBoot.config;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@ComponentScan("com.aoPremura.springBoot.controller")
@EntityScan("com.aoPremura.springBoot.model")
@EnableJpaRepositories("com.aoPremura.springBoot.repository")
public class ConfigClass {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClass.class, args);
	}
	
	@Bean
	public DataSource dataSource(){
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://192.168.50.11:3307/springBootTest");
	    dataSource.setUsername("root");
	    dataSource.setPassword("12345");
	    return dataSource;
	}

}
