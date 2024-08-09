package Card;

import specialEffects.SpecialEffect;

public class SpecialCard extends Card{
    SpecialEffect specialEffect;

    public SpecialCard(String color, String value, boolean isWild, SpecialEffect specialEffect) {
        super(color, value, isWild);
        this.specialEffect = specialEffect;
    }

    public SpecialEffect geSpecialEffect(){
        return this.specialEffect;
    }

}
