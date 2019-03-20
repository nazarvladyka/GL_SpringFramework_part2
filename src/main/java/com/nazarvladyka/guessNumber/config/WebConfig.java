package com.nazarvladyka.guessNumber.config;

import com.nazarvladyka.guessNumber.service.GameManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com")
public class WebConfig {

    @Bean
    public GameManager gameService() {
        return new GameManager();
    }
}
