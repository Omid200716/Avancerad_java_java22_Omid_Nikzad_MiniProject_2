package board;

public class Board {
	private char[][]grid;

	
	
	
	public Board() {
		grid = new char[3][3];
		for(int i =0; i<3; i++) {
			for( int j=0; j<3; j++) {
				grid[i][j] = ' ';
			}
		}
		
	}
	
	
	
	public void displayGrid() {
		int cellNumber = 1;
		 for (int i = 0; i < 3; i++) {
		        for (int j = 0; j < 3; j++) {
		            if (grid[i][j] == ' ') {
		                System.out.print(cellNumber + "|");
		            } else {
		                System.out.print(grid[i][j] + "|");
		            }
		            cellNumber++;
		        }
		        System.out.println();
		        System.out.println("------");
		    }
		
	}
	
	

	
	
	public boolean checkDraw() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(grid[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
		
		
	}
	
	public boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) {
                return true;
            }
            if (grid[0][i] == player && grid[1][i] == player && grid[2][i] == player) {
                return true;
            }
        }
        if (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) {
            return true;
        }
        if (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player) {
            return true;
        }
        return false;
    }



	public boolean isGameOver() {
		
		return checkWin('X') || checkWin('O') || checkDraw();
	}



	public char[][] getGrid() {
		
		return grid;
	}



	public void placeMark(int i, int j, char mark) {
		if(grid[i][j] == ' ') {
			grid[i][j] = mark;
			
			

		}
		
	}
	
	public void resetBoard() {
	    for(int i = 0; i < 3; i++) {
	        for(int j = 0; j < 3; j++) {
	            grid[i][j] = ' ';
	        }
	    }
	}

}
