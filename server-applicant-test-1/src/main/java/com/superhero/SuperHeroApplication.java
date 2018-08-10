package com.superhero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.superhero.util.LoggingInterceptor;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main entity for Super Hero Application.
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 08.08.2018
 */
@EnableSwagger2
@SpringBootApplication
public class SuperHeroApplication extends
		WebMvcConfigurerAdapter {

	/**
	 * Main method.
	 */
	public static void main(String[] args) {
		SpringApplication.run(SuperHeroApplication.class, args);
	}

	/**
	 * Adding Interceptors.
	 * 
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggingInterceptor())
				.addPathPatterns("/**");
	}

	/**
	 * Provides sensible defaults and convenience methods for configuration.
	 * 
	 * @return Docket
	 */
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(getClass()
						.getPackage().getName())).paths(PathSelectors.any())
				.build().apiInfo(generateApiInfo());
	}

	/**
	 * Generate Web Service API information.
	 * 
	 * @return ApiInfo
	 */
	private ApiInfo generateApiInfo() {
		return new ApiInfo(
				"Super Hero Creator Application.",
				"This service is to simulate a super hero application.",
				"Version 1.0 - mw", "urn:tos", "ahmed.elgamal.dev@gmail.com",
				"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	}
}
