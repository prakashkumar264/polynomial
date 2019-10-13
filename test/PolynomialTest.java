import org.junit.Test;

import polynomial.Polynomial;
import polynomial.PolynomialImpl;

import static org.junit.Assert.assertEquals;

/**
 * This class is used to test the operations on polynomials.
 */
public class PolynomialTest {

  @Test
  public void testEmptyPolynomialString() {
    Polynomial poly = new PolynomialImpl();
    assertEquals("0", poly.toString());
  }

  @Test
  public void testEmptyPolynomialDegree() {
    Polynomial poly = new PolynomialImpl();
    assertEquals(0, poly.getDegree());
  }

  @Test
  public void testEmptyPolynomialDerivative() {
    Polynomial poly = new PolynomialImpl();
    assertEquals(null, poly.derivative());
  }

  @Test
  public void testEmptyPolynomialEvaluate() {
    Polynomial poly = new PolynomialImpl();
    assertEquals(0.00, poly.evaluate(5), 2);
  }

  @Test
  public void testEmptyPolynomialCoefficient() {
    Polynomial poly = new PolynomialImpl();
    assertEquals(0, poly.getCoefficient(5));
  }

  @Test
  public void testEmptyPolynomialAddPolynomial() {
    Polynomial poly = new PolynomialImpl();
    Polynomial newP = new PolynomialImpl();
    assertEquals("0", poly.add(newP).toString());
  }

  @Test
  public void testEmptyPolynomialMultiplyPolynomial() {
    Polynomial poly = new PolynomialImpl();
    Polynomial newP = new PolynomialImpl();
    assertEquals(null, poly.multiply(newP));
  }

  @Test
  public void testEmptyPolynomialEqualsPolynomial() {
    Polynomial poly = new PolynomialImpl();
    Polynomial newP = new PolynomialImpl();
    assertEquals(true, poly.equals(newP));
  }


  @Test
  public void testPolynomialConstructorString() {
    Polynomial poly = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    assertEquals("-2x^5-3x^4+11x^1-5", poly.toString());
  }

  @Test
  public void testPolynomialConstructorStringOnlyConstant() {
    Polynomial poly = new PolynomialImpl("264");
    assertEquals("264", poly.toString());
  }

  @Test(expected = Exception.class)
  public void testPolynomialConstructorStringNoSpace() {
    Polynomial poly = new PolynomialImpl("-3x^4-2x^5 -5 +11x^1");
  }

  @Test(expected = Exception.class)
  public void testPolynomialConstructorStringInvalidFormat() {
    Polynomial poly = new PolynomialImpl("-3x^4 -2x^5 -5x +11x^1");
  }

  @Test
  public void testPolynomialConstructorStringDegree() {
    Polynomial poly = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    assertEquals(5, poly.getDegree());
  }

  @Test
  public void testPolynomialConstructorStringCoefficient() {
    Polynomial poly = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    assertEquals(-2, poly.getCoefficient(5));
  }

  @Test
  public void testPolynomialConstructorStringDerivative() {
    Polynomial poly = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    assertEquals("-10x^4-12x^3+11", poly.derivative().toString());
  }

  @Test
  public void testPolynomialConstructorStringEvaluate() {
    Polynomial poly = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    assertEquals(-12755.375, poly.evaluate(5.5), 2);
  }

  @Test
  public void testPolynomialConstructorAdd() {
    Polynomial poly = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    Polynomial newP = new PolynomialImpl("4x^3 +3x^1 -5");
    assertEquals("-2x^5-3x^4+4x^3+14x^1-10", poly.add(newP).toString());
  }

  @Test
  public void testPolynomialConstructorMultiply() {
    Polynomial poly = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    Polynomial newP = new PolynomialImpl("4x^3 +3x^1 -5");
    assertEquals("-8x^8-12x^7-6x^6+1x^5+59x^4-20x^3+33x^2-70x^1+25",
            poly.multiply(newP).toString());
  }

  @Test
  public void testPolynomialConstructorEquals() {
    Polynomial poly = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    Polynomial newP = new PolynomialImpl("4x^3 +3x^1 -5");
    assertEquals(false, poly.equals(newP));
  }

  @Test
  public void testPolynomialConstructorEqualsTrue() {
    Polynomial poly = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    Polynomial newP = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
    assertEquals(true, poly.equals(newP));
  }

  @Test
  public void testPolynomialCreationValid() {
    Polynomial poly = new PolynomialImpl();
    poly.addTerm(5, 5);
    poly.addTerm(-4, 3);
    poly.addTerm(2, 2);
    poly.addTerm(0, 1);
    poly.addTerm(12, 0);
    assertEquals("5x^5-4x^3+2x^2+12", poly.toString());
  }

  @Test(expected = Exception.class)
  public void testPolynomialCreationInvalid() {
    Polynomial poly = new PolynomialImpl();
    poly.addTerm(5, 5);
    poly.addTerm(-4, -3);
  }

  @Test
  public void testPolynomialCreationValidZero() {
    Polynomial poly = new PolynomialImpl();
    poly.addTerm(0, 0);
    poly.addTerm(0, 0);
    assertEquals("0", poly.toString());
  }

  @Test
  public void testPolynomialCreationValidZeroDegree() {
    Polynomial poly = new PolynomialImpl();
    poly.addTerm(0, 0);
    poly.addTerm(0, 0);
    assertEquals(0, poly.getDegree());
  }

  @Test
  public void testPolynomialCreationLargeValid() {
    Polynomial poly = new PolynomialImpl();
    poly.addTerm(125, 185);
    poly.addTerm(82, 124);
    poly.addTerm(154, 88);
    poly.addTerm(27, 75);
    poly.addTerm(-142, 96);
    poly.addTerm(79, 55);
    poly.addTerm(21, 45);
    poly.addTerm(-1, 16);
    poly.addTerm(8, 8);
    poly.addTerm(42, 50);
    poly.addTerm(-12575,0);
    assertEquals("125x^185+82x^124-142x^96+154x^88+27x^75+79x^55+42x^50+21x^45-1x^16" +
            "+8x^8-12575", poly.toString());
  }

  @Test
  public void testPolynomialCreationLargeDegree() {
    Polynomial poly = new PolynomialImpl();
    poly.addTerm(125, 185);
    poly.addTerm(82, 124);
    poly.addTerm(154, 88);
    poly.addTerm(27, 75);
    poly.addTerm(-142, 96);
    poly.addTerm(79, 55);
    poly.addTerm(21, 45);
    poly.addTerm(-1, 16);
    poly.addTerm(8, 8);
    poly.addTerm(42, 50);
    poly.addTerm(-12575,0);
    assertEquals(185, poly.getDegree());
  }

  @Test
  public void testPolynomialCreationLargeCoefficient() {
    Polynomial poly = new PolynomialImpl();
    poly.addTerm(125, 185);
    poly.addTerm(82, 124);
    poly.addTerm(154, 88);
    poly.addTerm(27, 75);
    poly.addTerm(-142, 96);
    poly.addTerm(79, 55);
    poly.addTerm(21, 45);
    poly.addTerm(-1, 16);
    poly.addTerm(8, 8);
    poly.addTerm(42, 50);
    poly.addTerm(-12575,0);
    assertEquals(-142, poly.getCoefficient(96));
  }

  @Test
  public void testPolynomialCreationLargeEvaluate() {
    Polynomial poly = new PolynomialImpl();
    poly.addTerm(125, 185);
    poly.addTerm(82, 124);
    poly.addTerm(154, 88);
    poly.addTerm(27, 75);
    poly.addTerm(-142, 96);
    poly.addTerm(79, 55);
    poly.addTerm(21, 45);
    poly.addTerm(-1, 16);
    poly.addTerm(8, 8);
    poly.addTerm(42, 50);
    poly.addTerm(-12575,0);
    assertEquals(2.7868010475736477E65, poly.evaluate(2.2),2);
  }

  @Test
  public void testPolynomialCreationLargeDerivative() {
    Polynomial poly = new PolynomialImpl();
    poly.addTerm(125, 185);
    poly.addTerm(82, 124);
    poly.addTerm(154, 88);
    poly.addTerm(27, 75);
    poly.addTerm(-142, 96);
    poly.addTerm(79, 55);
    poly.addTerm(21, 45);
    poly.addTerm(-1, 16);
    poly.addTerm(8, 8);
    poly.addTerm(42, 50);
    poly.addTerm(-12575,0);
    assertEquals("23125x^184+10168x^123-13632x^95+13552x^87+2025x^74+4345x^54+2100x^49" +
            "+945x^44-16x^15+64x^7", poly.derivative().toString());
  }

  @Test
  public void testPolynomialCreationLargeAdd() {
    Polynomial poly = new PolynomialImpl();
    poly.addTerm(125, 185);
    poly.addTerm(82, 124);
    poly.addTerm(154, 88);
    poly.addTerm(27, 75);
    poly.addTerm(-142, 96);
    poly.addTerm(79, 55);
    poly.addTerm(21, 45);
    poly.addTerm(-1, 16);
    poly.addTerm(8, 8);
    poly.addTerm(42, 50);
    poly.addTerm(-12575,0);

    Polynomial newP = new PolynomialImpl();
    newP.addTerm(5,100);
    newP.addTerm(-42,85);
    newP.addTerm(16,42);
    newP.addTerm(1,16);
    newP.addTerm(12575,0);

    assertEquals("5x^100-42x^85+16x^42+1x^16+12575", newP.toString());
    assertEquals("125x^185+82x^124-142x^96+154x^88+27x^75+79x^55+42x^50+21x^45-1x^16" +
            "+8x^8-12575", poly.toString());
    assertEquals("125x^185+82x^124+5x^100-142x^96+154x^88-42x^85+27x^75+79x^55+42x^50" +
            "+21x^45+16x^420x^16+8x^80", poly.add(newP).toString());
  }

  @Test
  public void testPolynomialCreationLargeMultiply() {
    Polynomial poly = new PolynomialImpl();
    poly.addTerm(125, 185);
    poly.addTerm(82, 124);
    poly.addTerm(154, 88);
    poly.addTerm(27, 75);
    poly.addTerm(-142, 96);
    poly.addTerm(79, 55);
    poly.addTerm(21, 45);
    poly.addTerm(-1, 16);
    poly.addTerm(8, 8);
    poly.addTerm(42, 50);
    poly.addTerm(-12575,0);

    Polynomial newP = new PolynomialImpl();
    newP.addTerm(5,100);
    newP.addTerm(-42,85);
    newP.addTerm(16,42);
    newP.addTerm(1,16);
    newP.addTerm(12575,0);


    assertEquals("5x^100-42x^85+16x^42+1x^16+12575", newP.toString());
    assertEquals("125x^185+82x^124-142x^96+154x^88+27x^75+79x^55+42x^50+21x^45-1x^16" +
            "+8x^8-12575", poly.toString());
    assertEquals("625x^285-5250x^270+2000x^227+410x^224-3444x^209+125x^201-710x^196" +
            "+770x^188+1571875x^185+5964x^181+135x^175-6468x^173+1312x^166-1134x^160+395x^155" +
            "+210x^150+105x^145-3236x^140-2272x^138-1764x^135+1582x^130+1031150x^124+432x^117" +
            "-5x^116-142x^112+40x^108+154x^104+42x^101-62875x^100+1264x^97-1785650x^96-336x^93" +
            "+672x^92+27x^91+1936550x^88+336x^87+528150x^85+339525x^75+79x^71+42x^66+21x^61" +
            "-16x^58+993425x^55+528278x^50+264075x^45-201200x^42-1x^32+8x^24-25150x^16+100600x^8" +
            "-158130625", poly.multiply(newP).toString());
  }

  @Test
  public void testPolynomialCreationLargeEquals() {
    Polynomial poly = new PolynomialImpl();
    poly.addTerm(125, 185);
    poly.addTerm(82, 124);
    poly.addTerm(154, 88);
    poly.addTerm(27, 75);
    poly.addTerm(-142, 96);
    poly.addTerm(79, 55);
    poly.addTerm(21, 45);
    poly.addTerm(-1, 16);
    poly.addTerm(8, 8);
    poly.addTerm(42, 50);
    poly.addTerm(-12575,0);

    Polynomial newP = new PolynomialImpl();
    newP.addTerm(5,100);
    newP.addTerm(-42,85);
    newP.addTerm(16,42);
    newP.addTerm(1,16);
    newP.addTerm(12575,0);

    assertEquals(false, poly.equals(newP));
  }



}