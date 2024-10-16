package org.example;

public class CalculatorLogic {

    private CalculatorLogic() {}    // Static class

    public static double computeStandardDeviation(double[] values, boolean isPopulation) throws Exception {
        if(values == null || values.length == 0) {
            throw new Exception("valuesList parameter cannot be null or empty");
        }

        double mean = computeMean(values);
        double squareOfDifference = computeSquareOfDifferences(values, mean);
        double variance = computeVariance(squareOfDifference, values.length, isPopulation);

        return Math.sqrt(variance);
    }

    public static double computeSampleStandardDeviation(double[] values) throws Exception {
        //preq-LOGIC-3
        return computeStandardDeviation(values, false);
    }

    public static double computePopulationStandardDeviation(double[] values) throws Exception {
        //preq-LOGIC-4
        return computeStandardDeviation(values, true);
    }

    public static double computeMean(double[] values) throws Exception {
        //preq-LOGIC-5
        if(values == null || values.length == 0) {
            throw new Exception("valuesList parameter cannot be null or empty");
        }

        double sumAccumulator = 0.0;
        for (double value : values)
            sumAccumulator += value;
        return sumAccumulator / values.length;
    }

    public static double computeSquareOfDifferences(double[] values, double mean) {
        double squareAccumulator = 0;
        for (double value : values)
            squareAccumulator += (value * value) - 2 * (value * mean) + (mean * mean);  //fancy for (value - mean)^2
        return squareAccumulator;
    }

    public static double computeVariance(double squareOfDifferences, int numValues, boolean isPopulation) throws Exception {
        if (!isPopulation)
            numValues--;

        if (numValues < 1)
            throw new Exception("numValues is too low (sample size must be >= 2, population size must be >= 1)");

        return squareOfDifferences / numValues;
    }

    public static double computeZScore(double value, double mean, double stdDev) {
        //preq-LOGIC-6
        return (value - mean) / stdDev;
    }

    public static double[] computeSingleLineRegressionFormula(double[][] pairs) {
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

        return new double[] {m, b};
    }

    public static double predictYFromLinearRegressionFormula(double x, double m, double b) {
        //preq-LOGIC-8
        return x * m + b;
    }
}
