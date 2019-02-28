package binaryTree_NumOfNodes;



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
	
	
	Node getTheRightChild(Node n) {
		return n.right;
	}
	Node getTheLeftChild(Node n) {
		return n.left;
	}
	
	Node insert(Node root, int key) {
		if(root==null) {
			root=new Node(key);
			return root;
		}
		
		if(key<root.data) {
			root.left=insert(root.left,key);
		}
		
		else if(key>root.data) {
			root.right=insert(root.right, key);
		}
		
		return root;
	}
	
	   void insert(int key) { 
	        root = insert(root, key); 
	    } 
	   
	   int count() {
		    Stack<Node> s = new Stack<Node>();
		    Node tmp=root;
		    s.push(tmp);
		    int count = 0;
		    while (!s.isEmpty()) {
		        Node n = s.pop();
		        count++;
		        Node ch = getTheLeftChild(n);
		        if (ch != null) { 
		        	s.push(ch); 
		        	}
		        ch = getTheRightChild(n);
		        if (ch != null) { 
		        	s.push(ch); 
		        	}
		    }
		    return count;
		}
	 
	   
	   
	   
	   public static void main(String[] args) {
		   Tree tree= new Tree();
		    tree.insert(50); 
	        tree.insert(30); 
	        tree.insert(20); 
	        tree.insert(40); 
	        tree.insert(70); 
	        tree.insert(60); 
	        tree.insert(80); 
	        tree.insert(23); 
	        tree.insert(124); 
	        tree.insert(648); 
	        tree.insert(69); 
	        tree.insert(12); 
	        tree.insert(412); 
	        tree.insert(988); 
	        
	        
	        int num=tree.count();
	        System.out.println(num);
	}

}
