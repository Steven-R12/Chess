import java.util.Arrays;

public class GameState {
    public Player[] players;
    public Board board;
    private Player currentPlayer;

    public GameState() {
        this.board = new Board(true);
        this.players = new Player[2];
        this.players[0]= new Player(ChessColor.WHITE);
        this.players[1]= new Player(ChessColor.BLACK);
        this.currentPlayer = this.players[0];
    }
    public void switchCurrentPlayer() {
        if (this.currentPlayer.equals(this.players[0])) {
            this.currentPlayer = this.players[1];
        } else {
            this.currentPlayer = (this.players[0]);
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public boolean gameOver() {
        return false;
    }

}
