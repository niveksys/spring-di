package com.niveksys.poc.springdi.controller;

import com.niveksys.poc.springdi.service.PetService;

import org.springframework.stereotype.Controller;

@Controller
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    public String whichPetIsTheBest() {
        return this.petService.getPetType();
    }
}
