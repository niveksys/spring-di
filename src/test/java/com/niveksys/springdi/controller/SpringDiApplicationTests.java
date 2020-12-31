package com.niveksys.springdi.controller;

import com.niveksys.springdi.service.PrimaryGreetingService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpringDiApplicationTests {

    PropertyInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new PropertyInjectedController();
        controller.greetingService = new PrimaryGreetingService();
    }

    @Test
    void getGreeting() {
        System.out.println(this.controller.getGreeting());
    }
}
