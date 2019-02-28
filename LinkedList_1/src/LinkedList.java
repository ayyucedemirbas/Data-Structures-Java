

public class LinkedList {
	Node head;
	 static class Node {
	        int data;
	        Node next;
	        Node(int d)  { //Constructor
	        	data = d;  
	        	next=null; 
	        	
	 }

}
	 public void printList() {
		 Node n= head;
		 while(n!=null) {
			 System.out.println(n.data+ " ");
			 n=n.next;
		 }
	 }
	 
	 
	 public static void main(String[] args) {
		 LinkedList ll = new LinkedList();
		 ll.head= new Node(1);
		 Node second= new Node(2);
		 Node third= new Node(3);

	        /* Three nodes have been allocated  dynamically.
	          We have refernces to these three blocks as first,  
	          second and third
	 
	          llist.head        second              third
	             |                |                  |
	             |                |                  |
	         +----+------+     +----+------+     +----+------+
	         | 1  | null |     | 2  | null |     |  3 | null |
	         +----+------+     +----+------+     +----+------+ */
		 
		 
		 ll.head.next=second;
		 
		  /*  Now next of first Node refers to second.  So they
         both are linked.

      llist.head        second              third
         |                |                  |
         |                |                  |
     +----+------+     +----+------+     +----+------+
     | 1  |  o-------->| 2  | null |     |  3 | null |
     +----+------+     +----+------+     +----+------+ */
		 second.next=third;
		 
		  /*  Now next of second Node refers to third.  So all three
         nodes are linked.

      llist.head        second              third
         |                |                  |
         |                |                  |
     +----+------+     +----+------+     +----+------+
     | 1  |  o-------->| 2  |  o-------->|  3 | null |
     +----+------+     +----+------+     +----+------+ */
		 
		 
		 ll.printList();
		 
	 }
	 
	 
	 
}