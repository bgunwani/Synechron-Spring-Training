package com.bhawnagunwani.SpringBootRestResourceDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication

@EnableJpaRepositories
@EnableSpringDataWebSupport
public class SpringBootRestResourceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestResourceDemoApplication.class, args);
	}

}
