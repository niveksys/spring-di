package com.niveksys.poc.springdi.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("de")
@Service("i18nService")
public class I18nGermanGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hallo Welt - DE";
    }

}
