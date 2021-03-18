package cisc181.lab_5;

public class ActionMove extends Action {
    //Constructor that takes a Game181H and four integeres
    public ActionMove(Game181H game, int fromRow, int fromColumn, int toRow, int toColumn){
        super(game,fromRow,fromColumn,toRow,toColumn);
    }
    //Checks if it is a valid move for a piece to make
    public boolean validAction(){
        if (this.fromSpaceValid()){
            if (this.toSpaceValid(true)){
                if (this.validActionPath()) {
                    return true;
                }
                else{
                    return false;
                }
            }
            else if(this.toSpaceValid(false) && this.game.getBoard().getSpaces()[toRow][toColumn].getPiece() instanceof Egg && this.game.getBoard().getSpaces()[toRow][toColumn].getPiece().getColor().equals(this.game.getOpponentTeam().getTeamColor())) {
                if (this.validActionPath()) {
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
        else{
            return false;
        }
    }
    //Moves the piece and changes the turn
    public void performAction(){
        BoardSpace[][] spaces = this.game.getBoard().getSpaces();
        BoardSpace space1 = spaces[fromRow][fromColumn];
        BoardSpace space2 = spaces[toRow][toColumn];
        Piece p = space1.getPiece();
        Piece p2 = space2.getPiece();
        if (p2 instanceof Egg){
            p.setHealth(p2.getStrength());
            space2.removePiece();
            if (p.getHealth() < 1){
                space2.removePiece();
                this.game.getCurrentTeam().removePieceFromTeam(p);
                this.game.getOpponentTeam().removePieceFromTeam(p2);
                space1.removePiece();
            }
            else{
                space2.removePiece();
                this.game.getOpponentTeam().removePieceFromTeam(p2);
                space1.removePiece();
                space2.setPiece(p);
                if (space2.getCoin() == true){
                    System.out.println("Congrats you found a coin!");
                    this.game.getCurrentTeam().getToolBox().addTool( new Tool(Tool.ITEM.COIN, Tool.STRENGTH.SILVER));
                    space2.setCoin(false);
                    BoardSpace b = this.game.getBoard().findRandomEmptySpace();
                    b.setCoin(true);
                }
            }
        }
        else{
            space1.removePiece();
            space2.setPiece(p);
            if (space2.getCoin() == true){
                System.out.println("Congrats, you found a coin!");
                this.game.getCurrentTeam().getToolBox().addTool( new Tool(Tool.ITEM.COIN, Tool.STRENGTH.SILVER));
                space2.setCoin(false);
                BoardSpace b = this.game.getBoard().findRandomEmptySpace();
                b.setCoin(true);
            }
        }
        this.game.changeTurn();
    }
}
