import Game.DefaultGame;

public class GameDriver {
    public static void main(String[] args) {
        DefaultGame game = DefaultGame.getInstance();
        game.play();
    }
}
