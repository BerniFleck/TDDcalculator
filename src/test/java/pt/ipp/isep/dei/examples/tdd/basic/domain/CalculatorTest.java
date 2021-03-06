package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    public static void classSetUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a CalculatorTest class method and takes place before any @Test is executed");
        calculator = new Calculator();
    }

    @AfterAll
    public static void classTearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a CalculatorTest class method and takes place after all @Test are executed");
    }

    @BeforeEach
    public void setUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "\tThis call takes place before each @Test is executed");
    }

    @AfterEach
    public void tearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "\tThis call takes place after each @Test is executed");
    }

    private boolean isPositive(int number) {
        return number > 0;
    }

    private boolean isNegative(int number) {
        return number < 0;
    }

    /**
     * Test to ensure two positive numbers are summed correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arrange: one positive number (three) and another positive number (two).<p>
     * Act: sum both numbers (three and two).<p>
     * Assert: the result is five.
     */
    @Test
    public void ensurePositiveNrPlusPositiveNrIsPositive() {

        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int expectedResult = 5;
        int firsOperand = 3;
        int secondOperand = 2;
        int result = 3;

        // Act
        result = calculator.sum(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure positive and negative numbers are summed correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arranje a positive number (three) and a negative number (minus two)<p>
     * Act I sum three to minus two<p>
     * Assert the sum result should be one.
     */
    @Test
    public void ensureBiggerPositiveNrPlusSmallerNegativeNrIsPositive() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firstOperand = 3;
        int secondOperand = -2;
        int expectedResult = 1;
        int result = 3;

        // Act
        result = calculator.sum(firstOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureNegativeNrPlusNegativeNrIsNegative() {
        //Arrange
        int firstOperand = -3;
        int secondOperand = -2;
        int expectedResult = -5;
        int actualResult;

        // Act
        actualResult = calculator.sum(firstOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void ensurePositiveNrPlusZeroIsPositiveNumber() {
        //Arrange
        int firstOperand = 3;
        int secondOperand = 0;
        int calculationResult;
        boolean isResultPositive;

        // Act
        calculationResult = calculator.sum(firstOperand, secondOperand);
        isResultPositive = isPositive(calculationResult);

        // Assert
        assertTrue(isResultPositive);
    }

    @Test
    public void ensureBiggerPositiveNrSubtractedFromSmallerPositiveNrIsNegative() {
        //Arrange
        int firstOperand = 3;
        int secondOperand = 2;
        int calculationResult;
        boolean isResultNegative;

        // Act
        calculationResult = calculator.subtractFirstOperandFromSecondOne(firstOperand, secondOperand);
        isResultNegative = isNegative(calculationResult);

        // Assert
        assertTrue(isResultNegative);
    }

    @Test
    public void ensureSmallerPositiveNrSubtractedFromBiggerPositiveNrIsPositive() {
        //Arrange
        int firstOperand = 2;
        int secondOperand = 3;
        int calculationResult;
        boolean isResultPositive;

        // Act
        calculationResult = calculator.subtractFirstOperandFromSecondOne(firstOperand, secondOperand);
        isResultPositive = isPositive(calculationResult);

        // Assert
        assertTrue(isResultPositive);
    }

    @Test
    public void ensureNegativeNrSubtractedFromEqualPositiveNrIsPositive() {
        //Arrange
        int firstOperand = -3;
        int secondOperand = 3;
        int calculationResult;
        boolean isResultPositive;

        // Act
        calculationResult = calculator.subtractFirstOperandFromSecondOne(firstOperand, secondOperand);
        isResultPositive = isPositive(calculationResult);

        // Assert
        assertTrue(isResultPositive);
    }

    @Test
    public void ensurePositiveNrSubtractedFromEqualNegativeNrIsNegative() {
        //Arrange
        int firstOperand = 4;
        int secondOperand = -4;
        int calculationResult;
        boolean isResultNegative;

        // Act
        calculationResult = calculator.subtractFirstOperandFromSecondOne(firstOperand, secondOperand);
        isResultNegative = isNegative(calculationResult);

        // Assert
        assertTrue(isResultNegative);
    }

    @Test
    public void ensurePositiveNrMultipliedByNegativeNrIsNegative() {
        //Arrange
        int firstOperand = 4;
        int secondOperand = -4;
        int calculationResult;
        boolean isResultNegative;

        // Act
        calculationResult = calculator.multiply(firstOperand, secondOperand);
        isResultNegative = isNegative(calculationResult);

        // Assert
        assertTrue(isResultNegative);
    }

    @Test
    public void ensureNegativeNrMultipliedByPositiveNrIsNegative() {
        //Arrange
        int firstOperand = -4;
        int secondOperand = 5;
        int calculationResult;
        boolean isResultNegative;

        // Act
        calculationResult = calculator.multiply(firstOperand, secondOperand);
        isResultNegative = isNegative(calculationResult);

        // Assert
        assertTrue(isResultNegative);
    }

    @Test
    public void ensureNegativeNrMultipliedByNegativeNrIsPositive() {
        // Arrange
        int firstOperand = -4;
        int secondOperand = -5;
        int calculationResult;
        boolean isResultPositive;

        // Act
        calculationResult = calculator.multiply(firstOperand, secondOperand);
        isResultPositive = isPositive(calculationResult);

        // Assert
        assertTrue(isResultPositive);
    }

    @ParameterizedTest
    @ValueSource(ints = {-15, 0, 1, 2, 15, Integer.MAX_VALUE, Integer.MIN_VALUE})
    public void ensureAnyNrMultipliedByZeroIsZero(int firstOperand) {
        // Arrange
        int secondOperand = 0;
        int expectedResult = 0;
        int actualResult;

        // Act
        actualResult = calculator.multiply(firstOperand, secondOperand);

        // Assert
        assertEquals(actualResult, expectedResult);
    }

    /*
    divide positive by positive number returns positive number
    */
    @Test
    public void ensurePositiveNrDividedByPositiveNrIsPositive() {
        // Arrange
        int firstOperand = 12;
        int secondOperand = 4;
        int calculationResult;
        boolean isResultPositive;

        // Act
        calculationResult = calculator.divide(firstOperand, secondOperand);
        isResultPositive = isPositive(calculationResult);

        // Assert
        assertTrue(isResultPositive);
    }

    /*
    divide positive by negative number returns negative number
    */
    @Test
    public void ensurePositiveNrDividedByNegativeNrIsNegative() {
        // Arrange
        int firstOperand = 12;
        int secondOperand = -4;
        int calculationResult;
        boolean isResultNegative;

        // Act
        calculationResult = calculator.divide(firstOperand, secondOperand);
        isResultNegative = isNegative(calculationResult);

        // Assert
        assertTrue(isResultNegative);
    }

    /*
    divide negative by positive number returns negative number
    */
    @Test
    public void ensureNegativeNrDividedByPositiveNrIsNegative() {
        // Arrange
        int firstOperand = -12;
        int secondOperand = 4;
        int calculationResult;
        boolean isResultNegative;

        // Act
        calculationResult = calculator.divide(firstOperand, secondOperand);
        isResultNegative = isNegative(calculationResult);

        // Assert
        assertTrue(isResultNegative);
    }

    /*
    divide negative by negative number returns positive number
    */
    @Test
    public void ensureNegativeNrDividedByNegativeNrIsPositive() {
        // Arrange
        int firstOperand = -12;
        int secondOperand = -4;
        int calculationResult;
        boolean isResultPositive;

        // Act
        calculationResult = calculator.divide(firstOperand, secondOperand);
        isResultPositive = isPositive(calculationResult);

        // Assert
        assertTrue(isResultPositive);
    }

    /*
    divide positive number by zero returns exception
    */
    @Test
    public void ensurePositiveNrDividedByZeroReturnsException() {
        // Arrange
        int firstOperand = 12;
        int secondOperand = 0;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(firstOperand, secondOperand));
    }

    /*
    positive number factored returns positive number
    */
    @Test
    public void ensurePositiveNrFactoredReturnsPositiveNr() {
        // Arrange
        int firstOperand = 12;
        int calculationResult;
        boolean isResultPositive;

        // Act
        calculationResult = calculator.factorial(firstOperand);
        isResultPositive = isPositive(calculationResult);

        // Assert
        assertTrue(isResultPositive);
    }

    /*
    negative number factored returns one
    */
    @Test
    public void ensureNegativeNrFactoredReturnsOne() {
        // Arrange
        int firstOperand = -12;
        int calculationResult;
        int expectedResult = 1;

        // Act
        calculationResult = calculator.factorial(firstOperand);

        // Assert
        assertEquals(expectedResult, calculationResult);
    }

    /*
    zero factored returns one
    */
    @Test
    public void ensureZeroFactoredReturnsOne() {
        // Arrange
        int firstOperand = 0;
        int calculationResult;
        int expectedResult = 1;

        // Act
        calculationResult = calculator.factorial(firstOperand);

        // Assert
        assertEquals(expectedResult, calculationResult);
    }
}



