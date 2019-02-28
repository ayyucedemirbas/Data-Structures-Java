
public class Stack {
	class Parantez{
		char c;
		Parantez(char c){
			this.c=c;
		}
	}
	Parantez[] denge;
	int top, size;

	Stack(int size){
		this.size=size;
		denge= new Parantez[size];
		top=-1;
	}
	
     boolean isFull() {
    	 return top==size-1;
     }
     
     boolean isEmpty() {
    	 return top==-1;
     }
	 
     
     void push(Parantez p) {
    	 if(!isFull()) {
    		 top+=1;
    		 denge[top]=p;
    	 }
     }
     
     char pop() {
    	 if(!isEmpty()) {
    		 top-=1;
    		 return denge[top+1].c;
    	 }
    	 return ' ';
     }
     
     
     Parantez olustur(char ch) {
    	 Parantez p= new Parantez(ch);
    	 return p;
     }
     char peek() {
    	 return denge[top].c;
     }
	
}
