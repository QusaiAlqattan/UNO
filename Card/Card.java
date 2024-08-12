package Card;

public abstract class Card {
    private String color;


    public Card(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
