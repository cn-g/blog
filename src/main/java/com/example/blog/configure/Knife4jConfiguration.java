package com.example.blog.configure;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * swagger
 * @author Admin
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

//    @Bean
//    public Docket defaultApi2() {
//        Docket docket=new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(new ApiInfoBuilder()
//                        //.title("swagger-bootstrap-ui-demo RESTful APIs")
//                        .description("gcp test swagger APIS")
//                        //.termsOfServiceUrl("http://www.xx.com/")
//                        .contact(new Contact("郭长平","","2046039989@qq.com"))
//                        .license("2046039989@qq.com")
//                        .version("1.0")
//                        .build())
//                //分组名称
//                .groupName("后台相关API")
//                .select()
//                //这里指定Controller扫描包路径
//                .apis(RequestHandlerSelectors.basePackage("com.example.blog"))
//                .paths(PathSelectors.any())
//                .build();
//        return docket;
//    }

    /**
     * 相关Api
     *
     * @return
     */
    @Bean
    public Docket createApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("博客后台相关Api").apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.blog.controller.receptionController")).paths(PathSelectors.any()).build()
                .securitySchemes(Lists.<SecurityScheme>newArrayList(tokenKey(), accessType()));
    }

    /**
     * 手机端相关API
     * @return
     */
    @Bean
    public Docket createMobileApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("博客前台相关Api").apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.blog.controller.adminController")).paths(PathSelectors.any()).build()
                .securitySchemes(Lists.<SecurityScheme>newArrayList(tokenKey(), accessType()));
    }
    private ApiKey tokenKey() {
        return new ApiKey("用户认证", "token", "header");
    }

    private ApiKey accessType() {
        return new ApiKey("用户角色id", "role_id", "header");
    }

    private ApiInfo apiInfo() {

        Contact contact = new Contact("郭长平", "", "2046039989@qq.com");
        return new ApiInfoBuilder().title("博客相关Api").description("blog swagger APIS")
                .contact(contact).version("1.0.0").build();
    }

}
