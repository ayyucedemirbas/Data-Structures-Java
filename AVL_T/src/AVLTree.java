public class AVLTree {
	
	Node root;
	
	class Musteri{
		int id;
		String ad;
		double borc;
		Musteri(int id, String ad, double borc){
			this.id=id;
			this.ad=ad;
			this.borc=borc;
		}
	}
	
	
	Musteri createMusteri(int id, String ad, double borc) {
		Musteri m=new Musteri(id,ad,borc);
		return m;
	}
	
	class Node{
		Musteri m;
		Node left, right;
		int height;
		Node(Musteri m){
			this.m=m;
			left=null;
			right=null;
			height = 1;
		}
		
	}
	
	
	
	
	 int height(Node N) { 
	        if (N == null) {
	            return 0; 
	        }
	        return N.height; 
	    } 
	 
	  int max(int a, int b) { 
	        return (a > b) ? a : b; 
	    } 
	 
	 Node rightRotate(Node y) { 
	        Node x = y.left; 
	        Node T2 = x.right; 
	  
	    
	        x.right = y; 
	        y.left = T2; 

	        y.height = max(height(y.left), height(y.right)) + 1; 
	        x.height = max(height(x.left), height(x.right)) + 1; 
	
	        return x; 
	    } 
	 
	 Node leftRotate(Node x) { 
	        Node y = x.right; 
	        Node T2 = y.left; 
	  

	        y.left = x; 
	        x.right = T2; 
	  
	
	        x.height = max(height(x.left), height(x.right)) + 1; 
	        y.height = max(height(y.left), height(y.right)) + 1; 
	  
	  
	        return y; 
	    } 
	  
	    
	    int getBalance(Node N) { 
	        if (N == null) 
	            return 0; 
	  
	        return height(N.left) - height(N.right); 
	    } 
	    
	    Node insert(Node node, Musteri m) { 
	    	  
	        if (node == null) 
	            return (new Node(m)); 
	  
	        if (m.id < node.m.id) {
	            node.left = insert(node.left, m); 
	        }
	        else if (m.id > node.m.id) {
	            node.right = insert(node.right, m); 
	        }
	        else { 
	            return node; 
	        }
	     
	        node.height = 1 + max(height(node.left), height(node.right)); 
	  
	     
	        int balance = getBalance(node); 
	  
	   
	        if (balance > 1 && m.id < node.left.m.id) {
	            return rightRotate(node); 
	        }
	 
	        if (balance < -1 && m.id > node.right.m.id) {
	            return leftRotate(node); 
	        }

	        if (balance > 1 && m.id > node.left.m.id) { 
	            node.left = leftRotate(node.left); 
	            return rightRotate(node); 
	        } 

	        if (balance < -1 && m.id < node.right.m.id) { 
	            node.right = rightRotate(node.right); 
	            return leftRotate(node); 
	        } 
	  
	  
	        return node; 
	    } 
	
	    void preOrder(Node node) { 
	        if (node != null) { 
	            System.out.println("Musteri ID: "+ node.m.id + "  Musteri Ismi:  "+node.m.ad+ " Musteri borcu:  "+node.m.borc+"  "); 
	            preOrder(node.left); 
	            preOrder(node.right); 
	        } 
	    } 
	    void inOrder(Node node) { 
	        if (node != null) { 
	           
	            inOrder(node.left); 
	            System.out.println("Musteri ID: "+ node.m.id + "  Musteri Ismi:  "+node.m.ad+ " Musteri borcu:  "+node.m.borc+"  ");
	            inOrder(node.right); 
	        } 
	    } 
	    void postOrder(Node node) { 
	        if (node != null) { 
	             
	            postOrder(node.left); 
	            postOrder(node.right); 
	            System.out.println("Musteri ID: "+ node.m.id + "  Musteri Ismi:  "+node.m.ad+ " Musteri borcu:  "+node.m.borc+"  ");
	        } 
	    } 
	   
	    
	    void printLevelOrder(Node r)   { 
	        Queue<Node> queue = new Queue<Node>(); 
	        queue.add(r); 
	        while (!queue.isEmpty())  { 
	            Node n = queue.poll(); 
	            System.out.println("Musteri ID "+  n.m.id + "  Musteri Ismi: " +n.m.ad+ " Musteri borcu: "+ n.m.borc); 
	  
	            
	            if (n.left != null) { 
	                queue.add(n.left); 
	            } 
	            if (n.right != null) { 
	                queue.add(n.right); 
	            } 
	        } 
	    } 
	    Node prev;
	
	    boolean isBST(Node node) { 
	        if (node != null)  { 
	            if (!isBST(node.left)) 
	                return false; 
	  
	            if (prev != null && node.m.id <= prev.m.id ) 
	                return false; 
	            prev = node; 
	            return isBST(node.right); 
	        } 
	        return true; 
	    } 
	    
	    private void borclar(Node p, int data){
	        if(p == null){
	            return;
	        }
	        else{
	            if(p.m.borc >= data){
	                System.out.println("Musteri ID "+  p.m.id + "  Musteri Ismi: " +p.m.ad+ " Musteri borcu: "+ p.m.borc);
	            }
	            borclar(p.left, data);
	            borclar(p.right, data);
	        }
	    }
	    
	    Queue<Node> queue1 = new Queue<Node>(); 
	    
	    void Ekle(Node r)   { 
	        
	        if(r!=null) {
	        	queue1.add(r);
	        	Ekle(r.left);
	        	Ekle(r.right);
	        	
	        }
	        
	        
	    } 
	    
	    void yaz() {
	    	while(!queue1.isEmpty()) {
	    		System.out.println(queue1.poll().m.ad);
	    	}
	    	
	    }
	   Node EnYuksekBorc() {
	    	Node n=null ;
	    	Node max=queue1.poll();
	    	while(!queue1.isEmpty()) {
	    		
	    	    if(queue1.poll().m.borc > max.m.borc){
	    		max=queue1.poll();
	    		n=max;
	    	}
	    	}
	    	return n;
	    	
	    }
	    
	    
	    
	    
	    
	    static Node yeni;
	    static Node findMax(Node node) 
	    { 
	        if (node == null) 
	            return node; 
	  
	        Node res = node; 
	        Node lres = findMax(res.left); 
	        Node rres = findMax(res.right); 
	  
	        if (lres.m.borc > res.m.borc) 
	            res.m.borc = lres.m.borc; 
	        if (rres.m.borc > res.m.borc) 
	            res.m.borc = rres.m.borc; 
	        
	        
	        
	        
	       return res; 
	    } 
	    
	    
	    
	    public static void main(String[] args) {
			AVLTree t= new AVLTree();
			Musteri m= t.createMusteri(14, "q", 20);
			Musteri m1= t.createMusteri(17, "w", 20);
			Musteri m2= t.createMusteri(11, "t", 50);
			Musteri m3= t.createMusteri(7, "r", 10);
			Musteri m4= t.createMusteri(53, "t", 10);
			Musteri m5= t.createMusteri(4, "e", 50);
			Musteri m6= t.createMusteri(13, "u", 30);
			Musteri m7= t.createMusteri(12, "o", 40);
			Musteri m8= t.createMusteri(8, "y", 70);
			
			
			
			t.root=	t.insert(t.root, m);
			t.root=	t.insert(t.root, m1);
			t.root=	t.insert(t.root, m2);
			t.root=	t.insert(t.root, m3);
			t.root=	t.insert(t.root, m4);
			t.root=	t.insert(t.root, m5);
			t.root=t.insert(t.root, m6);
			t.root=	t.insert(t.root, m7);
			t.root=t.insert(t.root, m8);
			
			
			/*System.out.println("Preorder: ");
			t.preOrder(t.root);
			
			System.out.println("ineorder: ");
			t.inOrder(t.root);
			
			
			
			System.out.println("postorder: ");
			t.postOrder(t.root);
			
			System.out.println("Level Order: ");
			t.printLevelOrder(t.root);
			
			System.out.println("is a binary search tree: " + t.isBST(t.root));
			System.out.println("Borcu 35 TL'den yuksek olan musteriler: ");
			t.borclar(t.root, 35);*/
			
			t.Ekle(t.root);
			//t.yaz();
			Node max= t.EnYuksekBorc();
			System.out.println(max.m.borc);
			
			
			//Node yeni= t.enYuksekBorc(t.root, t.root.m.borc);
			
			//Node yeni=t.enYuksekBorc(t.root);
			
			//System.out.println(yeni.m.borc);
		}
	    
	    
	    
}
