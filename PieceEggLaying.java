package cisc181.lab_5;

public abstract class PieceEggLaying extends Piece {
    //Constructor that takes two Strings and an int
    public PieceEggLaying(String symbol, String color, int strength, int health) {
        super(symbol,color,strength,health);
    }
    //Getter that returns the number of eggs

    abstract Egg layEgg();
}
