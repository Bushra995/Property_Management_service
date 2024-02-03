package com.Property_Management_service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Bushra Rehman",
                        email ="bushraf995@gmail.com"
                ) ,
                description =  "API services for Property management system",
                title ="Property_Management_service",
                version = "3"
        ),
        servers = {
                @Server(
                        description = "LOCAL ENV",
                        url ="localhost:8081"
                )
        }
)
public class OpenApiConfig {

}