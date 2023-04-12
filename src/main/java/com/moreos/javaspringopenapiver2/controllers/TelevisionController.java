package com.moreos.javaspringopenapiver2.controllers;

import com.moreos.javaspringopenapiver2.models.Television;
import com.moreos.javaspringopenapiver2.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/televisions")
public class TelevisionController {
    private final TelevisionRepository televisionRepository;

    @Autowired
    public TelevisionController(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    @ModelAttribute("televisions")
    public List<Television> getTelevisionList() {
        return televisionRepository.findAll();
    }

    @GetMapping
    public String homePage() {
        return "televisions/home";
    }

    @GetMapping("/new")
    public String createPage(@ModelAttribute("television") Television television) {
        return "televisions/newTelevision";
    }

    @PostMapping
    public String create(Television television) {
        televisionRepository.save(television);
        return "redirect:/televisions";
    }
}
