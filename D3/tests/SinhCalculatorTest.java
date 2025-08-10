import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for SinhCalculator.
 */
public class SinhCalculatorTest {

  private static final double EPS = 1e-6;

  @Test
  void testZero() {
    assertEquals(0.0, SinhCalculator.computeSinh(0.0), EPS);
  }

  @Test
  void testPositiveOne() {
    double expected = Math.sinh(1.0);
    assertEquals(expected, SinhCalculator.computeSinh(1.0), EPS);
  }

  @Test
  void testNegativeOne() {
    double expected = Math.sinh(-1.0);
    assertEquals(expected, SinhCalculator.computeSinh(-1.0), EPS);
  }

  @Test
  void testOddSymmetry() {
    double x = 0.75;
    double a = SinhCalculator.computeSinh(x);
    double b = SinhCalculator.computeSinh(-x);
    assertEquals(a, -b, EPS); // sinh is an odd function
  }

  @Test
  void testLargerMagnitudeLooseTolerance() {
    double expected = Math.sinh(3.0);
    // allow looser tolerance because Taylor series truncation error grows with |x|
    assertEquals(expected, SinhCalculator.computeSinh(3.0), 1e-4);
  }
}
