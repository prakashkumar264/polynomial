import org.junit.Test;

import polynomial.Polynomial;
import polynomial.PolynomialImpl;

import static org.junit.Assert.assertEquals;

public class PolynomialTest {

  @Test
  public void test1() {

    Polynomial newP = new PolynomialImpl();
    newP.addTerm(8, 3);
    newP.addTerm(5, 2);
    newP.addTerm(1, 0);

    Polynomial poly = new PolynomialImpl();
    poly.addTerm(5, 2);
    poly.addTerm(5, 7);

    newP.multiply(poly);

    assertEquals("0", newP.multiply(poly).getDegree());
  }


  @Test
  public void test3() {
    Polynomial poly = new PolynomialImpl("");
    assertEquals("0", poly.toString());
  }


}