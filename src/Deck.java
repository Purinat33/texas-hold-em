import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(){
        this.deck = new ArrayList<>();
        // Generate the 52 cards
        // https://www.w3schools.com/java/java_enums.asp
        for (Value v: Value.values()){
            for(Suit s : Suit.values()){
                Card c = new Card(v, s);
                this.deck.add(c);
            }
        }
    }

    public void shuffle(){
        System.out.println("SHUFFLING...");
        for(int i = 0 ; i < 5; i++){
            Collections.shuffle(this.deck);
        }
        System.out.println("SHUFFLING COMPLETED");
    }

    public Card draw(){
        return this.deck.removeLast();
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{\n");
        for(Card c : this.deck){
            s.append("[");
            s.append(c.getValue());
            s.append(" of ");
            s.append(c.getSuit());
            s.append("]\n");
        }
        s.append("}");
        s.append(" Count: ");
        s.append(this.deck.size());

        return s.toString();
    }
}
