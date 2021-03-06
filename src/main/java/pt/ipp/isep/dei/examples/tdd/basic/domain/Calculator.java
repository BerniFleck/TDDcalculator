package pt.ipp.isep.dei.examples.tdd.basic.domain;

/**
 * Calculator class.
 * This class is very simple in order to demonstrate how to build test cases for Unit Testing.
 */
public class Calculator {

    /**
     * Sums one operand to the other, returning the result.
     *
     * @param firstOperand  First operand to sum.
     * @param secondOperand Second Operand to sum.
     * @return The sum of firstOperand with secondOperand.
     */
    public int sum(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }

    public int subtractFirstOperandFromSecondOne(int firstOperand, int secondOperand) {
        return secondOperand - firstOperand;
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            throw new IllegalArgumentException("Illegal Argument. Divisor must not be zero.");
        else
            return dividend / divisor;
    }

    public int multiply(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }

    public int factorial(int firstOperand) {

        int factorial = 1;
        for (int i = firstOperand; i >= 1; i--) {
            factorial *= i;
        }
        return factorial;
    }
}
