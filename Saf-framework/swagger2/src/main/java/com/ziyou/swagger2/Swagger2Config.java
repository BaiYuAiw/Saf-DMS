package com.ziyou.swagger2;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author libo
 * @date 2023/10/27
 */
@SpringBootConfiguration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class Swagger2Config {
    @Autowired
    private Swagger2ConfigProperties properties;

    @Bean
    public Docket safSwaggerApp(){
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(properties.isShow())
                .groupName(properties.getGroupName())
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(properties.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(properties.getTitle())
                .description(properties.getDesc())
                .termsOfServiceUrl(properties.getServiceUrl())
                .contact(contact())
                .version(properties.getVersion())
                .build();
    }

    private Contact contact(){
        return new Contact(properties.getContactName(),properties.getContactUrl(),properties.getContactEmail());
    }

}
