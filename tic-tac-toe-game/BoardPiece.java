package model; 

public class BoardPiece {
    private char piece;
    
    public BoardPiece(char piece) {
        
        if (piece != 'X' && piece != 'O' && piece != ' '){
            throw new IllegalArgumentException("Piece is not X, Y, or a space. Re-program to be X, Y, or space only.");
        }
        this.piece = piece;
    }
    
    public void setPiece(char piece) {
        if (piece != 'X' && piece != 'O' && piece != ' '){
            throw new IllegalArgumentException("Piece is not X, Y, or a space. Re-program to be X, Y, or space only.");
        }
        this.piece = piece;
    }
    
    public char getPiece() {
        return piece;
    }
}