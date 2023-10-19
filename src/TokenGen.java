import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
public interface TokenGen {
    void inputExpression(String expression);
    //清單的元素是Token=> <>
    List<Token> getTokens();
}

//實作的意思：把介面的方法上內容
class SimpleTokenGen implements TokenGen{

    List<Token> result;
    //對運算式做解析
    public void inputExpression(String expression){
        result = new LinkedList<>();
        String value="";
        //遍歷expression
        try{
            for(char c:expression.toCharArray()){
                switch(c) {
                    case '(':
                    case ')':
                        //判斷是不是空字串
                        if (!value.equals("")) {
                            result.add(new Token(TokenType.VALUE, value));
                            value = "";
                        }
                        //單引號
                        result.add(//新的代幣
                                new Token(TokenType.PARENTHESIS, String.valueOf(c))
                        );
                        break;
                    case '+':

                    case '-':

                    case '*':

                    case '/':
                        //新的代幣
                        if (!value.equals("")) {
                            result.add(new Token(TokenType.VALUE, value));
                            value = "";
                        }
                        result.add(
                                new Token(TokenType.OPERATOR, String.valueOf(c))
                        );
                        break;
                    case ' ':
                        break;
                    //預設處理=>default
                    default:
                        if (Character.isDigit(c)) {
                            //將自串串起來
                            value = value.concat(String.valueOf(c));
                        } else {
                            throw new Exception("Error");
                        }
                    }
                }
            }catch(Exception e){
                System.out.println(e);
            }
    }
    public List<Token> getTokens(){
        System.out.println("Tokens：");
        //對於每個result的token t
        for(Token t:result){
            System.out.print(t.content+" ");
        }
        System.out.println();
        return result;
    }
}