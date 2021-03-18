package cisc181.lab_5;
import java.io.*;
import java.util.*;

public class Game181H extends GameH {
    //Constructor that takes two ints and two TeamH
    public Game181H(int rows, int columns, TeamH team1, TeamH team2){
        super(rows,columns,team1,team2);
    }
    //Checks if game has ended
    public boolean isGameEnded(){
        int strengthSum1 = 0;
        int strengthSum2 = 0;
        for (int i=0;i<this.team1.getTeamPieces().size();i++){
            strengthSum1 += this.team1.getTeamPieces().get(i).getStrength();
        }
        for (int i=0;i<this.team2.getTeamPieces().size();i++){
            strengthSum2 += this.team2.getTeamPieces().get(i).getStrength();
        }
        if (strengthSum1 == 0 || strengthSum2 == 0){
            return true;
        }
        else{
            return false;
        }
    }
    //Checks if a team won
    public boolean isAWinner(){
        int strengthSum1 = 0;
        int strengthSum2 = 0;
        for (int i=0;i<this.team1.getTeamPieces().size();i++){
            strengthSum1 += this.team1.getTeamPieces().get(i).getStrength();
        }
        for (int i=0;i<this.team2.getTeamPieces().size();i++){
            strengthSum2 += this.team2.getTeamPieces().get(i).getStrength();
        }
        if (strengthSum1 == 0 ^ strengthSum2 == 0){
            return true;
        }
        else{
            return false;
        }
    }
    //Gets the team that won
    public TeamH getWinner(){
        int strengthSum1 = 0;
        int strengthSum2 = 0;
        for (int i=0;i<this.team1.getTeamPieces().size();i++){
            strengthSum1 += this.team1.getTeamPieces().get(i).getStrength();
        }
        for (int i=0;i<this.team2.getTeamPieces().size();i++){
            strengthSum2 += this.team2.getTeamPieces().get(i).getStrength();
        }
        if (strengthSum1 == 0){
            return team2;
        }
        else if(strengthSum2 == 0){
            return team1;
        }
        else{
            return null;
        }
    }
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
                .append(strHiddenBoard())
                .append("\nIt is Team " + getCurrentTeam().getTeamName() + "'s turn\n");
        return retString.toString();
    }
    public String strHiddenBoard() {
        Piece curPiece;

        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :     ");

        for (int col = 0; col < getBoard().getSpaces()[0].length; col++) {
            boardString.append(col + "       ");
        }
        boardString.append("\n");
        for (int row = 0; row < getBoard().getSpaces().length; row++) {
            boardString.append("Row : " + row + "   ");
            for (int col = 0; col < getBoard().getSpaces()[row].length; col++) {
                curPiece = getBoard().getSpaces()[row][col].getPiece();
                if (curPiece == null) {
                    boardString.append("------" + "  ");
                }
                // if the Piece is hidden and it belongs to the other
                // team - don't show it on the board
                else if (curPiece.isHidden() && getOpponentTeam().getTeamPieces().contains(curPiece)){
                    boardString.append("------" + "  ");
                }
                else {
                    boardString.append(getBoard().getSpaces()[row][col].toString() + "  ");
                }
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }

}
