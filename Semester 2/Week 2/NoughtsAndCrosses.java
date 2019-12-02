/* SELF ASSESSMENT  
   1.  clearBoard:
Did I use the correct method definition?
Mark out of 5: 5
Comment: I used the correct method definition.
Did I use loops to set each position to the BLANK character?
Mark out of 5: 5
Comment: I used nested loops to set each position to the BLANK character.
   2.  printBoard
Did I use the correct method definition?
Mark out of 5: 5
Comment: I used the correct method definition.
Did I loop through the array and prints out the board in a way that it looked like a board?
Mark out of 5: 5
Comment: I looped through the array and printed out the board so that it looked like a square grid.
   3.  canMakeMove
Did I have the correct function definition and returned the correct item?
Mark out of 5: 5
Comment: I have the correct function definition and it returned a boolean.
Did I check if a specified location was BLANK?
Mark out of 5: 5
Comment: I checked that the specified location was BLANK.
   4.  makeMove
Did I have the correct function definition?
Mark out of 5: 5
Comment: I had the correct function definition.
Did I set the  currentPlayerPiece in the specified location?
Mark out of 5: 5
Comment: I set the currentPlayerPiece in the specified location.
   5.  isBoardFull
Did I have the correct function definition and returned the correct item?
Mark out of 5: 5
Comment: I had the correct function definition and it returned a boolean.
Did I loop through the board to check if there are any BLANK characters?
Mark out of 5: 5
Comment: I looped through the board to check for BLANK characters.
   6.  winner
Did I have the correct function definition and returned the winning character
Mark out of 5: 5
Comment: I have the correct function definition and it returned the winning character.
Did I identify all possible horizontal, vertical and diagonal winners  
Mark out of 15: 15
Comment: I identified all possible winning lines.
   7.main

Did I create a board of size 3 by 3 and use the clearBoard method to set all the positions to the BLANK character ('  ')?
Mark out of 3: 3
Comments: I created a 3 by 3 board and used clearBoard to set all positions to BLANK.
Did I loop asking the user for a location until wither the board was full or there was a winner?
Mark out of 5: 5
Comments: I kept asking for user input until the game was won or the board was full.
Did I call all of the methods above?
Mark out of 5: 5
Comments: I called all of the above functions.
Did I handle incorrect locations provided by the user (either occupied or invalid locations)?
Mark out of 3: 3
Comments: I handled invalid locations provided by the user.
Did I switch the current player piece from cross to nought and vice versa after every valid move?
Mark out of 3: 3
Comments: I switched the current player piece after every valid move.
Did I display the winning player piece or a draw at the end of the game?
Mark out of 3: 3
Comments:  I displayed the winning player if there was one, otherwise I displayed that there was a draw.

   8.  Overall
Is my code indented correctly?
Mark out of 3: 3
Comments: My code is indented correctly.
Do my variable names and Constants (at least four of them) make sense?
Mark out of 3: 3
Comments: My variable names and constants make sense.
Do my variable names, method names and class name follow the Java coding standard
Mark out of 2: 2
Comments: My names follow the coding standard.
      Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Scanner;

public class NoughtsAndCrosses {
	
	public static final int TOO_SMALL = -1;
	public static final int TOO_BIG = 3;
	public static final int FIRST = 0;
	public static final int SECOND = 1;
	public static final int THIRD = 2;

	public static void main(String[] args) {
		char[][] board = new char[3][3];
		int turnNumber = 1;
		int row;
		int column;
		char playerPiece;
		System.out.println("Welcome to Xs and Os. This game requires each player to type in the coordinates"
				+ " of the square where they want to play their piece.\nThere are three rows(0,1,2 from top to"
				+ " bottom), and three columns(0,1,2 from left to right). The first player to get three of "
				+ "their pieces in a row wins.");
		clearBoard(board);
		while(isBoardFull(board)==false)
		{
			if (turnNumber%2==0)
			{
				playerPiece = 'O';
			}
			else
			{
				playerPiece = 'X';
			}
			printBoard(board);
			System.out.println(playerPiece + ", what is your move? (row column)");
			Scanner inputScanner = new Scanner( System.in );
			try {
				row = inputScanner.nextInt();
				column = inputScanner.nextInt();
			}
			catch (Exception InputMismatchException)
			{
				row = TOO_SMALL;
				column = TOO_SMALL;
			}
			if (canMakeMove(board, row, column) == true)
			{
				makeMove(board, playerPiece, row, column);
				turnNumber++;
			}
			else
			{
				System.out.println("Invalid move.");
			}
			if (winner(board)!=' ')
			{
				System.out.println(winner(board) + " wins!");
				System.exit(0);
			}
		}
		System.out.print("The board is now full. This game has resulted in a draw.");

	}
	
	public static void clearBoard (char[][] board) {
		for(int row=FIRST; row<board.length; row++)
		{
			for(int column=FIRST; column<board[row].length; column++) {
				board[row][column] = ' ';
			}
		}
	}
	
	public static void printBoard (char[][] board) {
		for (int row=FIRST; row<board.length; row++)
		{
			for(int column=FIRST; column<board[row].length; column++)
			{
				System.out.print("[");
				System.out.print(board[row][column]);
				System.out.print("]");
			}
			System.out.println("");
		}
	}
	
	public static boolean canMakeMove (char[][] board, int row, int column) {
		if ((row>TOO_SMALL)&&(row<TOO_BIG)&&(column>TOO_SMALL)&&(column<TOO_BIG)&&(board[row][column]==' '))
		{
		return true;
		}
		return false;
	}
	
	public static void makeMove (char[][] board, char currentPlayerPiece , int row, int column) {
		board[row][column]=currentPlayerPiece;
	}
	
	public static boolean isBoardFull(char[][] board) {
		for(int row=FIRST; row<board.length; row++) 
		{
			for(int column=FIRST; column<board[row].length; column++)
			{
				if(board[row][column]==' ')
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static char winner ( char[][] board) {
		for(int row=FIRST; row<board.length; row++)
		{
			if((board[row][FIRST]==board[row][SECOND])&&(board[row][FIRST]==board[row][THIRD]))
			{
				return board[row][FIRST];
			}
		}
		for(int column=FIRST; column<board[FIRST].length; column++)
		{
			if((board[FIRST][column]==board[SECOND][column])&&(board[FIRST][column]==board[THIRD][column]))
			{
				return board[FIRST][column];
			}
		}
		if (((board[FIRST][FIRST]==board[SECOND][SECOND])&&(board[FIRST][FIRST]==board[THIRD][THIRD]))
			||((board[FIRST][THIRD]==board[SECOND][SECOND])&&(board[FIRST][THIRD]==board[THIRD][FIRST])))
		{
			return board[SECOND][SECOND];
		}
		return ' ';
	}

}
