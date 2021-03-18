package cisc181.lab_5;

public class PurchaseTool {
    protected Game181H game;
    //Constructor that takes a Game181H
    public PurchaseTool(Game181H game){
        this.game = game;
    }
    //Checks if the purchase being made is valid
    public boolean validToolPurchase(Tool coin, Tool t){
        if (coin.getToolType() == Tool.ITEM.COIN){
            if (this.game.getCurrentTeam().getToolBox().hasTool(coin.getToolType(), coin.getToolStrength())){
                if (coin.getToolStrength() == Tool.STRENGTH.SILVER){
                    if(this.game.getGameToolBox().hasTool(t.getToolType(),t.getToolStrength())){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    if(this.game.getGameToolBox().hasTool(t.getToolType(),t.getToolStrength()) || this.game.getOpponentTeam().getToolBox().hasTool(t.getToolType(),t.getToolStrength())){
                        return true;
                    }
                    else{
                        return false;
                    }
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
    //Moves a tool from one toolbox to another
    public void exchangeTool(Tool tExchange, ToolBox fromTB, ToolBox toTB){
        fromTB.removeTool(tExchange.getToolType(), tExchange.getToolStrength());
        toTB.addTool(tExchange);
    }
    //Purchases a tool from a toolbox and exchanges the coin for that tool
    public void performToolPurchase(Tool coin, Tool t){
        if (coin.getToolStrength() == Tool.STRENGTH.SILVER){
            this.game.getCurrentTeam().getToolBox().removeTool(coin.getToolType(),coin.getToolStrength());
            this.game.getGameToolBox().addTool(coin);
            exchangeTool(t,this.game.getGameToolBox(),this.game.getCurrentTeam().getToolBox());
        }
        else{
            if (this.game.getOpponentTeam().getToolBox().hasTool(t.getToolType(),t.getToolStrength())){
                this.game.getCurrentTeam().getToolBox().removeTool(coin.getToolType(),coin.getToolStrength());
                this.game.getOpponentTeam().getToolBox().addTool(coin);
                exchangeTool(t,this.game.getOpponentTeam().getToolBox(),this.game.getCurrentTeam().getToolBox());
            }
            else{
                this.game.getCurrentTeam().getToolBox().removeTool(coin.getToolType(),coin.getToolStrength());
                this.game.getGameToolBox().addTool(coin);
                exchangeTool(t,this.game.getGameToolBox(),this.game.getCurrentTeam().getToolBox());
            }
        }
    }
}
