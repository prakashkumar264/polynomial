package polynomial;

/**
 *
 */
public interface PolynomialNode {

  /**
   *
   * @param coefficient
   * @param power
   * @return
   */
  PolynomialNode addTerm(int coefficient, int power);

  /**
   *
   * @return
   */
  String toString();

  /**
   *
   * @return
   */
  int getDegree();

  /**
   *
   * @param number
   * @return
   */
  double evaluate(double number);

  /**
   *
   * @param power
   * @return
   */
  int getCoefficient(int power);

  /**
   *
   * @param polynomial
   * @return
   */
  Polynomial add(Polynomial polynomial);

  /**
   *
   * @return
   */
  Polynomial derivative();

  /**
   *
   * @param polynomial
   * @return
   */
  Polynomial multiply(Polynomial polynomial);

  /**
   *
   * @param input
   * @param po
   * @return
   */
  Polynomial helperMultiply(String input, Polynomial po);

  /**
   *
   * @param po
   * @return
   */
  Polynomial derviateHelper(Polynomial po);

  /**
   *
   * @param po
   * @return
   */
  Polynomial helperAdd(Polynomial po);
}
