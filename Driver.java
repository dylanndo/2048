//Project: 2048
//Created by: Dylan Do
//Last modified: 04/01/2022
//Purpose: Move blocks on board based on user input  

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String userInput = "";
		
		System.out.println("WELCOME TO 2048!\nCONTROLS:\n w = up\ta = left\ts = down\td = right");
		
		Board board = new Board();
		
		do {
			board.resetBoard();
			do {
				
				board.printBoard();
				userInput = input.nextLine(); //accepts user input
				if(userInput.equals("w") == true) {
					if(board.up())
						board.newPiece();
				}
				
				else if(userInput.equals("a") == true) {
					if(board.left())
						board.newPiece();
				}
				
				else if(userInput.equals("s") == true) {
					if(board.down())
						board.newPiece();
				}
				
				else if(userInput.equals("d") == true) {
					if(board.right())
						board.newPiece();
				}
				
				if(board.hasWon() == true) {
					System.out.println("Congrats! You have won! Type continue to continue, or anything else to quit: ");
					userInput = input.nextLine().toLowerCase();
					if(!userInput.equals("continue"))
						break;
				}
				
				
			} while(board.movesLeft() == true);
			
			if(board.hasWon() == true)
				break;
				System.out.println("Game over! Type yes to play again, or anything else to quit: ");
			
			userInput = input.nextLine().toLowerCase();
		} while(userInput.equals("yes"));
	}

}
