package com.example.demo;

import com.example.demo.domain.Quantity;
import com.example.demo.domain.UnitConversionFactor;
import com.example.demo.repository.UnitConversionFactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private UnitConversionFactorRepository unitConversionFactorRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UnitConversionFactor ucf1 = new UnitConversionFactor(null, "minute", "min", Quantity.TIME.getCod(), "60s", 60.0);
		UnitConversionFactor ucf2 = new UnitConversionFactor(null, "hour", "h", Quantity.TIME.getCod(), "3.600s", 3600.0);
		UnitConversionFactor ucf3 = new UnitConversionFactor(null, "day", "d", Quantity.TIME.getCod(), "86.400s", 86400.0);
		UnitConversionFactor ucf4 = new UnitConversionFactor(null, "degree", "º", Quantity.UNITLESS_PLANE_ANGLE.getCod(), "(π/180)rad", 0.01745329252);
		UnitConversionFactor ucf5 = new UnitConversionFactor(null, "arcminute", "'", Quantity.UNITLESS_PLANE_ANGLE.getCod(), "(π/10800)rad", 0.00029088820866572);
		UnitConversionFactor ucf6 = new UnitConversionFactor(null, "arcsecond", "\"", Quantity.UNITLESS_PLANE_ANGLE.getCod(), "(π/648000)rad", 4.8481368110954E-6);
		UnitConversionFactor ucf7 = new UnitConversionFactor(null, "hectare", "ha", Quantity.AREA.getCod(), "10.000 m²", 10000.0);
		UnitConversionFactor ucf8 = new UnitConversionFactor(null, "litre", "L", Quantity.VOLUME.getCod(), "0.001 m³", 0.001);
		UnitConversionFactor ucf9 = new UnitConversionFactor(null, "tonne", "t", Quantity.MASS.getCod(), "1000 kg", 1000.0);

		unitConversionFactorRepository.saveAll(Arrays.asList(ucf1, ucf2, ucf3, ucf4, ucf5, ucf6, ucf7, ucf8, ucf9));
	}
}
