package com.moreos.javaspringopenapiver2.repositories;

import com.moreos.javaspringopenapiver2.models.Television;
import com.moreos.javaspringopenapiver2.models.VacuumCleaner;
import com.moreos.javaspringopenapiver2.models.VacuumCleanerModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VacuumCleanerModelRepository extends JpaRepository<VacuumCleanerModel, Long> {
    List<VacuumCleanerModel> findAllByVacuumCleaner(VacuumCleaner vacuumCleaner, Sort sort);

    @Query("select v from VacuumCleanerModel v where UPPER(v.name) = UPPER(?1) order by v.name, v.price asc ")
    List<VacuumCleanerModel> findByNameSorted(String name);

    @Query("select v from VacuumCleanerModel v where UPPER(v.color) = UPPER(?1) intersect " +
            "select v from VacuumCleanerModel v where v.price between ?2 and ?3 intersect " +
            "select v from VacuumCleanerModel v where v.dustCapacity = ?4 intersect " +
            "select v from VacuumCleanerModel v where v.modesCount = ?5")
    List<VacuumCleanerModel> findAllFilter(String color, Integer priceFrom, Integer priceTo, Double dustCapacity, Integer modesCount);



}
