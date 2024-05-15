public class Tile {

    public void pieceColor(){

    }

    Piece piece;

    public Tile () {
        this.piece = null;
    }

    public Tile(Piece piece){
    this.piece = piece;

    }

    public String toString() {
        if (piece != null) {
            return piece.toString();
        } else {
            return "   ";
        }
    }

    public boolean isOccupied() {
        return piece != null;  //Checks if the tile contains a piece
    }

    public void releasePiece(){
        piece = null;  // Removes the piece
    }

    public String getPieceString(){
        if(piece == null) {
            return "  ";
        }
        return piece.toString();
    }
    public void setPiece(Piece piece){
        this.piece = piece;    //Sets a piece to the tile
    }
    public Piece getPiece() {
        return piece;
    }
}
