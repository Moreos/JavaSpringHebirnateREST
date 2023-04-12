package com.moreos.javaspringopenapiver2.repositories;

import com.moreos.javaspringopenapiver2.models.Fridge;
import com.moreos.javaspringopenapiver2.models.PersonalComputer;
import com.moreos.javaspringopenapiver2.models.PersonalComputerModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonalComputerModelRepository extends JpaRepository<PersonalComputerModel, Long> {
    List<PersonalComputerModel> findAllByPersonalComputer(PersonalComputer personalComputer, Sort sort);

    @Query("select p from PersonalComputerModel p where UPPER(p.name) = UPPER(?1) order by p.name, p.price asc ")
    List<PersonalComputerModel> findByNameSorted(String name);

    @Query("select p from PersonalComputerModel p where UPPER(p.color) = UPPER(?1) intersect " +
            "select p from PersonalComputerModel p where p.price between ?2 and ?3 intersect " +
            "select p from PersonalComputerModel p where UPPER(p.category) = UPPER(?4) intersect " +
            "select p from PersonalComputerModel p where UPPER(p.processorType) = UPPER(?5)")
    List<PersonalComputerModel> findAllFilter(String color, Integer priceFrom, Integer priceTo, String category, String processorType);
}
