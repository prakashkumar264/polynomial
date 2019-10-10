package polynomial;

public interface PolynomialNode {

  PolynomialNode addTerm(int coefficient, int power);

  String toString();

  int getDegree();

  double evaluate(double number);

  int getCoefficient(int power);

  Polynomial add(Polynomial polynomial);

  Polynomial derivative();

  Polynomial multiply(Polynomial polynomial);

  Polynomial helperMultiply(String input, Polynomial po);

  Polynomial derviateHelper(Polynomial po);

  Polynomial helperAdd(Polynomial po);
}
