package com.moreos.javaspringopenapiver2.controllers;

import com.moreos.javaspringopenapiver2.models.FridgeModel;
import com.moreos.javaspringopenapiver2.repositories.FridgeModelRepository;
import com.moreos.javaspringopenapiver2.repositories.FridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fridges/{model}")
public class FridgeModelController {
    private final FridgeModelRepository fridgeModelRepository;
    private final FridgeRepository fridgeRepository;

    @Autowired
    public FridgeModelController(FridgeModelRepository fridgeModelRepository, FridgeRepository fridgeRepository) {
        this.fridgeModelRepository = fridgeModelRepository;
        this.fridgeRepository = fridgeRepository;
    }

    @GetMapping
    public String homePage(@PathVariable("model") String name, Model model) {
        model.addAttribute("fridges", fridgeModelRepository.findAllByFridge(fridgeRepository.findByNameIgnoreCase(name), Sort.by(Sort.Direction.ASC, "name", "price")));
        return "fridges/models";
    }

    @GetMapping("/filter")
    public String showFridgeByName(@PathVariable("model") String sModel,
                                   @Param("name") String name,
                                   @Param("color") String color,
                                   @Param("priceFrom") Double priceFrom,
                                   @Param("priceTo") Double priceTo,
                                   @Param("doorsCount") Integer doorsCount,
                                   @Param("compressorType") String compressorType,
                                   Model model) {
        Iterable<FridgeModel> fridges;
        if (name != null) {
            fridges = fridgeModelRepository.findByNameSorted(name);
        } else {
            fridges = fridgeModelRepository.findAllFilter(color, priceFrom.intValue(), priceTo.intValue(), doorsCount, compressorType);
        }
        model.addAttribute("fridges", fridges);
        return "fridges/models";
    }

    @GetMapping("/new")
    public String createModelPage(@PathVariable("model") String name, @ModelAttribute("fridgeModel") FridgeModel fridgeModel, Model model) {
        return "fridges/newModel";
    }

    @PostMapping
    public String create(@PathVariable("model") String name, FridgeModel fridgeModel) {
        fridgeModel.setFridge(fridgeRepository.findByNameIgnoreCase(name));
        fridgeModelRepository.save(fridgeModel);
        return "redirect:/fridges/" + name;
    }
}
