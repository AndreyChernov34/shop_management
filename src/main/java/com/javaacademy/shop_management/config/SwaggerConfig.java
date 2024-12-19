package com.javaacademy.shop_management.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi() {
        Info info = new Info()
                .title("Дз система управления магазинами")
                .contact(new Contact().email("che34@mail.ru")
                        .name("Андрей Чернов")
                );
        return new OpenAPI()
                .info(info);
    }
}
