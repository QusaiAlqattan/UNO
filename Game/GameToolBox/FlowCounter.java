package Game.GameToolBox;

import Game.*;

public abstract class FlowCounter {
    public static int moveFlow(Game game, int i, int j) {
        if (game.isClockWise()) {
            i = (i + 1) % j;  // Move to the next index and wrap around using modulus
        } else {
            i = (i - 1 + j) % j;  // Move to the previous index and wrap around using modulus
        }

        return i;
    }

}
