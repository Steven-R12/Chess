import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestQueen {
    @Test
    public void testValidMoveDiagonal() {
        Board board = new Board(false);
        Queen queen = new Queen("Q1", ChessColor.WHITE);
        board.board[3][3] = new Tile(new Queen("Q1", ChessColor.WHITE));
        board.Display();
        assertTrue(queen.validMove(board.board, 3, 3, 6, 6)); //They are Diagonal
        assertTrue(queen.validMove(board.board, 3, 3, 0, 0));
        assertTrue(queen.validMove(board.board, 3, 3, 6, 0));
        assertTrue(queen.validMove(board.board, 3, 3, 0, 6));

        assertFalse(queen.validMove(board.board, 3, 3, 6, 4)); //They are not Diagonal
        assertFalse(queen.validMove(board.board, 3, 3, 7, 1));
    }

    @Test
    public void testValidMoveVertical() {
        Board board = new Board(false);
        Queen queen = new Queen("Q1", ChessColor.WHITE);
        board.board[3][3] = new Tile(new Queen("Q1", ChessColor.WHITE));
        board.Display();
        assertTrue(queen.validMove(board.board, 3, 3, 0, 3)); // Move vertically up
        assertTrue(queen.validMove(board.board, 3, 3, 7, 3)); // Move vertically down
    }

    @Test
    public void testValidMoveHorizontal() {
        Board board = new Board(false);
        Queen queen = new Queen("Q1", ChessColor.WHITE);
        board.board[3][3] = new Tile(new Queen("Q1", ChessColor.WHITE));
        board.Display();
        assertTrue(queen.validMove(board.board, 3, 3, 3, 0));//Move Horizontally
        assertTrue(queen.validMove(board.board, 3, 3, 3, 7));
    }
    @Test
    public void testValidMoveOutOfBounds(){
        Board board = new Board(false);
        Queen queen = new Queen("Q1", ChessColor.WHITE);
        board.board[3][3] = new Tile(new Queen("Q1", ChessColor.WHITE));
        board.Display();
        assertFalse(queen.validMove(board.board, 0, 0, -1, 0)); // Move off the board
        assertFalse(queen.validMove(board.board, 0, 0, 0, -1));
        assertFalse(queen.validMove(board.board, 7, 7, 8, 7));
        assertFalse(queen.validMove(board.board, 7, 7, 7, 8));
    }

    @Test
    public void testValidMoveCaptureAnotherPiece() {
        Board board = new Board(false);
        Queen queen = new Queen("Q1", ChessColor.WHITE);
        Pawn pawn = new Pawn("P1", ChessColor.BLACK);
        board.board[0][0] = new Tile(new Queen("Q1", ChessColor.WHITE));
        board.board[1][1]= new Tile(new Pawn("P1", ChessColor.BLACK));
        board.Display();

        assertTrue(queen.validMove(board.board, 0,0,1,1));
    }
    @Test
    public void testNotValidTakingAPawn() {
        Board board = new Board(false);
        Queen queen = new Queen("Q1", ChessColor.WHITE);
        Pawn pawn = new Pawn("P1", ChessColor.WHITE);
        board.board[0][0] = new Tile(new Queen("Q1", ChessColor.WHITE));
        board.board[1][1]= new Tile(new Pawn("P1", ChessColor.WHITE));
        board.Display();

        assertFalse(queen.validMove(board.board, 0,0,1,1));
    }
}
