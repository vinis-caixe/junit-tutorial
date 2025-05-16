package org.example.math;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTestS4 {

    SimpleMath math;

    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
    }

    @DisplayName("Test 6.2 / 2 = 3.1")
    @ParameterizedTest
    //@MethodSource("testDivisionInputParameters")
    @MethodSource()
    void testDivision(double firstNumber, double secondNumber, double expected) {

        System.out.println("Test " + firstNumber + " / " + secondNumber + " = " + expected + "!");
        double result = math.division(firstNumber, secondNumber);

        assertEquals(expected, result, 2D,
                () -> "(" + firstNumber + "/" + secondNumber + ")" +
                "did not produce " + expected + "!");
        Assertions.assertNotEquals(8.2D, result);
    }

    //public static Stream<Arguments> testDivisionInputParameters() {
    public static Stream<Arguments> testDivision() {
        return Stream.of(
                Arguments.of(6.2D, 2D, 3.1D),
                Arguments.of(71D, 14D, 5.07D),
                Arguments.of(18.3D, 3.1D, 5.90D)
        );
    }

}