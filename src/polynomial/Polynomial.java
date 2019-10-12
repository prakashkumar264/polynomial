package polynomial;

/**
 * A polynomial is made of several terms, each term having a coefficient and a variable raised to a
 * power. Polynomials are one-variable if all their terms contain only one variable. The degree of a
 * polynomial is defined as the highest power of the variable in a term. The polynomials we deal
 * with have only non-negative whole numbers as powers. The coefficients of our polynomials are
 * integral numbers. Two polynomials are the same if they contain the same terms. Several algebraic
 * operations are possible with polynomials.The simplest one is evaluating the polynomial for a
 * specific value of the variable. Polynomials can be added together to create a new polynomial. The
 * addition is performed by combining all the terms and adding the coefficients of the terms with
 * the same power.The degree of the sum is the maximum of the degrees of the two polynomials.
 * Polynomials can be multiplied together to create a new polynomial. To multiply two polynomials
 * 𝑓(𝑥) and 𝑔(𝑥) we multiply 𝑔(𝑥) with each term in 𝑓(𝑥) to produce new polynomials and then
 * add them together.The degree of  product is equal to the sum of the degrees of the two
 * polynomials. The derivative of a polynomial (from differential calculus) is a polynomial made up
 * of the derivative of each term. The derivative of a term 𝑎𝑥𝑏 is a term with coefficient 𝑎𝑏
 * with the variable raised to the power 𝑏−1. The derivative of a constant term (𝑥0) is 0.
 * This interface defines a polynomial that does the above operations. This interface implements the
 * polynomial as a list of terms. Each term is an individual node and all the operations are done on
 * each nodes.
 */
public interface Polynomial {

  /**
   * Add a particular valid term to the current polynomial term.
   *
   * @param coefficient The coefficient of the term.
   * @param power The power of the term.
   * @throws IllegalArgumentException If power is negative, Exception will be thrown.
   */
  void addTerm(int coefficient, int power) throws IllegalArgumentException;

  /**
   * Returns the degree of the the current polynomial.
   *
   * @return the degree of polynomial as integer.
   */
  int getDegree();

  /**
   * Returns the coefficient of a particular term by passing in the power of the term as argument.
   *
   * @param power The power of particular term coefficient is needed.
   * @return the coefficient of the term of associated power as integer.
   */
  int getCoefficient(int power);

  /**
   * Evaluates a particular polynomial by passing in a specific value as argument.
   *
   * @param number The specific value is passed to the polynomial.
   * @return The value of the polynomial as double.
   */
  double evaluate(double number);

  /**
   * A method that takes another Polynomial object and returns the polynomial obtained by adding the
   * two polynomials.
   *
   * @param polynomial Another polynomial object passed as argument.
   * @return Returns a new polynomial.
   */
  Polynomial add(Polynomial polynomial);

  /**
   * A method that takes another Polynomial object and returns the polynomial obtained by
   * multiplying the two polynomials.
   *
   * @param polynomial Another polynomial object passed as argument.
   * @return Returns a new polynomial.
   */
  Polynomial multiply(Polynomial polynomial);

  /**
   * A method derivative that takes no parameters and returns the polynomial obtained by
   * differentiating this polynomial.
   *
   * @return A new polynomial as a result of calling this method.
   */
  Polynomial derivative();

}
