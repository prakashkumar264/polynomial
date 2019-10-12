package polynomial;

/**
 * This interface represents all operations for a term in a list of terms of implemented as an
 * polynomial. The advantage of this design is that this interface may now represent operations on a
 * single term instead of the Polynomial that represented polynomial but the operations were really
 * on terms.
 */
public interface PolynomialNode {

  /**
   * Add a particular valid term to the current polynomial term.
   *
   * @param coefficient The coefficient of the term.
   * @param power       The power of the term.
   * @return A new Polynomial term and add it to the list.
   */
  PolynomialNode addTerm(int coefficient, int power);

  /**
   * A method which converts the list of terms of polynomial as a String.
   *
   * @return String representation of the polynomial.
   */
  String toString();

  /**
   * Returns the degree of the the current polynomial.
   *
   * @return the degree of polynomial as integer.
   */
  int getDegree();

  /**
   * Evaluates a particular polynomial by passing in a specific value as argument.
   *
   * @param number The specific value is passed to the polynomial.
   * @return The value of the polynomial as double.
   */
  double evaluate(double number);

  /**
   * Returns the coefficient of a particular term by passing in the power of the term as argument.
   *
   * @param power The power of particular term coefficient is needed.
   * @return the coefficient of the term of associated power as integer.
   */
  int getCoefficient(int power);

  /**
   * A method that takes another Polynomial object and returns the polynomial obtained by adding the
   * two polynomials.
   *
   * @param polynomial Another polynomial object passed as argument.
   * @return Returns a new polynomial.
   */
  Polynomial add(Polynomial polynomial);

  /**
   * A method derivative that takes no parameters and returns the polynomial obtained by
   * differentiating this polynomial.
   *
   * @return A new polynomial as a result of calling this method.
   */
  Polynomial derivative();

  /**
   * A method that takes another Polynomial object and returns the polynomial obtained by
   * multiplying the two polynomials.
   *
   * @param polynomial Another polynomial object passed as argument.
   * @return Returns a new polynomial.
   */
  Polynomial multiply(Polynomial polynomial);

  /**
   * A helper method for the multiply method.
   *
   * @param input The current polynomial as a String.
   * @param po    Another polynomial object passed as argument.
   * @return Returns a new polynomial.
   */
  Polynomial helperMultiply(String input, Polynomial po);

  /**
   * A helper method for the derivative to calculate the derivative.
   *
   * @param po Current polynomial object passed as argument.
   * @return A new polynomial as a result of calling this method.
   */
  Polynomial derviateHelper(Polynomial po);

  /**
   * A helper method for the add method.
   *
   * @param po Another polynomial object passed as argument.
   * @return Returns a new polynomial.8
   */
  Polynomial helperAdd(Polynomial po);
}
