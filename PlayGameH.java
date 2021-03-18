package cisc181.lab_5;
import java.util.*;

public class PlayGameH {
    protected Game181H game;
    //Constructor that takes a Game181H
    public PlayGameH(Game181H game){
        this.game = game;
    }
    //Asks the user to input the type of action they would like to take
    private char getValidActionType(){
        System.out.println("M:move     A:attack     R:recruit     T:tool     L:lay egg");
        Scanner scnr = new Scanner(System.in);
        System.out.print("Please enter action type: ");
        char actionType = scnr.next().charAt(0);
        while (actionType != 'M' && actionType != 'R' && actionType != 'A' && actionType != 'T' && actionType != 'L'){
            System.out.print("Please enter a valid character: ");
            actionType = scnr.next().charAt(0);
        }
        return actionType;
    }
    //Asks the user the type of tool they would like to use
    private Tool getValidTool(){
        Tool t;
        System.out.println("SGLASSES : GGLASSES : SCLOAK : SCOIN : GCOIN : GCLOAK : SFEDORA");
        Scanner scnr = new Scanner(System.in);
        System.out.print("Please enter tool type: ");
        String toolType = scnr.nextLine();
        while(!(toolType.equals("SGLASSES")) && !(toolType.equals("GGLASSES")) && !(toolType.equals("SCLOAK")) && !(toolType.equals("SCOIN")) && !(toolType.equals("GCOIN")) && !(toolType.equals("GCLOAK")) && !(toolType.equals("SFEDORA"))){
            System.out.print("Please enter a valid string: ");
            toolType = scnr.nextLine();
        }
        if (toolType.equals("SGLASSES")){
            t = new Tool(Tool.ITEM.GLASSES, Tool.STRENGTH.SILVER);
        }
        else if (toolType.equals("GGLASSES")){
            t = new Tool(Tool.ITEM.GLASSES, Tool.STRENGTH.GOLD);
        }
        else if (toolType.equals("SCLOAK")){
            t = new Tool(Tool.ITEM.CLOAK, Tool.STRENGTH.SILVER);
        }
        else if (toolType.equals("SCOIN")){
            t = new Tool(Tool.ITEM.COIN, Tool.STRENGTH.SILVER);
        }
        else if (toolType.equals("SFEDORA")){
            t = new Tool(Tool.ITEM.FEDORA, Tool.STRENGTH.SILVER);
        }
        else if (toolType.equals("GCLOAK")){
            t = new Tool(Tool.ITEM.CLOAK, Tool.STRENGTH.GOLD);
        }
        else{
            t = new Tool(Tool.ITEM.COIN, Tool.STRENGTH.GOLD);
        }
        return t;
    }
    //Uses getValidAction and getValidTool to perform the users commands. If it is invalid for their
    //piece or tool box, it is recalled
    private void nextPlayersAction(){
        char action;
        action = getValidActionType();
        if (action == 'T'){
            Tool t1;
            this.game.getCurrentTeam().getToolBox().toString();
            t1 = getValidTool();
            if (t1.getToolType() == Tool.ITEM.COIN){
                Tool t2;
                if (t1.getToolStrength() == Tool.STRENGTH.GOLD){
                    System.out.println("Game's toolbox: \n" + this.game.getGameToolBox().toString());
                    System.out.println("Opponent's toolbox: \n" + this.game.getOpponentTeam().getToolBox().toString());
                    t2 = getValidTool();
                    PurchaseTool obj = new PurchaseTool(this.game);
                    if(obj.validToolPurchase(t1,t2)){
                        obj.performToolPurchase(t1,t2);
                    }
                    else{
                        nextPlayersAction();
                    }
                }
                else{
                    System.out.println("Game's toolbox: \n" + this.game.getGameToolBox().toString());
                    t2 = getValidTool();
                    PurchaseTool obj = new PurchaseTool(this.game);
                    if(obj.validToolPurchase(t1,t2)){
                        obj.performToolPurchase(t1,t2);
                    }
                    else{
                        nextPlayersAction();
                    }
                }
            }
            else{
                UseTool obj = new UseTool(this.game);
                if (obj.validUseToolAction(t1)){
                    obj.performToolAction(t1);
                }
                else{
                    nextPlayersAction();
                }
            }
        }
        else{
            Scanner scnr = new Scanner(System.in);
            System.out.println("Please enter the from space row: ");
            int fromRow = scnr.nextInt();
            System.out.println("Please enter the from space column: ");
            int fromColumn = scnr.nextInt();
            System.out.println("Please enter the to space row: ");
            int toRow = scnr.nextInt();
            System.out.println("Please enter the to space column: ");
            int toColumn = scnr.nextInt();
            if (action == 'A'){
                ActionAttack obj = new ActionAttack(this.game,fromRow,fromColumn,toRow,toColumn);
                if (obj.validAction()){
                    obj.performAction();
                }
                else{
                    nextPlayersAction();
                }
            }
            else if (action == 'R'){
                ActionRecruit obj = new ActionRecruit(this.game,fromRow,fromColumn,toRow,toColumn);
                if (obj.validAction()){
                    obj.performAction();
                }
                else{
                    nextPlayersAction();
                }
            } else if (action == 'L') {
                ActionLayEgg obj = new ActionLayEgg(this.game,fromRow, fromColumn);
                if (obj.validAction()){
                    obj.performAction();
                }
            } else {
                ActionMove obj = new ActionMove(this.game, fromRow, fromColumn, toRow, toColumn);
                if (obj.validAction()) {
                    obj.performAction();
                } else {
                    nextPlayersAction();
                }
            }
        }
    }
    //Starts the game and finishes when isGameEnded is true
    public void playOurGame(){
        System.out.println(this.game.toString());
        nextPlayersAction();
        while (!(this.game.isGameEnded())){
            System.out.println(this.game.toString());
            nextPlayersAction();
        }
        System.out.print("Game is over. " + this.game.getWinner().getTeamName() + " is the winner.");
    }
    public static void main(String[] args){
        // Create 3 pieces for Team A
        Piece a = new PieceSharkBait("A:SB","");
        Piece b = new PieceBlueHen("B:BH","",0);
        Piece c  = new PiecePenguin("C:P ","",0);
        Piece d  = new PieceSharkBait("D:SB","");
        Piece e = new PieceBlueHen("E:BH","",0);
        Piece f = new PiecePenguin("F:P ","",0);
        Piece g = new PerryThePlatypus("G:PP","",0);
        Piece h = new PerryThePlatypus("H:PP","",0);
        Piece i  = new MajorMonogram("I:MM","");
        Piece j  = new MajorMonogram("J:MM","");

        ArrayList<Piece> pieces = new ArrayList<Piece>();
        pieces.add(a);
        pieces.add(b);
        pieces.add(c);
        pieces.add(d);
        pieces.add(e);
        pieces.add(f);
        pieces.add(g);
        pieces.add(h);
        pieces.add(i);
        pieces.add(j);


        // Create an array list to hold Team A's pieces
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        // Create an array list to hold Team B's pieces
        ArrayList<Piece> piecesTeamB = new ArrayList<>();

        int counter = 0;
        boolean realPiece = false;
        while (counter < 10){
            Scanner scnr = new Scanner(System.in);
            if (counter%2 == 0){
                System.out.println("Player A, please pick a piece, type the capital letter");
                System.out.println("SB: SharkBait; P: Penguin; PP: PerrythePlatypus; MM: MajorMonogram; BH: BlueHen");
                for (int x = 0;x<pieces.size();x++){
                    System.out.println(pieces.get(x).getSymbol());
                }
                char input = scnr.next().charAt(0);
                for (int x = 0;x<pieces.size();x++){
                    if (pieces.get(x).getSymbol().charAt(0) == input){
                        pieces.get(x).setColor("Red");
                        piecesTeamA.add(pieces.get(x));
                        pieces.remove(x);
                        realPiece = true;
                        break;
                    }
                }
                if (realPiece == true){
                    realPiece = false;
                    counter++;
                }
            }
            else{
                System.out.println("Player B, please pick a piece, type the capital letter");
                System.out.println("SB: SharkBait; P: Penguin; PP: PerrythePlatypus; MM: MajorMonogram; BH: BlueHen");
                for (int x = 0;x<pieces.size();x++){
                    System.out.println(pieces.get(x).getSymbol());
                }
                char input = scnr.next().charAt(0);
                for (int x = 0;x<pieces.size();x++){
                    if (pieces.get(x).getSymbol().charAt(0) == input){
                        pieces.get(x).setColor("Green");
                        piecesTeamB.add(pieces.get(x));
                        pieces.remove(x);
                        realPiece = true;
                        break;
                    }
                }
                if (realPiece == true){
                    realPiece = false;
                    counter++;
                }
            }
        }
        // Create TeamA and TeamB objects and pass them the array lists of pieces
        TeamH teamA = new TeamH("A", "Red",piecesTeamA);
        TeamH teamB = new TeamH("B",  "Green",piecesTeamB);

        // Create an instance of the game
        Game181H ourGame = new Game181H(7, 7, teamA, teamB);

        // Create PlayGame object and play the game
        PlayGameH play = new PlayGameH(ourGame);
        play.playOurGame();
    }

}
