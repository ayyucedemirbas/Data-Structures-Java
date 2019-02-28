public class Maze {
	class Move {
	    int i, j; 
		
	    public Move(int i, int j) {
		this.i = i; 
		this.j = j;
	    }
	    public int i(){ 
	    	return i;
	    	}

	    public int j(){ 
	    	return j;
	    	}

	    public Move up() {
		return new Move(i-1, j);
	    }
	    public Move down() {
		return new Move(i+1, j);
	    }
	    public Move right() {
		return new Move(i, j+1);
	    }
	    public Move left() {
		return new Move(i, j-1);
	    }


	}

    
    private static char[][] maze = {
    		{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}, 
    		{'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
    		{' ', ' ', ' ', ' ', '#', ' ', '#', '#', ' ', '#'},
    		{'#', ' ', '#', '#', '#', ' ', '#', '#', ' ', '#'}, 
    		{'#', ' ', ' ', ' ', ' ', '#', '#', '#', ' ', '#'},
    		{'#', '#', '#', '#', ' ', '#', '#', '#', ' ', '#'},
    		{'#', '#', '#', '#', ' ', '#', '#', '#', ' ', '#'},
    		{'#', '#', ' ', '#', ' ', '#', '#', '#', 'S', '#'}, 
    		{'#', '#', ' ',' ', ' ', ' ', ' ', '#', '#','#'},  
    		{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
    	    };

    
    Maze(){
    	print();
    }
    
    private static int[][] visited=new int[maze.length][maze[0].length];
    
    
    
  static int sx = 7, sy = 8, ex = 2, ey = 0; 
  
  
  public char path (Move m, char value) {
  	char tmp = maze[m.i][m.j];
  	maze[m.i][m.j] = value;
  	return tmp;
  }

  
 
 
  static int sizex=maze.length, sizey=maze[0].length;

    
    public void print() {
    	
	for (int i=0; i<sizex; i++) {
	    for (int j=0; j<sizey; j++) {
		System.out.print(maze[i][j]+" ");
	    }
	    System.out.println();
	}
    }
   

    private boolean isInBounds(int x, int y) {
 		return x >= 0 && x < Maze.sizex && y >= 0 && y < Maze.sizey;
 	}
    
    
    public boolean isAvailable(Move m) {
    	
    	return (maze[m.i][m.j] != '#'&& visited[m.i][m.j]!=1);
    		
    	
       }
    
 
 
  
   boolean isFound( Move m) {
	return (m.i== ex && m.j == ey);
    }
    

  

    public void solve() {
		
	Stack<Move> stack = new Stack<Move>(); 
   
	stack.push(new Move(sx, sy)); 
	Move tmp, step;
	while (!stack.isEmpty()) {
		
	   
		tmp = stack.pop();
		    
	    if (isFound(tmp)) {
	    	break;
	    }

	   
	    path(tmp, '.');
	   
	    maze[sx][sy]='S';
	
	    step = tmp.up(); 
	    
	   if (isInBounds(step.i, step.j) && isAvailable(step)) { 
	    	stack.push(step);
	    	visited[step.i][step.j]=1;
	    	}
	    step = tmp.right(); 
	    if (isInBounds(step.i,step.j) && isAvailable(step)) {
	    	stack.push(step);
	    	visited[step.i][step.j]=1;
	    	}
	    step = tmp.left(); 
	    if (isInBounds(step.i,step.j) && isAvailable(step)) {
	    	stack.push(step);
	    	visited[step.i][step.j]=1;
	    	}
	    step= tmp.down(); 
	    if (isInBounds(step.i,step.j) && isAvailable(step)) {
	    	stack.push(step);
	    	visited[step.i][step.j]=1;
	    	}
	   
	    System.out.println();
	    System.out.println("x:"+step.i+"  y:"+step.j+" is visited");
	
	}
		
	System.out.println();
	if (!stack.isEmpty()) {
	    System.out.println("Solved!");
	    maze[ex][ey]='.';
	    }
	else { 
		System.out.println("Could not solved!");
		}
	System.out.println();
	print();



    }



    public static void main(String[] args) {
		
   	   Maze maze = new Maze();
    	maze.solve();
    	


    		
        }
   
   


}
