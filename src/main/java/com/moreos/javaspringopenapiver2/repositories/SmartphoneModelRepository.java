package com.moreos.javaspringopenapiver2.repositories;

import com.moreos.javaspringopenapiver2.models.Smartphone;
import com.moreos.javaspringopenapiver2.models.SmartphoneModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SmartphoneModelRepository extends JpaRepository<SmartphoneModel, Long> {
    List<SmartphoneModel> findAllBySmartphone(Smartphone smartphone, Sort sort);

    @Query("select s from SmartphoneModel s where UPPER(s.name) = UPPER(?1) order by s.name, s.price asc ")
    List<SmartphoneModel> findByNameSorted(String name);

    @Query("select s from SmartphoneModel s where UPPER(s.color) = UPPER(?1) intersect " +
            "select s from SmartphoneModel s where s.price between ?2 and ?3 intersect " +
            "select s from SmartphoneModel s where s.memory = ?4 intersect " +
            "select s from SmartphoneModel s where s.cameraCount = ?5")
    List<SmartphoneModel> findAllFilter(String color, Integer priceFrom, Integer priceTo, Integer memory, Integer cameraCount);

}
