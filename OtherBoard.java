public class OtherBoard{

    private int boardRowSize;
    private int boardColSize;
    private char[][] board;
    private String name;


    OtherBoard(){
        this(3, 3, "TTT 2D array of char");
    }

    OtherBoard(int row, int col, String name){
        this.setName(name);
        this.setSize(row, col);
    }

    private void init() {
        this.board = new char[boardRowSize][boardColSize];
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[i].length; j++){
                board[i][j] = '-';
            }
        }
        printMyBoard()	;
    }

    public void printMyBoard() {
        System.out.println("printing the " + this.name + " - " +
                this.boardRowSize + "*" + this.boardColSize + " board info....");
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[i].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int availability() {
        int count = 0;
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[i].length; j++){
                if(board[i][j] == '-'){
                    count++;
                }
            }
        }
        return count;
    }

    public String getMark(int row, int col) {
        return board[row][col] + "";
    }

    public boolean setMark(int row, int col, String player) {
        if(board[row][col] == '-'){
            board[row][col] = player.charAt(0);
            return true;
        }else return false;
    }

    //	public boolean makeMove(String s, Move m) {
    //		if(board[m.getRow()][m.getCol()] == Mark.DASH.getMark().charAt(0)){
    //			board[m.getRow()][m.getCol()] = s.charAt(0);
    //			return true;
    //		}else return false;
    //	}

    public void setSize(int row, int col) {
        this.boardRowSize = row;
        this.boardColSize = col;
        this.init();
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void reset() {
        // TODO Auto-generated method stub

    }

    public int getColSize() {
        return this.boardColSize;
    }

    public int getRowSize() {
        return this.boardRowSize;
    }

    /*
     * it will give us an array of all the empty spots
     * by multiplying row and col
     */
    public int[] emptyCells(){
        int[] emptyCells = new int[availability()];
        int index = 0;
        if(availability()>0)
            for(int i = 0 ; i < board.length; i++){
                for(int j = 0 ; j < board[i].length; j++){
                    if(board[i][j] == '-') {
                        emptyCells[index++] = i * this.boardRowSize + j;
                    }
                }
            }
        return emptyCells;
    }
    public boolean isWinner(char Mark) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] == Mark) {
                return true;
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] == Mark) {
                return true;
            }
        }
        int diagonal_counter = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[0][0] == board[i][i]) {
                diagonal_counter++;
            }
        }
        if (diagonal_counter == board.length && board[0][0] == Mark) {
            return true;
        }
        diagonal_counter = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[0][board.length - 1] == board[i][(board.length - 1) - i]) {
                diagonal_counter++;
            }
        }
        if (diagonal_counter == board.length && board[0][board.length - 1] == Mark) {
            return true;
        }
        else return false;
    }
    //	public Move[] getAllPossibleMoves() {
    //		Move[] validMoves = new Move[availability()];
    //		int count = 0;
    //		for(int i = 0 ; i < board.length; i++){
    //			for(int j = 0 ; j < board[i].length; j++){
    //				if(board[i][j] == Mark.DASH.getMark().charAt(0)) {
    //					Move m = new Move(i,j);
    //					validMoves[count++] = m;
    //				}
    //			}
    //		}
    //		return validMoves;
    //	}



}
