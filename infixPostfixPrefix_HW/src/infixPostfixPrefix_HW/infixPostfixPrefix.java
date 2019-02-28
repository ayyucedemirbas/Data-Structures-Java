package infixPostfixPrefix_HW;

public class infixPostfixPrefix {

	
	static int priority(char ch)  { //operator onceligini geri dondurur
        switch (ch) { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
       
        case '^': 
            return 3; 
        } 
        return -1; 
    }  
	

    static String infixToPostfix(String s) { 
      
        String result = new String(""); 
          
     
        Stack<Character> stack = new Stack<Character>(); 
          
        for (int i = 0; i<s.length(); ++i){ 
            char c = s.charAt(i); 
              
          
            if (Character.isLetterOrDigit(c)) //char degeri bir harf veya sayi mi
                result += c; //String'e ekle
             
            else if (c == '(') //Ac parantez ise stack'e ekle
                stack.push(c); 
              
          
            else if (c == ')') { //Eger char degeri kapa parantez ise ac parantez gorene kadar stack'i bosalt
                while (!stack.isEmpty() && stack.peek() != '(') 
                    result += stack.pop(); 
                  
                if (!stack.isEmpty() && stack.peek() != '(') 
                    return "hata";                
                else
                    stack.pop(); 
            } 
            else {  // char degeri islem operatoru ise
           
                while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {/*stack'in en tepesindeki operatorun islem onceligini kontrol eder. 
                
               Buna gore operatoru result isimli String'e atar*/
                    result += stack.pop(); 
                    }
                stack.push(c); 
            } 
       
        } 
       
        // tum operatorleri stack'ten result isimli String'e atar 
        while (!stack.isEmpty()) {
            result += stack.pop();
            } 
       
        return result; 
    } 
    
	
    static String infixToPrefix(String infix)  { 
        Stack<Character> operators = new Stack<Character>(); 

        Stack<String> operands = new Stack<String>(); 
      
        for (int i = 0; i < infix.length(); i++)   { 
      
            if (infix.charAt(i) == '(')   { 
                operators.push(infix.charAt(i)); 
            } 
      
            // If current character is a 
            // closing bracket, then pop from 
            // both stacks and push result 
            // in operands stack until 
            // matching opening bracket is 
            // not found. 
            else if (infix.charAt(i) == ')')   { 
                while (!operators.isEmpty() && operators.peek() != '(')  
                    { 
      
                    // operand 1 
                    String op1 = operands.pop(); 
                  
      
                    // operand 2 
                    String op2 = operands.pop(); 
                    
      
                    // operator 
                    char op = operators.pop(); 
                 
      
                    // Add operands and operator 
                    // in form operator + 
                    // operand1 + operand2. 
                    String tmp = op + op2 + op1; 
                    operands.push(tmp); 
                } 
      
                // Pop opening bracket  
                // from stack. 
                operators.pop(); 
            } 
      
            // If current character is an 
            // operand then push it into 
            // operands stack. 
            else if (Character.isLetterOrDigit(infix.charAt(i)))  
            { 
                operands.push(infix.charAt(i) + ""); 
            } 
      
            // If current character is an 
            // operator, then push it into 
            // operators stack after popping 
            // high priority operators from 
            // operators stack and pushing 
            // result in operands stack. 
            else 
            { 
                while (!operators.isEmpty() &&   priority(infix.charAt(i)) <=  priority(operators.peek()))   { 
      
                    String op1 = operands.pop(); 
                  
      
                    String op2 = operands.pop(); 
                
      
                    char op = operators.pop(); 
              
      
                    String tmp = op + op2 + op1; 
                    operands.push(tmp); 
                } 
      
                operators.push(infix.charAt(i)); 
            } 
        } 
      
        // Pop operators from operators  
        // stack until it is empty and  
        // operation in add result of  
        // each pop operands stack. 
        while (!operators.isEmpty())  
        { 
            String op1 = operands.pop(); 
         
      
            String op2 = operands.pop(); 
           
      
            char op = operators.pop(); 
           
      
            String tmp = op + op2 + op1; 
            operands.push(tmp); 
        } 
      
        // Final prefix expression is 
        // present in operands stack. 
        return operands.peek(); 
    } 
    
    
    static int evaluatePostfix(String exp) { 
        //create a stack 
        Stack<Integer> stack=new Stack<>(); 
          
        // Scan all characters one by one 
        for(int i=0;i<exp.length();i++) 
        { 
            char c=exp.charAt(i); 
              
            // If the scanned character is an operand (number here), 
            // push it to the stack. 
            if(Character.isDigit(c)) 
            stack.push(c - '0'); 
              
            //  If the scanned character is an operator, pop two 
            // elements from stack apply the operator 
            else
            { 
                int val1 = stack.pop(); 
                int val2 = stack.pop(); 
                  
                switch(c) 
                { 
                    case '+': 
                    stack.push(val2+val1); 
                    break; 
                      
                    case '-': 
                    stack.push(val2- val1); 
                    break; 
                      
                    case '/': 
                    stack.push(val2/val1); 
                    break; 
                      
                    case '*': 
                    stack.push(val2*val1); 
                    break; 
              } 
            } 
        } 
        return stack.pop();     
    } 

    public static void main(String[] args){ 
        String s = "((A+B)*(C-D))"; 
        System.out.println(infixToPostfix(s)); 
        String s1 = "(A-B/C)*(A/K-L)"; 
        System.out.println( infixToPrefix(s1)); 
        String exp="291*+3-"; 
        System.out.println("postfix evaluation: "+evaluatePostfix(exp)); 
    } 
	

	
	
	
	
}
