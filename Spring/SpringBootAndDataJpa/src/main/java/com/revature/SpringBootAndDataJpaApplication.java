package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

/*
 * Note the @SpringBootApplication annotation here. This annotation is actually a combination of
 * several different annotations:
 * 
 * @Configuration: this allows us to create methods that are annotated @Bean.
 * @ComponentScan: tells the framework which packages to scan for Spring annotations; by default in
 * 				   a Spring Boot application, all subpackages of the main class's package are
 * 				   scanned. This means that all packages that fall under "com.revature are scanned.
 * @EnableAutoConfiguration: auto configures our Application Context (our current IoC container),
 * 							 making assumptions about which beans should be added to the context.
 */
@SpringBootApplication
public class SpringBootAndDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAndDataJpaApplication.class, args);
	}
	
	/*
	 * For anyone who is using a 3rd party API for their project, calling the 3rd party API from
	 * the client (e.g. your React application) is actually considered bad practice. You should
	 * use your backend (your Java application) to make this request to the 3rd party API and
	 * then expose an endpoint to your client to pass the data to the client. In order to achieve
	 * this, we can use what is known as RestTemplate. RestTemplate allows us to make HTTP requests
	 * from within our Spring applications.
	 * 
	 * Yes, we're going to add the RestTemplate as a bean.
	 */
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		/*
		 * This step is optional but useful if you're using your RestTemplate to make a request to the exact
		 * same API each time as it allows us to specify a base URL that we can append to later.
		 */
		restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("https://pokeapi.co/api/v2/"));
		return restTemplate;
	}
	
	

}
