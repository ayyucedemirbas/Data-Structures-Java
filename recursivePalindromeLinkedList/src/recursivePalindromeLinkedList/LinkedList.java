package recursivePalindromeLinkedList;



public class LinkedList {
	
Node head;
	
	class Node{
		Node next;
		int data;
		Node(int data){
			this.data=data;
			next=null;
			
		}
		
		
	}
	
	
	Node last(Node n) {
		while(n!=null) {
			n=n.next;
		}
		return n;
	}
	
	
	
	
	
	static int[] arr;
	
	static int num=0;
	
	
	
	static void addToArr(Node n) {
		
	arr=new int[num];
		int j=0;
		while(n!=null&&j<num) {
			
			arr[j]=n.data;
			n=n.next;
			j++;
			
			
			
		}
	
		
	}
	
	//static int count=0;
	
	public static boolean isPalindrome(int first, int last) {
	    if (arr.length == 0 || arr.length == 1) 
		return true;
	    if (first>= last)
		return true;
	  
	    if (arr[first] != arr[last])
		return false;

	    return isPalindrome(first + 1, last- 1);
	}
	
	
	void push(int x){
		Node n= new Node(x);
		n.next=head;
		head=n;
	}
	
	void print(Node n) {
		while(n!=null) {
			System.out.println(n.data);
			n=n.next;
		}
	}
	
 static	void size(Node n) {
		int counter=0;
		while(n!=null) {
			
			n=n.next;
			
			counter++;
		}
		num=counter;
		
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
		
		
		size(ll.head);
		addToArr(ll.head);
		
		/*for(int val : arr) {
			System.out.println(val);
		}*/
		
		
	if(isPalindrome(0,num-1)) {System.out.println("Palindrome");}
	else System.out.println("Not Plaindrome");
		
	}
	

}
