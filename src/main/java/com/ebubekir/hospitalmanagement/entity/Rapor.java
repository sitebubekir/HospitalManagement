package com.ebubekir.hospitalmanagement.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Rapor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String raporTarihi;
    private String turu;
    private String dosyaYolu;
    private String dosyaAdi;

    private Long hastaId;
    private Long doktorId;



}

