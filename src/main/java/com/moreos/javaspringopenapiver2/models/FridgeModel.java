package com.moreos.javaspringopenapiver2.models;

import jakarta.persistence.*;

@Entity
public class FridgeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String serialNumber;
    private String color;
    private Double price;
    private Boolean productAvailability;
    private Double size;
    private Integer doorsCount;
    private String compressorType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "fridge_name", nullable = false)
    private Fridge fridge;

    public FridgeModel() {}

    public FridgeModel(String name, String serialNumber, String color, Double price, Boolean productAvailability, Double size, Integer doorsCount, String compressorType, Fridge fridge) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.color = color;
        this.price = price;
        this.productAvailability = productAvailability;
        this.size = size;
        this.doorsCount = doorsCount;
        this.compressorType = compressorType;
        this.fridge = fridge;
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

    public Integer getDoorsCount() {
        return doorsCount;
    }

    public void setDoorsCount(Integer doorsCount) {
        this.doorsCount = doorsCount;
    }

    public String getCompressorType() {
        return compressorType;
    }

    public void setCompressorType(String compressorType) {
        this.compressorType = compressorType;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }
}
