package com.moreos.javaspringopenapiver2.repositories;

import com.moreos.javaspringopenapiver2.models.Television;
import com.moreos.javaspringopenapiver2.models.TelevisionModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TelevisionModelRepository extends JpaRepository<TelevisionModel, Long> {
    List<TelevisionModel> findAllByTelevision(Television television, Sort sort);

    @Query("select t from TelevisionModel t where UPPER(t.name) = UPPER(?1) order by t.name, t.price asc ")
    List<TelevisionModel> findByNameSorted(String name);

    @Query("select t from TelevisionModel t where UPPER(t.color) = UPPER(?1) intersect " +
            "select t from TelevisionModel t where t.price between ?2 and ?3 intersect " +
            "select t from TelevisionModel t where UPPER(t.category) = UPPER(?4) intersect " +
            "select t from TelevisionModel t where UPPER(t.technology) = UPPER(?5)")
    List<TelevisionModel> findAllFilter(String color, Integer priceFrom, Integer priceTo, String category, String technology);


}
