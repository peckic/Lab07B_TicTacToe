// File: Game.java
public class Game {
    private TTTPlayer playerX = new TTTPlayer('X');
    private TTTPlayer playerO = new TTTPlayer('O');
    private TTTPlayer currentPlayer = playerX;
    private TTTBoard board = new TTTBoard();

    public TTTPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public TTTBoard getBoard() {
        return board;
    }

    public void reset() {
        board.reset();
        currentPlayer = playerX;
    }
}
