package tree;

public class Tree {
  Node root;
	static class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data=data;
			left=null;
			right=null;
		}
	}
	
	Tree(){
		root=null;
	}
	
	void inOrderTraversal(Node node) {
		if (node!= null) {
		inOrderTraversal(node.left);
		System.out.print(node.data+" ");
		inOrderTraversal(node.right);
		}
		
	}
	int minValue(Node root)  { 
        int min = root.data; 
        while (root.left != null) { 
            min = root.left.data; 
            root = root.left; 
        } 
        return min; 
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
	
	Node delete(Node root, int key) {
		if(root==null) {
			return root;
		}
		
		if(key<root.data) {
			root.left=delete(root.left,key);
		}
		else if(key>root.data) {
			root.right=delete(root.right,key);
		}
		else {
			if(root.left==null) {
				return root.right;
			}
			else if(root.right==null) {
				return root.left;
			}
			
			root.data=minValue(root.right);
		    root.right=delete(root.right, root.data);
		}
		return root;
	}
	 void delete(int key)  { 
	        root = delete(root, key); 
	    } 
	  

	/*public Node search(Node root, int key) { 
    // Base Cases: root is null or key is present at root 
    if (root==null || root.key==key){ 
        return root; 
	}
  
    // val is greater than root's key 
    if (root.key > key) {
        return search(root.left, key); 
  }
    // val is less than root's key 
    return search(root.right, key); 
} 


*/
	
	
	public static void main(String[] args) {
		Tree tree= new Tree();
		    tree.insert(50); 
	        tree.insert(30); 
	        tree.insert(20); 
	        tree.insert(40); 
	        tree.insert(70); 
	        tree.insert(60); 
	        tree.insert(80); 
	  
	        
	        /* 
            50 
         /     \ 
        30      70 
       /  \    /  \ 
      20   40  60   80 */
	        
	        
	        Node tmp=tree.root;
	        //tree.inOrderTraversal(tmp); 
	        
	        System.out.println("Inorder traversal of the given tree"); 
	        tree.inOrderTraversal(tmp); 
	  
	        
	        System.out.println();
	        System.out.println("Delete 20"); 
	        tree.delete(20); 
	        System.out.println("Inorder traversal of the modified tree"); 
	        tree.inOrderTraversal(tmp); 
	  
	        System.out.println();
	        System.out.println("Delete 30"); 
	        tree.delete(30); 
	        System.out.println("Inorder traversal of the modified tree"); 
	        tree.inOrderTraversal(tmp); 
	  
	        System.out.println();
	        System.out.println("Delete 50"); 
	        tree.delete(50); 
	        System.out.println("Inorder traversal of the modified tree"); 
	        tree.inOrderTraversal(tmp); 
	}
	
}
