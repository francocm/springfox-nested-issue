package com.test;

import com.fasterxml.classmate.TypeResolver;
import com.test.pojos.ApplicationLang;
import com.test.pojos.Language;
import com.test.pojos.LanguageResponse;
import com.test.pojos.LanguageText;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Config {

    @Bean
    public Docket swagger2() {
        TypeResolver typeResolver = new TypeResolver();
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(
                        "com.test"))
                .paths(PathSelectors.ant("/**")).build().
                useDefaultResponseMessages(false)
                .apiInfo(apiInfo()).additionalModels(typeResolver.resolve(LanguageResponse.class),
                typeResolver.resolve(ApplicationLang.class),
                typeResolver.resolve(Language.class),
                typeResolver.resolve(LanguageText.class));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Springfox Nested Issue")
                .description("Hello World!")
                .version("1.0")
                .build();
    }

}
