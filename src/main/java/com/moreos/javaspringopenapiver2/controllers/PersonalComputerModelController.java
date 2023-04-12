package com.moreos.javaspringopenapiver2.controllers;

import com.moreos.javaspringopenapiver2.models.PersonalComputerModel;
import com.moreos.javaspringopenapiver2.repositories.PersonalComputerModelRepository;
import com.moreos.javaspringopenapiver2.repositories.PersonalComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/personalComputers/{model}")
public class PersonalComputerModelController {
    private final PersonalComputerModelRepository personalComputerModelRepository;
    private final PersonalComputerRepository personalComputerRepository;

    @Autowired
    public PersonalComputerModelController(PersonalComputerModelRepository personalComputerModelRepository, PersonalComputerRepository personalComputerRepository) {
        this.personalComputerModelRepository = personalComputerModelRepository;
        this.personalComputerRepository = personalComputerRepository;
    }

    @GetMapping
    public String homePage(@PathVariable("model") String name, Model model) {
        model.addAttribute("personalComputers", personalComputerModelRepository.findAllByPersonalComputer(personalComputerRepository.findByNameIgnoreCase(name), Sort.by(Sort.Direction.ASC, "name", "price")));
        return "personalComputers/models";
    }

    @GetMapping("/filter")
    public String showFridgeByName(@PathVariable("model") String sModel,
                                   @Param("name") String name,
                                   @Param("color") String color,
                                   @Param("priceFrom") Double priceFrom,
                                   @Param("priceTo") Double priceTo,
                                   @Param("category") String category,
                                   @Param("processorType") String processorType,
                                   Model model) {
        Iterable<PersonalComputerModel> personalComputers;
        if (name != null) {
            personalComputers = personalComputerModelRepository.findByNameSorted(name);
        } else {
            personalComputers = personalComputerModelRepository.findAllFilter(color, priceFrom.intValue(), priceTo.intValue(), category, processorType);
        }
        model.addAttribute("personalComputers", personalComputers);
        return "personalComputers/models";
    }

    @GetMapping("/new")
    public String createModelPage(@PathVariable("model") String name, @ModelAttribute("personalComputerModel") PersonalComputerModel personalComputerModel, Model model) {
        return "personalComputers/newModel";
    }

    @PostMapping
    public String create(@PathVariable("model") String name, PersonalComputerModel personalComputerModel) {
        personalComputerModel.setPersonalComputer(personalComputerRepository.findByNameIgnoreCase(name));
        personalComputerModelRepository.save(personalComputerModel);
        return "redirect:/personalComputers/" + name;
    }
}
