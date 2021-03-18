package cisc181.lab_5;
import java.util.ArrayList;


public class TeamH {
    private String teamName;
    private String teamColor;
    protected ArrayList<Piece> teamPieces;
    private ToolBox teamTB;
    private int numEggs;
    //constructor that takes two strings and an arraylist of pieces
    public TeamH(String teamName, String color, ArrayList<Piece> teamPieces){
        ToolBox tb = new ToolBox(false);
        this.teamName = teamName;
        this.teamColor = color;
        this.teamPieces = teamPieces;
        this.teamTB = tb;
        this.numEggs = 0;
    }
    //Getter that returns the team name
    public String getTeamName(){
        return this.teamName;
    }
    //Getter that returns a team color
    public String getTeamColor(){
        return this.teamColor;
    }
    //getter that returns a team's pieces
    public ArrayList<Piece> getTeamPieces(){
        return this.teamPieces;
    }
    //getter that returns a team's toolbox
    public ToolBox getToolBox(){
        return this.teamTB;
    }
    //removes a piece from a team
    public void removePieceFromTeam(Piece pieceRemoved){
        teamPieces.remove(pieceRemoved);
    }
    //adds a piece to a team
    public void addPieceToTeam(Piece pieceAdded){
        pieceAdded.setColor(this.getTeamColor());
        teamPieces.add(pieceAdded);
    }
    public int getNumEggs() {
        return this.numEggs;
    }
    //Getter that increases the number of eggs
    public void incrementNumEggs(){
        this.numEggs ++;
    }
    //Abstract method that returns a PieceEggLaying
    public void decreaseNumEggs(){
        this.numEggs--;
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Team " + this.teamName + ": " + this.teamColor);
        str.append("\n");
        str.append("Pieces : ");
        for (int i = 0; i < this.teamPieces.size(); i++){
            if (teamPieces.get(i) == null){
                str.append("");
            }
            else {
                str.append(teamPieces.get(i).toString() + " ");
            }
        }
        str.append("\n");
        str.append("Tools : " + teamTB.toString());
        return str.toString();
    }
 }
