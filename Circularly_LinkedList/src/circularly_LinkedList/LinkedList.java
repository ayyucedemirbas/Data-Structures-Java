package circularly_LinkedList;

public class LinkedList {
	Node head;
static class Node{
	int data;
	Node next,prev;
	Node(int data){
		this.data=data;
		next=null;
		prev=null;
	}
	
}


void add(int k) {
	Node n= new Node(k);
	if(head==null) {
		n.next=n;
		n.prev=n;
		
	}
	else {
		n.next=head;
		n.prev=head.prev;
		head.prev.next=n;
		head.prev=n;
	}
	
	head=n;
		
}


void remove() {
	if(head.next==head) {
		head=null;
	}
	else {
		head.prev.next=head.next;
		head.next.prev=head.prev;
		head=head.next;
	}
}

void print() {
Node n=head;
	if(head!=null) {
	do {
		System.out.println(n.data);
		n=n.next;
	}
	
	while(n!=head);
	
	}
	
	
}
public static void main(String[] args) {
	LinkedList ll= new LinkedList();
	ll.add(2);
	ll.add(3);
	ll.add(4);
	ll.add(5);
	ll.add(6);
	
	ll.print();
	
	System.out.println("Head:  "+ ll.head.data);
	
	
}

}
