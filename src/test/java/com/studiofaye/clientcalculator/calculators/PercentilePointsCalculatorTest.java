package com.studiofaye.clientcalculator.calculators;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PercentilePointsCalculatorTest {
@Autowired PercentilePointsCalculator calculator;

    @Test
    public void testMapValueToNumber_WithValidInput(){
        int points = calculator.mapValueToNumber(25, 0, 100);
        assertEquals(3, points);
    }

    @Test
    public void testMapValueToNumber_WithTooHighValue(){
        int points = calculator.mapValueToNumber(102, 0, 100);
        assertEquals(10, points);
    }

    @Test
    public void testMapValueToNumber_WithNegativeValue(){
        int points = calculator.mapValueToNumber(-5, 0, 100);
        assertEquals(1, points);
    }
}
