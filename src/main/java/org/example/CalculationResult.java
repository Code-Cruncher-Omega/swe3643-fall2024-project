package org.example;

public class CalculationResult {


    public static double computeStandardDeviation(int[] values, boolean isPopulation) {
        if(values == null || values.length == 0) {
            throw new Exception("valuesList parameter cannot be null or empty");
        }

        double mean = computeMean(values);
        double squareOfDifference = computeSquareOfDifferences(values, mean);
        double variance = computeVariance(squareOfDifference, values.length, isPopulation);

        return Math.sqrt(variance);
    }

    public static double computeSampleStandardDeviation(int[] values) {
        //preq-LOGIC-3
        return computeStandardDeviation(values, false);
    }

    public static double computePopulationStandardDeviation(int[] values) {
        //preq-LOGIC-4
        return computeStandardDeviation(values, true);
    }

    public static double computeMean(int[] values) {
        //preq-LOGIC-5
        if(values == null || values.length == 0) {
            throw new Exception("valuesList parameter cannot be null or empty");
        }

        int sumAccumulator = 0;
        for (int value : values)
            sumAccumulator += value;
        return (double) sumAccumulator / values.length;
    }

    public static double computeSquareOfDifferences(int[] values, double mean) {
        if(values == null || values.length == 0) {
            throw new Exception("valuesList parameter cannot be null or empty");
        }

        double squareAccumulator = 0;
        for (int value : values)
            squareAccumulator += (value * value) - 2 * (value * mean) + (mean * mean);  //fancy for (value - mean)^2
        return squareAccumulator;
    }

    public static double computeVariance(double squareOfDifferences, int numValues, boolean isPopulation) {
        if (!isPopulation)
            numValues--;

        if (numValues < 1)
            throw new Exception("numValues is too low (sample size must be >= 2, population size must be >= 1)");

        return squareOfDifferences / numValues;
    }

    public static double computeZScore(double value, double mean, double stdDev) {
        //preq-LOGIC-6

    }

    public static String computeSingleLineRegressionFormula(double[][] pairs) {
        //preq-LOGIC-7

    }

    public static String predictYFromLinearRegressionFormula(double x, double m, double b) {
        //preq-LOGIC-8

    }
}
