package com.funso.techie.springredditclone;

import com.funso.techie.springredditclone.config.OpenAPIConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ospringframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(OpenAPIConfiguration.class)
public class SpringredditcloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringredditcloneApplication.class, args);
	}

}