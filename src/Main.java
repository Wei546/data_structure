import java.util.*;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //x+y
        Rational x,y,z;
        x=new Rational(1,3);
        y = new Rational(1,5);
        z=x.plus(y);
        StdOut.println(z);
        //x*y
        Rational x1=new Rational(2,3);
        Rational y1=new Rational(2,3);
        Rational z1=x1.times(y1);
        StdOut.println(z1);
        //x-y
        Rational x2=new Rational(5,6);
        Rational y2=new Rational(1,6);
        Rational z2=x2.minus(y2);
        StdOut.println(z2);

    }
}