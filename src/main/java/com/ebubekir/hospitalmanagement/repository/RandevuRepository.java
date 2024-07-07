package com.ebubekir.hospitalmanagement.repository;

import com.ebubekir.hospitalmanagement.entity.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RandevuRepository extends JpaRepository<Randevu, Long> {
    List<Randevu> findByHastaId(Long hastaId);
    List<Randevu> findByDoktorId(Long doktorId);
}
