
public class Tree {
	
	static class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data=data;
			left=null;
			right=null;
			
		}
	}
	
	Node root;
	
	Tree(){
		root=null;
	}
	
	boolean iterativeSearch(Node root, int key) { 
	    while (root != null) { 
	        
	        if (key > root.data) {
	            root = root.left; 
	        }
	       
	        else if (key < root.data) {
	            root = root.right; 
	            }
	        else {
	            return true;
	            }
	    } 
	    return false; 
	} 
	 
	
	
	
	public Node search(Node root, int key) { 
	   
	    if (root==null || root.data==key) {
	    	 System.out.println("Found");
	        return root; 
	       
	    }
	  
	  
	    if (root.data > key) {
	        return search(root.left, key); 
	        }
	  
	   
	    return search(root.right, key); 
	} 
	
	
	public static void main(String[] args) {
		Tree t= new Tree();
		t.root=new Node(8);
		t.root.right=new Node(4);
		t.root.left=new Node(12);
		t.root.right.right=new Node(2);
		t.root.right.left=new Node(6);
		t.root.left.right=new Node(10);
		t.root.left.left=new Node(14);
		t.root.right.right.right=new Node(1);
		t.root.right.right.left=new Node(3);
		t.root.right.left.right=new Node(5);
		t.root.right.left.left=new Node(7);
		t.root.left.right.right=new Node(9);
		t.root.left.right.left=new Node(11);
		t.root.left.left.right=new Node(13);
		t.root.left.left.left=new Node(15);
		
	
	
	   boolean found=t.iterativeSearch(t.root,7);
	   System.out.println(found);
		
		
		
		
		
	}

}
