package cisc181.lab_5;

public class ActionLayEgg extends Action {
    public ActionLayEgg(Game181H game, int fromRow, int fromColumn){
        super(game,fromRow,fromColumn);
    }
    public boolean validAction() {
        if (fromSpaceValid()) {
            if (this.game.getCurrentTeam().getNumEggs() < 3) {
                return true;
            } else {
                return false;
            }
        }
        else{
            return false;
        }
    }
    private Egg layEgg() {
        Piece layPiece = game.getBoard()
                .getSpaces()[fromRow][fromColumn].getPiece();
        if (layPiece instanceof PieceBlueHen) {
            return ((PieceBlueHen) layPiece)
                    .layEgg();
        } else if (layPiece instanceof PiecePenguin) {
            return ((PiecePenguin) layPiece)
                    .layEgg();
        } else if (layPiece instanceof PerryThePlatypus) {
            return ((PerryThePlatypus) layPiece)
                    .layEgg();
        }
        else{
            return null;
        }
    }
    public void performAction(){
        Egg newEgg = layEgg();
        this.game.getCurrentTeam().addPieceToTeam(newEgg);
        BoardSpace space = this.game.getBoard().findRandomEmptySpace();
        space.setPiece(newEgg);
        BoardSpace[][] spaces = this.game.getBoard().getSpaces();
        this.game.changeTurn();
    }
}
