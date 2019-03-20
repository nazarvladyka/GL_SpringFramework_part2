package com.nazarvladyka.guessNumber.config;

//import basecamp.service.GameService;
import com.nazarvladyka.guessNumber.service.GameService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com")
public class WebConfig {

    @Bean
    public GameService gameService() {
        return new GameService();
    }
}
