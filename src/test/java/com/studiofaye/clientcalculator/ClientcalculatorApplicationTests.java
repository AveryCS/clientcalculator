package com.studiofaye.clientcalculator;

import com.studiofaye.clientcalculator.calculators.PercentilePointsCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClientcalculatorApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testPercentilePointsCalculator(){
		PercentilePointsCalculator calculator = new PercentilePointsCalculator();
		int points = calculator.mapValueToNumber(25, 0, 100);
		assertEquals(3, points);
	}
}



