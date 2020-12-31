package com.niveksys.springdi.controller;

import com.niveksys.springdi.service.GreetingService;
import com.niveksys.springdi.service.GreetingServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SetterInjectedControllerTests {
    SetterInjectedController controller;

    @BeforeEach
    void setUp() {
        this.controller = new SetterInjectedController();
        this.controller.setGreetingService(new GreetingServiceImpl());
    }

    @Test
    void getGreeting() {
        System.out.println(this.controller.getGreeting());
    }
}
