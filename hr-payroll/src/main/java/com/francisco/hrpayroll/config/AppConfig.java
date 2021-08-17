package com.francisco.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    /*
     * Padrão de Projeto Singleton
     * uma única instância de RestTemplate para toda a aplicação
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
