package com.ebubekir.hospitalmanagement.dto;

import com.ebubekir.hospitalmanagement.entity.Randevu;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RandevuDTO {

    private Long id;

    private String randevuTarihi;
    private String randevuSaati;
    private String doktorAdi;
    private String hastaAdi;

    public RandevuDTO() {
    }

    public RandevuDTO(Randevu randevu) {
        this.id = randevu.getId();
        this.randevuTarihi = randevu.getRandevuTarihi();
        this.randevuSaati = randevu.getRandevuSaati();
    }
}
