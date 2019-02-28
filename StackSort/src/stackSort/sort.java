package stackSort;


public class sort {
	
	public static void main(String[] args) {
		Stack s1= new Stack();
		Stack s2= new Stack();
		
		s1.push(6);
		s1.push(9);
		s1.push(5);
		s1.push(1);
		s1.push(14);
		s1.push(8);
		s1.push(3);
		s1.push(19);
		s1.push(26);
		
		
	
		while(!s1.isEmpty()) {
			int tmp=s1.pop();
			while(!s2.isEmpty()&&s2.peek()>tmp) {
				s1.push(s2.pop());
			}
			s2.push(tmp);
			
		}
		
	while(!s2.isEmpty()) {
		System.out.println(s2.pop());
	}	
		
		
		
		
	}

}
