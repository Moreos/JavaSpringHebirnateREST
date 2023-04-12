package com.moreos.javaspringopenapiver2.repositories;

import com.moreos.javaspringopenapiver2.models.Fridge;
import com.moreos.javaspringopenapiver2.models.FridgeModel;
import com.moreos.javaspringopenapiver2.models.SmartphoneModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FridgeModelRepository extends JpaRepository<FridgeModel, Long> {

    List<FridgeModel> findAllByFridge(Fridge fridge, Sort sort);

    @Query("select f from FridgeModel f where UPPER(f.name) = UPPER(?1) order by f.name, f.price asc ")
    List<FridgeModel> findByNameSorted(String name);

    @Query("select f from FridgeModel f where UPPER(f.color) = UPPER(?1) intersect " +
            "select f from FridgeModel f where f.price between ?2 and ?3 intersect " +
            "select f from FridgeModel f where f.doorsCount = ?4 intersect " +
            "select f from FridgeModel f where UPPER(f.compressorType) = UPPER(?5)")
    List<FridgeModel> findAllFilter(String color, Integer priceFrom, Integer priceTo, Integer doorsCount, String compressorType);

}
