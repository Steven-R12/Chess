import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TestKnight {
    @Test
    public void testValidMoveTrue() {
        Board board = new Board(false);
        Knight knight = new Knight("K1", ChessColor.WHITE);
        board.board[3][3] = new Tile(new Knight("K1", ChessColor.WHITE));
        board.Display();
        assertTrue(knight.validMove(board.board, 3, 3, 1, 2));
        assertTrue(knight.validMove(board.board, 3, 3, 1, 4));

        assertTrue(knight.validMove(board.board, 3, 3, 5, 2));
        assertTrue(knight.validMove(board.board, 3, 3, 5, 4));

        assertTrue(knight.validMove(board.board, 3, 3, 2, 5));
        assertTrue(knight.validMove(board.board, 3, 3, 4, 5));

        assertTrue(knight.validMove(board.board, 3, 3, 2, 1));
        assertTrue(knight.validMove(board.board, 3, 3, 4, 1));
    }

    @Test
    public void testValidMoveFalse() {
        Board board = new Board(false);
        Knight knight = new Knight("K1", ChessColor.WHITE);
        board.board[3][3] = new Tile(new Knight("K1", ChessColor.WHITE));
        board.Display();
        assertFalse(knight.validMove(board.board, 3, 3, 5, 1));
        assertFalse(knight.validMove(board.board, 3,3,2,7));
    }
    @Test
    public void testValidMoveOutOfBounds() {
        Board board = new Board(false);
        Knight knight = new Knight("K1", ChessColor.WHITE);
        board.board[3][3] = new Tile(new Knight("K1", ChessColor.WHITE));
        board.Display();
        assertFalse(knight.validMove(board.board, 3, 3, 0, -1));
    }
    @Test
    public void testValidMoveCaptureAnotherPiece() {
        Board board = new Board(false);
        Knight knight = new Knight("KN1", ChessColor.WHITE);
        Bishop bishop = new Bishop("B3", ChessColor.BLACK);
        board.board[0][0] = new Tile(new Knight("KN1",ChessColor.WHITE));
        board.board[2][1] = new Tile(new Bishop("B3",ChessColor.BLACK));
        board.Display();

        assertTrue(knight.validMove(board.board, 0, 0, 2, 1));
    }

    @Test
    public void testInvalidMoveNotCaptureAnotherPiece(){
        Board board = new Board(false);
        Knight knight = new Knight("KN1", ChessColor.WHITE);
        Bishop bishop = new Bishop("B3", ChessColor.WHITE);
        board.board[0][0] = new Tile(new Knight("KN1",ChessColor.WHITE));
        board.board[2][1] = new Tile(new Bishop("B3",ChessColor.WHITE));
        board.Display();

        assertFalse(knight.validMove(board.board, 0, 0, 2, 1));
    }
}
