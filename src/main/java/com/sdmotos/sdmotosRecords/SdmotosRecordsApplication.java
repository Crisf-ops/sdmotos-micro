package com.sdmotos.sdmotosRecords;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootApplication
public class SdmotosRecordsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdmotosRecordsApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedOrigins("http://127.0.0.1:5173/").allowedMethods("*").allowedHeaders("*");
			}
		};
	}
}
