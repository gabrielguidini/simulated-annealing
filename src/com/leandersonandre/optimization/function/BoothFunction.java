package com.leandersonandre.optimization.function;

/**
 * Booth Function
 * https://www.sfu.ca/~ssurjano/booth.html
 */
public class BoothFunction implements Function {

    private static final double MIN_VALUE = -10;
    private static final double MAX_VALUE = 10;

    @Override
    public double evaluate(double[] x) {
        validateAndFixDomain(x);
        if (x.length != 2) {
            throw new IllegalArgumentException("Booth function requires exactly 2 dimensions.");
        }

        double x1 = x[0];
        double x2 = x[1];

        double term1 = Math.pow(x1 + 2 * x2 - 7, 2);
        double term2 = Math.pow(2 * x1 + x2 - 5, 2);

        return term1 + term2;
    }

    @Override
    public void validateAndFixDomain(double[] x) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] < MIN_VALUE) {
                x[i] = MIN_VALUE;
            } else if (x[i] > MAX_VALUE) {
                x[i] = MAX_VALUE;
            }
        }
    }

    @Override
    public void generateRandomSolution(double[] solution) {
        for (int i = 0; i < solution.length; i++) {
            solution[i] = MIN_VALUE + (MAX_VALUE - MIN_VALUE) * Math.random();
        }
    }
}
