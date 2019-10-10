package polynomial;


public class PolynomialElementNode implements PolynomialNode {

  private int coefficient;
  private int power;
  private PolynomialNode rest;

  PolynomialElementNode(int coefficient, int power, PolynomialNode rest) {
    this.coefficient = coefficient;
    this.power = power;
    this.rest = rest;
  }


  public PolynomialElementNode addTerm(int c, int p) {
    if (p < 0) {
      throw new IllegalArgumentException("Invalid");
    }
    if (c == 0) {
      return this;
    }
    if (p > power) {
      return new PolynomialElementNode(c, p, this);
    } else if (p == power) {
      coefficient += c;
      return this;
    } else {
      rest = rest.addTerm(c, p);
      return this;
    }
  }

  @Override
  public int getDegree() {
    return this.power;
  }

  @Override
  public double evaluate(double number) {
    double acc = this.coefficient * Math.pow(number, this.power);
    return acc + this.rest.evaluate(number);
  }

  @Override
  public int getCoefficient(int p) {
    if (this.power == p) {
      return this.coefficient;
    } else {
      return this.rest.getCoefficient(p);
    }
  }

  @Override
  public Polynomial add(Polynomial other) {

    String input = other.toString();
    PolynomialImpl newPolynomial = (PolynomialImpl) other;
    Polynomial po = new PolynomialImpl();
    String[] element = input.split("\\+|(?=-)");
    for (String x : element) {
      String[] term = x.split("x\\^");
      if (term.length > 1) {
        po.addTerm(Integer.parseInt(term[0]) , Integer.parseInt(term[1]) );
      } else if (term.length == 1) {
        po.addTerm(Integer.parseInt(term[0]) , 0);
      }
    }
    return helperAdd( po);
  }

  public Polynomial helperAdd( Polynomial po) {
    po.addTerm(this.coefficient,this.power);

    return rest.helperAdd(po);
  }


  @Override
  public Polynomial derivative() {
    Polynomial po = new PolynomialImpl();
    return derviateHelper(po);
  }

  public Polynomial derviateHelper(Polynomial po) {
    int newCoeff = this.coefficient * this.power;
    int newPow = power - 1;
    if(newPow <0){
      newPow = 0;
    }
    po.addTerm(newCoeff, newPow);
    return rest.derviateHelper(po);
  }

  @Override
  public Polynomial multiply(Polynomial other) {
    String input = other.toString();
    PolynomialImpl newPolynomial = (PolynomialImpl) other;
    Polynomial po = new PolynomialImpl();
    return helperMultiply(input, po);
  }

  public Polynomial helperMultiply(String input, Polynomial po) {
    String[] element = input.split("\\+|(?=-)");
    for (String x : element) {
      String[] term = x.split("x\\^");
      if (term.length > 1) {
        po.addTerm(Integer.parseInt(term[0]) * this.coefficient, Integer.parseInt(term[1]) + this.power);
      } else if (term.length == 1) {
        po.addTerm(Integer.parseInt(term[0]) * this.coefficient, this.power);
      }
    }

    return rest.helperMultiply(input, po);
  }

  public String toString() {
    StringBuilder str = new StringBuilder();
    if (this.coefficient > 0) {
      str.append("+");
    }
    str.append(this.coefficient);
    if (this.power != 0) {
      str.append("x");
      str.append("^");
      str.append(this.power);
    }
    return str.toString() + this.rest.toString();
  }



}
