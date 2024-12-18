package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorLogicTest {

    @Test
    void computeSampleStandardDeviation_validList_returnsDouble() {
        //preq-UNIT-TEST-2
        // Arrange
        double [] valuesList = {
                9.0, 6.0, 8.0, 5.0, 7.0
        };
        double expectedResult = 1.5811388300841898;
        double result = 0.0;

        // Act
        try {
            result = CalculatorLogic.computeSampleStandardDeviation(valuesList);
        }   catch (Exception e) {
            fail();
        }

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void computeSampleStandardDeviation_listOfZeroes_returnsZero() {
        //preq-UNIT-TEST-2
        // Arrange
        final double EXPECTED = 0.0;

        final double[] VALUES = {
                0, 0, 0, 0
        };
        double result = Double.NEGATIVE_INFINITY;

        // Act
        try {
            result = CalculatorLogic.computeSampleStandardDeviation(VALUES);
        } catch (Exception e) {
            fail();
        }

        // Assert
        assertEquals(EXPECTED, result);
    }

    @Test
    void computeSampleStandardDeviation_listOfOneSample_throwException() {
        //preq-UNIT-TEST-2
        // Arrange
        final String EXPECTED = "Sample size must be greater than or equal to two";
        String result = "";

        // Act
        try {
            CalculatorLogic.computeSampleStandardDeviation(new double[] {1.0});
            fail();
        } catch (Exception e) {
            result = e.getMessage();
        }

        // Assert
        assertTrue(result.contains(EXPECTED));
    }

    @Test
    void computeSampleStandardDeviation_emptyList_throwException() {
        //preq-UNIT-TEST-2
        // Arrange
        final String EXPECTED = "Input values, each separated by a new line";
        String result = "";

        // Act
        try {
            CalculatorLogic.computeSampleStandardDeviation(new double[0]);
            fail();
        } catch (Exception e) {
            result = e.getMessage();
        }

        // Assert
        assertTrue(result.contains(EXPECTED));
    }

    @Test
    void computePopulationStandardDeviation_validList_returnsDouble() {
        //preq-UNIT-TEST-3
        // Arrange
        final double EXPECTED = 2.9832867780352594;

        final double[] VALUES = {
                9.0, 2.0, 5.0, 4.0, 12.0,
                7.0, 8.0, 11.0, 9.0, 3.0,
                7.0, 4.0, 12.0, 5.0, 4.0,
                10.0, 9.0, 6.0, 9.0, 4.0
        };
        double result = 0.0;

        // Act
        try {
            result = CalculatorLogic.computePopulationStandardDeviation(VALUES);
        }   catch (Exception e) {
            fail();
        }

        // Assert
        assertEquals(EXPECTED, result);
    }

    @Test
    void computePopulationStandardDeviation_listOfZeroes_returnsZero() {
        //preq-UNIT-TEST-3
        // Arrange
        final double EXPECTED = 0.0;

        final double[] VALUES = {
                0, 0, 0, 0
        };
        double result = Double.NEGATIVE_INFINITY;

        // Act
        try {
            result = CalculatorLogic.computePopulationStandardDeviation(VALUES);
        } catch (Exception e) {
            fail();
        }

        // Assert
        assertEquals(EXPECTED, result);
    }

    @Test
    void computePopulationStandardDeviation_emptyList_throwException() {
        //preq-UNIT-TEST-3
        // Arrange
        final String EXPECTED = "Input values, each separated by a new line";
        String result = "";

        // Act
        try {
            CalculatorLogic.computePopulationStandardDeviation(new double[0]);
            fail();
        } catch (Exception e) {
            result = e.getMessage();
        }

        // Assert
        assertTrue(result.contains(EXPECTED));
    }

    @Test
    void computeMean_validList_returnsDouble() {
        //preq-UNIT-TEST-4
        // Arrange
        final double EXPECTED = 7.0;

        double[] VALUES = {
                9.0, 6.0, 8.0, 5.0, 7.0
        };
        double result = Double.NEGATIVE_INFINITY;

        // Act
        try {
            result = CalculatorLogic.computeMean(VALUES);
        } catch (Exception e) {
            fail();
        }

        // Assert
        assertEquals(EXPECTED, result);
    }

    @Test
    void computeMean_emptyList_throwException() {
        //preq-UNIT-TEST-4
        // Arrange
        final String EXPECTED = "Input values, each separated by a new line";
        String result = "";

        // Act
        try {
            CalculatorLogic.computeMean(new double[0]);
            fail();
        } catch (Exception e) {
            result = e.getMessage();
        }

        // Assert
        assertTrue(result.contains(EXPECTED));
    }

    @Test
    void computeVariance_emptyPopulation_throwException() {
        // Arrange
        final String EXPECTED = "size must be greater than or equal to";    // Doesn't specify deviation type to work
        String result = "";                                                 // to work with either types

        // Act
        try {
            CalculatorLogic.computeVariance(12.0, 0, true);
            fail();
        } catch (Exception e) {
            result = e.getMessage();
        }

        // Assert
        assertTrue(result.contains(EXPECTED));
    }

    @Test
    void computeZScore_validInput_returnZ() {
        //preq-UNIT-TEST-5
        // Arrange
        final double EXPECTED = 2.846049894151541;
        final double[] INPUT = {
                11.5, 7, 1.5811388300841898
        };
        double result = Double.NEGATIVE_INFINITY;

        // Act
        try {
            result = CalculatorLogic.computeZScore(INPUT);
        } catch (Exception e) {
            fail();
        }

        // Assert
        assertEquals(EXPECTED, result);
    }

    @Test
    void computeZScore_emptyInput_throwException() {
        //preq-UNIT-TEST-5
        // Arrange
        final String EXPECTED = "Input value, mean, and deviation, each separated by a comma";
        String result = "";

        // Act
        try {
            CalculatorLogic.computeZScore(new double[0]);
            fail();
        } catch (Exception e) {
            result = e.getMessage();
        }

        // Assert
        assertTrue(result.contains(EXPECTED));
    }

    @Test
    void computeZScore_missingParameter_throwException() {
        //preq-UNIT-TEST-5
        // Arrange
        final String EXPECTED = "Input the values in the following order \"value, mean, standard deviation\"";
        double[] input;
        String valueResult = "", meanResult = "", standardDeviationResult = "";

        // Act
        try {
            input = new double[] {
                    Double.NEGATIVE_INFINITY, 0.0, 1.0  // Empty value
            };
            CalculatorLogic.computeZScore(input);
            fail();
        } catch (Exception e) {
            valueResult = e.getMessage();
        }
        try {
            input = new double[] {
                    0.0, Double.NEGATIVE_INFINITY, 1.0  // Empty mean
            };
            CalculatorLogic.computeZScore(input);
        } catch (Exception e) {
            meanResult = e.getMessage();
        }
        try {
            input = new double[] {
                    0.0, 0.0, Double.NEGATIVE_INFINITY  // Empty standard deviation
            };
            CalculatorLogic.computeZScore(input);
        } catch (Exception e) {
            standardDeviationResult = e.getMessage();
        }

        // Assert
        assertTrue(valueResult.contains(EXPECTED));
        assertTrue(meanResult.contains(EXPECTED));
        assertTrue(standardDeviationResult.contains(EXPECTED));
    }

    @Test
    void computeZScore_meanIsZero_returnZ() {
        //preq-UNIT-TEST-5
        // Arrange
        final double EXPECTED = 7.285974499089253;
        final double[] INPUT = {
                12, 0, 1.647
        };
        double result = Double.NEGATIVE_INFINITY;

        // Act
        try {
            result = CalculatorLogic.computeZScore(INPUT);
        } catch (Exception e) {
            fail();
        }

        // Assert
        assertEquals(EXPECTED, result);
    }

    @Test
    void computeSingleLineRegressionFormula_validInput_returnMB() {
        //preq-UNIT-TEST-6
        // Arrange
        final double M = 61.272186542107;
        final double B = -39.061955918838;

        final double[] INPUT = {
                1.47, 52.21,
                1.5, 53.12,
                1.52, 54.48,
                1.55, 55.84,
                1.57, 57.2,
                1.6, 58.57,
                1.63, 59.93,
                1.65, 61.29,
                1.68, 63.11,
                1.7, 64.47,
                1.73, 66.28,
                1.75, 68.1,
                1.78, 69.92,
                1.8, 72.19,
                1.83, 74.46
        };
        double[] result = {};

        // Act
        try {
            result = CalculatorLogic.computeSingleLineRegressionFormula(INPUT);
        } catch (Exception e) {
            fail();
        }

        // Assert
        assertEquals(M, result[0]);
        assertEquals(B, result[1]);
    }

    @Test
    void computeSingleLineRegressionFormula_emptyList_throwException() {
        //preq-UNIT-TEST-6
        // Arrange
        final String EXPECTED = "Input at least two distinct x-value and y-value pairs";

        String result = "";

        // Act
        try {
            CalculatorLogic.computeSingleLineRegressionFormula(new double[0]);
            fail();
        } catch (Exception e) {
            result = e.getMessage();
        }

        // Assert
        assertTrue(result.contains(EXPECTED));
    }

    @Test
    void computeSingleLineRegressionFormula_listOfEqualXValues_throwException() {
        //preq-UNIT-TEST-6
        // Arrange
        final String EXPECTED = "try making the values of x more distinct";
        final double[] INPUT = {
                12.0, 0.0,
                12.0, 9.4,
                12.0, 8.8,
                12.0, 12.3
        };

        String result = "";

        // Act
        try {
            CalculatorLogic.computeSingleLineRegressionFormula(INPUT);
            fail();
        } catch (Exception e) {
            result = e.getMessage();
        }

        // Assert
        assertTrue(result.contains(EXPECTED));
    }

    @Test
    void computeSingleLineRegressionFormula_listOfEqualYValues_returnMB() {
        //preq-UNIT-TEST-6
        // Arrange
        final double M = 0.0;
        final double B = 1.0;

        final double[] INPUT = {
                9.99, 1.0,
                -81.2, 1.0,
                -25.7, 1.0,
                60.0, 1.0
        };
        double[] result = {};

        // Act
        try {
            result = CalculatorLogic.computeSingleLineRegressionFormula(INPUT);
        } catch (Exception e) {
            fail();
        }

        // Assert
        assertEquals(M, result[0] + 0.0);   // Added 0.0 to result so -0.0 can turn back to 0.0
        assertEquals(B, result[1]);
    }

    @Test
    void computeSingleLineRegressionFormula_listOfZeroPairs_throwException() {
        //preq-UNIT-TEST-6
        // Arrange
        final String EXPECTED = "Error\ncannot divide by zero";
        final double[] VALUES = {
                0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0
        };

        String result = "";

        // Act
        try {
            CalculatorLogic.computeSingleLineRegressionFormula(VALUES);
            fail();
        } catch (Exception e) {
            result = e.getMessage();
        }

        // Assert
        assertTrue(result.contains(EXPECTED));
    }

    @Test
    void predictYFromLinearRegressionFormula_validInput_returnY() {
        //preq-UNIT-TEST-7
        // Arrange
        final double EXPECTED = 54.990850423296244;
        final double[] INPUT = {
                1.535, 61.272186542107434, -39.061955918838656
        };

        double result = Double.NEGATIVE_INFINITY;

        // Act
        try {
            result = CalculatorLogic.predictYFromLinearRegressionFormula(INPUT);
        } catch (Exception e) {
            fail();
        }

        // Assert
        assertEquals(EXPECTED, result);
    }

    @Test
    void predictYFromLinearRegressionFormula_missingParameter_throwException() {
        //preq-UNIT-TEST-7
        // Arrange
        final String EXPECTED = "Input the values x, m, and b values, each separated by a comma";
        String xResult = "", mResult = "", bResult = "";

        // Act
        try {
            CalculatorLogic.predictYFromLinearRegressionFormula(new double[] {Double.NEGATIVE_INFINITY, 0.0, 0.0}); // Missing X
            fail();
        } catch (Exception e) {
            xResult = e.getMessage();
        }
        try {
            CalculatorLogic.predictYFromLinearRegressionFormula(new double[] {0.0, Double.NEGATIVE_INFINITY, 0.0}); // Missing M
            fail();
        } catch (Exception e) {
            mResult = e.getMessage();
        }
        try {
            CalculatorLogic.predictYFromLinearRegressionFormula(new double[] {0.0, 0.0, Double.NEGATIVE_INFINITY}); // Missing B
            fail();
        } catch (Exception e) {
            bResult = e.getMessage();
        }

        // Assert
        assertTrue(xResult.contains(EXPECTED));
        assertTrue(mResult.contains(EXPECTED));
        assertTrue(bResult.contains(EXPECTED));
    }

    @Test
    void predictYFromLinearRegressionFormula_emptyInput_throwException() {
        // Arrange
        final String EXPECTED = "Input the values x, m, and b values, each separated by a comma";

        String result = "";

        // Act
        try {
            CalculatorLogic.predictYFromLinearRegressionFormula(new double [0]);
            fail();
        } catch (Exception e) {
            result = e.getMessage();
        }

        // Assert
        assertTrue(result.contains(EXPECTED));
    }
}