//Joshua Kattampally
//CS2336.002
//DriverMain:
//Analysis:
//  Creates random moves and returns the moves for each player.
//Design:
//  setters and getter for the name and mark.
//  randomNumber method returns a random number which is used as the row or column for the random player to move to.
public class ComputerPlayer extends APlayer{
    private String name;
    private String mark;

    //sets the name and the mark of the player.
    public ComputerPlayer(String name, String mark) {
        super(name, mark);
    }

    public int selectRowValue(int range) {
        return randomNumber(range);
    }
    public int selectColValue(int range) {
        return randomNumber(range);
    }

    //generates a random number for row and column for the computer player to move.
    private int randomNumber(int range) {
        return (int) (Math.random() * range);
    }
}
