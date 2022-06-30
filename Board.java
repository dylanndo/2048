//Project: 2048 (Board)
//Created by: Dylan Do
//Last modified: 04/01/2022
//Purpose: Board class, create/reset board, methods for movement

public class Board {
	public Block[][] board;
	private int rows;
	private int cols;
	private int tempRows;
	private int tempCols;
	private static boolean changed;	//tells if the board changed; if true, spawn new piece
	private static boolean won;	//tells if the player has reached 2048 and won
	
	
	public Board(){
		board = new Block[4][4];
		won = false;
	}
	
	
	public Block[][] getBoard(){
		return board;
	}
	
	
	public void resetBoard() {
		for(rows = 0; rows < board.length; rows++)
			for(cols = 0; cols < board[0].length; cols++) {
				board[rows][cols] = new Block();
				board[rows][cols].setCoordinates(rows, cols);
			}
		
		int x1, y1, x2, y2;
		do {	//makes two coordinates for two starting tiles
		x1 = (int)(Math.random() * 4);  //x Val for first starting tile
		y1 = (int)(Math.random() * 4);  //y Val for first starting tile
	      
	    x2 = (int)(Math.random() * 4);  //x Val for second starting tile
	    y2 = (int)(Math.random() * 4);  //y Val for second starting tile
		} while(x1 == x2 && y1 == y2);	//while two coordinates are the same
		
		board[x1][y1].newVal();
		board[x2][y2].newVal();
	}
	
	public boolean hasWon() {
		return won;
	}
	
	/*
	public void setBoard(int[][] changedBoard) {
		for(rows = 0; rows < board.length - 1; rows++)
			for(cols = 0; cols < board[0].length - 1; cols++)
				board[rows][cols] = changedBoard[rows][cols];
	}
	*/
	
	
	public void newPiece() {
		
		int x, y;
		do {	//creates new coordinate
			
		x = (int)(Math.random() * 4);  //x Val for first starting tile
		y = (int)(Math.random() * 4);  //y Val for first starting tile

		} while(board[x][y].getVal() != 0);	//while space is already filled
		
		board[x][y].newVal();
	}
	

	public boolean up() {
		changed = false;
		for(cols = 0; cols < board[0].length; cols++)	// left to right
			for(rows = 1; rows < board.length; rows++) {	// starts at second row, brings blocks up until it can't
				tempRows = rows;	//holds temporary Val of rows when moving blocks up 
				while(tempRows > 0 && board[tempRows - 1][cols].getVal() == 0 && board[tempRows][cols].getVal() != 0) {	
					board[tempRows - 1][cols].setVal(board[tempRows][cols].getVal());
					board[tempRows][cols].resetVal();
					tempRows--;
					changed = true;
				}
			}
		
		for(cols = 0; cols < board[0].length; cols++)	//checks top to bottom, then next column
			for(rows = 0; rows < board.length - 1; rows++)
				if(board[rows][cols].getVal() == board[rows + 1][cols].getVal() && board[rows][cols].getVal() != 0) {	//if two blocks on top of each other are equal
					board[rows][cols].increase();	//"combine"
					board[rows + 1][cols].resetVal();;	//other block is empty
					changed = true;
					
					if(board[rows][cols].getVal() == 2048)	//if user has reached 2048, they won
						won = true;
				}
		
		for(cols = 0; cols < board[0].length; cols++)	// left to right
			for(rows = 1; rows < board.length; rows++) {	// starts at second row, brings blocks up until it can't
				tempRows = rows;	//holds temporary Val of rows when moving blocks up 
				while(tempRows > 0 && board[tempRows - 1][cols].getVal() == 0 && board[tempRows][cols].getVal() != 0) {	
					board[tempRows - 1][cols].setVal(board[tempRows][cols].getVal());
					board[tempRows][cols].resetVal();
					tempRows--;
					changed = true;
				}
			}	
		
		return changed;	//return true if the board changed, false if the board did not
	}
	
	public boolean left() {
		changed = false;
		for(rows = 0; rows < board.length; rows++)	// goes row by row
			for(cols = 1; cols < board[0].length; cols++) {	//starts at second column, brings blocks left until it can't
				tempCols = cols;	//holds temporary Val of cols when moving blocks left
				while(tempCols > 0 && board[rows][tempCols - 1].getVal() == 0 && board[rows][tempCols].getVal() != 0) {
					board[rows][tempCols - 1].setVal(board[rows][tempCols].getVal());
					board[rows][tempCols].resetVal();
					tempCols--;
					changed = true;
				}
			}
		
		for(rows = 0; rows < board.length; rows++)	//row by row
			for(cols = 0; cols < board[0].length - 1; cols++)	//left to right
				if(board[rows][cols].getVal() == board[rows][cols + 1].getVal() && board[rows][cols].getVal() != 0) {	//if two blocks next to each other are equal
					board[rows][cols].increase();	//"combine"
					board[rows][cols + 1].resetVal();	//other block is empty
					changed = true;
					
					if(board[rows][cols].getVal() == 2048)	//if user has reached 2048, they won
						won = true;
				}
		
		for(rows = 0; rows < board.length; rows++)	// goes row by row
			for(cols = 1; cols < board[0].length; cols++) {	//starts at second column, brings blocks left until it can't
				tempCols = cols;	//holds temporary Val of cols when moving blocks left
				while(tempCols > 0 && board[rows][tempCols - 1].getVal() == 0 && board[rows][tempCols].getVal() != 0) {
					board[rows][tempCols - 1].setVal(board[rows][tempCols].getVal());
					board[rows][tempCols].resetVal();
					tempCols--;
					changed = true;
				}
			}
		
		return changed;	//return true if the board changed, false if the board did not
	}
	
	
	public boolean down() {
		changed = false;
		for(cols = 0; cols < board[0].length; cols++)	// left to right
			for(rows = board.length - 2; rows >= 0; rows--) {	// starts at second row from bottom, brings blocks down until it can't
				tempRows = rows;	//holds temporary Val of rows when moving blocks down 
				while(tempRows < board.length - 1 && board[tempRows + 1][cols].getVal() == 0 && board[tempRows][cols].getVal() != 0) {	
					board[tempRows + 1][cols].setVal(board[tempRows][cols].getVal());
					board[tempRows][cols].resetVal();
					tempRows++;
					changed = true;
				}
			}
		
		for(cols = 0; cols < board[0].length; cols++)	//checks bottom to top, then next column
			for(rows = board.length - 1; rows > 0; rows--)
				if(board[rows][cols].getVal() == board[rows - 1][cols].getVal() && board[rows][cols].getVal() != 0) {	//if two blocks on top of each other are equal
					board[rows][cols].increase();	//"combine"
					board[rows - 1][cols].resetVal();	//other block is empty
					changed = true;
					
					if(board[rows][cols].getVal() == 2048)	//if user has reached 2048, they won
						won = true;
				}
		
		for(cols = 0; cols < board[0].length; cols++)	// left to right
			for(rows = board.length - 2; rows >= 0; rows--) {	// starts at second row from bottom, brings blocks down until it can't
				tempRows = rows;	//holds temporary Val of rows when moving blocks down 
				while(tempRows < board.length - 1 && board[tempRows + 1][cols].getVal() == 0 && board[tempRows][cols].getVal() != 0) {	
					board[tempRows + 1][cols].setVal(board[tempRows][cols].getVal());
					board[tempRows][cols].resetVal();
					tempRows++;
					changed = true;
				}
			}
		return changed;	//return true if the board changed, false if the board did not
	}
	
	public boolean right() {
		changed = false;
		for(rows = 0; rows < board.length; rows++)	// goes row by row
			for(cols = board[0].length - 2; cols >= 0; cols--) {	//starts at second column from right, brings blocks right until it can't
				tempCols = cols;	//holds temporary Val of cols when moving blocks right
				while(tempCols < board.length - 1 && board[rows][tempCols + 1].getVal() == 0 && board[rows][tempCols].getVal() != 0) {
					board[rows][tempCols + 1].setVal(board[rows][tempCols].getVal());
					board[rows][tempCols].resetVal();
					tempCols++;
					changed = true;
				}
			}
		
		for(rows = 0; rows < board.length; rows++)	//row by row
			for(cols = board[0].length - 1; cols > 0; cols--)	//right to left
				if(board[rows][cols].getVal() == board[rows][cols - 1].getVal() && board[rows][cols].getVal() != 0) {	//if two blocks next to each other are equal
					board[rows][cols].increase();	//"combine"
					board[rows][cols - 1].resetVal();	//other block is empty
					changed = true;
					
					if(board[rows][cols].getVal() == 2048)	//if user has reached 2048, they won
						won = true;
				}
		
		for(rows = 0; rows < board.length; rows++)	// goes row by row
			for(cols = board[0].length - 2; cols >= 0; cols--) {	//starts at second column from right, brings blocks right until it can't
				tempCols = cols;	//holds temporary Val of cols when moving blocks right
				while(tempCols < board.length - 1 && board[rows][tempCols + 1].getVal() == 0 && board[rows][tempCols].getVal() != 0) {
					board[rows][tempCols + 1].setVal(board[rows][tempCols].getVal());
					board[rows][tempCols].resetVal();
					tempCols++;
					changed = true;
				}
			}
		return changed;	//return true if the board changed, false if the board did not
	}
		
	
	public boolean movesLeft() {
		for(rows = 0; rows < board.length; rows++)	//checks for any black spaces
			for(cols = 0; cols < board[0].length; cols++)
				if(board[rows][cols].getVal() == 0)
					return true;
		
		for(rows = 0; rows < board.length - 1; rows++)	//checks every square pairs expect those assoc. with bottom right square
			for(cols = 0; cols < board[0].length - 1; cols++)
				if(board[rows][cols].getVal() == board[rows + 1][cols].getVal() || board[rows][cols].getVal() == board[rows][cols + 1].getVal())
					return true;
		
		if(board[3][3].getVal() == board[2][3].getVal() || board[3][3].getVal() == board[3][2].getVal())	//checks bottom right square
			return true;
		
		return false;			
	}
	
	public void printBoard() {
		for(rows = 0; rows < board.length; rows++)
        {
           for(cols = 0; cols < board.length; cols++)
              System.out.print(board[rows][cols].getVal() + "\t");
           System.out.println("\n");
        }
		System.out.println("\n");
	}
}
