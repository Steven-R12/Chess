public class Queen extends Piece {
    String pos;
    ChessColor color;

    public Queen(String pos, ChessColor color) {
        super(pos, color);
        if (color == ChessColor.WHITE) {
            this.uniCode = "♕";
        } else {
            this.uniCode = "♛";
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
        // Checks if it's diagonal
        boolean ifMoveIsDiagonal = Math.abs(newRow - curRow) == Math.abs(newCol - curCol);

        // Checks if its horizontal and vertical
        boolean ifHorizontalOrVertical = !(curRow != newRow && curCol != newCol);

        if (!ifMoveIsDiagonal && !ifHorizontalOrVertical){
            return false;
        }

        int step = 0;

        if (curRow != newRow) {
            if (curRow < newRow) {
                step = 1;
            } else {
                step = -1;
            }
            for (int i = curRow + step; i != newRow; i += step) {
                if (board[i][curCol].piece != null) {
                    return false;
                }
            }
        }
        if (curCol != newCol) {
            if (curCol < newCol) {
                step = 1;
            } else {
                step = -1;
            }
            for (int i = curCol + step; i != newCol; i += step) {
                if (board[i][curCol].piece != null) {
                    return false;
                }
            }
        }
        return true;
    }
}
