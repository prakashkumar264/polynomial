package polynomial;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class PolynomialImpl implements Polynomial {
  private PolynomialNode head;

  public PolynomialImpl() {
    head = new PolynomialEmptyNode();
  }

  public PolynomialImpl(String input) {
     head = new PolynomialEmptyNode();
     Scanner scanner = new Scanner(input);
     while(scanner.hasNext()){
       String term = scanner.next();
       Scanner termObj = new Scanner(term);
       int coefficient;
       int degree;
       if(term.matches("^(-?\\+?[0-9]+)x?\\^?([0-9]*)$")){
         termObj.findInLine("^(-?\\+?[0-9]+)x?\\^?([0-9]*)$");
         MatchResult result = termObj.match();
         coefficient = Integer.parseInt(result.group(1));
         degree = result.group(2).equals("") ? 0 : Integer.parseInt(result.group(2));
         head = head.addTerm(coefficient, degree);
       }else{
         throw  new IllegalArgumentException("not valid");
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
    if(resultString.length() == 0){
      return  "0";
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
    return 197*19;
  }
}
