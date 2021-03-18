package cisc181.lab_5;
import java.util.ArrayList;
import java.io.*;
import java.util.*;


public abstract class GameH {
    protected Board gameBoard;
    protected TeamH team1;
    protected TeamH team2;
    protected ToolBox gameToolBox;
    protected String turn = "";
    //Places both teams' pieces on the board
    private void initializeGameBoard(int rows, int columns){
        int counter = 5;
        gameBoard = new Board(rows, columns);
        for (int i = 0; i < team1.getTeamPieces().size(); i++){
            gameBoard.findRandomEmptySpace().setPiece(team1.getTeamPieces().get(i));
        }
        for (int i = 0; i < team2.getTeamPieces().size(); i++){
            gameBoard.findRandomEmptySpace().setPiece(team2.getTeamPieces().get(i));
        }
        while (counter > 0){
            counter--;
            BoardSpace b = this.gameBoard.findRandomEmptySpace();
            b.setCoin(true);
        }
    }
    //Constructor that takes two ints and two TeamH
    public GameH(int rows, int columns, TeamH team1, TeamH team2){
        this.team1 = team1;
        this.team2 = team2;
        this.turn = team1.getTeamName();
        initializeGameBoard(rows,columns);
        gameToolBox = new ToolBox(true);
        team1.getToolBox().addTool(gameToolBox.removeTool(Tool.ITEM.COIN, Tool.STRENGTH.SILVER));
        team2.getToolBox().addTool(gameToolBox.removeTool(Tool.ITEM.COIN, Tool.STRENGTH.SILVER));
    }
    //Getter that returns a Board
    public Board getBoard(){
        return this.gameBoard;
    }
    //Getter that returns whose turn it is
    public TeamH getCurrentTeam(){
        if (this.turn.equals(team1.getTeamName())){
            return team1;
        }
        else{
            return team2;
        }
    }
    //Getter that returns the opposing team
    public TeamH getOpponentTeam(){
        if (this.getCurrentTeam() == team1){
            return team2;
        }
        else{
            return team1;
        }
    }
    public ToolBox getGameToolBox(){
        return this.gameToolBox;
    }
    //Checks if it is the turn of the team passed in
    public boolean isTurn(TeamH team){
        if (this.turn.equals(team.getTeamName())){
            return true;
        }
        else{
            return false;
        }
    }
    //Changes which team's turn it is
    public void changeTurn(){
        if (this.turn.equals(this.team1.getTeamName())){
            this.turn = this.team2.getTeamName();
        }
        else{
            this.turn = this.team1.getTeamName();
        }
    }
    //Abstract function that returns a boolean
    public abstract boolean isAWinner();
    //Abstract function that returns a TeamH
    public abstract TeamH getWinner();
    //Abstract function that returns a boolean
    public abstract boolean isGameEnded();
    @Override
    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game ToolBox:\n").append(gameToolBox.toString());
        retString.append(String.join("", Collections.nCopies(50, "*")))
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\n\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\n\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\nGame Board:\n")
                .append("\n" + getBoard().toString())
                .append("\nIt is Team " + getCurrentTeam().getTeamName() + "'s turn\n");
        return retString.toString();
    }

}
