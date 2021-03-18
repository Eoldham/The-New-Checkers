package cisc181.lab_5;

public class Egg extends Piece{
    int strength;
    public Egg(String color, int strength){
        super("Eg ",color,strength,1);
        this.hidden = true;
    }
    public int getStrength(){
        return this.strength;
    }
    public boolean validPath(int fromRow, int fromColumn, int toRow, int toColumn){
        return false;
    }
    public void speak(){
        System.out.println("Boom!");
    }
}
