package Game.GameToolBox;

import Game.*;

public abstract class FlowCounter {
    public static int moveFlow(Game game, int i, int j){
        if(game.isClockWise()){
            if (i++ > j-1){
                i = 0;
            }
        }else{
            if (i-- == -1){
                i = j-1;
            }
        }

        return i;
    }
}
