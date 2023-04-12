package com.moreos.javaspringopenapiver2.repositories;

import com.moreos.javaspringopenapiver2.models.PersonalComputer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalComputerRepository extends JpaRepository<PersonalComputer, Long> {
    PersonalComputer findByNameIgnoreCase(String name);
}
