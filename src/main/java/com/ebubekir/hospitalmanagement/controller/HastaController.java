package com.ebubekir.hospitalmanagement.controller;

import com.ebubekir.hospitalmanagement.entity.Hasta;
import com.ebubekir.hospitalmanagement.service.HastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hastalar")
public class HastaController {

    @Autowired
    private HastaService hastaService;

    @GetMapping
    public List<Hasta> getAllHastalar() {
        return hastaService.getAllHastalar();
    }

    @GetMapping("/{id}")
    public Hasta getHastaById(@PathVariable Long id) {
        return hastaService.getHastaById(id);
    }

    @PostMapping
    public Hasta saveHasta(@RequestBody Hasta hasta) {
        return hastaService.saveHasta(hasta);
    }

    @DeleteMapping("/{id}")
    public void deleteHasta(@PathVariable Long id) {
        hastaService.deleteHasta(id);
    }
}
