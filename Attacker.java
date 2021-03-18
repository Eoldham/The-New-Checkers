package cisc181.lab_5;

public interface Attacker {
    //Abstract function for pieces that attack
    public abstract void attack(int fromRow, int fromColumn, int toRow, int toColumn);
}
