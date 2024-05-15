import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestPawn {

    @Test
    public void testValidMoveForWhitePawn(){
        Board board = new Board(false);
        Pawn pawn = new Pawn("P1", ChessColor.WHITE);
        board.board[6][2] = new Tile(new Pawn("P1", ChessColor.WHITE));
        board.Display();
        assertTrue(pawn.validMove(board.board,6,2,7,2));
        assertTrue(pawn.validMove(board.board,6,3,7,3));
    }
    @Test
    public void testValidMoveForCapture_WhitePawn(){
        Board board = new Board(false);
        Pawn pawn = new Pawn("P1", ChessColor.WHITE);
        board.board[6][2] = new Tile(new Pawn("P1", ChessColor.WHITE));
        Pawn pawn2 = new Pawn("P2", ChessColor.BLACK);
        board.board[7][3] = new Tile(new Pawn("P2", ChessColor.BLACK));
        board.Display();

        assertTrue(pawn.validMove(board.board, 6,2,7,3));
    }

    @Test
    public void testValidMoveForBlackPawn(){
        Board board = new Board(false);
        Pawn pawn = new Pawn("P1", ChessColor.BLACK);
        board.board[1][2] = new Tile(new Pawn("P1", ChessColor.BLACK));
        board.Display();
        assertTrue(pawn.validMove(board.board, 1, 2, 0, 2));
        assertTrue(pawn.validMove(board.board, 3, 3, 2, 3));
    }

    @Test
    public void testNotValidMoveForBlackPawn(){
        Board board = new Board(false);
        Pawn pawn = new Pawn("P1", ChessColor.BLACK);
        board.board[1][2] = new Tile(new Pawn("P1", ChessColor.BLACK));
        board.Display();
        assertFalse(pawn.validMove(board.board, 1, 2, 3, 2));
    }


    @Test
    public void testNotValidMoveForWhitePawn() {
        Board board = new Board(false);
        Pawn pawn = new Pawn("P1", ChessColor.WHITE);
        board.board[6][2] = new Tile(new Pawn("P1", ChessColor.WHITE));
        board.Display();
        assertFalse(pawn.validMove(board.board, 6, 2, 4, 2));
    }
}
