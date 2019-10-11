package polynomial;

public class PolynomialEmptyNode implements PolynomialNode {

  public PolynomialNode addTerm(int coefficient, int power) {
    if (coefficient != 0 && power >= 0) {
      return new PolynomialElementNode(coefficient, power, this);
    } else if (coefficient == 0 && power >= 0) {
      return new PolynomialElementNode(0, 0, this);
    } else {
      throw new IllegalArgumentException("Not valid");
    }

  }

  public String toString() {
    return "";
  }

  @Override
  public int getDegree() {
    return 0;
  }

  @Override
  public double evaluate(double number) {
    return 0;
  }

  @Override
  public int getCoefficient(int power) {
    return 0;
  }

  @Override
  public Polynomial add(Polynomial other) {
    return other;
  }

  @Override
  public Polynomial derivative() {
    return null;
  }

  @Override
  public Polynomial multiply(Polynomial other) {
    return null;
  }

  @Override
  public Polynomial helperMultiply(String input, Polynomial po) {
    return po;
  }

  @Override
  public Polynomial derviateHelper(Polynomial po) {
    return po;
  }

  @Override
  public Polynomial helperAdd(Polynomial po) {
    return po;
  }


}
