package com.example.demo.domain;

import java.util.stream.Stream;

public enum Quantity {
    TIME(1, "time"),
    UNITLESS_PLANE_ANGLE(2, "unitless/plane angle"),
    AREA(3, "area"),
    VOLUME(4, "volume"),
    MASS(5, "mass");

    private int cod;
    private String description;

    private Quantity(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }
    public String getDescription() {
        return description;
    }

    public static Quantity toEnum(Integer cod) {
        return Stream.of(Quantity.values())
                .filter(e -> cod.equals(e.getCod()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + cod));
    }
}
