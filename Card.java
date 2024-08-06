public abstract class Card {
    String color;
    int number;
    SpecialEffect specialEffect;
    boolean isWild;

    public Card(String color, int number, SpecialEffect specialEffect, boolean isWild) {
        this.color = color;
        this.number = number;
        this.specialEffect = specialEffect;
        this.isWild = isWild;
    }
}
