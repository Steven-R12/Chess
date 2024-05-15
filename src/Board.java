public class Board {
    Tile[][] board;

    public Board() {
        this(true);
    }

    public Board(boolean fillBoard) {
        board = new Tile[8][8];
        for (int outer = 0; outer < 8; outer++) {
            for (int inner = 0; inner < 8; inner++) {
                this.board[outer][inner] = new Tile();
            }
        }
        if (fillBoard) {
            this.setNewBoard();
        }
    }

    //Graph the board
    public void setNewBoard() {

        this.board[0][0] = new Tile(new Rook("R1", ChessColor.WHITE));
        this.board[0][1] = new Tile(new Knight("KN1", ChessColor.WHITE));
        this.board[0][2] = new Tile(new Bishop("B1", ChessColor.WHITE));
        this.board[0][3] = new Tile(new King("K1", ChessColor.WHITE));
        this.board[0][4] = new Tile(new Queen("Q1", ChessColor.WHITE));
        this.board[0][5] = new Tile(new Bishop("B2", ChessColor.WHITE));
        this.board[0][6] = new Tile(new Knight("KN2", ChessColor.WHITE));
        this.board[0][7] = new Tile(new Rook("R2", ChessColor.WHITE));

        this.board[1][0] = new Tile(new Pawn("P1W", ChessColor.WHITE));
        this.board[1][1] = new Tile(new Pawn("P2W", ChessColor.WHITE));
        this.board[1][2] = new Tile(new Pawn("P3W", ChessColor.WHITE));
        this.board[1][3] = new Tile(new Pawn("P4W", ChessColor.WHITE));
        this.board[1][4] = new Tile(new Pawn("P5W", ChessColor.WHITE));
        this.board[1][5] = new Tile(new Pawn("P6W", ChessColor.WHITE));
        this.board[1][6] = new Tile(new Pawn("P7W", ChessColor.WHITE));
        this.board[1][7] = new Tile(new Pawn("P8W", ChessColor.WHITE));

        this.board[7][0] = new Tile(new Rook("R3", ChessColor.BLACK));
        this.board[7][1] = new Tile(new Knight("KN3", ChessColor.BLACK));
        this.board[7][2] = new Tile(new Bishop("B3", ChessColor.BLACK));
        this.board[7][3] = new Tile(new King("K2", ChessColor.BLACK));
        this.board[7][4] = new Tile(new Queen("Q2", ChessColor.BLACK));
        this.board[7][5] = new Tile(new Bishop("B4", ChessColor.BLACK));
        this.board[7][6] = new Tile(new Knight("KN4", ChessColor.BLACK));
        this.board[7][7] = new Tile(new Rook("R4", ChessColor.BLACK));

        this.board[6][0] = new Tile(new Pawn("P1B", ChessColor.BLACK));
        this.board[6][1] = new Tile(new Pawn("P2B", ChessColor.BLACK));
        this.board[6][2] = new Tile(new Pawn("P3B", ChessColor.BLACK));
        this.board[6][3] = new Tile(new Pawn("P4B", ChessColor.BLACK));
        this.board[6][4] = new Tile(new Pawn("P5B", ChessColor.BLACK));
        this.board[6][5] = new Tile(new Pawn("P6B", ChessColor.BLACK));
        this.board[6][6] = new Tile(new Pawn("P7B", ChessColor.BLACK));
        this.board[6][7] = new Tile(new Pawn("P8B", ChessColor.BLACK));


    }


    public void displayHelperThing(Tile[] tile) {
        System.out.printf("║ %s ║%s║%s ║%s ║ %s ║ %s ║ %s ║ %s ║ \n", tile[0], tile[1], tile[2], tile[3], tile[4], tile[5], tile[6], tile[7]);
    }

    public void Display() {
        System.out.print("      A      B      C      D      E      F      G      H \n");
        System.out.print("  ╔════╦════╦════╦════╦════╦════╦════╦════╗\n");


        for (int i = 0; i < board.length; i++) {
            System.out.print(i + 1 + " ");

            for (Tile tile : board[i]) {
                if (tile == null) {
                    System.out.print("║         ");
                } else {
                    System.out.printf("║    %s    ", tile);
                }
            }
            System.out.println("║");
            if (i == 7) {
                System.out.println("  ╚════╩════╩════╩════╩════╩════╩════╩════╝");
            } else {
                System.out.println("  ╠════╬════╬════╬════╬════╬════╬════╬════╣");
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();


        stringBuilder.append("      A      B      C      D      E      F      G      H \n");
        stringBuilder.append("  ╔════╦════╦════╦════╦════╦════╦════╦════╗\n");


        for (int i = 0; i < board.length; i++) {
            stringBuilder.append(i + 1).append(" ");

            for (Tile tile : board[i]) {
                if (tile == null) {
                    stringBuilder.append("║         ");
                } else {
                    stringBuilder.append("║    ").append(tile.getPieceString()).append("    ");
                }
            }
            stringBuilder.append("║\n");
            if (i == 7) {
                stringBuilder.append("  ╚════╩════╩════╩════╩════╩════╩════╩════╝");
            } else {
                stringBuilder.append("  ╠════╬════╬════╬════╬════╬════╬════╬════╣\n");
            }
        }
        return stringBuilder.toString();
    }


     public void capturePiece(Tile tile) {
        if (tile.isOccupied()) {
            tile.releasePiece();
        }
    }

    public void makeMove(Tile StartTile, Tile endTile) {
        if(endTile.isOccupied() && endTile.piece.getColor() != StartTile.piece.getColor()){
            capturePiece(endTile);
        }
        endTile.setPiece(StartTile.getPiece());
        StartTile.releasePiece();
    }

    public void makeMove(Move move){
        Tile tile1 = this.board[move.startY][move.startX];
        Tile tile2 = this.board[move.endY][move.endX];
        makeMove(tile1,tile2);
    }
}