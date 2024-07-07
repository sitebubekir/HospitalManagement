package com.ebubekir.hospitalmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Randevu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String randevuTarihi;
    private String randevuSaati;

    private Long hastaId;
    private Long doktorId;

}

