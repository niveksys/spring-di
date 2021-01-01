package com.niveksys.poc.springdi.controller;

import com.niveksys.poc.springdi.service.PrimaryGreetingService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SetterInjectedControllerTests {
    SetterInjectedController controller;

    @BeforeEach
    void setUp() {
        this.controller = new SetterInjectedController();
        this.controller.setGreetingService(new PrimaryGreetingService());
    }

    @Test
    void getGreeting() {
        System.out.println(this.controller.getGreeting());
    }
}
