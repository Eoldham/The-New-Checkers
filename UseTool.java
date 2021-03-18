package cisc181.lab_5;
import java.util.ArrayList;

public class UseTool {
    protected GameH game;
    //Constructor that takes a GameH
    public UseTool(GameH game){
        this.game = game;
    }
    //Checks if the team has the tool they are trying to use
    public boolean validUseToolAction(Tool t){
        if (t.getToolType()!= Tool.ITEM.COIN){
            if (this.game.getCurrentTeam().getToolBox().hasTool(t.getToolType(), t.getToolStrength())){
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
    //Moves a tool from one toolbox to another
    public void exchangeTool(Tool tExchange, ToolBox fromTB, ToolBox toTB){
        fromTB.removeTool(tExchange.getToolType(), tExchange.getToolStrength());
        toTB.addTool(tExchange);
    }
    //Hides or reveals pieces depending on the boolean inputs
    private void performHide(boolean hidden, boolean all, TeamH team){
        int index;
        if (hidden == true){
            if (all == true){
                for (int i=0; i < team.getTeamPieces().size(); i++){
                    team.getTeamPieces().get(i).setHidden(true);
                }
            }
            else{
                index = (int)(Math.random() * (team.getTeamPieces().size()-1));
                while (team.getTeamPieces().get(index).isHidden()){
                    index = (int)(Math.random() * (team.getTeamPieces().size()-1));
                }
                team.getTeamPieces().get(index).setHidden(true);
            }
        }
        else{
            if (all == true){
                for (int i=0; i < team.getTeamPieces().size(); i++){
                    team.getTeamPieces().get(i).setHidden(false);
                }
            }
            else{
                index = (int)(Math.random() * (team.getTeamPieces().size()-1));
                while(!(team.getTeamPieces().get(index).isHidden())) {
                    index = (int) (Math.random() * (team.getTeamPieces().size()-1));
                }
                team.getTeamPieces().get(index).setHidden(false);
            }
        }
    }
    //Hides or reveals pieces dependent on the type of tool being used
    public void performToolAction(Tool t){
        if(t.getToolType() == Tool.ITEM.CLOAK && t.getToolStrength()== Tool.STRENGTH.SILVER){
            performHide(true,false,this.game.getCurrentTeam());
        }
        else if(t.getToolType() == Tool.ITEM.CLOAK && t.getToolStrength()== Tool.STRENGTH.GOLD){
            performHide(true,true,this.game.getCurrentTeam());
        }
        else if (t.getToolType()== Tool.ITEM.GLASSES && t.getToolStrength()== Tool.STRENGTH.SILVER){
            performHide(false,false,this.game.getOpponentTeam());
        }
        else if(t.getToolType()== Tool.ITEM.GLASSES && t.getToolStrength()== Tool.STRENGTH.GOLD){
            performHide(false,true,this.game.getOpponentTeam());
        }
        else{
            int index = (int)(Math.random() * (this.game.getOpponentTeam().getTeamPieces().size()-1));
            this.game.getOpponentTeam().getTeamPieces().get(index).setHealth(2);
            if (this.game.getOpponentTeam().getTeamPieces().get(index).getHealth() < 1){
                for (int i = 0; i < this.game.getBoard().getNumRows(); i++){
                    for (int j = 0; j < this.game.getBoard().getNumColumns(); j++){
                        if (this.game.getBoard().getSpaces()[i][j].getPiece() == this.game.getOpponentTeam().getTeamPieces().get(index)){
                            this.game.getBoard().getSpaces()[i][j].removePiece();
                            break;
                        }
                    }
                }
                this.game.getOpponentTeam().removePieceFromTeam(this.game.getOpponentTeam().getTeamPieces().get(index));
            }
        }
        exchangeTool(t,this.game.getCurrentTeam().getToolBox(), this.game.getGameToolBox());
        this.game.changeTurn();
    }
}
