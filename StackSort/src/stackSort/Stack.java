package stackSort;

public class Stack {
	
	class Node{
		int val;
		Node next;
		Node(int val){
			this.val=val;
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
	
	public Node createNode(int key) {
		return new Node(key);
	}
	
	public void push(int key) {
		Node n= new Node(key);
		if(head==null) {
			head=n;
		}
		else {
			n.next=head;
			head=n;
		}
		size++;
	}
	public int pop() {
		if(!isEmpty()) {
		Node n=head;
		head=head.next;
		size--;
		return n.val;
		}
		return -1;
	}
	
	
	public int peek() {
		
		return head.val;
	}
	
	

}
