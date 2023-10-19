import java.util.*;
public class Evaluator {
    //初始化+-*/以及數字堆疊
    //初始化Token(使用者輸入的)
    Stack<String> operators = new Stack<>();
    Stack<Double> vals = new Stack<>();
    List<Token> tokens = null;
    //取得使用者輸入的資料
    void takeToken(List<Token> tks){
        tokens = tks;
    }

    Double evaluate(){
        //判斷是否為空
        if(tokens.isEmpty()){
            return null;
        }
        //使用tk遍歷tokens的內容
        for(Token tk:tokens){
            //取出content裡面的內容，回傳給s
            String s = tk.content;
            switch(s){
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    //題目要求拔出運算子
                    operators.push(s);
                    break;
                    //因為題目的需求是)要開始做計算
                case ")":
                    String op =operators.pop();
                    double v = vals.pop();
                    switch(op){
                        case "+":
                            v+=vals.pop();
                            break;
                        case "-":
                            v-=vals.pop();
                            break;
                        case "*":
                            v*=vals.pop();
                            break;
                        case "/":
                            v/=vals.pop();
                            break;
                    }
                    vals.push(v);
                    break;
                        //接受字串內容，轉成浮點數=>
                default:
                    vals.push(Double.parseDouble(s));
            }
        }

        return vals.pop();
    }
}
