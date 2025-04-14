import javax.swing.*;
import java.awt.*;

public class TTTGameUI extends JFrame {
    private TTTTileButton[][] buttons = new TTTTileButton[3][3];
    private JLabel statusLabel = new JLabel("Player X's turn");
    private Game game;
    private TTTController controller;

    public TTTGameUI(Game game, TTTController controller) {
        this.game = game;
        this.controller = controller;
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 450);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                buttons[r][c] = new TTTTileButton(r, c);
                buttons[r][c].addActionListener(controller);
                boardPanel.add(buttons[r][c]);
            }
        }

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            game.reset();
            for (TTTTileButton[] row : buttons)
                for (TTTTileButton btn : row)
                    btn.reset();
            statusLabel.setText("Player X's turn");
        });

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(statusLabel, BorderLayout.CENTER);
        bottomPanel.add(resetButton, BorderLayout.EAST);

        add(boardPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void updateStatus(String msg) {
        statusLabel.setText(msg);
    }

    public TTTTileButton[][] getButtons() {
        return buttons;
    }
}
