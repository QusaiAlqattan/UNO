package Game;


public class DefaultGame extends Game {
    private static volatile DefaultGame instance;

    private DefaultGame() {
        super();
        String[] colors = {"Red", "Blue", "Yellow", "Green"};
        this.setColors(colors);
    }

    public static DefaultGame getInstance() {
        DefaultGame result = instance;
        if (result == null) {
            synchronized (DefaultGame.class) {
                instance = result = new DefaultGame();
            }
        }
        return result;
    }
}
