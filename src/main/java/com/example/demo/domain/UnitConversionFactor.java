package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class UnitConversionFactor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String symbol;
    private Integer quantity;
    private String siConversion;
    private Double multiplicationFactor;

    public UnitConversionFactor() {}

    public UnitConversionFactor(Integer id, String name, String symbol, Integer quantity, String siConversion, Double multiplicationFactor) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.quantity = quantity;
        this.siConversion = siConversion;
        this.multiplicationFactor = multiplicationFactor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSiConversion() {
        return siConversion;
    }

    public void setSiConversion(String siConversion) {
        this.siConversion = siConversion;
    }

    public Double getMultiplicationFactor() {
        return multiplicationFactor;
    }

    public void setMultiplicationFactor(Double multiplicationFactor) {
        this.multiplicationFactor = multiplicationFactor;
    }
}
