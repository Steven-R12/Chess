public abstract class Piece {
    String id;
    ChessColor color;
    String uniCode;
    public String toString(){
        return uniCode;
    }
    public Piece(String id, ChessColor color){
        this.id = id;
        this.color= color;

    }

    public ChessColor getColor() {
        return color;
    }
    public abstract boolean validMove(Tile[][] board, int curRow, int curCol, int newRow, int newCol);
}
