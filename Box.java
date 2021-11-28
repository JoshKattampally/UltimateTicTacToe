//Joshua Kattampally
//CS2336.002
//DriverMain:
//Analysis:
//  Each box has a row and column and a placeHolder that it displays every time it is called to.
//Design:
//  Placeholders need to be edited and seen whenver needed through a setter and getter.
//  There is a function to make sure that the position is empty by checking the placeholder.
//  Placeholders are set based on if the current placeholder is empty.
public class Box {
    private int row;
    private int col;
    private final static String DASH = "-";
    private String placeHolder = Box.DASH;

    //construct the box with row and column given.
    Box(int row, int col) {
        this.row = row;
        this.col = col;
    }

    //getter for the place holder.
    public String getPlaceHolder() {
        return placeHolder;
    }

    //setter for the placeholder.
    public boolean setPlaceHolder(String placeHolder) {
        //only sets the placeHolder if it is not already taken.
        if(isAvailable()) {
            this.placeHolder = placeHolder;
            return true;
        }
        else{
            return false;
        }
    }
    boolean isAvailable() {
        //it is available if the default placeholder is in place.
        return this.placeHolder.equals(Box.DASH);
    }
    void print() {
        //for each spot it displays the contents, with all spots it creates the board.
        System.out.print(placeHolder + " ");
        //System.out.println("Row: " + this.row + " Column: " + this.col + " Placeholder: " + this.placeHolder);
    }



}
