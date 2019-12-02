public interface Connect4Grid {
    public String[][] grid = new String[6][7];
    public void emptyGrid();
    public String toString();
    public boolean isValidColumn(int column);
    public boolean isColumnFull(int column);
    public void dropPiece(ConnectPlayer player, int column);
    public boolean didLastPieceConnect4();
    public boolean isGridFull();
}
