package Card;

import Effects.Effect;

public class UnoCard extends Card{
    Effect effect;


    protected UnoCard(String color, String value, boolean isWild, Effect effect) {
        super(color, value, isWild);
        this.effect = effect;
    }

    // Getters and setters
    public Effect getSpecialEffect(){
        return this.effect;
    }

}
