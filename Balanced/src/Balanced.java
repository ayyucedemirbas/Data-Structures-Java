
public class Balanced {
	
	static boolean eslesenParantezler(char c1, char c2) {
		 if (c1 == '(' && c2 == ')') 
	         return true; 
	       else if (c1 == '{' && c2 == '}') 
	         return true; 
	       else if (c1 == '[' && c2 == ']') 
	         return true; 
	       else
	         return false; 
	}

	static boolean isBalanced(String parantezler) {
		Stack stack= new Stack(15);
		
		for(int i=0; i<parantezler.length(); i++) {
		char c=parantezler.charAt(i);
		if(c=='('||c=='['||c=='{') {
			stack.push(stack.olustur(c));
		}
		
		
		if(c==')'||c==']'||c=='}') {
			
			if(stack.isEmpty()) { //ilk eleman kapa parantezlerden birisi ise false don
				return false;
			}
			
			else if(!eslesenParantezler(stack.pop(),c)) {
				return false;
			}
		
		}
		

		}
		
		if (stack.isEmpty()) {
	        return true;
	        }
	       else{   
	    	   return false;
	         }  
		
	}
	
	
	public static void main(String[] args) {
		String parantezler="({()[{})]}())";
		
		if (isBalanced(parantezler)) {
			System.out.println("Parantezlerin tamami eslesiyor, dengeli");
		}
		else 
			System.out.println("Parantezler eslesmiyor, dengeli degil");
	}
	
	
}
