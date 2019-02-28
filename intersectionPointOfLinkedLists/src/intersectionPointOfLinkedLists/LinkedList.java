package intersectionPointOfLinkedLists;

public class LinkedList {
	

	class Node{
		Node next;
		int data;
		Node(int data){
			next=null;
			this.data=data;
			
		}
		
	}
	
	
	Node head;
	
	int getSize(Node listHead) {
		Node n=listHead;
		int size=0;
		while(n!=null) {
			n=n.next;
			size++;
		}
		return size;
	}
	
	Node getTail() {
		Node n= head;
		while(n.next!=null) {
			n=n.next;
		}
		return n;
	}
	
	
	  int getNode(int d, Node listHead1, Node listHead2) {  
	        Node n1 = listHead1; 
	        Node n2 = listHead2; 
	        for (int i = 0; i < d; i++) { 
	            if (n1 == null) { 
	                return -1; 
	            } 
	            n1 = n1.next; 
	        } 
	        while (n1 != null && n2 != null) { 
	            if (n1.data == n2.data) { 
	                return n1.data; 
	            } 
	           n1 = n1.next; 
	            n2 = n2.next; 
	        } 
	  
	        return -1; 
	    } 

	  void add(int val) {
		  if(head==null) {
			  head= new Node(val);
			  return;
		  }
		  Node n = new Node(val);
		  n.next=null;
		 Node tail= getTail();
		 tail.next=n;
		 return;
	  }
	  
	  
	  public static void main(String[] args) {
		LinkedList ll1= new LinkedList();
		LinkedList ll2= new LinkedList();
		
		ll1.add(1);
		ll1.add(2);
		ll1.add(3);
		ll1.add(4);
		ll1.add(5);
		ll1.add(6);
		ll1.add(7);
		ll1.add(8);
		
		ll2.add(0);
		ll2.add(15);
		ll2.add(13);
		ll2.add(12);
		ll2.add(7);
		ll2.add(8);
		
		System.out.print("Intersection Point: ");
		   int s1 = ll1.getSize(ll1.head); 
	        int s2 = ll1.getSize(ll2.head); 
	        int diff; 
	  
	        if (s1 > s2) { 
	            diff = s1 - s2; 
	            System.out.println(ll1.getNode(diff, ll1.head, ll2.head));
	        } else { 
	            diff = s2 - s1; 
	            System.out.println(ll1.getNode(diff, ll2.head, ll1.head));
	        } 
			
	}

}
