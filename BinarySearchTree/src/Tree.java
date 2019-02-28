
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
	
	int findSmallest(Node r) {
		while(r.left!=null) {
			r=r.left;
		}
		return r.data;
	}
	int findBiggest(Node r) {
		while(r.right!=null) {
			r=r.right;
		}
		return r.data;
	}
	 Node insertRec(Node root, int key) { 
	        if (root == null) { 
	            root = new Node(key); 
	            return root; 
	        } 
	  
	        if (key < root.data) 
	            root.left = insertRec(root.left, key); 
	        else if (key > root.data) 
	            root.right = insertRec(root.right, key); 
	        return root; 
	    } 
	

	
	
	public static void main(String[] args) {
		Tree t= new Tree();
		t.root=new Node(8);
		/*t.root.right=new Node(4);
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
		t.root.left.left.left=new Node(15);*/
		
		
		
		t.insertRec(t.root,4);
		t.insertRec(t.root,12);
		t.insertRec(t.root,2);
		t.insertRec(t.root,6);
		t.insertRec(t.root,10);
		t.insertRec(t.root,14);
		t.insertRec(t.root,1);
		t.insertRec(t.root,3);
		t.insertRec(t.root,5);
		t.insertRec(t.root,7);
		t.insertRec(t.root,9);
		t.insertRec(t.root,11);
		t.insertRec(t.root,13);
		t.insertRec(t.root,15);
		
	
	  // int s= t.findSmallest(t.root);
	  int b=t.findBiggest(t.root);
	   System.out.println(b);
		
		
		
	}

}
