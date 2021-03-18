package cisc181.lab_5;


public class Board {
    private int numRows;
    private int numColumns;
    private BoardSpace[][] spaces;
    //Constructor that takes two int parameters
    public Board(int numRows, int numColumns){
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.spaces = new BoardSpace[numRows][numColumns];
        setUpEmptyBoard();
    }
    //Getter that returns the number of rows
    public int getNumRows(){
        return this.numRows;
    }
    //Getter that returns the number of columns
    public int getNumColumns(){
        return this.numColumns;
    }
    //getter that returns the board spaces
    public BoardSpace[][] getSpaces(){
        return this.spaces;
    }
    //Checks if a space at a certain row and column exists
    public boolean inBounds(int rowIndex, int columnIndex){
        if (rowIndex > this.numRows-1 || columnIndex > this.numColumns-1){
            return false;
        }
        else if (rowIndex < 0 || columnIndex < 0){
            return false;
        }
        else{
            return true;
        }
    }
    //Sets up a board based on how many rows and columns there are
    public void setUpEmptyBoard(){
        for (int i = 0; i < this.numRows; i=i+2){
            for (int j = 0; j < this.numColumns; j++) {
                if (j % 2 == 0) {
                    BoardSpace blueSpace = new BoardSpace(i,j,"blue");
                    spaces[i][j] = blueSpace;
                }
                else{
                    BoardSpace orangeSpace = new BoardSpace(i,j,"orange");
                    spaces[i][j] = orangeSpace;
                }
            }
        }
        for (int i = 1; i < this.numRows; i=i+2){
            for (int j = 0; j < this.numColumns; j++) {
                if (j % 2 == 0) {
                    BoardSpace orangeSpace = new BoardSpace(i,j,"orange");
                    spaces[i][j] = orangeSpace;
                }
                else{
                    BoardSpace blueSpace = new BoardSpace(i,j,"blue");
                    spaces[i][j] = blueSpace;
                }
            }
        }
    }
    //Finds an empty space on the board
   public BoardSpace findRandomEmptySpace(){
        int rowIndex = (int)(Math.random() * this.numRows);
        int columnIndex = (int)(Math.random() * this.numRows);
        while(!spaces[rowIndex][columnIndex].isEmpty()){
            rowIndex = (int)(Math.random() * this.numRows);
            columnIndex = (int)(Math.random() * this.numRows);
        }
        return spaces[rowIndex][columnIndex];
    }
    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :     ");

        for(int col = 0; col < spaces[0].length; col++){
            boardString.append(col + "       ");
        }
        boardString.append("\n");
        for(int row = 0; row < spaces.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < spaces[row].length; col++){
                boardString.append(spaces[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
