package com.bxl.plus.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @Author: 白小楼
 * @Description:
 * @Date:Create in 2023/9/8 10:59
 */
@Configuration
@EnableSwagger2     //开启文档功能
public class Swagger2Config {

    @Bean
    public Docket createRestApi(){
        Predicate<RequestHandler> userPredicate = RequestHandlerSelectors.basePackage("com.bxl.plus.controller");
        return new Docket(DocumentationType.SWAGGER_2)  // 指定api类型为swagger2
                .apiInfo(apiInfo())                 // 用于定义api文档汇总信息
                .select()
                .apis(Predicates.or(userPredicate))
//                .apis(Predicates.or(adminPredicate, articlePredicate, userPredicate, filesPredicate))
                .paths(PathSelectors.any())         // 所有controller
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("百晓生江湖榜")                       // 文档页标题
                .contact(new Contact("bxs",
                        "https://www.bxs.com",
                        "bxs@163.com"))                   // 联系人信息
                .description("专为百晓生江湖榜提供的api文档")      // 详细信息
                .version("1.0.1")                               // 文档版本号
                .termsOfServiceUrl("https://www.bxs.com")     // 网站地址
                .build();
    }

}
