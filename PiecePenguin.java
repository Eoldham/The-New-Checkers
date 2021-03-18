package cisc181.lab_5;

public class PiecePenguin extends PieceEggLaying implements Recruiter,Attacker{

    private int numAttacked;

    //Constructor that takes two strings and two ints
    public PiecePenguin(String symbol, String color, int numAttacked){
        super(symbol,color,4,10);
        this.numAttacked = numAttacked;
    }

    //Prints a message
    public void speak(){
        System.out.println("Smile and wave boys. Smile and wave.");
    }

    //Checks if the piece is taking a valid path
    public boolean validPath(int oldRowIndex, int oldColumnIndex, int newRowIndex, int newColumnIndex){
        if(oldRowIndex == newRowIndex){
            return true;
        }
        else if(oldRowIndex+1 == newRowIndex || oldRowIndex-1 == newRowIndex){
            if (oldColumnIndex == newColumnIndex){
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
    //Attacks another piece
    public void attack(int fromRow, int fromCol, int toRow, int toCol){
        this.numAttacked++;
        this.speak();
        System.out.println("Attack with flipper smack. Other piece removed from game.");
    }
    //Recruits another piece
    public void recruit(int fromRow, int fromCol, int toRow, int toCol){
        this.speak();
        System.out.println("Come on over, we have cookies! Other piece removed from other team and added to this team.");
    }
    //Creates a new PiecePenguin
    public Egg layEgg(){
        return new Egg(this.getColor(), this.getStrength()/2);
    }


    //Getter that returns the number attacked
    public int getNumAttacked()  {
        return this.numAttacked;
    }
    //increases the number attacked
    public void incrementNumAttacked( ){
        this.numAttacked++;
    }


}

