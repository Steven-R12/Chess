import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestRook {

    @Test
    public void testValidMoveHorizontal() {
        Board board = new Board(false);
        Rook rook = new Rook("R1", ChessColor.WHITE);
        board.board[0][0] = new Tile(new Rook("R1",ChessColor.WHITE));
        board.Display();
        // Test move horizontally
        assertTrue(rook.validMove(board.board, 0, 0, 0, 3));
        assertFalse(rook.validMove(board.board, 0, 0, 1, 3));
        assertTrue(rook.validMove(board.board, 0, 0, 0, 7));
    }

    @Test
    public void testValidMoveVertical() {
        Board board = new Board(false);
        Rook rook = new Rook("R1", ChessColor.WHITE);
        board.board[0][0] = new Tile(new Rook("R1",ChessColor.WHITE));
        board.Display();
        // Test move vertically
        assertTrue(rook.validMove(board.board, 0, 0, 3, 0));
        assertFalse(rook.validMove(board.board, 0, 0, 3, 3)); // Invalid move (not vertical)
        assertTrue(rook.validMove(board.board, 0, 0, 7, 0));
    }

    @Test
    public void testValidMoveBlockedByAnotherPiece() {
        Board board = new Board();
        Rook rook = new Rook("R1", ChessColor.WHITE);
        board.Display();

        assertFalse(rook.validMove(board.board, 0, 0, 0, 5));//Blocked by someDude
    }

    @Test
    public void testValidMoveCaptureAnotherPiece() {
        Board board = new Board(false);
        Rook rook = new Rook("R1", ChessColor.WHITE);
        Rook rook3 = new Rook("R3", ChessColor.BLACK);
        board.board[0][7] = new Tile(new Rook("R3",ChessColor.BLACK));
        board.board[0][0]= new Tile(new Rook("R1",ChessColor.WHITE));
        board.Display();
        assertTrue(rook.validMove(board.board, 0, 0, 0, 7));
    }

    @Test
    public void testNotValidMoveCaptureAnotherPiece() {
        Board board = new Board(false);
        Rook rook = new Rook("R1", ChessColor.BLACK);
        Rook rook3 = new Rook("R3", ChessColor.BLACK);
        board.board[0][7] = new Tile(new Rook("R3",ChessColor.BLACK));
        board.board[0][0]= new Tile(new Rook("R1",ChessColor.BLACK));
        board.Display();
        assertFalse(rook.validMove(board.board, 0, 0, 0, 7));
    }

    @Test
    public void testValidMoveOutOfBounds() {
        Board board = new Board(false);
        Rook rook = new Rook("R1", ChessColor.WHITE);
        board.Display();

        assertFalse(rook.validMove(board.board, 0, 0, -1, 0));
        assertFalse(rook.validMove(board.board, 0, 0, 0, 8));
    }
}
