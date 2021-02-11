package com.example.demo.controller;

import com.example.demo.domain.dto.ConversionObjectDTO;
import com.example.demo.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/units")
public class ConverterController {

    @Autowired
    private ConverterService converterService;

    @GetMapping(value = "/si")
    public ResponseEntity<ConversionObjectDTO> converterUnits(@RequestParam String units) {
        return ResponseEntity.status(HttpStatus.OK).body(converterService.converterUnits(units));
    }
}
