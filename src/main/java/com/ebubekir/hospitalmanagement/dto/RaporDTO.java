package com.ebubekir.hospitalmanagement.dto;

import com.ebubekir.hospitalmanagement.entity.Rapor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RaporDTO {

    private Long id;

    private String raporTarihi;
    private String turu;
    private String dosyaYolu;
    private String dosyaAdi;
    private String doktorAdi;
    private String hastaAdi;

    public RaporDTO() {
    }

    public RaporDTO(Rapor rapor) {
        this.id = rapor.getId();
        this.turu = rapor.getTuru();
        this.dosyaAdi = rapor.getDosyaAdi();
        this.dosyaYolu = rapor.getDosyaYolu();
        this.raporTarihi = rapor.getRaporTarihi();
    }
}
