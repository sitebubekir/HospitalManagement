package com.ebubekir.hospitalmanagement.service;

import com.ebubekir.hospitalmanagement.dto.RaporDTO;
import com.ebubekir.hospitalmanagement.entity.Doktor;
import com.ebubekir.hospitalmanagement.entity.Hasta;
import com.ebubekir.hospitalmanagement.entity.Rapor;
import com.ebubekir.hospitalmanagement.repository.RaporRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class RaporService {

    private final String raporYolu = "src/main/resources/static/uploads/";

    @Autowired
    private HastaService hastaService;

    @Autowired
    private DoktorService doktorService;

    @Autowired
    private RaporRepository raporRepository;

    public List<RaporDTO> getAllRaporlar() {
        List<RaporDTO> raporlar = new ArrayList<>();
        for (Rapor rapor:raporRepository.findAll()) {
           RaporDTO dto = new RaporDTO(rapor);
            Hasta hasta = hastaService.getHastaById(rapor.getHastaId());
            Doktor doktor = doktorService.getDoktorById(rapor.getDoktorId());
            dto.setDoktorAdi(doktor.getAd() +" "+ doktor.getSoyad());
            dto.setHastaAdi(hasta.getAd() + " " + hasta.getSoyad());

           raporlar.add(dto);
        }
        return raporlar;
    }

    public Rapor getRaporById(Long id) {
        return raporRepository.findById(id).orElse(null);
    }

    public List<Rapor> getRaporlarByHastaId(Long hastaId) {
        return raporRepository.findByHastaId(hastaId);
    }

    public List<Rapor> getRaporlarByDoktorId(Long doktorId) {
        return raporRepository.findByDoktorId(doktorId);
    }

    public Rapor saveRapor(Rapor rapor, MultipartFile file) throws IOException {
        String dosyaAdi = file.getOriginalFilename();
        Path yol = Paths.get(raporYolu + dosyaAdi);
        Files.copy(file.getInputStream(), yol);

        rapor.setDosyaYolu(yol.toString());
        rapor.setDosyaAdi(dosyaAdi);
        return raporRepository.save(rapor);
    }

    public void deleteRapor(Long id) {
        Rapor rapor = raporRepository.findById(id).orElse(null);
        if (rapor != null) {
            File file = new File(rapor.getDosyaYolu());
            if (file.exists()) {
                file.delete();
            }
            raporRepository.deleteById(id);
        }
    }
}
