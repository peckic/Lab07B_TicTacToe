import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTController implements ActionListener {
    private Game game;
    private TTTGameUI ui;

    public TTTController(Game game) {
        this.game = game;
    }

    public void setUI(TTTGameUI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TTTTileButton btn = (TTTTileButton) e.getSource();
        int row = btn.getRow();
        int col = btn.getCol();

        if (game.getBoard().isTileEmpty(row, col)) {
            char mark = game.getCurrentPlayer().getMark();
            game.getBoard().setTile(row, col, mark);
            btn.setMark(mark);

            char winner = game.getBoard().checkWin();
            if (winner != ' ') {
                ui.updateStatus("Player " + winner + " wins!");
                disableAllButtons();
                return;
            }

            if (game.getBoard().isFull()) {
                ui.updateStatus("It's a draw!");
                return;
            }

            game.switchPlayer();
            ui.updateStatus("Player " + game.getCurrentPlayer().getMark() + "'s turn");
        }
    }

    private void disableAllButtons() {
        for (TTTTileButton[] row : ui.getButtons())
            for (TTTTileButton btn : row)
                btn.setEnabled(false);
    }
}
