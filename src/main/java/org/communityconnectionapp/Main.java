package org.communityconnectionapp;

import org.communityconnectionapp.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Import(SecurityConfig.class)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}