//Project: 2048 (Block)
//Created by: Dylan Do
//Last modified: 04/01/2022
//Purpose: Block class, create block, methods to modify value

public class Block {
	
	private int val;	//block value
	private int x, y;	//coordinates
	
	public Block() {
		val = 0;
		x = 0;
		y = 0;
	}
	
	public int getVal() {
		return val;
	}
	
	public void setVal(int newVal) {
		val = newVal;
	}
	
	public void increase() {	//use when matching valued blocks collide
		val *= 2;
	}
	
	public void resetVal() {
		val = 0;
	}
	
	public void newVal(){
		if(Math.random() < 0.1)	//there is a 10% chance of getting a 4 as a new tile
			val = 4;
		else
			val = 2;
	}
	
	public void setCoordinates(int rows, int cols) {
		x = cols;
		y = rows;
	}
	
	public int getXCoordinate() {
		return x;
	}
	
	public int getYCoordinate() {
		return y;
	}
	
	public boolean matchingCoordinates(int x1, int y1) {
		if(x == x1 & y == y1)
			return true;
		return false;
	}

}



/*


	public boolean right() {
		changed = false;
		for(int rows = 0; rows < board.length; rows++)	// goes row by row
			for(int cols = board[0].length - 2; cols >= 0; cols--) {	//starts at second column from right, brings blocks right until it can't
				tempCols = cols;	//holds temporary Val of cols when moving blocks right
				while(tempCols < board.length - 1 && board[rows][tempCols + 1].getVal() == 0 && board[rows][tempCols].getVal() != 0) {
					board[rows][tempCols + 1].setVal(board[rows][tempCols].getVal());
					board[rows][tempCols].resetVal();
					tempCols++;
					changed = true;
				}
			}
		
		for(int rows = 0; rows < board.length; rows++)	//row by row
			for(int cols = board[0].length - 1; cols > 0; cols--)	//right to left
				if(board[rows][cols].getVal() == board[rows][cols - 1].getVal() && board[rows][cols].getVal() != 0) {	//if two blocks next to each other are equal
					board[rows][cols].increase();	//"combine"
					board[rows][cols - 1].resetVal();	//other block is empty
					changed = true;
				}
		
		for(int rows = 0; rows < board.length; rows++)	// goes row by row
			for(int cols = board[0].length - 2; cols >= 0; cols--) {	//starts at second column from right, brings blocks right until it can't
				tempCols = cols;	//holds temporary Val of cols when moving blocks right
				while(tempCols < board.length - 1 && board[rows][tempCols + 1].getVal() == 0 && board[rows][tempCols].getVal() != 0) {
					board[rows][tempCols + 1].setVal(board[rows][tempCols].getVal());
					board[rows][tempCols].resetVal();
					tempCols++;
					changed = true;
				}
			}
		return changed;
	}




 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 */
