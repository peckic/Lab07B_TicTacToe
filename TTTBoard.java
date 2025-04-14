// File: TTTBoard.java
public class TTTBoard {
    private char[][] grid = new char[3][3];

    public TTTBoard() {
        reset();
    }

    public void setTile(int row, int col, char mark) {
        grid[row][col] = mark;
    }

    public boolean isTileEmpty(int row, int col) {
        return grid[row][col] == ' ';
    }

    public boolean isFull() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                if (grid[r][c] == ' ') return false;
        return true;
    }

    public char checkWin() {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] != ' ' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) return grid[i][0];
            if (grid[0][i] != ' ' && grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) return grid[0][i];
        }
        if (grid[0][0] != ' ' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) return grid[0][0];
        if (grid[0][2] != ' ' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) return grid[0][2];
        return ' ';
    }

    public void reset() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                grid[r][c] = ' ';
    }
}
