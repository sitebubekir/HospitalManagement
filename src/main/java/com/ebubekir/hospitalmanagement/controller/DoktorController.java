package com.ebubekir.hospitalmanagement.controller;

import com.ebubekir.hospitalmanagement.entity.Doktor;
import com.ebubekir.hospitalmanagement.service.DoktorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doktorlar")
public class DoktorController {

    @Autowired
    private DoktorService doktorService;

    @GetMapping
    public List<Doktor> getAllDoktorlar() {
        return doktorService.getAllDoktorlar();
    }

    @GetMapping("/{id}")
    public Doktor getDoktorById(@PathVariable Long id) {
        return doktorService.getDoktorById(id);
    }

    @PostMapping
    public Doktor saveDoktor(@RequestBody Doktor doktor) {
        return doktorService.saveDoktor(doktor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoktor(@PathVariable Long id) {
        doktorService.deleteDoktor(id);
    }
}

