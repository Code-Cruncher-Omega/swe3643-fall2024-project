package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorLogicTest {

    final double DELTA = .0000000000009;
    // Accuracy to the 12th decimal, not including 13th

    @Test
    void computeSampleStandardDeviation_ValidList_ReturnsDouble() {

        // Arrange
        double [] valuesList = {9.0, 6.0, 8.0, 5.0, 7.0};
        double expectedResult = 1.5811388300841898;
        double result = 0.0;

        // Act
        try {
            result = CalculatorLogic.computeSampleStandardDeviation(valuesList);
        }   catch(Exception e) {
            fail();
        }

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void computeSampleStandardDeviation_ListOfZeroes_ThrowException() {

        // Arrange
        final String EXPECTED = "valuesList parameter";

        final double[] VALUES = {0, 0, 0, 0};
        String result = null;

        // Act
        try {
            CalculatorLogic.computeSampleStandardDeviation(VALUES);
            fail();
        } catch(Exception e) {
            result = e.getMessage();
        }

        // Assert
        assertTrue(result.contains(EXPECTED));
    }

    @Test
    void computePopulationStandardDeviation_ValidList_ReturnsDouble() {

        // Arrange
        final double EXPECTED = 2.9832867780352594;

        final double[] VALUES = {9.0, 2.0, 5.0, 4.0, 12.0, 7.0, 8.0, 11.0, 9.0, 3.0, 7.0, 4.0, 12.0, 5.0, 4.0, 10.0, 9.0, 6.0, 9.0, 4.0};
        double result = 0.0;

        // Act
        try {
            result = CalculatorLogic.computePopulationStandardDeviation(VALUES);
        }   catch(Exception e) {
            fail();
        }

        // Assert
        assertEquals(EXPECTED, result);
    }

    @Test
    void computeMean_NullList_ThrowException() {

        // Arrange
        String expectedMessage = "valuesList parameter";
        Exception result = null;

        // Act
        try {
            CalculatorLogic.computeMean(null);
            fail();
        } catch (Exception e) {
            result = e;
        }
        String resultMessage = result.getMessage();

        // Assert
        assertTrue(resultMessage.contains(expectedMessage));
    }

    @Test
    void computeZScore_validInput_returnZ() {

        // Arrange
        final double EXPECTED = 2.846049894151541;

        // Act
        double result = CalculatorLogic.computeZScore(11.5, 7, 1.5811388300841898);

        // Assert
        assertEquals(EXPECTED, result); // Simple calculations, inaccuracy is unlikely
    }
    
    @Test
    void computeSingleLineRegressionFormula_validInput_returnMB() {

        // Arrange
        final double M = 61.272186542107434;
        final double B = -39.061955918838656;

        final double[][] VALUES = {{1.47, 52.21}, {1.5, 53.12}, {1.52, 54.48}, {1.55, 55.84}, {1.57, 57.2}, {1.6, 58.57}, {1.63, 59.93}, {1.65, 61.29}, {1.68, 63.11}, {1.7, 64.47}, {1.73, 66.28}, {1.75, 68.1}, {1.78, 69.92}, {1.8, 72.19}, {1.83, 74.46}};

        // Act
        double[] result = CalculatorLogic.computeSingleLineRegressionFormula(VALUES);

        // Assert
        assertEquals(M, result[0], DELTA);
        assertEquals(B, result[1], DELTA);
    }

    @Test
    void predictYFromLinearRegressionFormula_validInput_returnY() {

        // Arrange
        final double EXPECTED = 54.990850423296244;

        final double X = 1.535;
        final double M = 61.272186542107434;
        final double B = -39.061955918838656;

        // Act
        double result = CalculatorLogic.predictYFromLinearRegressionFormula(X, M, B);

        // Assert
        assertEquals(EXPECTED, result, DELTA);
    }
}