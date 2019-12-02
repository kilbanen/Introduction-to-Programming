
/* SELF ASSESSMENT

Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win.
Comment: My class does all of these things. (35/35)

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment: I define the 7 methods within my Connect4Grid interface. (10/10)

Connect4Grid2DArray class (25 marks)
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment: My class does all of these things. (25/25)

ConnectPlayer abstract class (10 marks)
My class provides at lest one non-abstract method and at least one abstract method.
Comment: My class provides two non-abstract methods and one abstract method. (10/10)

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides the Human player functionality.
Comment: My class extends ConnectPlayer and overrides the abstract method. It provides human player functionality. (10/10)

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides AI player functionality.
Comment: My class extends ConnectPlayer and overrides the abstract method. It provides AI player functionality. (10/10)

Total Marks out of 100:100

*/

import java.util.Scanner;

public class Connect4Game {
    public static void main(String[] args)
    {
        System.out.println("Would you like to play a game of Connect Four? (type 'yes' if you want to play)");
        Scanner inputScanner = new Scanner(System.in);
        String input = inputScanner.next();
        while(input.equals("yes"))
        {
            Connect4Grid grid = new Connect4Grid2DArray();
            grid.emptyGrid();
            System.out.println(grid.toString());
            System.out.println("Enter your name:");
            inputScanner = new Scanner(System.in);
            String playerName = inputScanner.next();
            ConnectPlayer player1 = new C4HumanPlayer("R", playerName);
            ConnectPlayer player2 = new C4RandomAIPlayer("Y", "Computer");
            ConnectPlayer currentPlayer = player1;
            while(true)
            {
                int column = currentPlayer.selectColumn(grid);
                grid.dropPiece(currentPlayer, column);
                System.out.println(grid.toString());
                if(grid.didLastPieceConnect4())
                {
                    System.out.println(currentPlayer.getName() + " wins!");
                    break;
                }
                if(grid.isGridFull())
                {
                    System.out.println("The grid is full.");
                    break;
                }
                if (currentPlayer == player1)
                {
                    currentPlayer = player2;
                }
                else {
                    currentPlayer = player1;
                }
            }
            System.out.println("Would you like to play again?");
            inputScanner = new Scanner(System.in);
            input = inputScanner.next();
        }
        System.out.println("Thank you for playing!");
    }
}
