package com.moreos.javaspringopenapiver2.controllers;

import com.moreos.javaspringopenapiver2.models.Smartphone;
import com.moreos.javaspringopenapiver2.repositories.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/smartphones")
public class SmartphoneController {
    private final SmartphoneRepository smartphoneRepository;

    @Autowired
    public SmartphoneController(SmartphoneRepository smartphoneRepository) {
        this.smartphoneRepository = smartphoneRepository;
    }

    @ModelAttribute("smartphones")
    public List<Smartphone> getSmartphonesList() {
        return smartphoneRepository.findAll();
    }

    @GetMapping
    public String homePage() {
        return "smartphones/home";
    }

    @GetMapping("/new")
    public String createPage(@ModelAttribute("smartphone") Smartphone smartphone) {
        return "smartphones/newSmartphone";
    }

    @PostMapping
    public String create(Smartphone smartphone) {
        smartphoneRepository.save(smartphone);
        return "redirect:/smartphones";
    }
}
