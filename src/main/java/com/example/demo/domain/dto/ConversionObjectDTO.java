package com.example.demo.domain.dto;

import com.example.demo.domain.UnitConversionFactor;

public class ConversionObjectDTO {

    private String unitName;
    private Double multiplicationFactor;

    public ConversionObjectDTO() {}

    public ConversionObjectDTO(UnitConversionFactor entity) {
        this.unitName = entity.getSiConversion();
        this.multiplicationFactor = entity.getMultiplicationFactor();
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Double getMultiplicationFactor() {
        return multiplicationFactor;
    }

    public void setMultiplicationFactor(Double multiplicationFactor) {
        this.multiplicationFactor = multiplicationFactor;
    }
}
