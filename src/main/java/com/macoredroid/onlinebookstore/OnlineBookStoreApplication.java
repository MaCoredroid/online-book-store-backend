package com.macoredroid.onlinebookstore;

import com.macoredroid.onlinebookstore.entity.Friend;
import com.macoredroid.onlinebookstore.repository.FriendRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableNeo4jRepositories
public class OnlineBookStoreApplication {
	private final static Logger log = LoggerFactory.getLogger(OnlineBookStoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(OnlineBookStoreApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
			}
		};
	}


}

