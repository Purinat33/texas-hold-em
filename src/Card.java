public class Card implements Comparable<Card> {

    private Value value;
    private Suit suit;

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Card(Value value, Suit suit){
        this.value = value;
        this.suit=suit;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.getValue().getCardValue(), o.getValue().getCardValue());
    }
}
