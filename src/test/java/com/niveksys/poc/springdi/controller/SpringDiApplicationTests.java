package com.niveksys.poc.springdi.controller;

import com.niveksys.poc.springdi.service.GreetingRepositoryImpl;
import com.niveksys.poc.springdi.service.PrimaryGreetingService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpringDiApplicationTests {

    PropertyInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new PropertyInjectedController();
        controller.greetingService = new PrimaryGreetingService(new GreetingRepositoryImpl());
    }

    @Test
    void getGreeting() {
        System.out.println(this.controller.getGreeting());
    }
}
