package Game.GameToolBox;

public abstract class IncrementCounter {
    public static int increment(int i, int j){
        if (!(i++ > j - 1)){
            i = 0;
        }
        return i;
    }
}
