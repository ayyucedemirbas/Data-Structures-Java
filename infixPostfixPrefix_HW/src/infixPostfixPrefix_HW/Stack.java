package infixPostfixPrefix_HW;

public class Stack<E> {
	class Node{
		E e;
		Node next;
		Node(E e){
			this.e=e;
			next=null;
		}
		
	}
	
	Node head;
	int size;
	Stack(){
		size=0;
		head=null;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return head==null;
	}

	public void push(E e) {
		Node n= new Node(e);
		if(head==null) {
			head=n;
		}
		else {
			n.next=head;
			head=n;
		}
		size++;
	}
	public E pop() {
		if(!isEmpty()) {
		Node n=head;
		head=head.next;
		size--;
		return n.e;
		}
		return null;
	}
	
	
	
	/*public MazePos pop() {
	MazePos mp= new MazePos(head.x,head.y);
	return mp;
	}*/
	
	public E peek() {
		
		return head.e;
	}
	
	
	

}




