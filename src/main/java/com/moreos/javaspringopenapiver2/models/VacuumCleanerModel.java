package com.moreos.javaspringopenapiver2.models;

import jakarta.persistence.*;

@Entity
public class VacuumCleanerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String serialNumber;
    private String color;
    private Double price;
    private Boolean productAvailability;
    private Double size;
    private Double dustCapacity;
    private Integer modesCount;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "vacuumCleaner_name", nullable = false)
    private VacuumCleaner vacuumCleaner;

    public VacuumCleanerModel() {}

    public VacuumCleanerModel(String name, String serialNumber, String color, Double price, Boolean productAvailability, Double size, Double dustCapacity, Integer modesCount, VacuumCleaner vacuumCleaner) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.color = color;
        this.price = price;
        this.productAvailability = productAvailability;
        this.size = size;
        this.dustCapacity = dustCapacity;
        this.modesCount = modesCount;
        this.vacuumCleaner = vacuumCleaner;
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

    public Double getDustCapacity() {
        return dustCapacity;
    }

    public void setDustCapacity(Double dustCapacity) {
        this.dustCapacity = dustCapacity;
    }

    public Integer getModesCount() {
        return modesCount;
    }

    public void setModesCount(Integer modesCount) {
        this.modesCount = modesCount;
    }

    public VacuumCleaner getVacuumCleaner() {
        return vacuumCleaner;
    }

    public void setVacuumCleaner(VacuumCleaner vacuumCleaner) {
        this.vacuumCleaner = vacuumCleaner;
    }
}
