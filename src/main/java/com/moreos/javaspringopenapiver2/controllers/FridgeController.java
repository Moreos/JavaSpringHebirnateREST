package com.moreos.javaspringopenapiver2.controllers;

import com.moreos.javaspringopenapiver2.models.Fridge;
import com.moreos.javaspringopenapiver2.models.Smartphone;
import com.moreos.javaspringopenapiver2.repositories.FridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/fridges")
public class FridgeController {
    private  final FridgeRepository fridgeRepository;

    @Autowired
    public FridgeController(FridgeRepository fridgeRepository) {
        this.fridgeRepository = fridgeRepository;
    }

    @ModelAttribute("fridges")
    public List<Fridge> getFridgeList() {
        return fridgeRepository.findAll();
    }

    @GetMapping
    public String homePage() {
        return "fridges/home";
    }

    @GetMapping("/new")
    public String createPage(@ModelAttribute("fridge") Fridge fridge) {
        return "fridges/newFridge";
    }

    @PostMapping
    public String create(Fridge fridge) {
        fridgeRepository.save(fridge);
        return "redirect:/fridges";
    }
}
