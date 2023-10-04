package com.studiofaye.clientcalculator.calculators;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PercentilePointsCalculatorTest {

    @Test
    public void testPercentilePointsCalculator() {
        PercentilePointsCalculator calculator = new PercentilePointsCalculator();
        int points = calculator.mapValueToNumber(25, 0, 100);
        assertEquals(2, points);
    }
}
