class Node{
	String name;
	int num;
	
	
	Node(String name, int num){
		this.name=name;
		this.num=num;
	}
	
}
public class Stack {
Node[] d;
int top, N;

Stack(int N){
	this.N=N;
	d= new Node[N];
	top=-1;
}


boolean isFull() {
	return top==N-1;
}


boolean isEmpty() {
	return top==-1;
}


void push(Node n) {
	if(!isFull()) {
		top++;
		d[top]=n;
	}
}


Node pop() {
	if(!isEmpty()) {
		top--;
		return d[top+1];
	}
	return null;
}
	

public static void main(String[] args) {
	Stack s= new Stack(5);
	Node n= new Node("Ayyuce",5);
	s.push(n);
	n= new Node("Ayse", 7);
	s.push(n);
	n= new Node("Demirbas", 4);
	s.push(n);
	n=s.pop();
	
	System.out.println(n.name);
	System.out.println(n.num);
}

	
}
