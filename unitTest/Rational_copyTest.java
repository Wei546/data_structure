import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rational_copyTest {


    @Test
    void testToString() {
        Rational_copy a = new Rational_copy(1,2);
        assertEquals("1/2",a.toString());
    }

    @Test
    void compareTo() {
        Rational_copy a = new Rational_copy(1,2);
        Rational_copy b = new Rational_copy(0,2);
        Rational_copy c = new Rational_copy(-1,2);
        Rational_copy zero = new Rational_copy(0,1);
        assertEquals(1,a.compareTo(zero));
        assertEquals(0,b.compareTo(zero));
        assertEquals(-1,c.compareTo(zero));
    }

    @Test
    void times() {
        Rational_copy a = new Rational_copy(1,2);
        Rational_copy b = new Rational_copy(3,2);
        Rational_copy c=a.times(b);
        assertEquals("3/4",c.toString());
    }

    @Test
    void plus() {
        Rational_copy a = new Rational_copy(1,2);
        Rational_copy b = new Rational_copy(3,2);
        Rational_copy c=a.plus(b);
        assertEquals("2",c.toString());
    }

    @Test
    void negate() {
        Rational_copy a = new Rational_copy(1,2);
        Rational_copy b = new Rational_copy(-1,2);
        assertEquals("-1/2",b.toString());
    }

    @Test
    void minus() {
        Rational_copy a = new Rational_copy(1,2);
        Rational_copy b = new Rational_copy(3,2);
        Rational_copy c=a.minus(b);
        assertEquals("-1",c.toString());
    }

    @Test
    void reciprocal() {
        Rational_copy a =new Rational_copy(1,2);
        assertEquals("2",a.reciprocal().toString());
    }

    @Test
    void divides() {
        Rational_copy a = new Rational_copy(1,2);
        Rational_copy b = new Rational_copy(3,2);
        Rational_copy c=a.divides(b);
        assertEquals("1/3",c.toString());
    }
}