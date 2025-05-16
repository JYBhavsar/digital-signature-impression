package com.sign;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
    info = @Info(
        title = "Digital Signature Impression API",
        version = "v1.0",
        description = "API for managing digital signature impression lifecycle",
        contact = @Contact(name = "Jay - Architect", email = "jay@example.com"),
        license = @License(name = "Proprietary License")
    )
)
@SpringBootApplication
public class DigitalSignatureImpressionApplication {
    public static void main(String[] args) {
        SpringApplication.run(DigitalSignatureImpressionApplication.class, args);
    }
}
