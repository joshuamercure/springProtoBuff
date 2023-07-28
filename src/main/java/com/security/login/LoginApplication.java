package com.security.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@SpringBootApplication
@EnableJpaRepositories
public class LoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

	private SecurityScheme createAPIKeyScheme() {
    return new SecurityScheme().type(SecurityScheme.Type.HTTP)
        .bearerFormat("JWT")
        .scheme("bearer");
}
@Bean
public OpenAPI openAPI() {
    return new OpenAPI().addSecurityItem(new SecurityRequirement().
            addList("Bearer Authentication"))
        .components(new Components().addSecuritySchemes
            ("Bearer Authentication", createAPIKeyScheme()))
        .info(new Info().title("Base REST API")
            .description("Base App Rest API")
            .version("1.0").contact(new Contact().name("NONE")
                .email( "NONE").url("NONE"))
            .license(new License().name("NONE")
                .url("NONE")));
}
	

}
