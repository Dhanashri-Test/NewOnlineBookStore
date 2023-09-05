package com.online.bookstore.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Collections;

@Configuration
//@EnableSwagger2WebMvc
//@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo(){

        return new ApiInfo(
                "Spring Boot OnlineBook Shopping",
                "Spring Boot Online Book sh Documnetation",
                "1.0.0",
                "Terms of service",
                new Contact("Dhanashri Mahajan","com.online.bookstore.demo","dhanashri.mahajan@eviden.com"),
                "API License","API License Url", Collections.emptyList());
    }


    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
    }
}
