package com.aoPremura.springBoot;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
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
