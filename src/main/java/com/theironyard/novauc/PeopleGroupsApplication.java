package com.theironyard.novauc;

import io.swagger.models.Contact;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service;

@SpringBootApplication
@EnableSwagger2


public class PeopleGroupsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleGroupsApplication.class, args);
	}

	@Bean
	public Docket swaggerSettings() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaData())
				.pathMapping("/");
	}
	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo(
				"PeopleGroups by Ross Small",
				"PeopleGroups Rest API",
				"1.0",
				"Terms of service",
				 "Ross Small, https://github.com/rsmall0006, rsmall0006@email.vccs.edu",
				"Apache License Version 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo;
	}

}
