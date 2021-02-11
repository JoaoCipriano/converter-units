package com.example.demo.service;

import com.example.demo.domain.dto.ConversionObjectDTO;
import com.example.demo.domain.UnitConversionFactor;
import com.example.demo.repository.UnitConversionFactorRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    @Autowired
    private UnitConversionFactorRepository unitConversionFactorRepository;

    public ConversionObjectDTO converterUnits(String unit) {
        validateArgument(unit);
        UnitConversionFactor ucf = unitConversionFactorRepository
                .search(unit)
                .orElseThrow(() -> new ObjectNotFoundException(UnitConversionFactor.class, "Não foi encontrada uma contraparte para a unidade especificada"));
        return new ConversionObjectDTO(ucf);
    }

    private void validateArgument(String unit) {
        if (unit.contains("/") || unit.contains("*")) {
            throw new IllegalArgumentException("Conversão para esta unidade indisponível");
        }
    }
}
