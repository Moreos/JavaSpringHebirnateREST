package com.moreos.javaspringopenapiver2.controllers;

import com.moreos.javaspringopenapiver2.models.Smartphone;
import com.moreos.javaspringopenapiver2.models.SmartphoneModel;
import com.moreos.javaspringopenapiver2.repositories.SmartphoneModelRepository;
import com.moreos.javaspringopenapiver2.repositories.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final SmartphoneRepository smartphoneRepository;
    private final SmartphoneModelRepository smartphoneModelRepository;

    @Autowired
    public HomeController(SmartphoneRepository smartphoneRepository, SmartphoneModelRepository smartphoneModelRepository) {
        this.smartphoneRepository = smartphoneRepository;
        this.smartphoneModelRepository = smartphoneModelRepository;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/secretFillDB")
    public String fillDB() {
        List<Smartphone> smartphoneList = new ArrayList<>();
        smartphoneList.add(smartphoneRepository.save(new Smartphone("Galaxy", "Korea", "Samsung", true, false)));
        smartphoneList.add(smartphoneRepository.save(new Smartphone("Iphone", "Korea", "Samsung", true, false)));
        smartphoneList.add(smartphoneRepository.save(new Smartphone("Xiaomi", "Korea", "Samsung", true, false)));
        smartphoneModelRepository.save(new SmartphoneModel("s9", "SUMGAL123", "green", 10000.0, true, 10.4, 128.0, 3, smartphoneList.get(0)));
        smartphoneModelRepository.save(new SmartphoneModel("s8", "SUMGAL133", "red", 11000.0, true, 9.4, 128.0, 3, smartphoneList.get(0)));
        smartphoneModelRepository.save(new SmartphoneModel("i4", "APPIPH123", "white", 12000.0, false, 7.4, 128.0, 3, smartphoneList.get(1)));
        smartphoneModelRepository.save(new SmartphoneModel("i4 mini", "APPIPH123M", "black", 13000.0, true, 1.4, 128.0, 3, smartphoneList.get(1)));
        smartphoneModelRepository.save(new SmartphoneModel("x12", "XIA12333", "yellow", 14000.0, false, 8.4, 128.0, 3, smartphoneList.get(2)));
        smartphoneModelRepository.save(new SmartphoneModel("x33", "XIA12311", "yellow", 15000.0, true, 11.4, 128.0, 3, smartphoneList.get(2)));

        return "redirect:/";
    }
}
