class Solution {
    
    /**
     1. convert given infix expression in to postfix . 
      https://scriptasylum.com/tutorials/infix_postfix/algorithms/infix-postfix/
   
      2. evaluate postfix expresssion.
      
     */
    
    private int prec(char op){
        if(op == '+' || op=='-')
            return 1;
        else if(op == '/' || op=='*')
            return 2;
          else 
               return 0;
            
        }
    
    private int eval(int a ,int b, char op){
        
        if(op == '*'){
            return a*b;
        }
        else if(op == '-') {
            return a-b;
        }
        else if(op == '/') {
            return a/b;
        }
         return a+b;
    }
    
    private String infixToPostfix(String s){
        String res = "";
        Stack<Character> stack = new Stack();
        
        for(int i=0;i<s.length();i++){
         
            char c = s.charAt(i);
             
            if(Character.isDigit(c)){
                  res += c;             
            }else if(c=='('){
                stack.push('(');
                
            }else if(c==')'){
                while(!stack.isEmpty() &&  stack.peek() == ')'){
                    res += stack.pop();
                }
                
                stack.pop();
                
            }else{
            /** when operator is coming
           if the top of the stack(suppose -) is less prec than incoming operator(suppose *) just push the incoming op. -*
           if incoming operator is high or equal prec than top of stack then pop the oprerator untill we              get a low prec
            */
                
                while(!stack.isEmpty() &&  prec(c) <= prec(stack.peek()) ){
                    res += stack.pop();
                }
                stack.push(c);
            }
        }
        
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
    
    private int evaluatePostfix(String postfix){
        Stack<Integer> stack = new Stack();
        for(int i=0;i<postfix.length();i++){
            char c = postfix.charAt(i);
            
            if(Character.isDigit(c)){
              stack.push((int)c);    
            }else{
                int y = (int)stack.pop();
                int x = (int)stack.pop();
                stack.push(eval(x,y,c));       
            }
        }
        return stack.pop();
    }
    
    public int calculate(String s) {
       // return evaluatePostfix(infixToPostfix(s));
        
        return evaluate(s);
    }
    
    private int evaluate(String s){
        
        int num = 0;
        int result= 0;
        int sign =1;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
           char c = s.charAt(i);
            if( c>='0' && c <='9'){
                num = num*10+ c-'0';
            }else if(c == '+'){
                result += sign*num;
                num=0;
                sign=1;
            }else if(c == '-'){
                 result += sign*num;
                num=0;
                sign= -1;
            }else if(c == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign =1;
                
            }else if(c == ')'){
                result += sign*num;
                num = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        
        if(num != 0) result += sign * num;
        
        return result;
    }
}