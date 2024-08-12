package Card;

public class NormalCard extends Card {
    private String number;


    public NormalCard(String color, String number) {
        super(color);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
