//Joshua Kattampally
//CS2336.002
//DriverMain:
//Analysis:
//  Declares a new game and starts it
//Design:
//  declares an instance of TTTGame and calls the start() method.
public class DriverMain {

    public static void main(String[] args) {
        // Creating a new game and starting it.
        TTTGame game = new TTTGame();
        game.setBoard(new OtherBoardWrapper());
        game.setPlayers(new ComputerPlayer("Player1", "X"), new HumanPlayer("Player2", "O"));
        game.start();
    }
}
