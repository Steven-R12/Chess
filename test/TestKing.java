import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestKing {
    @Test
    public void testValidMoveTrue() {
        Board board = new Board(false);
        King king = new King("K1", ChessColor.WHITE);
        board.board[1][4] = new Tile(new King("K1", ChessColor.WHITE));
        board.Display();
        assertTrue(king.validMove(board.board, 1, 4, 2, 3));
        assertTrue(king.validMove(board.board, 1, 4, 1, 3));

        assertTrue(king.validMove(board.board, 1, 4, 0, 3));
        assertTrue(king.validMove(board.board, 1, 4, 0, 4));

        assertTrue(king.validMove(board.board, 1, 4, 0, 5));
        assertTrue(king.validMove(board.board, 1, 4, 1, 5));

        assertTrue(king.validMove(board.board, 1, 4, 2, 5));
        assertTrue(king.validMove(board.board, 1, 4, 2, 4));
    }

    @Test
    public void testNotValidMove() {
        Board board = new Board(false);
        King king = new King("K1", ChessColor.WHITE);
        board.board[1][4] = new Tile(new King("K1", ChessColor.WHITE));
        board.Display();
        assertFalse(king.validMove(board.board, 1, 4, 0, 0));
        assertFalse(king.validMove(board.board, 1, 4, 6, 7));

        assertFalse(king.validMove(board.board, 1, 4, 0, 6));
    }

    @Test
    public void testNotValidMoveOutOfBounds() {
        Board board = new Board(false);
        King king = new King("K1", ChessColor.WHITE);
        board.Display();

        assertFalse(king.validMove(board.board, 0, 0, -1, -1));
        assertFalse(king.validMove(board.board, 7, 7, 8, 8));
    }

    @Test
    public void testValidMoveCaptureAnotherPiece() {
        Board board = new Board(false);
        King king = new King("K1", ChessColor.WHITE);
        Bishop bishop = new Bishop("B1", ChessColor.BLACK);
        board.board[0][0] = new Tile(new King("K1", ChessColor.WHITE));
        board.board[0][1] = new Tile(new Bishop("B1", ChessColor.BLACK));
        board.Display();

        assertTrue(king.validMove(board.board, 0, 0, 0, 1));
    }

    @Test
    public void testInvalidMoveDoesNotCapturePiece() {
        Board board = new Board(false);
        King king = new King("K1", ChessColor.WHITE);
        Bishop bishop = new Bishop("B1", ChessColor.WHITE);
        board.board[0][0] = new Tile(new King("K1", ChessColor.WHITE));
        board.board[0][1] = new Tile(new Bishop("B1", ChessColor.WHITE));
        board.Display();

        assertFalse(king.validMove(board.board, 0, 0, 0, 1));
    }
}
