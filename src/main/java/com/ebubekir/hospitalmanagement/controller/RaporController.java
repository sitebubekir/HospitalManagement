package com.ebubekir.hospitalmanagement.controller;

import com.ebubekir.hospitalmanagement.dto.RaporDTO;
import com.ebubekir.hospitalmanagement.entity.Rapor;
import com.ebubekir.hospitalmanagement.service.RaporService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/raporlar")
public class RaporController {


    @Autowired
    private RaporService raporService;

    @GetMapping
    public List<RaporDTO> getAllRaporlar() {
        return raporService.getAllRaporlar();
    }

    @GetMapping("/{id}")
    public Rapor getRaporById(@PathVariable Long id) {
        return raporService.getRaporById(id);
    }

    @GetMapping("/hasta/{hastaId}")
    public List<Rapor> getRaporlarByHastaId(@PathVariable Long hastaId) {
        return raporService.getRaporlarByHastaId(hastaId);
    }

    @GetMapping("/doktor/{doktorId}")
    public List<Rapor> getRaporlarByDoktorId(@PathVariable Long doktorId) {
        return raporService.getRaporlarByDoktorId(doktorId);
    }

    @PostMapping("/upload")
    public Rapor uploadRapor(@RequestParam("file") MultipartFile file,
                             @RequestParam("hastaId") Long hastaId,
                             @RequestParam("doktorId") Long doktorId,
                             @RequestParam("turu") String turu) throws IOException {
        Rapor rapor = new Rapor();
        rapor.setHastaId(hastaId);
        rapor.setDoktorId(doktorId);
        rapor.setTuru(turu);
        return raporService.saveRapor(rapor, file);
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<Resource> downloadRapor(@PathVariable Long id) throws IOException {
        Rapor rapor = raporService.getRaporById(id);
        Path yol = Paths.get(rapor.getDosyaYolu());
        Resource kaynak = new UrlResource(yol.toUri());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + kaynak.getFilename() + "\"")
                .body(kaynak);
    }

    @DeleteMapping("/{id}")
    public void deleteRapor(@PathVariable Long id) {
        raporService.deleteRapor(id);
    }
}

