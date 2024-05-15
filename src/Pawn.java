public class Pawn extends Piece {
    String pos;
    ChessColor color;

    public Pawn(String pos, ChessColor color) {
        super(pos, color);
        this.color = color;
        if (color == ChessColor.WHITE) {
            this.uniCode = "♙";
        } else {
            this.uniCode = "♟";
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
        }

        int step = 0;
        if (color == ChessColor.WHITE) {
            step = 1;
        } else {
            step = -1;
        }

        if (curCol == newCol && board[newRow][newCol].piece == null && newRow == curRow + step) {
            return true;
        } else if (curCol == newCol && board[newRow][newCol].piece == null && newRow == curRow + 2 * step &&
                (curRow == 1 || curRow == 6)) {
            if (board[curRow + step][curCol].piece == null) {
                return true;
            }
        } else if (Math.abs(newCol - curCol) == 1 && newRow == curRow + step &&
                board[newRow][newCol].piece != null &&
                board[newRow][newCol].piece.color != this.color) {
            return true;
        }
          return false;
    }
}
