package com.studiofaye.clientcalculator.calculators;

import com.studiofaye.clientcalculator.entities.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ClientRatingCalculatorTest {
    @Autowired
    ClientRatingCalculator clientCalc;

    @Autowired
    PercentilePointsCalculator percentCalc;

    @Test
    public void clientRatingCalculatorTest() {
        Client testClient = new Client();
        testClient.setEaseToWorkWith(10);
        testClient.setHourlyRate(50);
        testClient.setHoursBookedPerYear(90);
        int rating = clientCalc.calculateClientRating(testClient);
        assertEquals(10, rating);


    }


}
