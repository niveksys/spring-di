package com.niveksys.poc.springdi.controller;

import com.niveksys.poc.springdi.service.GreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    @Qualifier("propertyGreetingService")
    @Autowired
    public GreetingService greetingService;

    public String getGreeting() {
        return this.greetingService.sayGreeting();
    }
}
