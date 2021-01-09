package com.niveksys.poc.springdi.service;

public class GreetingServiceFactory {
    private GreetingRepository greetingRepository;

    public GreetingServiceFactory(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingService createGreetingService(String lang) {
        switch (lang) {
            case "en":
                return new PrimaryGreetingService(this.greetingRepository);
            case "de":
                return new PrimaryGermanGreetingService(this.greetingRepository);
            default:
                return new PrimaryGreetingService(this.greetingRepository);
        }
    }
}
