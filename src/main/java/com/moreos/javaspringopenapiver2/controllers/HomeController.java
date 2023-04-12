package com.moreos.javaspringopenapiver2.controllers;

import com.moreos.javaspringopenapiver2.models.*;
import com.moreos.javaspringopenapiver2.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final SmartphoneModelRepository smartphoneModelRepository;
    private final SmartphoneRepository smartphoneRepository;
    private final PersonalComputerModelRepository personalComputerModelRepository;
    private final PersonalComputerRepository personalComputerRepository;
    private final FridgeModelRepository fridgeModelRepository;
    private final FridgeRepository fridgeRepository;
    private final TelevisionModelRepository televisionModelRepository;
    private final TelevisionRepository televisionRepository;
    private final VacuumCleanerModelRepository vacuumCleanerModelRepository;
    private final VacuumCleanerRepository vacuumCleanerRepository;

    @Autowired
    public HomeController(SmartphoneRepository smartphoneRepository, SmartphoneModelRepository smartphoneModelRepository, PersonalComputerModelRepository personalComputerModelRepository, PersonalComputerRepository personalComputerRepository, FridgeModelRepository fridgeModelRepository, FridgeRepository fridgeRepository, TelevisionModelRepository televisionModelRepository, TelevisionRepository televisionRepository, VacuumCleanerModelRepository vacuumCleanerModelRepository, VacuumCleanerRepository vacuumCleanerRepository) {
        this.smartphoneRepository = smartphoneRepository;
        this.smartphoneModelRepository = smartphoneModelRepository;
        this.personalComputerModelRepository = personalComputerModelRepository;
        this.personalComputerRepository = personalComputerRepository;
        this.fridgeModelRepository = fridgeModelRepository;
        this.fridgeRepository = fridgeRepository;
        this.televisionModelRepository = televisionModelRepository;
        this.televisionRepository = televisionRepository;
        this.vacuumCleanerModelRepository = vacuumCleanerModelRepository;
        this.vacuumCleanerRepository = vacuumCleanerRepository;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/secretFillDB")
    public String fillDB() {
        // Заполнение телефонов
        List<Smartphone> smartphoneList = new ArrayList<>();
        smartphoneList.add(smartphoneRepository.save(new Smartphone("Galaxy", "Korea", "Samsung", true, false)));
        smartphoneList.add(smartphoneRepository.save(new Smartphone("Iphone", "USA", "Apple", false, true)));
        smartphoneList.add(smartphoneRepository.save(new Smartphone("Xiaomi", "China", "Xiaomi", true, true)));
        smartphoneModelRepository.save(new SmartphoneModel("s9", "SUMGAL123", "green", 10000.0, true, 10.4, 128.0, 3, smartphoneList.get(0)));
        smartphoneModelRepository.save(new SmartphoneModel("s8", "SUMGAL133", "red", 11000.0, true, 9.4, 1428.0, 3, smartphoneList.get(0)));
        smartphoneModelRepository.save(new SmartphoneModel("i4", "APPIPH123", "white", 12000.0, false, 7.4, 1228.0, 35, smartphoneList.get(1)));
        smartphoneModelRepository.save(new SmartphoneModel("i4 mini", "APPIPH123M", "black", 13000.0, true, 1.4, 5128.0, 3, smartphoneList.get(1)));
        smartphoneModelRepository.save(new SmartphoneModel("x12", "XIA12333", "yellow", 14000.0, false, 8.4, 4128.0, 2, smartphoneList.get(2)));
        smartphoneModelRepository.save(new SmartphoneModel("x33", "XIA12311", "yellow", 15000.0, true, 11.4, 1238.0, 1, smartphoneList.get(2)));


        // Заполнение ПК
        List<PersonalComputer> personalComputerList = new ArrayList<>();
        personalComputerList.add(personalComputerRepository.save(new PersonalComputer("PCGalaxy", "Korea", "Samsung", true, false)));
        personalComputerList.add(personalComputerRepository.save(new PersonalComputer("Iphone", "USA", "Apple", false, true)));
        personalComputerList.add(personalComputerRepository.save(new PersonalComputer("Xiaomi", "China", "Xiaomi", true, true)));
        personalComputerModelRepository.save(new PersonalComputerModel("PCs9", "PCSUMGAL123", "green", 100000.0, true, 10.4, "laptop", "m2", personalComputerList.get(0)));
        personalComputerModelRepository.save(new PersonalComputerModel("PCs8", "PCSUMGAL133", "red", 110000.0, true, 9.4, "gaming", "m3", personalComputerList.get(0)));
        personalComputerModelRepository.save(new PersonalComputerModel("PCi4", "PCAPPIPH123", "white", 120000.0, false, 7.4, "laptop", "graphic", personalComputerList.get(1)));
        personalComputerModelRepository.save(new PersonalComputerModel("PCi4 mini", "PCAPPIPH123M", "black", 130000.0, true, 1.4, "laptop", "intel", personalComputerList.get(1)));
        personalComputerModelRepository.save(new PersonalComputerModel("PCx12", "PCXIA12333", "yellow", 104000.0, false, 8.4, "gaming", "ryzen", personalComputerList.get(2)));
        personalComputerModelRepository.save(new PersonalComputerModel("PCx33", "PCXIA12311", "yellow", 150000.0, true, 11.4, "laptop", "ryzen", personalComputerList.get(2)));

        // Заполнение холодильников
        List<Fridge> fridgeList = new ArrayList<>();
        fridgeList.add(fridgeRepository.save(new Fridge("FRGalaxy", "Korea", "Samsung", true, false)));
        fridgeList.add(fridgeRepository.save(new Fridge("FRIphone", "USA", "Apple", false, true)));
        fridgeList.add(fridgeRepository.save(new Fridge("FRXiaomi", "China", "Xiaomi", true, true)));
        fridgeModelRepository.save(new FridgeModel("FRs9", "FRSUMGAL123", "green", 103000.0, true, 10.4, 1, "Cool", fridgeList.get(0)));
        fridgeModelRepository.save(new FridgeModel("FRs8", "FRSUMGAL133", "red", 113000.0, true, 9.4, 2, "Cool", fridgeList.get(0)));
        fridgeModelRepository.save(new FridgeModel("FRi4", "FRAPPIPH123", "white", 123000.0, false, 7.4, 6, "Hot", fridgeList.get(1)));
        fridgeModelRepository.save(new FridgeModel("FRi4 mini", "FRAPPIPH123M", "black", 133000.0, true, 1.4, 2, "Bad", fridgeList.get(1)));
        fridgeModelRepository.save(new FridgeModel("FRx12", "FRXIA12333", "yellow", 143000.0, false, 8.4, 3, "Good", fridgeList.get(2)));
        fridgeModelRepository.save(new FridgeModel("FRx33", "FRXIA12311", "yellow", 153000.0, true, 11.4, 3, "No", fridgeList.get(2)));

        // Заполнение телевизоров
        List<Television> televisionList = new ArrayList<>();
        televisionList.add(televisionRepository.save(new Television("TVGalaxy", "Korea", "Samsung", true, false)));
        televisionList.add(televisionRepository.save(new Television("TVIphone", "USA", "Apple", false, true)));
        televisionList.add(televisionRepository.save(new Television("TVXiaomi", "China", "Xiaomi", true, true)));
        televisionModelRepository.save(new TelevisionModel("TVs9", "TVSUMGAL123", "green", 1000.0, true, 10.4, "Smooth", "Crystal", televisionList.get(0)));
        televisionModelRepository.save(new TelevisionModel("TVs8", "TVSUMGAL133", "red", 1100.0, true, 9.4, "Smooth", "Analog", televisionList.get(0)));
        televisionModelRepository.save(new TelevisionModel("TVi4", "TVAPPIPH123", "white", 1200.0, false, 7.4, "Moon", "Crystal", televisionList.get(1)));
        televisionModelRepository.save(new TelevisionModel("TVi4 mini", "TVAPPIPH123M", "black", 1300.0, true, 1.4, "Moon", "Crystal", televisionList.get(1)));
        televisionModelRepository.save(new TelevisionModel("TVx12", "TVXIA12333", "yellow", 1400.0, false, 8.4, "Smooth", "Analog", televisionList.get(2)));
        televisionModelRepository.save(new TelevisionModel("TVx33", "TVXIA12311", "yellow", 1500.0, true, 11.4, "Smooth", "Analog", televisionList.get(2)));

        // Заполнение пылесосов
        List<VacuumCleaner> vacuumCleanerList = new ArrayList<>();
        vacuumCleanerList.add(vacuumCleanerRepository.save(new VacuumCleaner("Galaxy", "Korea", "Samsung", true, false)));
        vacuumCleanerList.add(vacuumCleanerRepository.save(new VacuumCleaner("Iphone", "USA", "Apple", false, true)));
        vacuumCleanerList.add(vacuumCleanerRepository.save(new VacuumCleaner("Xiaomi", "China", "Xiaomi", true, true)));
        vacuumCleanerModelRepository.save(new VacuumCleanerModel("s9", "SUMGAL123", "green", 10000.0, true, 10.4, 128.0, 3, vacuumCleanerList.get(0)));
        vacuumCleanerModelRepository.save(new VacuumCleanerModel("s8", "SUMGAL133", "red", 11000.0, true, 9.4, 1248.0, 3, vacuumCleanerList.get(0)));
        vacuumCleanerModelRepository.save(new VacuumCleanerModel("i4", "APPIPH123", "white", 12000.0, false, 7.4, 1218.0, 2, vacuumCleanerList.get(1)));
        vacuumCleanerModelRepository.save(new VacuumCleanerModel("i4 mini", "APPIPH123M", "black", 13000.0, true, 1.4, 6128.0, 1, vacuumCleanerList.get(1)));
        vacuumCleanerModelRepository.save(new VacuumCleanerModel("x12", "XIA12333", "yellow", 14000.0, false, 8.4, 3128.0, 4, vacuumCleanerList.get(2)));
        vacuumCleanerModelRepository.save(new VacuumCleanerModel("x33", "XIA12311", "yellow", 15000.0, true, 11.4, 1128.0, 2, vacuumCleanerList.get(2)));


        return "redirect:/";
    }
}
