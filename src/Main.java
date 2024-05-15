public class Main {
    public static void main(String[] args) {
        GameState game = new GameState();
        while (true){
            game.board.Display();
            Move makeMove;

            while (true) {
                if (game.getCurrentPlayer().color == ChessColor.WHITE){
                    System.out.println("Whites turn!");
                }
                if (game.getCurrentPlayer().color == ChessColor.BLACK){
                    System.out.println("Blacks turn!");
                }
                makeMove = game.getCurrentPlayer().getMove();
                Piece piece= game.board.board[makeMove.startY][makeMove.startX].piece;

                if (piece == null){
                    System.out.println("There's ne piece there CUH!");
                    continue;
                }
                if (game.getCurrentPlayer().color != piece.color ) {
                    System.out.println("Its not your turn Foo!");
                    continue;
                }
                if (makeMove.startY == makeMove.endY && makeMove.startX == makeMove.endX){
                    System.out.println("Please move the piece to a different end location");
                    continue;
                }
                if (piece.validMove(game.board.board, makeMove.startY, makeMove.startX, makeMove.endY, makeMove.endX)){
                    break;
                } else {
                    System.out.println("Please input a valid move according to rules of each chess piece");
                }
            }
            game.board.makeMove(makeMove);
            game.switchCurrentPlayer();

        }

    }
}
