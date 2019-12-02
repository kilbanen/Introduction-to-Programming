import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer{
    C4RandomAIPlayer(String piece, String name)
    {
        super(piece, name);
    }

    @Override
    public int selectColumn(Connect4Grid grid)
    {
        Random generator = new Random();
        int column = generator.nextInt(7);
        if(grid.isValidColumn(column) && !grid.isColumnFull(column))
        {
            System.out.println(getName() + " has placed a counter in column " + (column + 1) + ".");
            return column;
        }
        System.out.println("You can't place a counter in column " + (column + 1) + ".");
        return selectColumn(grid);
    }
}
