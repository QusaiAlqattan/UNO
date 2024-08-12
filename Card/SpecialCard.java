package Card;

import Effects.Effect;

public class SpecialCard extends Card{
    private Effect effect;
    private boolean isWild;


    public SpecialCard(String color, Effect effect, boolean isWild) {
        super(color);
        this.effect = effect;
        this.isWild = isWild;
    }

    public Effect getSpecialEffect(){
        return this.effect;
    }

    public boolean isWild(){
        return this.isWild;
    }

}
