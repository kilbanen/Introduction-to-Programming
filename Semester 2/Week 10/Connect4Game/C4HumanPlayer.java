import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer {
    C4HumanPlayer(String piece, String name)
    {
        super(piece, name);
    }

    @Override
    public int selectColumn(Connect4Grid grid)
    {
        System.out.println(getName() + ", please select a column to drop your counter (1-7).");
        Scanner inputScanner = new Scanner( System.in );
        int column;
        if(inputScanner.hasNextInt())
        {
            column = inputScanner.nextInt() - 1;
            if (grid.isValidColumn(column) && !grid.isColumnFull(column))
            {
                System.out.println(getName() + " has placed a counter in column " + (column + 1) + ".");
                return column;
            }
            else
            {
                System.out.println("You can't place a counter in column " + (column + 1) + ".");
                return selectColumn(grid);
            }
        }
        System.out.println("That is not a valid column.");
        return selectColumn(grid);
    }
}
