package cisc181.lab_5;

public abstract class Piece {
    protected String symbol;
    protected String color;
    protected boolean hidden;
    int attackStrength;
    int health;
    //Constructor that takes two Strings
    public Piece(String symbol, String color, int strength, int health) {
        this.symbol = symbol;
        this.color = color;
        this.hidden = false;
        this.attackStrength = strength;
        this.health = health;
    }
    //Constructor that takes one String
    public Piece(String symbol) {
        this(symbol, "", 0 ,0);
    }
    //Abstract function that has no return
    abstract void speak();
    //Getter that returns a piece's symbol
    public String getSymbol() {
        return this.symbol;
    }
    //Getter that returns a piece's color
    public String getColor() {
        return this.color;
    }
    public int getStrength(){
        return this.attackStrength;
    }
    public int getHealth(){
        return this.health;
    }
    public void setHealth(int damage){
        this.health -= damage;
    }
    //Sets a piece's color
    public void setColor(String color) {
        this.color = color;
    }
    //Getter that tells if a piece is hidden
    public boolean isHidden() {
        return this.hidden;
    }
    //Sets if a piece is hidden
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    //Abstract function that returns a boolean
    abstract boolean validPath(int oldRowIndex, int oldColumnIndex, int newRowIndex, int newColumnIndex);
    @Override
    public String toString(){
        return this.color.charAt(0) + "-" + this.symbol;
    }
}
