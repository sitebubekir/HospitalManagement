package com.ebubekir.hospitalmanagement.service;


import com.ebubekir.hospitalmanagement.dto.RandevuDTO;
import com.ebubekir.hospitalmanagement.entity.Doktor;
import com.ebubekir.hospitalmanagement.entity.Hasta;
import com.ebubekir.hospitalmanagement.entity.Randevu;
import com.ebubekir.hospitalmanagement.repository.RandevuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RandevuService {

    @Autowired
    private RandevuRepository randevuRepository;

    @Autowired
    private HastaService hastaService;

    @Autowired
    private DoktorService doktorService;

    public List<RandevuDTO> getAllRandevular() {
        List<RandevuDTO> randevular = new ArrayList<>();
        for (Randevu randevu: randevuRepository.findAll()){
            RandevuDTO dto = new RandevuDTO(randevu);
            Hasta hasta = hastaService.getHastaById(randevu.getHastaId());
            Doktor doktor = doktorService.getDoktorById(randevu.getDoktorId());
            dto.setDoktorAdi(doktor.getAd() +" "+ doktor.getSoyad());
            dto.setHastaAdi(hasta.getAd() + " " + hasta.getSoyad());
            dto.setRandevuTarihi(randevu.getRandevuTarihi());
            dto.setRandevuSaati(randevu.getRandevuSaati());

            randevular.add(dto);
        }
        return randevular;
    }

    public Randevu getRandevuById(Long id) {
        return randevuRepository.findById(id).orElse(null);
    }

    public List<Randevu> getRandevularByHastaId(Long hastaId) {
        return randevuRepository.findByHastaId(hastaId);
    }

    public List<Randevu> getRandevularByDoktorId(Long doktorId) {
        return randevuRepository.findByDoktorId(doktorId);
    }

    public Randevu saveRandevu(Randevu randevu) {
        return randevuRepository.save(randevu);
    }

    public void deleteRandevu(Long id) {
        randevuRepository.deleteById(id);
    }
}

