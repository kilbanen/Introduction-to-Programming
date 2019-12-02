public class Connect4Grid2DArray implements Connect4Grid {

    public void emptyGrid()
    {
        for(int row = 0; row < grid.length; row++)
        {
            for(int column = 0; column < grid[row].length; column++)
            {
                grid[row][column] = "0";
            }
        }
    }

    public String toString()
    {
        String printedGrid = "";
        for(int row = 0; row < grid.length; row++)
        {
            for(int column = 0; column < grid[row].length; column++)
            {
                printedGrid += grid[row][column];
            }
            printedGrid += "\n";
        }
        return printedGrid;
    }

    public boolean isValidColumn(int column)
    {
        if(0 <= column && column <= 6)
        {
            return true;
        }
        return false;
    }

    public boolean isColumnFull(int column)
    {
        if(grid[0][column].equals("0"))
        {
            return false;
        }
        return true;
    }

    public void dropPiece(ConnectPlayer player, int column)
    {
        for(int row = 5; row >= 0; row--)
        {
            if(grid[row][column].equals("0"))
            {
                grid[row][column] = player.getPiece();
                break;
            }
        }
    }

    public boolean didLastPieceConnect4()
    {
        for(int row = 0; row < grid.length; row++)
        {
            for(int column = 0; column < 4; column++)
            {
                if(!grid[row][column].equals("0") && grid[row][column].equals(grid[row][column + 1]) &&
                        grid[row][column].equals(grid[row][column + 2]) && grid[row][column].equals(grid[row][column + 3]))
                {
                    return true;
                }
            }
        }
        for(int row = 0; row < 3; row++)
        {
            for(int column = 0; column < grid[0].length; column++)
            {
                if (!grid[row][column].equals("0") && grid[row][column].equals(grid[row + 1][column]) &&
                        grid[row][column].equals(grid[row + 2][column]) && grid[row][column].equals(grid[row + 3][column]))
                {
                    return true;
                }
            }
            for(int column = 0; column < 4; column++)
            {
                if(!grid[row][column].equals("0") && grid[row][column].equals(grid[row+1][column+1]) &&
                        grid[row][column].equals(grid[row+2][column+2]) && grid[row][column].equals(grid[row+3][column+3]))
                {
                    return true;
                }
            }
            for(int column = 6; column > 2; column--)
            {
                if(!grid[row][column].equals("0") && grid[row][column].equals(grid[row+1][column-1]) &&
                        grid[row][column].equals(grid[row+2][column-2]) && grid[row][column].equals(grid[row+3][column-3]))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isGridFull()
    {
        for(int column = 0; column < grid[0].length; column++)
        {
            if(grid[0][column].equals("0"))
            {
                return false;
            }
        }
        return true;
    }


}
