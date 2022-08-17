package net.maku.framework.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger配置
 *
 * @author 阿沐  babamu@126.com
 */
@Configuration
public class SwaggerConfig{

    @Bean
    public GroupedOpenApi userApi(){
        String[] paths = { "/**" };
        String[] packagedToMatch = { "net.maku" };
        return GroupedOpenApi.builder().group("FastCloud")
                .pathsToMatch(paths)
                .packagesToScan(packagedToMatch).build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact= new Contact();
        contact.setName("阿沐 babamu@126.com");

        OpenAPI openapi = new OpenAPI().info(new Info()
            .title("FastCloud")
            .description( "FastCloud")
            .contact(contact)
            .version("1.0")
            .termsOfService("https://maku.net")
            .license(new License().name("MIT")
            .url("https://maku.net")));

        openapi.addSecurityItem(new SecurityRequirement().addList("api_key"))
            .components(new Components().addSecuritySchemes("api_key",
                new SecurityScheme()
                    .name("Authorization")
                    .type(SecurityScheme.Type.APIKEY)
                    .in(SecurityScheme.In.HEADER)));

        return openapi;
    }

}