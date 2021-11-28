public class OtherBoardWrapper implements Iboard{
    OtherBoard otherBoard = new OtherBoard();

    @Override
    public void print() {
        otherBoard.printMyBoard();
    }

    @Override
    public boolean isWinner(String mark) {
        return otherBoard.isWinner(mark.charAt(0));
    }

    @Override
    public void reset() {

    }

    @Override
    public String getMark(int row, int column) {
        return otherBoard.getMark(row,column);
    }

    @Override
    public boolean makeMove(String player, int row, int col) {
        return otherBoard.setMark(row, col, player);
    }

    @Override
    public void setSize(int row, int col) {
        otherBoard.setSize(row, col);
    }

    @Override
    public int getColSize() {
        return otherBoard.getColSize();
    }

    @Override
    public int getRowSize() {
        return otherBoard.getColSize();
    }

    @Override
    public String getName() {
        return otherBoard.getName();
    }

    @Override
    public boolean isFull() {
        return (otherBoard.emptyCells().length == 0);
    }
}
