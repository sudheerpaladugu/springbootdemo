package com.normal.spring.initial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//@EnableEurekaClient
@RestController
@ComponentScan({
	"org.springframework.web.client.RestTemplate",
	"com.normal.spring.initial.controller",
	"com.normal.spring.initial.exception",
	"com.normal.spring.initial.interceptor",
	"com.normal.spring.initial.service",
	"com.normal.spring.initial.security",
	"com.normal.spring.initial.model"
	})
public class DemoApplication {
   public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
   }
   
   @Bean
   public WebMvcConfigurer corsConfigurer() {
      return new WebMvcConfigurer() {
         @Override
         public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/products").allowedOrigins("http://localhost:8080");
         }
      };
   }
   
   @RequestMapping("/client")
   public static String getMessage() {	   
	   return "Hello message form Eureka Client";
   }
}