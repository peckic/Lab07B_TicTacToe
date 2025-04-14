import javax.swing.*;

public class TTTTileButton extends JButton {
    private int row, col;
    private char mark = ' ';

    public TTTTileButton(int row, int col) {
        this.row = row;
        this.col = col;
        setFont(getFont().deriveFont(40f));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public char getMark() {
        return mark;
    }

    public void setMark(char mark) {
        this.mark = mark;
        setText(String.valueOf(mark));
        setEnabled(false);
    }

    public void reset() {
        mark = ' ';
        setText("");
        setEnabled(true);
    }
}
