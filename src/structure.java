import java.util.Scanner;
import java.io.*;

public class structure {
    public static void main(String[] args){
        //in代表終端

        Scanner scn = new Scanner(System.in);
        scn.useDelimiter("\n");
        //實體化：使用interface名稱中SimpleTokenGen方法
        TokenGen tk = new SimpleTokenGen();
        //使用Evaluator名稱實體化eval
        Evaluator eval = new Evaluator();

        //hasNext()代表有無輸入下一個字串
        while(scn.hasNext()){

            String s=scn.next();

            if(scn.equals("q") ){
                break;
            }
            //呼叫inputExpression方法
            tk.inputExpression(s);
            //呼叫taleToken方法，並做運算
            eval.takeToken(tk.getTokens());

            System.out.println("value="+eval.evaluate());
        }
    }
}
