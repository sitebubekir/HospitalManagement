package com.ebubekir.hospitalmanagement.repository;

import com.ebubekir.hospitalmanagement.entity.Hasta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HastaRepository extends JpaRepository<Hasta, Long> {
}

