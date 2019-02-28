

public class infixToPostfixClass {
	static int Prec(char ch)  { 
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
    static String infixToPostfix(String exp) { 
      
        String result = new String(""); 
          
     
        Stack stack = new Stack(17); 
          
        for (int i = 0; i<exp.length(); ++i){ 
            char c = exp.charAt(i); 
              
             // If the scanned character is an operand, add it to output. 
            if (Character.isLetterOrDigit(c)) 
                result += c; 
               
            // If the scanned character is an '(', push it to the stack. 
            else if (c == '(') 
                stack.push(stack.createNode(c)); 
              
            //  If the scanned character is an ')', pop and output from the stack  
            // until an '(' is encountered. 
            else if (c == ')') { 
                while (!stack.isEmpty() && stack.peek() != '(') 
                    result += stack.pop(); 
                  
                if (!stack.isEmpty() && stack.peek() != '(') 
                    return "Invalid Expression"; // invalid expression                 
                else
                    stack.pop(); 
            } 
            else {  // an operator is encountered 
           
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    result += stack.pop(); }
                stack.push(stack.createNode(c)); 
            } 
       
        } 
       
        // pop all the operators from the stack 
        while (!stack.isEmpty()) 
            result += stack.pop(); 
       
        return result; 
    } 
    
    // Driver method  
    public static void main(String[] args){ 
        String exp = "(a-b)*(c+d)"; 
        System.out.println(infixToPostfix(exp)); 
    } 
	

	
	
	

}