package cisc181.lab_5;

public class MajorMonogram extends Piece implements Recruiter {

    public MajorMonogram(String symbol,String color){
        super(symbol,color,0,10);
    }
    public void speak(){
        System.out.println("OWCA");
    }
    public boolean validPath(int fromRow, int fromColumn, int toRow, int toColumn){
        if (fromColumn == toColumn){
            return true;
        }
        else{
            return false;
        }
    }
    public void recruit(int fromRow, int fromColumn, int toRow, int toColumn){
        this.speak();
        System.out.println("Here is your fedora! Other piece removed from other team and added to this team.");
    }
}
