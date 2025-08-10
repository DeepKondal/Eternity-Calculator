/**
 * Calculator for computing sinh(x) using a Taylor series expansion without Math.sinh().
 */
public class SinhCalculator {

  /**
   * Computes sinh(x) using Taylor series.
   *
   * @param x input value
   * @return sinh(x) result
   */
  public static double computeSinh(double x) {
    double sum = 0.0;
    double term;
    int terms = 15; // number of terms for reasonable accuracy

    for (int n = 0; n < terms; n++) {
      term = power(x, 2 * n + 1) / factorial(2 * n + 1);
      sum += term;
    }
    return sum;
  }

  /**
   * Computes base raised to the given exponent.
   *
   * @param base     the base value
   * @param exponent the exponent value
   * @return base^exponent
   */
  private static double power(double base, int exponent) {
    double result = 1.0;
    for (int i = 1; i <= exponent; i++) {
      result *= base;
    }
    return result;
  }

  /**
   * Computes the factorial of n (non-recursive).
   *
   * @param n number for factorial
   * @return factorial of n
   */
  private static double factorial(int n) {
    double result = 1.0;
    for (int i = 2; i <= n; i++) {
      result *= i;
    }
    return result;
  }
}
