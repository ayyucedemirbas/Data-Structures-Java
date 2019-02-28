
public class Tree {
	
	
	class Ogrenci{
		int numara, not;
		String ad;
		Ogrenci(int numara, int not, String ad){
			this.numara=numara;
			this.not=not;
			this.ad=ad;
			
		}
		
	}
	
	class Node{
	    Ogrenci o;
		Node left, right;
		Node(Ogrenci o){
			this.o=o;
			left=null;
			right=null;
		}
		
	}
	
	
	
	Ogrenci createOgrenci(int numara, int not, String ad) {
		Ogrenci o= new Ogrenci( numara, not, ad);
		
		return o;
		
		
	}
	
	
	Node root;
	
	Tree(){
		root=null;
	}
	
	
	void insert(Ogrenci o) { 
	       root = insertStudent(root, o); 
	    } 
	      
	  
	    Node insertStudent(Node root, Ogrenci o) { 
	  
	       
	        if (root == null) { 
	            root = new Node(o); 
	            return root; 
	        } 
	  
	      
	        if (o.numara < root.o.numara) 
	            root.left = insertStudent(root.left, o); 
	        else if (o.numara  > root.o.numara) 
	            root.right = insertStudent(root.right, o); 
	  
	     
	        return root; 
	    } 
	

	    
	    
	    
	    void delete(Ogrenci yeni) { 
	        root = deleteStudent(root, yeni); 
	    } 
	    
	  	 Node deleteStudent(Node root, Ogrenci yeni) { 
	        
	        if (root == null) {
	        	return root; 
	        }
	  
	      
	        if (yeni.numara < root.o.numara) {
	            root.left = deleteStudent(root.left, yeni); 
	        }
	        else if (yeni.numara > root.o.numara) {
	            root.right = deleteStudent(root.right, yeni); 
	        }
	        
	        else{ 
	            
	            if (root.left == null) {
	                return root.right; 
	            }
	            else if (root.right == null) {
	                return root.left; 
	            }
	            root.o.numara = min(root.right); 
	            root.right = deleteStudent(root.right, yeni); 
	        } 
	  
	        return root; 
	    } 
	    
	    
	    int min(Node root){  //Minimum numarayi bulur
	    
	        int minv = root.o.numara; 
	        while (root.left != null) { 
	            minv = root.left.o.numara; 
	            root = root.left; 
	        } 
	        return minv; 
	    } 
	    
	    
	    
	    int max(Node root){  //Maksimum numarayi bulur
		    
	        int maxv = root.o.numara; 
	        while (root.right != null) { 
	            maxv = root.right.o.numara; 
	            root = root.right; 
	        } 
	        return maxv; 
	    } 
	    
	    public String search(Node root, int key)  { 
	        
	        if (root==null || root.o.numara==key) {
	            return root.o.ad; 
	        }
	       
	        if (root.o.numara > key) {
	            return search(root.left, key); 
	        }
	        
	        return search(root.right, key); 
	    } 
	    void print(Node r) {//Inorder. Numaraya gore sirali yazar
	    	if(r!=null) {
	    	
	    	print(r.left);
	    	System.out.println("Numara: "+r.o.numara+"  Isim:  "+r.o.ad+"  Not:  "+r.o.not);
	    	print(r.right);
	    	
	    	
	    	}
	    	
	    }
	    
	    void inOrder(Node r) {
	    	if(r!=null) {
	    		inOrder(r.left);
	    		System.out.println("Numara: "+r.o.numara+"  Isim:  "+r.o.ad+"  Not:  "+r.o.not);
	    		inOrder(r.right);
	    	}
	    	
	    }
	    
	    void postOrder(Node r) {
	    	if(r!=null) {
	    		postOrder(r.left);
	    		postOrder(r.right);
	    		System.out.println("Numara: "+r.o.numara+"  Isim:  "+r.o.ad+"  Not:  "+r.o.not);
	    	}
	    	
	    }
	    void preOrder(Node r) {
	    	if(r!=null) {
	    		System.out.println("Numara: "+r.o.numara+"  Isim:  "+r.o.ad+"  Not:  "+r.o.not);
	    		preOrder(r.left);
	    		preOrder(r.right);
	    		
	    	}
	    	
	    }
	  
	
	    
	    
	    
	    void printLevelOrder(Node r)   { 
	        Queue<Node> queue = new Queue<Node>(); 
	        queue.add(r); 
	        while (!queue.isEmpty())  { 
	            Node tempNode = queue.poll(); 
	            System.out.println("Numara: "+  tempNode.o.numara + "  Isim: " +tempNode.o.ad+ " Not: "+ tempNode.o.not); 
	  
	            
	            if (tempNode.left != null) { 
	                queue.add(tempNode.left); 
	            } 
	            if (tempNode.right != null) { 
	                queue.add(tempNode.right); 
	            } 
	        } 
	    } 
	  
	    
	    public static void main(String[] args) {
	    	
	    	Tree t= new Tree();
			Ogrenci o= t.createOgrenci(10, 20, "qqqqqq");
			Ogrenci o1= t.createOgrenci(11, 55, "yyyyyyy");
			Ogrenci o2= t.createOgrenci(54, 12, "dddddddd");
			Ogrenci o3= t.createOgrenci(67, 6, "hhhhhhhhh");
			Ogrenci o4= t.createOgrenci(1, 2, "zzzzzzzzzz");
			Ogrenci o5= t.createOgrenci(78, 45, "jjjjjjjjjjj");
			Ogrenci o6= t.createOgrenci(23, 8, "ttttttttttt");
			Ogrenci o7= t.createOgrenci(5, 34, "pppppppppppp");
			t.insert(o);
			t.insert(o1);
			t.insert(o2);
			t.insert(o3);
			t.insert(o4);
			t.insert(o5);
			t.insert(o6);
			t.insert(o7);
			
			
			
			t.delete(o4);
			
			
			
			
			t.print(t.root);
			
		  System.out.println("Minimum Numara:  "+t.min(t.root));
		  System.out.println("Maksimum Numara:  "+t.max(t.root));

		  
		  
		  System.out.println("Aranan ogrencinin adi: "+ t.search(t.root, 54));
			
		System.out.println("inOrder:");
		t.inOrder(t.root);
		
		System.out.println("postOrder:");
		t.postOrder(t.root);
		
		System.out.println("preOrder:");
		t.preOrder(t.root);
		  
		  
	   System.out.println("Level Order Traversal");
	   t.printLevelOrder(t.root);
		  
			
		}
	    
	    

}
