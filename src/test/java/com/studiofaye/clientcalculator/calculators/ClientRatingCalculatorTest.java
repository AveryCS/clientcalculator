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


    //TODO TEST IS WORKING BUT NEED TO DOUBLE CHECK THE VALUES
    @Test
    public void clientRatingCalculatorTest() {
        Client testClient = new Client();
        testClient.setEaseToWorkWith(10);
        testClient.setHourlyRate(100);
        testClient.setHoursBookedPerYear(110);
        int rating = clientCalc.calculateClientRating(testClient);
        assertEquals(10, rating);


    }


}
