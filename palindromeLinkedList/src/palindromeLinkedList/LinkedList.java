package palindromeLinkedList;


//2018 Ayyuce Demirbas
//Checks the singly linked list for is palindrome.
//Converts linked list to array because we cannot reach the previous element for singly linked lists. 
//I also wrote a solution for doubly linked lists, without converting to array
public class LinkedList {
	
	Node head;
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			next=null;
		}
	}
	
	
	void print(Node n) {
		while(n != null) {
			System.out.println(n.data);
			n=n.next;
		}
	}
	
	void push(int d) {
		Node node= new Node(d);
		node.next=head;
		head=node;
	}
	
	boolean isPalindrome(Node n, LinkedList ll) {
	
		int num=0;
		while(n != null) {
			num++;
			n=n.next;
		}
		//System.out.println(num);
		n=null;
	   n=ll.head;
		
		//System.out.println(n.next.data);
		int[] arr= new int[num];
		
		/*for (int i=0; i<num; i++) {
			
			arr[i]=n.data;
			n=n.next;
			
			
		}*/
		int j=0;
		while(n!=null) {
			arr[j]=n.data;
			n=n.next;
			j++;
		}
		
		
		for (int i=0; i<num/2; i++) {
			if(arr[i]!=arr[num-1-i]) {
				return false;
			
			}
			
			
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
		//System.out.println(ll.head.data);
		
	 boolean palindrome=ll.isPalindrome(ll.head, ll);
	// ll.print(ll.head);
	 System.out.println(palindrome);
		
	}
	

}
