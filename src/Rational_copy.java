//1.Rational的paramenter 2.line120 plus() 3. Line67 equals()
//先判斷分母是否為0->做輾轉相除法約分->分母通分
//Rational class實作Comparable界面
public class Rational_copy implements Comparable<Rational_copy>{
    //不太懂這段放在這裡的意義
    private static Rational_copy zero = new Rational_copy(0,1);
    //資料成員
    private int num;
    private int den;

    //建構子
    public Rational_copy(int numerator, int denominator){
        if(denominator==0){
            //例外處理
            throw new ArithmeticException("denominator is 0");
        }
        //呼叫gcd，回傳最大公因數，並且進行約分
        int g = gcd(numerator,denominator);
        num = numerator / g ;
        den = denominator / g ;

        //有理數為負數的條件
        if(den<0){
            den=-den;
            num=-num;
        }
    }
    public String toString(){
        if(den == 1){
            return num + "";
        }else{
            return num +  "/" + den;
        }
    }
    //Line122
    public int compareTo(Rational_copy b){
        //這個this是Rational的欄位
        Rational_copy a =this;
        //這邊分母通分
        int lhs = a.num * b.den;
        int rhs = a.den * b.num;
        //為甚麼lhs為0要回傳-1?
        if(lhs<rhs){
            return -1;
        }
        //
        if(lhs>rhs){
            return 1;
        }
        //判斷a、b是否=0
        return 0;
    }
    //參數放的是其中一方的分子、分母
    private static int gcd(int m ,int n){
        //過濾負數
        if(m<0){
            m=-m;
        }
        if(n<0){
            n=-n;
        }
        //輾轉相除法:餘數變成除數
        if (n == 0) {
            return m;

        }else{
            return gcd(n,m%n);
        }
    }
    //參數是a、b的分母
    private static int lcm(int m,int n){
        if(m<0){
            m=-m;
        }
        if(n<0){
            n=-n;
        }
        return m*(n/gcd(m,n));
    }
    //看不懂!!!!!
    public Rational_copy times(Rational_copy b){
        Rational_copy a=this;
        Rational_copy c =new Rational_copy(a.num,b.den);
        Rational_copy d = new Rational_copy(b.num,a.den);
        return new Rational_copy(c.num * d.num,c.den*d.den);
    }



    //跟Line6、Line45相關
    public Rational_copy plus(Rational_copy b){
        //this含括num、den
        Rational_copy a = this;
        //判斷任一方是否為0
        if(a.compareTo(zero)==0){
            return b;
        }
        if(b.compareTo(zero)==0){
            return a;
        }
        //回傳最大公因數
        int f = gcd(a.num,b.num);
        int g = gcd(a.den,b.den);
        //分子:十字交乘法、約分；分母:最小公倍數
        Rational_copy s =new Rational_copy((a.num / f)*(b.den/g)+(b.num/f) * (a.den / g),lcm(a.den,b.den));
        //不懂!!!
        s.num *= f;
        return s;
    }
    public Rational_copy negate(){
        return new Rational_copy(-num,den);
    }

    public Rational_copy minus(Rational_copy b){
        Rational_copy a=this;
        return a.plus(b.negate());
    }
    //Line154 divides
    public Rational_copy reciprocal(){
        return new Rational_copy(den,num);
    }
    public Rational_copy divides(Rational_copy b){
        Rational_copy a =this;
        return a.times(b.reciprocal());
    }
}