package cisc181.lab_5;

public class ActionAttack extends Action {

   // constructor
    public ActionAttack(Game181H game, int fromSpaceRow, int fromSpaceCol, int toSpaceRow, int toSpaceCol) {
        super(game, fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
    }

    // Check to see if this is valid Attack Action
    public boolean validAction() {

        // check if from space valid
        if(fromSpaceValid() ) {
            // get the piece that is in the from BoardSpace
            Piece fromPiece = game.getBoard().getSpaces()
                    [fromRow][fromColumn].getPiece();
            // check to see if this piece has implemented the Attacker interface
            if (Attacker.class.isAssignableFrom(fromPiece.getClass())) {
                // if to space is valid - should NOT be empty so pass false to the method
                if (toSpaceValid(false)) {
                    return validActionPath();
                }
            } else {
                System.out.println("The piece on first space can't attack.");
                return false;
            }
        }
        return false;
    }

   // this method calls the Piece's attack method

    private void attack(){
        // Get the piece that is in the fromSpace
        Piece attPiece = game.getBoard()
                .getSpaces()[fromRow][fromColumn].getPiece();
        // check to see which type of Piece we have
        // we can't call the attack method on all pieces in the game
        // we can only call these methods on pieces that have this method - ie - Pieces that have implemented the Attacker Interface
        // so we will cast the Piece to its subclass type so we can call attack
        if(attPiece instanceof PieceBlueHen){
            // cast and call BlueHen's attack method
             ((PieceBlueHen) attPiece)
                    .attack(fromRow,fromColumn,toRow,toColumn);
        }
        else if(attPiece instanceof PiecePenguin){
            // cast and call Penguin's attack method
            ((PiecePenguin) attPiece)
                    .attack(fromRow,fromColumn,toRow,toColumn);
        }
        else if(attPiece instanceof PerryThePlatypus){
            // cast and call Penguin's attack method
            ((PerryThePlatypus) attPiece)
                    .attack(fromRow,fromColumn,toRow,toColumn);
        }
    }

    //Attacks the piece on the to space and removes it from the board and changes turns
    public void performAction() {
        attack();
        BoardSpace[][] spaces = this.game.getBoard().getSpaces();
        BoardSpace space1 = spaces[fromRow][fromColumn];
        BoardSpace space2 = spaces[toRow][toColumn];
        Piece p1 = space1.getPiece();
        Piece p2 = space2.getPiece();
        p2.setHealth(p1.getStrength());
        if (p2.getHealth() < 1) {
            space2.removePiece();
            this.game.getOpponentTeam().removePieceFromTeam(p2);
            space1.removePiece();
            space2.setPiece(p1);
            this.game.changeTurn();
        }
        else{
            this.game.changeTurn();
        }
    }
}
