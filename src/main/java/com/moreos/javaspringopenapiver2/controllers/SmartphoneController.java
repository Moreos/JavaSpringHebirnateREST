package com.moreos.javaspringopenapiver2.controllers;

import com.moreos.javaspringopenapiver2.models.Smartphone;
import com.moreos.javaspringopenapiver2.repositories.SmartphoneRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/smartphones")
@Tag(name = "Серия смартфонов", description = "Контроллер для работы с сериями смартонов")
public class SmartphoneController {
    private final SmartphoneRepository smartphoneRepository;

    @Autowired
    public SmartphoneController(SmartphoneRepository smartphoneRepository) {
        this.smartphoneRepository = smartphoneRepository;
    }

    @ModelAttribute("smartphones")
    @Operation(summary = "Добавляет атрибут в модель со списком смартфонов")
    public List<Smartphone> getSmartphonesList() {
        return smartphoneRepository.findAll();
    }

    @GetMapping
    @Operation(summary = "Возвращает стартовую страницу")
    public String homePage() {
        return "smartphones/home";
    }

    @GetMapping("/new")
//    @Operation(summary = "Открывает страницу создания смартофона")
    public String createPage(
//            @Parameter(description = "Автоматический параметр который добавляет экземлпяр класс в модель")
            @ModelAttribute("smartphone") Smartphone smartphone) {
        return "smartphones/newSmartphone";
    }

    @PostMapping
//    @Operation(summary = "Сохраняет новую линейку смартфонов в бд")
    public String create(
//            @Parameter(description = "Автоматический параметр который получает из POST формы")
            Smartphone smartphone) {
        smartphoneRepository.save(smartphone);
        return "redirect:/smartphones";
    }
}
