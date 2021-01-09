package com.niveksys.poc.springdi.config;

import com.niveksys.poc.springdi.service.GreetingRepository;
import com.niveksys.poc.springdi.service.GreetingService;
import com.niveksys.poc.springdi.service.GreetingServiceFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Bean
    GreetingServiceFactory greetingServiceFactory(GreetingRepository repository) {
        return new GreetingServiceFactory(repository);
    }

    @Bean
    @Primary
    @Profile({ "default", "EN" })
    GreetingService primaryGreetingService(GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.createGreetingService("en");
    }

    @Bean
    @Primary
    @Profile("DE")
    GreetingService primaryGermanGreetingService(GreetingServiceFactory greetingServiceFactory) {
        System.out.println("Factory - de");
        return greetingServiceFactory.createGreetingService("de");
    }
}
