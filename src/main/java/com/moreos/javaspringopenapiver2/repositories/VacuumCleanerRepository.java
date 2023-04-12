package com.moreos.javaspringopenapiver2.repositories;

import com.moreos.javaspringopenapiver2.models.VacuumCleaner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacuumCleanerRepository extends JpaRepository<VacuumCleaner, Long> {
    VacuumCleaner findByNameIgnoreCase(String name);
}
