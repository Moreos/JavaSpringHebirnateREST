package com.moreos.javaspringopenapiver2.controllers;

import com.moreos.javaspringopenapiver2.models.TelevisionModel;
import com.moreos.javaspringopenapiver2.repositories.TelevisionModelRepository;
import com.moreos.javaspringopenapiver2.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/televisions/{model}")
public class TelevisionModelController {
    private final TelevisionModelRepository televisionModelRepository;
    private final TelevisionRepository televisionRepository;

    @Autowired
    public TelevisionModelController(TelevisionModelRepository televisionModelRepository, TelevisionRepository televisionRepository) {
        this.televisionModelRepository = televisionModelRepository;
        this.televisionRepository = televisionRepository;
    }

    @GetMapping
    public String homePage(@PathVariable("model") String name, Model model) {
        model.addAttribute("televisions", televisionModelRepository.findAllByTelevision(televisionRepository.findByNameIgnoreCase(name), Sort.by(Sort.Direction.ASC, "name", "price")));
        return "televisions/models";
    }

    @GetMapping("/filter")
    public String showTelevisionByName(@PathVariable("model") String sModel,
                                       @Param("name") String name,
                                       @Param("color") String color,
                                       @Param("priceFrom") Double priceFrom,
                                       @Param("priceTo") Double priceTo,
                                       @Param("category") String category,
                                       @Param("technology") String technology,
                                       Model model) {
        Iterable<TelevisionModel> televisions;
        if (name != null) {
            televisions = televisionModelRepository.findByNameSorted(name);
        } else {
            televisions = televisionModelRepository.findAllFilter(color, priceFrom.intValue(), priceTo.intValue(), category, technology);
        }
        model.addAttribute("televisions", televisions);
        return "televisions/models";
    }

    @GetMapping("/new")
    public String createModelPage(@PathVariable("model") String name, @ModelAttribute("televisionModel") TelevisionModel televisionModel, Model model) {
        return "televisions/newModel";
    }

    @PostMapping
    public String create(@PathVariable("model") String name, TelevisionModel televisionModel) {
        televisionModel.setTelevision(televisionRepository.findByNameIgnoreCase(name));
        televisionModelRepository.save(televisionModel);
        return "redirect:/televisions/" + name;
    }
}
