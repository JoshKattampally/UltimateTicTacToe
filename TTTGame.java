//Joshua Kattampally
//CS2336.002
//TTTGame:
//Analysis:
//  The logic behind the game. Allows each player to move and checks to see if the game is over, either by full board
//  or somebody getting three in a row.
//Design:
//  Initializes the board and the computer players.
//  Makes the computers moves and makes sure they are value.
//  Keeps going until somebody wins or the board is full (it checks every round).
// Makes sure every time something is done, it is done validly.
public class TTTGame {
    private APlayer[] players = new APlayer[2];
    private Iboard board;

    private String[] marks = {"O", "X"};
    private String name = "Tic Tac Toe Game";

    private int gameRowSize = 3;
    private int gameColSize = 3;
    private int gameScoreToWin= 3;

    private int currentPlayerIndex = -1;

    //initializing a board and a player.
    public TTTGame() {
        setPlayers();
        setBoard();
    }

    private void setPlayers() {
        //set the number of players by declaring the players array size.
        for(int i = 0; i < players.length; i++) {
            //initalizing the players.
            ComputerPlayer p = new ComputerPlayer("player" + i + 1, marks[i]);
            players[i] = p;
        }
    }
    public void setPlayers(APlayer player1, APlayer player2) {
        players[0] = player1;
        players[1] = player2;
    }

    private void setBoard() {
        //initializing a board.
        this.board = new Board(gameRowSize, gameColSize, "TTTGame");
    }
    public void setBoard(Iboard board) {
        //initializing a board.
        System.out.println("The other board will be used.");
        this.board = board;
    }

    public void start() {
        System.out.println("Game started....");
        do {
            //switch players every time
            switchPlayer();
            //keep repeating the random move creation until it goes through.
            while(!board.makeMove(players[this.currentPlayerIndex].getMark(),
                    players[this.currentPlayerIndex].selectRowValue(gameRowSize),
                    players[this.currentPlayerIndex].selectColValue(gameColSize)));
            board.print();
        }while(!gameOver()); //if gameOver returns true then stop the game.
    }

    private void switchPlayer() {
        //if the player was player 0 then it becomes player 1 and vice versa.
        if(currentPlayerIndex == -1 || currentPlayerIndex == 1) {
            currentPlayerIndex = 0;
        }
        else if (currentPlayerIndex == 0) {
            currentPlayerIndex = 1;
        }
    }

    private boolean gameOver() {
        //if there is a winner then gameOver.
        if (board.isWinner(marks[0])) {
            System.out.println("Player " + marks[0] + " wins!");
            return true;
        }
        else if(board.isWinner(marks[1])) {
            System.out.println("Player " + marks[1] + " wins!");
            return true;
        }
        //if the board is full, then game over.
        else if(board.isFull()) {
            System.out.println("The board is now full, nobody won.");
            return true;
        }
        //if neither full nor somebody won, then the game is not over.
        else {
            return false;
        }
    }
}
