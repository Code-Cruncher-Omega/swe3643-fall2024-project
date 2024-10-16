package org.example;

import java.util.Arrays;

public class CalculatorLogic {


    public static CalculationResult computeStandardDeviation(int[] values, boolean isPopulation) {
        /*
        if(values == null || values.length == 0) {
            throw new Exception("valuesList parameter cannot be null or empty");
        }
        */
        CalculationResult mean = computeMean(values);
        CalculationResult squareOfDifference = computeSquareOfDifferences(values, mean.getResult());
        CalculationResult variance = computeVariance(squareOfDifference.getResult(), values.length, isPopulation);

        double result = Math.sqrt(variance.getResult());
        return new CalculationResult(result, true, null, null);
    }

    public static CalculationResult computeSampleStandardDeviation(int[] values) {
        //preq-LOGIC-3
        return computeStandardDeviation(values, false);
    }

    public static CalculationResult computePopulationStandardDeviation(int[] values) {
        //preq-LOGIC-4
        return computeStandardDeviation(values, true);
    }

    public static CalculationResult computeMean(int[] values) {
        //preq-LOGIC-5
        /*
        if(values == null || values.length == 0) {
            throw new Exception("valuesList parameter cannot be null or empty");
        }
        */
        int sumAccumulator = 0;
        for (int value : values)
            sumAccumulator += value;

        double result = (double) sumAccumulator / values.length;
        return new CalculationResult(result, true, result + "", null);
    }

    public static CalculationResult computeSquareOfDifferences(int[] values, double mean) {
        /*
        if(values == null || values.length == 0) {
            throw new Exception("valuesList parameter cannot be null or empty");
        }
        */
        double squareAccumulator = 0;
        for (int value : values)
            squareAccumulator += (value * value) - 2 * (value * mean) + (mean * mean);  //fancy for (value - mean)^2
        return new CalculationResult(squareAccumulator, true, squareAccumulator + "", null);
    }

    public static CalculationResult computeVariance(double squareOfDifferences, int numValues, boolean isPopulation) {
        if (!isPopulation)
            numValues--;
        /*
        if (numValues < 1)
            throw new Exception("numValues is too low (sample size must be >= 2, population size must be >= 1)");
        */
        double result = squareOfDifferences / numValues;
        return new CalculationResult(result, true, result + "", null);
    }

    public static CalculationResult computeZScore(double value, double mean, double stdDev) {
        //preq-LOGIC-6
        double result = (value - mean) / stdDev;
        return new CalculationResult(result, true, result + "", null);
    }

    public static CalculationResult computeSingleLineRegressionFormula(double[][] pairs) {
        //preq-LOGIC-7
        double xAvg = 0.0, yAvg = 0.0, xyProductAvg = 0.0, xSquaredAvg = 0.0;

        for(double[] pair : pairs) {
            double x = pair[0];
            double y = pair[1];

            xAvg += x;
            yAvg += y;
            xyProductAvg += x * y;
            xSquaredAvg += x * x;
        }

        xAvg /= pairs.length;
        yAvg /= pairs.length;
        xyProductAvg /= pairs.length;
        xSquaredAvg /= pairs.length;

        double m = (xAvg * yAvg - xyProductAvg) / (xAvg * xAvg - xSquaredAvg);
        double b = yAvg - m * xAvg;

        return new CalculationResult(m, true, "y = " + m + "x + " + b, null);
    }

    public static CalculationResult predictYFromLinearRegressionFormula(double x, double m, double b) {
        //preq-LOGIC-8
        double result = x * m + b;
        return new CalculationResult(result, true, "y = " + result, null);
    }

    public static void main(String[] args) {
        String[] pairs = "1.47,52.21\n1.5,53.12\n1.52,54.48\n1.55,55.84\n1.57,57.2\n1.6,58.57\n1.63,59.93\n1.65,61.29\n1.68,63.11\n1.7,64.47\n1.73,66.28\n1.75,68.1\n1.78,69.92\n1.8,72.19\n1.83,74.46".split("\n");
        double[][] pairDouble = new double[pairs.length][2];
        for(int i = 0 ; i < pairs.length ; i++) {
            String[] pairValues = pairs[i].split(",");
            pairDouble[i][0] = Double.parseDouble(pairValues[0]);
            pairDouble[i][1] = Double.parseDouble(pairValues[1]);
        }
        String test = Arrays.deepToString(pairDouble);
        char[] letters = test.toCharArray();
        for(int i = 0 ; i < letters.length ; i++) {
            if(letters[i] == '[')
                letters[i] = '{';
            if(letters[i] == ']')
                letters[i] = '}';
        }
        //System.out.println(letters);

        double[][] newPairDouble = {{1.47, 52.21}, {1.5, 53.12}, {1.52, 54.48}, {1.55, 55.84}, {1.57, 57.2}, {1.6, 58.57}, {1.63, 59.93}, {1.65, 61.29}, {1.68, 63.11}, {1.7, 64.47}, {1.73, 66.28}, {1.75, 68.1}, {1.78, 69.92}, {1.8, 72.19}, {1.83, 74.46}};
        System.out.println(computeSingleLineRegressionFormula(newPairDouble));
        //result is off by the 13th decimal place on m and b
    }
}
