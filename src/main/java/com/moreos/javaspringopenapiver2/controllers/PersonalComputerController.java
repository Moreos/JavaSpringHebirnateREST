package com.moreos.javaspringopenapiver2.controllers;

import com.moreos.javaspringopenapiver2.models.PersonalComputer;
import com.moreos.javaspringopenapiver2.repositories.PersonalComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/personalComputers")
public class PersonalComputerController {
    private final PersonalComputerRepository personalComputerRepository;

    @Autowired
    public PersonalComputerController(PersonalComputerRepository personalComputerRepository) {
        this.personalComputerRepository = personalComputerRepository;
    }

    @ModelAttribute("personalComputers")
    public List<PersonalComputer> getFridgeList() {
        return personalComputerRepository.findAll();
    }

    @GetMapping
    public String homePage() {
        return "personalComputers/home";
    }

    @GetMapping("/new")
    public String createPage(@ModelAttribute("personalComputer") PersonalComputer personalComputer) {
        return "personalComputers/newPersonalComputer";
    }

    @PostMapping
    public String create(PersonalComputer personalComputer) {
        personalComputerRepository.save(personalComputer);
        return "redirect:/personalComputers";
    }
}
