public abstract class ConnectPlayer {
    private String piece;
    private String name;
    ConnectPlayer(String piece, String name)
    {
        this.piece = piece;
        this.name = name;
    }

    public String getPiece()
    {
        return piece;
    }

    public String getName()
    {
        return name;
    }

    public abstract int selectColumn(Connect4Grid grid);
}
