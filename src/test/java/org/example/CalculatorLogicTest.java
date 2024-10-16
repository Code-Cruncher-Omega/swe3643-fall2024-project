package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CalculatorLogicTest {

    @Test
    void computeSingleLineRegressionFormula_validValues_returnMB() {
        // Arrange
        final double[][] VALUES = {{1.47, 52.21}, {1.5, 53.12}, {1.52, 54.48}, {1.55, 55.84}, {1.57, 57.2}, {1.6, 58.57}, {1.63, 59.93}, {1.65, 61.29}, {1.68, 63.11}, {1.7, 64.47}, {1.73, 66.28}, {1.75, 68.1}, {1.78, 69.92}, {1.8, 72.19}, {1.83, 74.46}};
        final double M = 61.272186542107434;
        final double B = -39.061955918838656;

        // Act
        CalculationResult result = CalculatorLogic.computeSingleLineRegressionFormula(VALUES);

        // Assert
        assertEquals(M, result.getResult(), .0000000000009);
        assertEquals(B, Double.parseDouble(result.getOperation().split(" ")[4]), .0000000000009);
        // Accuracy to the 12th decimal, not including 13th, for some reason there's inaccuracy there
        // The way the 2nd assert works is it takes the string "y = mx + b" and splits it by spaces
        // then parses the 4th element, which is always b, to get its value since multiple values
        // need to be tested here
    }
}