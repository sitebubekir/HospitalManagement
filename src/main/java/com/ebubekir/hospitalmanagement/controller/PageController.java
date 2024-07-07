package com.ebubekir.hospitalmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class PageController {


    @GetMapping("/hastalar")
    public String  getAllHastalar() {
        return "hastalar";
    }

    @GetMapping("/doktorlar")
    public String getAllDoktorlar() {
        return "doktorlar";
    }

    @GetMapping("/randevular")
    public String getAllRandevular() {
        return "randevular";
    }
    @GetMapping("/raporlar")
    public String getAllRaporlar() {
        return "/raporlar";
    }

}

