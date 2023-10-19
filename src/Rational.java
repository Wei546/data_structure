//1.Rational的paramenter 2.line120 plus() 3. Line67 equals()
//先判斷分母是否為0->做輾轉相除法約分->分母通分
//Rational class實作Comparable界面
public class Rational implements Comparable<Rational>{
    //假設任一方為0的情況，分母不為0，因為會不存在
    private static Rational zero = new Rational(0,1);
    //資料成員
    private int num;
    private int den;

    //建構子
    public Rational(int numerator,int denominator){
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
    public int numerator(){
        return num;
    }
    public int denominator(){
        return den;
    }
    public double toDouble(){
        return (double) num/den;
    }
    public String toString(){
        if(den == 1){
            return num + "";
        }else{
            return num +  "/" + den;
        }
    }
    //Line122
    public int compareTo(Rational b){
        //這個this是Rational的欄位
        Rational a =this;
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
        //相等代表任兩方!=0
        return 0;
    }

    //看不懂!!!!
    //為甚麼有理數物件需要等於y?
    //為甚麼paramter要用object?
    //為甚麼是空值，而且還要回傳false?
    //
    public boolean equals(Object y){
        if(y==null){
            return false;
        }
        if(y.getClass() != this.getClass()){
            return false;
        }
        Rational b = (Rational) y;
        return compareTo(b) ==0;
    }

    public int hashCode(){
        return this.toString().hashCode();
    }

    public static Rational mediant(Rational r,Rational s){
        return new Rational(r.num+s.num,r.den+s.den);
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
    //先約分，分子分母在相乘
    public Rational times(Rational b){
        Rational a=this;

        Rational c =new Rational(a.num,b.den);
        Rational d = new Rational(b.num,a.den);
        return new Rational(c.num * d.num,c.den*d.den);
    }



    //跟Line6、Line45相關
    public Rational plus(Rational b){
        //this含括num、den
        Rational a = this;
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
        Rational s =new Rational((a.num / f)*(b.den/g)+(b.num/f) * (a.den / g),lcm(a.den,b.den));
        //不懂!!!
        s.num *= f;
        return s;
    }
    public Rational negate(){
        return new Rational(-num,den);
    }

    public Rational minus(Rational b){
        Rational a=this;
        return a.plus(b.negate());
    }
    //Line154 divides
    public Rational reciprocal(){
        return new Rational(den,num);
    }
    public Rational divides(Rational b){
        Rational a =this;
        return a.times(b.reciprocal());
    }
}

