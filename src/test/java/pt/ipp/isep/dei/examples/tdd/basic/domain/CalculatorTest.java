package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        boolean isResultPositive;

        // Act
        calculationResult = calculator.subtractFirstOperandFromSecondOne(firstOperand, secondOperand);
        isResultPositive = isNegative(calculationResult);

        // Assert
        assertTrue(isResultPositive);
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

    //subtract positive from equal negative number returns negative number
    @Test
    public void ensurePositiveNrSubtractedFromEqualNegativeNrIsNegative() {
        //Arrange
        int firstOperand = 4;
        int secondOperand = -4;
        int calculationResult;
        boolean isResultPositive;

        // Act
        calculationResult = calculator.subtractFirstOperandFromSecondOne(firstOperand, secondOperand);
        isResultPositive = isNegative(calculationResult);

        // Assert
        assertTrue(isResultPositive);
    }
}



