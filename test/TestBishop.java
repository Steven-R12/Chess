import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class TestBishop {

    @Test
    public void testValidMoveDiagonal(){
        Board board = new Board(false);
        Bishop bishop = new Bishop("B1", ChessColor.WHITE);
        board.board[0][2] = new Tile(new Bishop("B1",ChessColor.WHITE));
        board.Display();
        assertTrue(bishop.validMove(board.board, 0, 2, 1, 3));
        assertFalse(bishop.validMove(board.board, 0, 2, 1, 4));
        assertFalse(bishop.validMove(board.board,0,2,0,3)); // Should Fail Cuz Das horizontal
    }
    @Test
    public void testValidMoveBlockedByAnotherPiece() {
        Board board = new Board();
        Bishop bishop = new Bishop("B1", ChessColor.WHITE);
        board.Display();
        assertFalse(bishop.validMove(board.board, 0, 0, 5, 5)); // Blocked by some piece
    }

    @Test
    public void testValidMoveCaptureAnotherPiece() {
        Board board = new Board(false);
        Bishop bishop = new Bishop("B1", ChessColor.WHITE);
        Bishop bishop3 = new Bishop("B3", ChessColor.BLACK);
        board.board[0][0] = new Tile(new Bishop("B1",ChessColor.WHITE));
        board.board[7][7] = new Tile(new Bishop("B3",ChessColor.BLACK));
        board.Display();

        assertTrue(bishop.validMove(board.board, 0, 0, 7, 7));
    }

    @Test
    public void testValidMoveOutOfBounds() {
        Board board = new Board(false);
        Bishop bishop = new Bishop("B1", ChessColor.WHITE);
        board.Display();

        assertFalse(bishop.validMove(board.board, 0, 0, -1, -1));
        assertFalse(bishop.validMove(board.board, 0, 0, 8, 8));
    }

    @Test
    public void testNotValidTakingAPawn(){
        Board board = new Board(false);
        Bishop bishop = new Bishop("B1", ChessColor.WHITE);
        Pawn pawn = new Pawn("P1", ChessColor.BLACK);
        board.board[0][0] = new Tile(new Bishop("B1", ChessColor.WHITE));
        board.board[1][1]= new Tile(new Pawn("P1", ChessColor.WHITE));
        board.Display();

        assertFalse(bishop.validMove(board.board,0,0,1,1));

    }

}
