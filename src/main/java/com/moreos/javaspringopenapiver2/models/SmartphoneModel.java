package com.moreos.javaspringopenapiver2.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class SmartphoneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String serialNumber;
    private String color;
    private Double price;
    private Boolean productAvailability;
    private Double size;
    private Double memory;
    private Integer cameraCount;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "smartphone_name", nullable = false)
    private Smartphone smartphone;

    public SmartphoneModel() {}

    public SmartphoneModel(String name, String serialNumber, String color, Double price, Boolean productAvailability, Double size, Double memory, Integer cameraCount, Smartphone smartphone) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.color = color;
        this.price = price;
        this.productAvailability = productAvailability;
        this.size = size;
        this.memory = memory;
        this.cameraCount = cameraCount;
        this.smartphone = smartphone;
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

    public Double getMemory() {
        return memory;
    }

    public void setMemory(Double memory) {
        this.memory = memory;
    }

    public Integer getCameraCount() {
        return cameraCount;
    }

    public void setCameraCount(Integer cameraCount) {
        this.cameraCount = cameraCount;
    }

    public Smartphone getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }
}
