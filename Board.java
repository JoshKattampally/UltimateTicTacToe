//Joshua Kattampally
//CS2336.002
//DriverMain:
//Analysis:
//  Declares a board and fills the board with a square array of boxes, typically 9 (3*3).
//Design:
//  Initializes the boards name and size.
//  Initializes an array of boxes relative to the 3*3 size of 9 spots.
//  Prints out the board with print() method every time a move is made.
// Has a method to make moves, a method to make sure the board is not full, and a method to check if anybody won.
public class Board implements Iboard{
    private Box[] boxes;
    private String name;
    private int boardRowSize;
    private int boardColSize;

    // default constructor constructs a 3*3 board.
    Board() {
        this(3, 3, "3 x 3 Board");
    }

    //setting the name and size of the board with this constructor.
    Board(int rows, int cols, String name) {
        this.setName(name);
        this.setSize(rows, cols);
    }

    //gives the board a name.
    private void setName(String name) {
        this.name = name;
    }

    //makes sure the size input is valid and lets the user know if its invalid, if it is valid, then sets the size variables.
    public void setSize(int rows, int cols) {
        if (rows < 3 || cols < 3) {
            System.out.println("Minimum board size is 3 x 3");
        }
        else {
            this.boardRowSize = rows;
            this.boardColSize = cols;
            init();
        }
    }

    //initialize the board with boxes containing the '-' char with row and column values.
    private void init() {
        boxes = new Box[boardRowSize * boardColSize];
        for (int i = 0; i < boxes.length; i++) {
            Box b = new Box(i/boardColSize, i % boardRowSize);
            boxes[i] = b;
        }
        print();
    }

    //printing the value of each box in the board.
    public void print() {
        System.out.println("Printing the " + this.name + "-" + this.boardRowSize + "*" + this.boardColSize + " board info......");
        for(int i = 0; i < boxes.length; i++) {
            //for each box call its print() function.
            if(i != 0 && i%boardColSize == 0) {
                System.out.println();
            }
            boxes[i].print();
        }
        System.out.println();
    }

    //If the position selected is available, then put the players mark in that position.
    public boolean makeMove(String mark, int row, int col) {
        int box_index = (row * 3) + col;
        if(boxes[box_index].isAvailable()) {
            boxes[box_index].setPlaceHolder(mark);
            return true;
        }
        //if position is unavailable return false and retry.
        else{
            return false;
        }
    }

    //makes sure the board is not completely full.
    public boolean isFull() {
        for(Box b: boxes) {
            if (b.isAvailable()) { //if any position on the board is available return false.
                return false;
            }
        }
        return true;
    }

    //checks for a winner.
    public boolean isWinner(String mark) {
        // if any three indexes in a row are the same then it's a win.
        for (int i = 0; i < boxes.length; i+=3) {
            if(boxes[i].getPlaceHolder().equals(boxes[i+1].getPlaceHolder()) &&
                    boxes[i+1].getPlaceHolder().equals(boxes[i+2].getPlaceHolder()) &&
                    boxes[i].getPlaceHolder().equals(mark)) {
                return true;
            }
        }
        //if any full column is the same then it's a win.
        for (int i = 0; i < boardColSize; i++) {
            if (boxes[i].getPlaceHolder().equals(boxes[i + 3].getPlaceHolder()) &&
                    boxes[i + 3].getPlaceHolder().equals(boxes[i + 6].getPlaceHolder()) &&
                    boxes[i + 6].getPlaceHolder().equals(mark)) {
                return true;
            }
        }
        //check how many in a row are the same on the diagonal.
        int diagonal_counter = 0;
        //loops through the positions on the diagonal starting from index 0.
        for(int i = 0; i < boxes.length; i+= (boardRowSize + 1)) {
            if (boxes[i].getPlaceHolder().equals(mark)) {
                diagonal_counter++;
            }
        }
        //if three diagonals in a row, then win.
        if (diagonal_counter == 3) {
            return true;
        }
        //checks the diagonal in the other direction starting from index 2.
        diagonal_counter = 0;
        for(int i = boardColSize - 1; i < (boxes.length - 1); i += (boardColSize - 1)) {
            if (boxes[i].getPlaceHolder().equals(mark)) {
                diagonal_counter++;
            }
        }
        //if there are 3 in a row in the other direction also a win.
        if (diagonal_counter == 3) {
            return true;
        }
        //if there is no win, then false.
        return false;
    }
    public String getName() {
        return this.name;
    }
    public int getRowSize() {
        return this.boardRowSize;
    }
    public int getColSize(){
        return boardColSize;
    }
    public void reset() {

    }
    public String getMark(int row, int col) {
        return null;
    }
}
