

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        TTTController controller = new TTTController(game);
        TTTGameUI ui = new TTTGameUI(game, controller);
        controller.setUI(ui);
    }
}
