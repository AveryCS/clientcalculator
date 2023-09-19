package com.studiofaye.clientcalculator.calculators;
import com.studiofaye.clientcalculator.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import static java.lang.Math.round;

@Component
public class ClientRatingCalculator {

    @Autowired
    PercentilePointsCalculator percentileCalculator;
    public ClientRatingCalculator() {
    }

    public int calculateClientRating(Client client){
        //TODO- query the database for the minimum and the maximum values of each
        int hourlyRatePoints = percentileCalculator.mapValueToNumber(client.getHourlyRate(), 30,60);
        int hoursBookedPerYearPoints = percentileCalculator.mapValueToNumber(client.getHoursBookedPerYear(), 0,100);
        int result = (int) Math.round((client.getEaseToWorkWith()*.60) + (hourlyRatePoints *.25)+ (hoursBookedPerYearPoints*.15));
          return result;
    }


}
