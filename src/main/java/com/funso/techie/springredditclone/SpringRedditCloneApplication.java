package com.funso.techie.springredditclone;

import com.funso.techie.springredditclone.config.OpenAPIConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(OpenAPIConfiguration.class)
public class SpringRedditCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedditCloneApplication.class, args);
	}

}