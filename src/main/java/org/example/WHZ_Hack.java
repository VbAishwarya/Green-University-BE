package org.example;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "GREEN-FHU API", version = "1.0", description = "API for Green FHU"))
public class WHZ_Hack {
    public static void main(String[] args) {
        SpringApplication.run(WHZ_Hack.class, args);
    }
}