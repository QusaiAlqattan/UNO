package Card;

public class Card {
    private String color;
    private String value;
    private boolean isWild;

    protected Card(String color, String value, boolean isWild) {
        this.color = color;
        this.value = value;
        this.isWild = isWild;
    }

    // Getters and setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isWild() {
        return isWild;
    }

    public void setWild(boolean wild) {
        isWild = wild;
    }
}
