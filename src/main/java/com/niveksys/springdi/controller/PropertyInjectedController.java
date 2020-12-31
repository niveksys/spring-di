package com.niveksys.springdi.controller;

import com.niveksys.springdi.service.GreetingService;

public class PropertyInjectedController {
    public GreetingService greetingService;

    public String getGreeting() {
        return this.greetingService.sayGreeting();
    }
}
