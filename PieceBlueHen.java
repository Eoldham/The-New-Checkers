package cisc181.lab_5;

public class PieceBlueHen extends PieceEggLaying implements Attacker{
    private boolean fly;
    private int numAttacked;
    //Constructor that takes two strings and two ints
    public PieceBlueHen(String symbol, String color, int numAttacked){
        super(symbol,color, 5,10);
        this.numAttacked = numAttacked;
        updateFly();
    }

    //Prints a message
    public void speak(){
        System.out.println("Go UD!");
    }
    //Getter that returns the number of attacks
    public int getNumAttacked()  {
        return this.numAttacked;
    }
    //Getter that returns if the piece can fly
    public boolean canFly ()  {
        return this.fly;
    }
    //Increases the number of attacks
    public void incrementNumAttacked( ){
        this.numAttacked++;
        updateFly();
    }
    //Returns if the path the piece wants to take is valid
    public boolean validPath(int oldRowIndex, int oldColumnIndex, int newRowIndex, int newColumnIndex){
        if (this.fly == false){
            if (Math.abs(newRowIndex-oldRowIndex) > 1 || Math.abs(newColumnIndex - oldColumnIndex) > 1){
                return false;
            }
            else if (oldRowIndex+1 == newRowIndex || oldRowIndex-1 == newRowIndex){
                if (oldColumnIndex == newColumnIndex){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                if (oldRowIndex == newRowIndex){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        else{
            return true;
        }
    }
    //Attacks another piece and speaks
    public void attack(int fromRow, int fromCol, int toRow, int toCol){
        this.incrementNumAttacked();
        this.speak();
        System.out.println("Attacks with peck. Other piece removed from game.");
    }
    //Creates a new PieceBlueHen
    public Egg layEgg(){
        return new Egg(this.getColor(), this.getStrength()/2);
    }
    //Changes if a piece can fly
    private void updateFly( ) {
        if (this.numAttacked == 0) {
            this.fly = true;
        }
        else {
            this.fly = false;
        }
    }

}

