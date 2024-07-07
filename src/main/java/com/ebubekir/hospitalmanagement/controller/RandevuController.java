package com.ebubekir.hospitalmanagement.controller;

import com.ebubekir.hospitalmanagement.dto.RandevuDTO;
import com.ebubekir.hospitalmanagement.entity.Randevu;
import com.ebubekir.hospitalmanagement.service.RandevuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/randevular")
public class RandevuController {

    @Autowired
    private RandevuService randevuService;

    @GetMapping
    public List<RandevuDTO> getAllRandevular() {
        return randevuService.getAllRandevular();
    }

    @GetMapping("/{id}")
    public Randevu getRandevuById(@PathVariable Long id) {
        return randevuService.getRandevuById(id);
    }

    @GetMapping("/hasta/{hastaId}")
    public List<Randevu> getRandevularByHasta(@PathVariable Long hastaId) {
        return randevuService.getRandevularByHastaId(hastaId);
    }

    @GetMapping("/doktor/{doktorId}")
    public List<Randevu> getRandevularByDoktorId(@PathVariable Long doktorId) {
        return randevuService.getRandevularByDoktorId(doktorId);
    }

    @PostMapping
    public Randevu saveRandevu(@RequestBody Randevu randevu) {
        return randevuService.saveRandevu(randevu);
    }

    @DeleteMapping("/{id}")
    public void deleteRandevu(@PathVariable Long id) {
        randevuService.deleteRandevu(id);
    }
}
