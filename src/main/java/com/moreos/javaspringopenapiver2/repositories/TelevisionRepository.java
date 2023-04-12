package com.moreos.javaspringopenapiver2.repositories;

import com.moreos.javaspringopenapiver2.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
    Television findByNameIgnoreCase(String name);
}
