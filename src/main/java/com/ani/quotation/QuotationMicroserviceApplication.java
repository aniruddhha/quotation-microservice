package com.ani.quotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class QuotationMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuotationMicroserviceApplication.class, args);
	}
}

// docker run --name my-nginx -p 8085:80 -v /home/aniruddha/projects/fullstack-training/nginx-demo:/usr/share/nginx/html nginx