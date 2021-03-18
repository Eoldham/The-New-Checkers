package cisc181.lab_5;

public abstract class Action {
    protected Game181H game;
    protected int fromRow;
    protected int fromColumn;
    protected int toRow;
    protected int toColumn;
    //Constructor that takes a Game181H and four integers
    public Action(Game181H game, int fromRow, int fromColumn, int rowOpponent,int columnOpponent){
        this.game = game;
        this.fromRow = fromRow;
        this.fromColumn = fromColumn;
        this.toRow = rowOpponent;
        this.toColumn = columnOpponent;
    }
    public Action(Game181H game, int fromRow, int fromColumn){
        this.game = game;
        this.fromRow = fromRow;
        this.fromColumn = fromColumn;
        this.toColumn=0;
        this.toRow=0;
    }
    //Checks if the from space is valid
    public boolean fromSpaceValid(){
        if (this.game.getBoard().inBounds(this.fromRow, this.fromColumn)){
            BoardSpace[][] spaces = this.game.getBoard().getSpaces();
            BoardSpace space = spaces[fromRow][fromColumn];
            if( this.game.getCurrentTeam().getTeamPieces().contains(space.getPiece())) {
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    //Checks if the to space is valid
    public boolean toSpaceValid(boolean empty){
        if (this.game.getBoard().inBounds(toRow,toColumn)){
            BoardSpace[][] spaces = this.game.getBoard().getSpaces();
            BoardSpace space = spaces[toRow][toColumn];
            if (space.isEmpty() == true && empty == true){
                return true;
            }
            else if(space.isEmpty() == false && empty == false && this.game.getOpponentTeam().getTeamPieces().contains(space.getPiece())){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    //Checks if the path assigned is valid for the piece
    public boolean validActionPath(){
        BoardSpace[][] spaces = this.game.getBoard().getSpaces();
        BoardSpace space = spaces[fromRow][fromColumn];
        if(space.getPiece().validPath(fromRow,fromColumn,toRow,toColumn)){
            return true;
        }
        else{
            return false;
        }
    }
    public abstract boolean validAction();
    public abstract void performAction();
}
