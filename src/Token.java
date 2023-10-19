public class Token {
    //代表(、)、+
    //0 -->() ; 1--> 1,2,3... ;2--> +、-、*、/
    TokenType type;
    //代表儲存 ( 或是 )
    String content;

    //class cons
    Token(TokenType type,String content){
        this.type=type;
        this.content=content;
    }
}
//列舉
enum TokenType{
    PARENTHESIS,OPERATOR,VALUE
}