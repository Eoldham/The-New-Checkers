package cisc181.lab_5;

public interface Recruiter {
    //Abstract method that gets used by those that implement the recruiter interface
    public abstract void recruit(int fromRow, int fromColumn, int toRow, int toColumn);
}
