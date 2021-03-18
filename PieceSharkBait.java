package cisc181.lab_5;


public class PieceSharkBait extends Piece implements Recruiter {

    //Constructor that takes two strings
    public PieceSharkBait(String symbol, String color){
        super(symbol,color,0,10);
    }

    // constructor for when color information is not available yet
    public PieceSharkBait(String symbol){
        super(symbol);
    }
    //Prints a message
    public void speak(){
        System.out.println("Shark bait oooh ha haa!");
    }
    //Checks if the path the piece is taking is valid
    public boolean validPath(int oldRowIndex, int oldColumnIndex, int newRowIndex, int newColumnIndex) {
        if ((Math.abs(newRowIndex-oldRowIndex) == 2) && (Math.abs(newColumnIndex - oldColumnIndex) == 2)){
            return true;
        }
        else{
            return false;
        }
    }
    //Recruits another piece
    public void recruit(int fromRow, int fromCol, int toRow, int toCol){
        this.speak();
        System.out.println("Come on over, we have cookies! Other piece removed from other team and added to this team.");
    }

}

