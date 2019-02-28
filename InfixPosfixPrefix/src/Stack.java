
public class Stack {

	class Node{
		char c;
		
		Node(char c){
			this.c=c;
			
		}
	}
	
	Node[] n;
	int top, size;
	
	
	Stack(int size){
		this.size=size;
		n= new Node[size];
		top=-1;
	
	}
	
	
	boolean isFull() {
		return top==size-1;
	}
	
	boolean isEmpty() {
		return top==-1;
	}
	
	void push(Node q) {
		if(!isFull()) {
			top+=1;
			n[top]=q;
			
		}
		
	}
	
	char pop() {
		if(!isEmpty()) {
			top-=1;
			return n[top+1].c;
		}
		return ' ';
	}
	
	Node createNode(char w) {
		Node n= new Node(w);
		return n;
		
	}
	
	
	char peek() {
		return n[top].c;
	}		
}
