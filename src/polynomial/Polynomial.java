package polynomial;

/**
 *
 */
public interface Polynomial {

  /**
   * @param coefficient
   * @param power
   * @return
   * @throws IllegalArgumentException
   */
  void addTerm(int coefficient, int power) throws IllegalArgumentException;

  /**
   * @return
   */
  int getDegree();

  /**
   * @param power
   * @return
   */
  int getCoefficient(int power);

  /**
   * @param number
   * @return
   */
  double evaluate(double number);

  /**
   * @param polynomial
   * @return
   */
  Polynomial add(Polynomial polynomial);

  /**
   * @param polynomial
   * @return
   */
  Polynomial multiply(Polynomial polynomial);

  /**
   * @return
   */
  Polynomial derivative();

}
