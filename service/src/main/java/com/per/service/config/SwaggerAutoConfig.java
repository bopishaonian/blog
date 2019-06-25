package com.per.service.config;


import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huangbo
 * @Description:
 * @date 2019/5/27 17:25
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty({"swagger.conf.host"})
@ConfigurationProperties("swagger.conf")
@Data
public class SwaggerAutoConfig {
    private String groupName;
    private String basePackage;
    private String title;
    private String host;
    private String desc;
    private String serviceUrl;
    private String version;

    @Bean
    public Docket createRestApi() {
        List<Parameter> pars = new ArrayList<Parameter>() {
            private static final long serialVersionUID = 1L;{
                this.add((new ParameterBuilder())
                        .name("gsid")
                        .description("全局会话ID(必要时使用)")
                        .modelRef(new ModelRef("string"))
                        .parameterType("header")
                        .required(false).build());
            }
        };
        return (new Docket(DocumentationType.SWAGGER_2))
                .groupName(this.groupName)
                .apiInfo(this.apiInfo())
                .host(this.host).select()
                .apis(RequestHandlerSelectors.basePackage(this.basePackage))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }
    private ApiInfo apiInfo() {
        return (new ApiInfoBuilder())
                .title(this.title)
                .description(this.desc)
                .termsOfServiceUrl(this.serviceUrl)
                .version(this.version + LocalDateTime.now())
                .build();
    }
}
