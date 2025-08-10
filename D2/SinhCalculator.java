public class SinhCalculator {
    public static double computeSinh(double x) {
        double term, sum = 0.0;
        int N = 15; // number of terms for reasonable accuracy

        for (int n = 0; n < N; n++) {
            term = power(x, 2 * n + 1) / factorial(2 * n + 1);
            sum += term;
        }

        return sum;
    }
    // Custom power function (x^n)
    private static double power(double base, int exponent) {
        double result = 1.0;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }
    // Custom factorial function (non-recursive)
    private static double factorial(int n) {
        double result = 1.0;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
