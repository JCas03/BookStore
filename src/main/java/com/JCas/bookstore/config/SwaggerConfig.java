package com.JCas.bookstore.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket bookStoreApiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.JCas.bookstore.Controller"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(apiMetaData());
    }

    private ApiInfo apiMetaData() {
        return new ApiInfo(
                "Book Store REST API",
                "ALL api's for book store application",
                "1.0",
                "term and condition url",
                new Contact(
                        "BookStore Admin",
                        "https://book-store-v2.herokuapp.com",
                        "bookstore@gmail.com"
                ),
                "book store licence",
                "licence url",
                Collections.emptyList()
        );
    }

}
