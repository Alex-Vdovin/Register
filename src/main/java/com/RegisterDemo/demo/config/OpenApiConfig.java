package com.RegisterDemo.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "RegisterDemo",
                description = "Register", version = "3.0.0",
                contact = @Contact(
                        name = "Aleksandr Vdovin",
                        email = "av.avisto@mail.ru",
                        url = "https://vk.com/aster_vermillion"
                )
        )
)
public class OpenApiConfig {
}
