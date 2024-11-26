package org.example;

public class CalculatorLogic {

    private CalculatorLogic() {}    // Static class

    public static double computeStandardDeviation(double[] values, boolean isPopulation) throws Exception {
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

    public static double computeMean(double[] values) {
        //preq-LOGIC-5
        if(values.length == 0) {
            return 0.0;
        }

        double sumAccumulator = 0.0;
        for (double value : values)
            sumAccumulator += value;
        return sumAccumulator / values.length;
    }

    public static double computeSquareOfDifferences(double[] values, double mean) {
        double squareAccumulator = 0.0;
        for (double value : values)
            squareAccumulator += Math.pow(value - mean, 2.0);
        return squareAccumulator;
    }

    public static double computeVariance(double squareOfDifferences, int numValues, boolean isPopulation) throws Exception {
        if (!isPopulation)
            numValues--;

        if (numValues < 1) {
            if(isPopulation) {
                throw new Exception("Invalid input\nPopulation size must be greater than or equal to one");
            }
            throw new Exception("Invalid input\nSample size must be greater than or equal to two");
        }

        return squareOfDifferences / numValues;
    }

    public static double computeZScore(double[] input) throws Exception {
        //preq-LOGIC-6
        double value = input[0];
        double mean = input[1];
        double standardDeviation = input[2];
        if(value == Double.NEGATIVE_INFINITY || mean == Double.NEGATIVE_INFINITY || standardDeviation == Double.NEGATIVE_INFINITY) {
            throw new Exception("Invalid input\ninsert the values in the following order \"value, mean, standard deviation\"");
        }
        return (value - mean) / standardDeviation;
    }

    public static double[] computeSingleLineRegressionFormula(double[] pairs) throws Exception {
        //preq-LOGIC-7

        if(pairs.length == 0) {
            throw new Exception("Invalid input\ninsert at least two distinct x-value and y-value pairs");
        }

        double xAverage = 0.0, yAverage = 0.0, xyProductAverage = 0.0, xSquaredAverage = 0.0;

        for(int i = 0 ; i < pairs.length ; i += 2) {
            double x = pairs[i];
            double y = pairs[i + 1];

            xAverage += x;
            yAverage += y;
            xyProductAverage += x * y;
            xSquaredAverage += x * x;
        }

        int numberOfPairs = pairs.length / 2;

        xAverage /= numberOfPairs;
        yAverage /= numberOfPairs;
        xyProductAverage /= numberOfPairs;
        xSquaredAverage /= numberOfPairs;

        double denominator = xAverage * xAverage - xSquaredAverage;

        if(denominator == 0) {
            throw new Exception("Error\ncannot divide by zero - try making the values of x more distinct");
        }

        double m = (xAverage * yAverage - xyProductAverage) / denominator;
        double b = yAverage - m * xAverage;

        return new double[] {m, b};
    }

    public static double predictYFromLinearRegressionFormula(double x, double m, double b) throws Exception {
        //preq-LOGIC-8
        if(x == Double.NEGATIVE_INFINITY || m == Double.NEGATIVE_INFINITY || b == Double.NEGATIVE_INFINITY) {
            throw new Exception("Invalid input\ninsert the values in the following order \"x, m, b\"");
        }
        return x * m + b;
    }
}
