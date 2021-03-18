package cisc181.lab_5;

public class Tool {
    public enum ITEM{CLOAK, GLASSES, COIN, FEDORA};
    public enum STRENGTH{GOLD, SILVER};
    private ITEM toolType;
    private STRENGTH toolStrength;
    //Constructor that takes an ITEM and a Strength
    public Tool(ITEM toolType, STRENGTH toolStrength){
        this.toolType = toolType;
        this.toolStrength = toolStrength;
    }
    //Getter for an object's ITEM
    public ITEM getToolType(){
        return this.toolType;
    }
    //Getter for an object's STRENGTH
    public STRENGTH getToolStrength(){
        return this.toolStrength;
    }
    @Override
    public String toString(){
        return this.getToolStrength() + " " + this.getToolType();
    }
    //Create's a string describing a tool
    public String getDescription(){
        String toolDescription="";
        int switchCase = 10;
        if (this.getToolStrength() == STRENGTH.SILVER){
            if (this.getToolType() == ITEM.CLOAK){
                switchCase = 0;
            }
            if (this.getToolType() == ITEM.GLASSES){
                switchCase = 2;
            }
            if(this.getToolType() == ITEM.COIN){
                switchCase = 4;
            }
            if (this.getToolType() == ITEM.FEDORA){
                switchCase = 6;
            }
        }
        if (this.getToolStrength() == STRENGTH.GOLD){
            if (this.getToolType() == ITEM.GLASSES) {
                switchCase = 1;
            }
            if(this.getToolType() == ITEM.COIN){
                switchCase = 3;
            }
            if (this.getToolType() == ITEM.CLOAK){
                switchCase = 5;
            }
        }
        switch(switchCase){
            case 0:
                toolDescription = "Hide one of your own team's pieces";
                break;

            case 1:
                toolDescription = "Unhide all of the other team's pieces";
                break;

            case 2:
                toolDescription = "Unhide one of the other team's pieces";
                break;

            case 3:
                toolDescription = "Trade for any tool in the game";
                break;

            case 4:
                toolDescription = "Buy any tool from the game's toolbox";
                break;

            case 5:
                toolDescription = "Hides all of your team's pieces";
                break;

            case 6:
                toolDescription = "Randomly attacks an opponent's piece";
                break;

            default:
                toolDescription = "Unidentified tool";
                break;
        }
        return toolDescription;
    }
}
