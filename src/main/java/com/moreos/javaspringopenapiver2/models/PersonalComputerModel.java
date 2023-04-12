package com.moreos.javaspringopenapiver2.models;

import jakarta.persistence.*;

@Entity
public class PersonalComputerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String serialNumber;
    private String color;
    private Double price;
    private Boolean productAvailability;
    private Double size;
    private String category;
    private String processorType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "personalComputer_name", nullable = false)
    private PersonalComputer personalComputer;

    public PersonalComputerModel() {}

    public PersonalComputerModel(String name, String serialNumber, String color, Double price, Boolean productAvailability, Double size, String category, String processorType, PersonalComputer personalComputer) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.color = color;
        this.price = price;
        this.productAvailability = productAvailability;
        this.size = size;
        this.category = category;
        this.processorType = processorType;
        this.personalComputer = personalComputer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getProductAvailability() {
        return productAvailability;
    }

    public void setProductAvailability(Boolean productAvailability) {
        this.productAvailability = productAvailability;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    public PersonalComputer getPersonalComputer() {
        return personalComputer;
    }

    public void setPersonalComputer(PersonalComputer personalComputer) {
        this.personalComputer = personalComputer;
    }
}
