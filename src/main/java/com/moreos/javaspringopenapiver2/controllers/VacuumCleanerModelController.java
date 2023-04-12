package com.moreos.javaspringopenapiver2.controllers;

import com.moreos.javaspringopenapiver2.models.VacuumCleanerModel;
import com.moreos.javaspringopenapiver2.repositories.VacuumCleanerModelRepository;
import com.moreos.javaspringopenapiver2.repositories.VacuumCleanerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vacuumCleaners/{model}")
public class VacuumCleanerModelController {
    private final VacuumCleanerModelRepository vacuumCleanerModelRepository;
    private final VacuumCleanerRepository vacuumCleanerRepository;

    public VacuumCleanerModelController(VacuumCleanerModelRepository vacuumCleanerModelRepository, VacuumCleanerRepository vacuumCleanerRepository) {
        this.vacuumCleanerModelRepository = vacuumCleanerModelRepository;
        this.vacuumCleanerRepository = vacuumCleanerRepository;
    }

    @GetMapping
    public String homePage(@PathVariable("model") String name, Model model) {
        model.addAttribute("vacuumCleaners", vacuumCleanerModelRepository.findAllByVacuumCleaner(vacuumCleanerRepository.findByNameIgnoreCase(name), Sort.by(Sort.Direction.ASC, "name", "price")));
        return "vacuumCleaners/models";
    }

    @GetMapping("/filter")
    public String showTelevisionByName(@PathVariable("model") String sModel,
                                       @Param("name") String name,
                                       @Param("color") String color,
                                       @Param("priceFrom") Double priceFrom,
                                       @Param("priceTo") Double priceTo,
                                       @Param("dustCapacity") Double dustCapacity,
                                       @Param("modesCount") Integer modesCount,
                                       Model model) {
        Iterable<VacuumCleanerModel> vacuumCleaners;
        if (name != null) {
            vacuumCleaners = vacuumCleanerModelRepository.findByNameSorted(name);
        } else {
            vacuumCleaners = vacuumCleanerModelRepository.findAllFilter(color, priceFrom.intValue(), priceTo.intValue(), dustCapacity, modesCount);
        }
        model.addAttribute("vacuumCleaners", vacuumCleaners);
        return "vacuumCleaners/models";
    }

    @GetMapping("/new")
    public String createModelPage(@PathVariable("model") String name, @ModelAttribute("vacuumCleanerModel") VacuumCleanerModel vacuumCleanerModel, Model model) {
        return "vacuumCleaners/newModel";
    }

    @PostMapping
    public String create(@PathVariable("model") String name, VacuumCleanerModel vacuumCleanerModel) {
        vacuumCleanerModel.setVacuumCleaner(vacuumCleanerRepository.findByNameIgnoreCase(name));
        vacuumCleanerModelRepository.save(vacuumCleanerModel);
        return "redirect:/vacuumCleaners/" + name;
    }
}
