//2018 Ayyuce Demirbas
//Checks the doubly linked list for is palindrome.
public class LinkedList {
	Node head;
	class Node{
		int data;
		Node next;
		Node prev;
		Node(int data){
			this.data=data;
			next =null;
			prev=null;
		}
	}

	void push(int d) {
		
		Node n= new Node(d);
		n.next=head;
		n.prev=null;
		
		if(head!=null) {
			
			head.prev=n;
		}
		head=n;
		
		
		
		
	}
	
	boolean isPalindrome(LinkedList ll, Node n) {
		Node last=null;
		while(n!= null) {
			last=n;
			n=n.next;
		}
		
		n=ll.head;
		
		
		
		while(n!= null&& last!=null) {
			
			if(n.data!=last.data) {
				return false;
			}
			
			n=n.next;
			last=last.prev;
			
		}
		
		return true;
		
		
	}
	
	
	public static void main(String[] args) {
		LinkedList ll= new LinkedList();
		
		ll.push(1);
		ll.push(2);
		ll.push(3);
		ll.push(4);
		ll.push(4);
		ll.push(3);
		ll.push(2);
		ll.push(1);
		
		boolean palindrome= ll.isPalindrome(ll,ll.head);
		 System.out.println(palindrome);
	}
	
	
	
	
}
