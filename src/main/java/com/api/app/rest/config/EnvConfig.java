package com.api.app.rest.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class EnvConfig {
    @PostConstruct
    public void loadEnv() {
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(entry -> {
            System.setProperty(entry.getKey(), entry.getValue());
        });

        boolean isConfigValid = validateDbConfig();

        if (isConfigValid) {
            System.out.println("✅ Succesful connection to Database from .env");
        } else {
            System.err.println("❌ Failed connection to Database from .env");
        }
    }

    private boolean validateDbConfig() {
        String dbUrl = System.getProperty("DB_URL");
        String dbUsername = System.getProperty("DB_USERNAME");
        String dbPassword = System.getProperty("DB_PASSWORD");

        return dbUrl != null && !dbUrl.isBlank()
                && dbUsername != null && !dbUsername.isBlank()
                && dbPassword != null && !dbPassword.isBlank();
    }
}
