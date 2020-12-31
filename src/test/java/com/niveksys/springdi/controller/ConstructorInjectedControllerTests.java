package com.niveksys.springdi.controller;

import com.niveksys.springdi.service.GreetingServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConstructorInjectedControllerTests {

    ConstructorInjectedController controller;

    @BeforeEach
    void setUp() {
        this.controller = new ConstructorInjectedController(new GreetingServiceImpl());
    }

    @Test
    void getGreeting() {
        System.out.println(this.controller.getGreeting());
    }
}
