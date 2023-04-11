package com.moreos.javaspringopenapiver2.repositories;

import com.moreos.javaspringopenapiver2.models.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {
    Smartphone findByNameIgnoreCase(String name);
}
