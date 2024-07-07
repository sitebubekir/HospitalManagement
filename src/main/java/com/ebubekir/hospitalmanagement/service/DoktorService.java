package com.ebubekir.hospitalmanagement.service;

import com.ebubekir.hospitalmanagement.entity.Doktor;
import com.ebubekir.hospitalmanagement.repository.DoktorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoktorService {

    @Autowired
    private DoktorRepository doktorRepository;

    public List<Doktor> getAllDoktorlar() {
        return doktorRepository.findAll();
    }

    public Doktor getDoktorById(Long id) {
        return doktorRepository.findById(id).orElse(null);
    }

    public Doktor saveDoktor(Doktor doktor) {
        return doktorRepository.save(doktor);
    }

    public void deleteDoktor(Long id) {
        doktorRepository.deleteById(id);
    }
}

