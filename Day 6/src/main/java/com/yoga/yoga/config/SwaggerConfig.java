package com.yoga.yoga.config;

import java.time.LocalDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
// import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket customImplementation() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.yoga.yoga"))
                .build()
                .apiInfo(apiInfo())
                .pathMapping("/")
                .useDefaultResponseMessages(false)
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class);
    }

        ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger for ZenvistaYoga")
                .version("1.0.0")
                .description("Operations related to Birthday Bash")
                .contact(new Contact("Mridini Shankar", "http://localhost:8080","mridinishankar2004@gmail.com"))
                .build();
    }
}