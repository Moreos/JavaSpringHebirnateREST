package com.moreos.javaspringopenapiver2.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Set;

@Schema(description = "Информация о созданной линейки смартфонов")
@Entity
public class Smartphone {
    @Schema(description = "Id серии")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Schema(description = "Наименование серии")
    private String name;
    private String countryOfManufacturer;
    private String firmOfManufacturer;
    private Boolean canOrderOnline;
    private Boolean canInstallments;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "smartphone")
    private Set<SmartphoneModel> smartphones;

    public Smartphone() {}

    public Smartphone(String name, String countryOfManufacturer, String firmOfManufacturer, Boolean canOrderOnline, Boolean canInstallments) {
        this.name = name;
        this.countryOfManufacturer = countryOfManufacturer;
        this.firmOfManufacturer = firmOfManufacturer;
        this.canOrderOnline = canOrderOnline;
        this.canInstallments = canInstallments;
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

    public String getCountryOfManufacturer() {
        return countryOfManufacturer;
    }

    public void setCountryOfManufacturer(String countryOfManufacturer) {
        this.countryOfManufacturer = countryOfManufacturer;
    }

    public String getFirmOfManufacturer() {
        return firmOfManufacturer;
    }

    public void setFirmOfManufacturer(String firmOfManufacturer) {
        this.firmOfManufacturer = firmOfManufacturer;
    }

    public Boolean getCanOrderOnline() {
        return canOrderOnline;
    }

    public void setCanOrderOnline(Boolean canOrderOnline) {
        this.canOrderOnline = canOrderOnline;
    }

    public Boolean getCanInstallments() {
        return canInstallments;
    }

    public void setCanInstallments(Boolean canInstallments) {
        this.canInstallments = canInstallments;
    }

    public Set<SmartphoneModel> getSmartphones() {
        return smartphones;
    }

    public void setSmartphones(Set<SmartphoneModel> smartphones) {
        this.smartphones = smartphones;
    }
}
