package com.ani.quotation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/quotation")
@RestController
public class QuotationController {

    @GetMapping
    public ResponseEntity<String> getQuotation() {
        return ResponseEntity.ok("it is quotation");
    }
}
