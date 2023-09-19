package com.studiofaye.clientcalculator.calculators;

import org.springframework.stereotype.Component;

@Component
public class PercentilePointsCalculator {

    public PercentilePointsCalculator() {

    }
    public int mapValueToNumber(int itemBeingCalculated, int min,int max) {
        if (itemBeingCalculated < min ){
            return 1;
        }
        if(itemBeingCalculated > max) {
            return 10;
        }
        // Calculate the output value n based on the decile scale
        double range = max - min;
        int n = (int) Math.ceil((itemBeingCalculated - min) / (range / 10.0));

        // Ensure n is within the range [1, 10]
        n = Math.max(1, Math.min(10, n));
        return n;
    }
}
