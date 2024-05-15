public class King extends Piece {
    String pos;
    ChessColor color;

    public King(String pos, ChessColor color) {
        super(pos, color);
        if (color == ChessColor.WHITE) {
            this.uniCode = "♔";
        } else {
            this.uniCode = "♚";
        }
    }


    public boolean validMove(Tile[][] board, int curRow, int curCol, int newRow, int newCol) {
        if (newRow < 0 || newCol < 0 || newRow > 7 || newCol > 7) {
            return false;
        }
        Tile StartTile = board[curRow][curCol];
        Tile endTile = board[newRow][newCol];


        if (endTile.isOccupied() && endTile.piece.getColor() == StartTile.piece.getColor()) {
            return false;
        } else if (curRow + 1 == newRow && curCol - 1 == newCol) {
            return true;
        } else if (curRow == newRow && curCol - 1 == newCol) {
            return true;
        } else if (curRow - 1 == newRow && curCol - 1 == newCol) {
            return true;
        } else if (curRow - 1 == newRow && curCol == newCol) {
            return true;
        } else if (curRow - 1 == newRow && curCol + 1 == newCol) {
            return true;
        } else if (curRow == newRow && curCol + 1 == newCol) {
            return true;
        } else if (curRow + 1 == newRow && curCol + 1 == newCol) {
            return true;
        } else return curRow + 1 == newRow && curCol == newCol;
    }
}
