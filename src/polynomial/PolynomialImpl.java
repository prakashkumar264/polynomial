package polynomial;


public class PolynomialImpl implements Polynomial {
  private PolynomialNode head;

  public PolynomialImpl() {
    head = new PolynomialEmptyNode();
  }

  public PolynomialImpl(String input) {
    head = new PolynomialEmptyNode();
    String[] element = input.split("\\s");
    for (String x : element) {
      String[] term = x.split("x\\^");
      if (term.length > 1) {
        addTerm(Integer.parseInt(term[0]), Integer.parseInt(term[1]));
      } else if (term.length == 1) {
        addTerm(Integer.parseInt(term[0]), 0);
      }
    }
  }

  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    head = head.addTerm(coefficient, power);
  }

  @Override
  public int getDegree() {
    return head.getDegree();
  }

  @Override
  public int getCoefficient(int power) {
    return head.getCoefficient(power);
  }

  @Override
  public double evaluate(double number) {
    return head.evaluate(number);
  }

  @Override
  public Polynomial add(Polynomial polynomial) {
    return head.add(polynomial);
  }

  @Override
  public Polynomial multiply(Polynomial other) {
    return head.multiply(other);
  }

  @Override
  public Polynomial derivative() {
    return head.derivative();
  }

  public String toString() {
    String resultString = head.toString();
    if (resultString.length() == 0) {
      return "0";
    }
    if (resultString.charAt(0) == '+') {
      resultString = resultString.substring(1);
    }
    return resultString;
  }


  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Polynomial)) {
      return false;
    }
    Polynomial newPolynomial = (Polynomial) obj;
    return this.toString().equals(newPolynomial.toString());
  }

  public int hashCode() {
    return 197 * 19;
  }
}
