package com.moreos.javaspringopenapiver2.controllers;

import com.moreos.javaspringopenapiver2.models.Smartphone;
import com.moreos.javaspringopenapiver2.models.SmartphoneModel;
import com.moreos.javaspringopenapiver2.repositories.SmartphoneModelRepository;
import com.moreos.javaspringopenapiver2.repositories.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/smartphones/{model}")
public class SmartphoneModelController {

    private final SmartphoneModelRepository smartphoneModelRepository;
    private final SmartphoneRepository smartphoneRepository;

    @Autowired
    public SmartphoneModelController(SmartphoneModelRepository smartphoneModelRepository, SmartphoneRepository smartphoneRepository) {
        this.smartphoneModelRepository = smartphoneModelRepository;
        this.smartphoneRepository = smartphoneRepository;
    }

    @GetMapping
    public String homePage(@PathVariable("model") String name, Model model) {
        model.addAttribute("smartphones", smartphoneModelRepository.findAllBySmartphone(smartphoneRepository.findByNameIgnoreCase(name), Sort.by(Sort.Direction.ASC, "name", "price")));
        return "smartphones/models";
    }

    @GetMapping("/filter")
    public String showFridgeByName(@PathVariable("model") String sModel,
                                   @Param("name") String name,
                                   @Param("color") String color,
                                   @Param("priceFrom") Double priceFrom,
                                   @Param("priceTo") Double priceTo,
                                   @Param("memory") Integer memory,
                                   @Param("cameraCount") Integer cameraCount,
                                   Model model) {
        Iterable<SmartphoneModel> smartphones;
        if (name != null) {
            smartphones = smartphoneModelRepository.findByNameSorted(name);
        } else {
            smartphones = smartphoneModelRepository.findAllFilter(color, priceFrom.intValue(), priceTo.intValue(), memory, cameraCount);
        }
        model.addAttribute("smartphones", smartphones);
        return "smartphones/models";
    }

    @GetMapping("/new")
    public String createModelPage(@PathVariable("model") String name, @ModelAttribute("smartphoneModel") SmartphoneModel smartphoneModel, Model model) {
        return "smartphones/newModel";
    }

    @PostMapping
    public String create(@PathVariable("model") String name, SmartphoneModel smartphoneModel) {
        smartphoneModel.setSmartphone(smartphoneRepository.findByNameIgnoreCase(name));
        smartphoneModelRepository.save(smartphoneModel);
        return "redirect:/smartphones/" + name;
    }
}
