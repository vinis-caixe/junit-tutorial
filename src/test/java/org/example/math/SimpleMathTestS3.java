package org.example.math;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTestS3 {

    SimpleMath math;

    @BeforeAll
    static void setup() {
        System.out.println("Running @BeforeAll method!");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Running @AfterAll method!");
    }

    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
        System.out.println("Running @BeforeEach method!");
    }

    @AfterEach
    void afterEachMethod() {
        System.out.println("Running @AfterEach method!");
    }

    @Test
    @DisplayName("Test 6.2 + 2 = 8.2")
    void testSum() {

        System.out.println("Test 6.2 + 2 = 8.2");

        // Given
        double firstNumber = 6.2D;
        double secondNumber = 2.0D;
        Double expected = 8.2D;

        // When
        double result = math.sum(firstNumber, secondNumber);

        // Then
        assertEquals(expected, result, "The testSum() did not produce expected result");
        Assertions.assertNotEquals(9.2D, result);
        Assertions.assertNotNull(expected);
    }

    @Test
    @DisplayName("Test 6.2 - 2 = 4.2")
    void testSubtraction() {
        System.out.println("Test 6.2 - 2 = 4.2");

        double firstNumber = 6.2D;
        double secondNumber = 2.0D;
        double result = math.subtraction(firstNumber, secondNumber);
        Double expected = 4.2D;
        assertEquals(expected, result, "The testSubtraction() did not produce the expected result");
        Assertions.assertNotEquals(8.2D, result);
    }

    @DisplayName("Test 6.2 * 2 = 12.4")
    @Test
    void testMultiplication() {
        System.out.println("Test 6.2 * 2 = 12.4");

        double firstNumber = 6.2D;
        double secondNumber = 2.0D;
        double result = math.multiplication(firstNumber, secondNumber);
        Double expected = 12.4D;
        assertEquals(expected, result, "The testMultiplication() did not produce the expected result");
        Assertions.assertNotEquals(8.2D, result);
    }

    @Test
    @DisplayName("Test 6.2 / 2 = 3.1")
    void testDivision() {
        System.out.println("Test 6.2 / 2 = 3.1");

        double firstNumber = 6.2D;
        double secondNumber = 2.0D;
        double result = math.division(firstNumber, secondNumber);
        Double expected = 3.1D;
        assertEquals(expected, result,
                () -> "(" + firstNumber + "/" + secondNumber + ")" +
                "did not produce " + expected + "!");
        Assertions.assertNotEquals(8.2D, result);
    }

    //@Disabled("TODO: We need to still work on it!")
    @Test
    @DisplayName("Test Division by Zero")
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException() {
        //given
        double firstNumber = 6.2D;
        double secondNumber = 0D;

        var expectedMessage = "Impossible to divide by zero!";

        //when & then
        ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
            //when & then
            math.division(firstNumber, secondNumber);
        }, () -> "Division by zero should throw an ArithmeticException");

        assertEquals(expectedMessage, actual.getMessage(), () -> "Unexpected exception message!");
    }

}