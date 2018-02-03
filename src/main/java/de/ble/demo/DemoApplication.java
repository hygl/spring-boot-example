package de.ble.demo;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Function<Flux<String>, Flux<String>> uppercase() {
		return flux -> flux.log().map(value -> value.toUpperCase());
	}

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
			return application.sources(applicationClass);
	}

	private static Class<DemoApplication> applicationClass = DemoApplication.class;
}
