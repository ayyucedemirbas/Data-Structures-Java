package doubly_LinkedList;

public class LinkedList {
	Node head;
	class Node{
		int num;
		Node next, prev;
		Node(int num){
			this.num=num;
			next=null;
			prev=null;
		}
		
	}

	
	Node findLast() {
		Node n= head;
		while(n.next!=null) {
			n=n.next;
		}
		return n;
	}
	
	void addLast(int i) {
		Node n= new Node(i);
		Node tail= findLast();
		if(head==null) {
			head=n;
		}
		else {
			
			tail.next=n;
			
		}
		n.prev=tail;
		tail=n;
		
	}
	
	
	void addBetweenTwoNodes(int i, Node prevNode) {
		Node n= new Node(i);
		n.next=prevNode.next;
		n.prev=prevNode;
		prevNode.next.prev=n;
		prevNode.next=n;
		
	}
	
	
	void push(int i) {
		Node n= new Node(i);
		n.next=head;
		n.prev=null;
		
		if(head!=null) {
			
			head.prev=n;
		}
		head=n;
	}
	
	
	void removeTheFirstElement() {
		head=head.next;
		Node last=findLast();
		if(head==null) {
			last=null;
			
		}
		else {
			head.prev=null;
		}
	}
	
	void removeTheLastElement() {
		Node last=findLast();
		last=last.prev;
		if(last==null) {
			head=null;
		}
		else {
			last.next=null;
		}
	}
	
	void removeBetweenTwoNodes(Node delete) {
		delete.next.prev=delete.prev;
		delete.prev.next=delete.next;
	}
	
	void print() {
		Node n=head;
		while(n!=null) {
			System.out.println(n.num);
			n=n.next;
		}
	}
	
	
    public static void main(String[] args) {
		LinkedList ll= new LinkedList();
		ll.push(1);
		ll.push(6);
		System.out.println("head: "+ll.head.num);
		ll.addBetweenTwoNodes(5, ll.head);
		ll.addLast(8);
		ll.addBetweenTwoNodes(0, ll.head.next);
	    ll.removeBetweenTwoNodes(ll.head.next.next);
	    ll.removeTheFirstElement();
	    ll.removeTheLastElement();
		ll.print();
		System.out.println("head.next: "+ll.head.next.num);
	}
	

}
