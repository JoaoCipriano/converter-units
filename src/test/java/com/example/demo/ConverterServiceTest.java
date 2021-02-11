package com.example.demo;

import com.example.demo.domain.Quantity;
import com.example.demo.domain.UnitConversionFactor;
import com.example.demo.domain.dto.ConversionObjectDTO;
import com.example.demo.repository.UnitConversionFactorRepository;
import com.example.demo.service.ConverterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ConverterServiceTest {

    @TestConfiguration
    static class ConverterServiceTestConfiguration {

        @Bean
        public ConverterService converterService() {
            return new ConverterService();
        }
    }

    @Autowired
    ConverterService converterService;

    @MockBean
    UnitConversionFactorRepository unitConversionFactorRepository;

    @Test
    public void converterServiceTestConverterUnits() {
        String unit = "minute";
        ConversionObjectDTO conversionObjectDTO = converterService.converterUnits(unit);

        Assertions.assertEquals("60s", conversionObjectDTO.getUnitName());
        Assertions.assertEquals(60.0, conversionObjectDTO.getMultiplicationFactor());
    }

    @Before
    public void setup() {
        UnitConversionFactor ucf = new UnitConversionFactor(1, "minute", "min", Quantity.TIME.getCod(), "60s", 60.0);

        Mockito.when(unitConversionFactorRepository.search(ucf.getName()))
                .thenReturn(java.util.Optional.of(ucf));
    }
}
