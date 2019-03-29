package de.grimmpp.springboot.zipkindemo.zipkindemo;

import brave.http.HttpTracing;
import brave.spring.web.TracingClientHttpRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@SpringBootApplication
public class ZipkinDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinDemoApplication.class, args);
	}

}
