package cisc181.lab_5;

public class PerryThePlatypus extends PieceEggLaying implements Attacker{
    //Constructor that takes two strings and an integer
    public PerryThePlatypus(String symbol, String color, int numAttacked){
        super(symbol,color, 6,10);
    }
    //Prints out a message
    public void speak(){
        System.out.println("Perry...Perry the Platypus");
    }
    //Checks if the piece is moving in a valid path
    public boolean validPath(int fromRow, int fromColumn, int toRow, int toColumn) {
        if ((Math.abs(fromRow - toRow) == 1) && (Math.abs(fromColumn - toColumn) == 2)) {
            return true;
        }
        else {
            return false;
        }
    }
    public void attack(int fromRow, int fromCol, int toRow, int toCol){
        this.speak();
        System.out.println("Attacks with roundhouse to the face. Other piece loses 4 health.");
    }
    public Egg layEgg(){
        return new Egg(this.getColor(), this.getStrength()/2);
    }
}
