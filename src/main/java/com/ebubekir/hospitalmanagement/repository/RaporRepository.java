package com.ebubekir.hospitalmanagement.repository;

import com.ebubekir.hospitalmanagement.entity.Rapor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaporRepository extends JpaRepository<Rapor, Long> {
    List<Rapor> findByHastaId(Long hastaId);
    List<Rapor> findByDoktorId(Long doktorId);
}
