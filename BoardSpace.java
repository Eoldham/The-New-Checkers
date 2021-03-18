package cisc181.lab_5;

public class BoardSpace {
    private int row;
    private int column;
    private String spaceColor;
    private boolean empty;
    private Piece piece;
    private boolean coin;
    //Constructor that takes two ints and a String
    public BoardSpace(int row, int column, String color){
        this.row = row;
        this.column = column;
        this.spaceColor = color;
        this.empty = true;
        this.coin = false;
    }
    //Getter that returns the row of a space
    public int getRow(){
        return this.row;
    }
    //Getter that returns the column of a space
    public int getColumn(){
        return this.column;
    }
    //Getter that returns a Piece on a space
    public Piece getPiece(){
        return this.piece;
    }
    //Getter that returns a space's color
    public String getSpaceColor(){
        return this.spaceColor;
    }
    //Getter that returns if a space is empty
    public boolean isEmpty(){
        return this.empty;
    }
    //Puts a piece on a space
    public void setPiece(Piece piece){
        this.piece = piece;
        this.empty = false;
    }
    public void setCoin(boolean x){
        this.coin = x;
    }
    public boolean getCoin(){
        return this.coin;
    }
    //Removes a piece from a space and returns that piece
    public Piece removePiece(){
        Piece piece = this.piece;
        this.piece = null;
        this.empty = true;
        return piece;
    }
    @Override
    public String toString(){
        if (this.piece == null){
            return "------";
        }
        else{
            return this.piece.toString();
        }
    }
}
