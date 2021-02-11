package com.example.demo.repository;

import com.example.demo.domain.UnitConversionFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitConversionFactorRepository extends JpaRepository<UnitConversionFactor, Integer> {

    @Query("SELECT unit FROM UnitConversionFactor unit WHERE unit.name = :unit OR unit.symbol = :unit")
    Optional<UnitConversionFactor> search(@Param("unit") String unit);
}
