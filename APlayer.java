public abstract class APlayer {
    private String name;
    private String mark;

    //sets the name and the mark of the player.
    public APlayer(String name, String mark) {
        this.setName(name);
        this.setMark(mark);
    }

    //getter for the name.
    public String getName() {
        return name;
    }

    //setter for the name.
    public void setName(String name) {
        this.name = name;
    }

    //getter for the mark.
    public String getMark() {
        return mark;
    }

    //setter for the mark.
    public void setMark(String mark) {
        this.mark = mark;
    }

    //generates a random number for row and column for the computer player to move.
    public abstract int selectColValue(int range);
    public abstract int selectRowValue(int range);
}
