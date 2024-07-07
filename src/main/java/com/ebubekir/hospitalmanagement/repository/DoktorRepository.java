package com.ebubekir.hospitalmanagement.repository;

import com.ebubekir.hospitalmanagement.entity.Doktor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoktorRepository extends JpaRepository<Doktor, Long> {
}

