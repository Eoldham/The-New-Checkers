package cisc181.lab_5;

public class ActionRecruit extends Action {

   // constructor

    public ActionRecruit(Game181H game, int fromSpaceRow, int fromSpaceCol, int toSpaceRow, int toSpaceCol) {
        super(game, fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
    }

    // Check to see if this is valid Recruit Action
    public boolean validAction() {
        // check if from space valid
        if(fromSpaceValid() ) {
            // get the piece that is in the from BoardSpace
            Piece fromPiece = game.getBoard().getSpaces()
                    [fromRow][fromColumn].getPiece();
            // check to see if this piece has implemented the Recruiter interface
            if (Recruiter.class.isAssignableFrom(fromPiece.getClass())) {
                // if to space valid - should NOT be empty so pass a value of false to the toSpaceValid method
                if (toSpaceValid(false)) {
                    return validActionPath();
                }
            } else {
                System.out.println("The piece on first space can't recruit.");
                return false;
            }
        }
        return false;
    }
    // this method calls the Piece's recruit method
    private void recruit(){
        // Get the piece that is in the fromSpace
        Piece recPiece = game.getBoard()
                .getSpaces()[fromRow][fromColumn].getPiece();
        // check to see which type of Piece we have
        // we can't call the recruit method on all pieces in the game
        // we can only call these methods on pieces that have this method - ie - Pieces that have implemented the Recruiter Interface
        // so we will cast the Piece to its subclass type so we can call recruit
        if(recPiece instanceof PieceSharkBait){
            // cast and call SharkBait's recruit method
            ((PieceSharkBait) recPiece).recruit(fromRow,fromColumn,toRow,toColumn);
        }
        else if(recPiece instanceof PiecePenguin){
            // cast and call Penguin's recruit method
            ((PiecePenguin) recPiece).recruit(fromRow,fromColumn,toRow,toColumn);
        }
        else if(recPiece instanceof MajorMonogram){
            // cast and call Penguin's recruit method
            ((MajorMonogram) recPiece).recruit(fromRow,fromColumn,toRow,toColumn);
        }
    }
    //Recruits the piece of the to space and changes turns
     public void performAction() {
        recruit();
        BoardSpace[][] spaces = this.game.getBoard().getSpaces();
        BoardSpace space2 = spaces[toRow][toColumn];
        Piece p2 = space2.getPiece();
        this.game.getOpponentTeam().removePieceFromTeam(p2);
        this.game.getCurrentTeam().addPieceToTeam(p2);
        this.game.changeTurn();
    }
}