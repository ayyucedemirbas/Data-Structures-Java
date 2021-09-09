public class NQueens {
	static int size;
	static int solutions;
	
	public NQueens(int size) {
		// TODO Auto-generated constructor stub
		this.size=size;
		this.solutions=0;
		solve();
		
	}
	
	public static void solve() {
		int[] positions= new int[size];
		for(int i =0; i<size; i++) {
			positions[i]=-1;
			
		}
		put_queeen(positions,0);
		System.out.println("Found "+ solutions+" solutions");
	}

	private static void put_queeen(int[] positions, int target_row) {
		// TODO Auto-generated method stub
		if(target_row == size) {
			show_full_board(positions);
			solutions++;
		}
		else {
			for(int column=0; column< size; column++) {
				if(check_place(positions, target_row, column)) {
					positions[target_row] =column;
					put_queeen(positions, target_row+1);
				}
				
			}
		}
		
	}

	private static boolean check_place(int[] positions, int occupied_rows, int column) {
		// TODO Auto-generated method stub
		for(int i =0; i<occupied_rows; i++) {
			if(positions[i]==column || positions[i]-i==column - occupied_rows || positions[i] + i==column + occupied_rows ) {
				return false;
			}
		}
		
		return true;
	}

	private static void show_full_board(int[] positions) {
		// TODO Auto-generated method stub
		StringBuilder line = new StringBuilder();
		for(int row =0; row<size; row++) {
			for(int column =0; column<size; column++) {
				if(positions[row]==column) {
					line.append("Q ");
				}
				else {
					line.append(". ");
				}
			}
			System.out.print(line.toString());
			System.out.println();
			
		}
		//System.out.println();
		
	}
	
	public static void main(String[] args) {
		NQueens nq = new NQueens(4);
	}

}
