package com.ebubekir.hospitalmanagement.service;

import com.ebubekir.hospitalmanagement.entity.Hasta;
import com.ebubekir.hospitalmanagement.repository.HastaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HastaService {

    @Autowired
    private HastaRepository hastaRepository;

    public List<Hasta> getAllHastalar() {
        return hastaRepository.findAll();
    }

    public Hasta getHastaById(Long id) {
        return hastaRepository.findById(id).orElse(null);
    }

    public Hasta saveHasta(Hasta hasta) {
        return hastaRepository.save(hasta);
    }

    public void deleteHasta(Long id) {
        hastaRepository.deleteById(id);
    }
}
