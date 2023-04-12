package com.moreos.javaspringopenapiver2.controllers;

import com.moreos.javaspringopenapiver2.models.VacuumCleaner;
import com.moreos.javaspringopenapiver2.repositories.VacuumCleanerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/vacuumCleaners")
public class VacuumCleanerController {
    private final VacuumCleanerRepository vacuumCleanerRepository;

    @Autowired
    public VacuumCleanerController(VacuumCleanerRepository vacuumCleanerRepository) {
        this.vacuumCleanerRepository = vacuumCleanerRepository;
    }

    @ModelAttribute("vacuumCleaners")
    public List<VacuumCleaner> getTelevisionList() {
        return vacuumCleanerRepository.findAll();
    }

    @GetMapping
    public String homePage() {
        return "vacuumCleaners/home";
    }

    @GetMapping("/new")
    public String createPage(@ModelAttribute("vacuumCleaner") VacuumCleaner vacuumCleaner) {
        return "vacuumCleaners/newVacuumCleaner";
    }

    @PostMapping
    public String create(VacuumCleaner vacuumCleaner) {
        vacuumCleanerRepository.save(vacuumCleaner);
        return "redirect:/vacuumCleaners";
    }
}
