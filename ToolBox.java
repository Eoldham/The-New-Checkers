package cisc181.lab_5;
import java.util.ArrayList;


public class ToolBox {
    final public static int MAX_NUM_TOOLS = 12;
    private ArrayList<Tool> toolSet = new ArrayList<Tool>();
    //Constructor that takes one boolean
    public ToolBox(boolean gameBox){
        if (gameBox == true) {
            setUpToolBox();
        }
    }
    public void setUpToolBox(){
        toolSet.add(new Tool(Tool.ITEM.CLOAK, Tool.STRENGTH.SILVER));
        toolSet.add(new Tool(Tool.ITEM.CLOAK, Tool.STRENGTH.GOLD));
        toolSet.add(new Tool(Tool.ITEM.GLASSES, Tool.STRENGTH.GOLD));
        toolSet.add(new Tool(Tool.ITEM.GLASSES, Tool.STRENGTH.SILVER));
        toolSet.add(new Tool(Tool.ITEM.COIN, Tool.STRENGTH.GOLD));
        toolSet.add(new Tool(Tool.ITEM.COIN, Tool.STRENGTH.GOLD));
        toolSet.add(new Tool(Tool.ITEM.COIN, Tool.STRENGTH.SILVER));
        toolSet.add(new Tool(Tool.ITEM.COIN, Tool.STRENGTH.SILVER));
        toolSet.add(new Tool(Tool.ITEM.FEDORA, Tool.STRENGTH.SILVER));
    }
    //Getter that gets a tool from a toolbox
    public Tool getTool(int index){
        if (index < 0 || index > 11){
            return null;
        }
        else {
            return toolSet.get(index);
        }
    }
    public ArrayList<Tool> getToolSet(){
        return this.toolSet;
    }
    //Checks if a toolbox has a tool
    public boolean hasTool(Tool.ITEM itemType, Tool.STRENGTH itemStrength){
        for (int i = 0; i < toolSet.size(); i++){
            if (toolSet.get(i).getToolType() == itemType && toolSet.get(i).getToolStrength() == itemStrength){
                return true;
            }
        }
        return false;
    }
    //removes a tool from a toolbox
    public Tool removeTool(Tool.ITEM itemType, Tool.STRENGTH itemStrength){
        Tool removedTool = null;
        for (int i = 0; i < toolSet.size(); i++){
            if (toolSet.get(i).getToolType() == itemType  && toolSet.get(i).getToolStrength().equals(itemStrength)){
                removedTool = toolSet.get(i);
                toolSet.remove(i);
                System.out.println(removedTool.getDescription());
                break;
            }
        }
        return removedTool;
    }
    //adds a tool to a toolbox
    public void addTool(Tool addedTool){
                toolSet.add(addedTool);
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("");
        if (toolSet.size() == 0) {
            return str.toString();
        }
            for (int i = 0; i < toolSet.size(); i++) {
                    str.append(toolSet.get(i).toString() + " : " + toolSet.get(i).getDescription());
                    str.append("\n");
        }
        return str.toString();
    }
}
