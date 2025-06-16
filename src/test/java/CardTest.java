import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class CardTest {
    Hand testHand;

    @Test
    public void testRoyalFlush(){
        testHand = new Hand(new Deck());

        Card a = new Card(Value.ACE, Suit.HEARTS);
        Card t = new Card(Value.TEN, Suit.HEARTS);
        Card j = new Card(Value.JACK, Suit.HEARTS);
        Card q = new Card(Value.QUEEN, Suit.HEARTS);
        Card k = new Card(Value.KING, Suit.HEARTS);

        ArrayList<Card> testRoyal = new ArrayList<>();
        testRoyal.add(a);
        testRoyal.add(t);
        testRoyal.add(j);
        testRoyal.add(q);
        testRoyal.add(k);

        testHand.setHand(testRoyal);
        System.out.println(testHand);
        assertTrue(testHand.checkRoyalFlush());

        // Throwing random thing into the mix but the cards are still there
        Card two = new Card(Value.TWO, Suit.HEARTS);
        testRoyal.addFirst(two);
        testHand.setHand(testRoyal);
        System.out.println(testHand);
        assertTrue(testHand.checkRoyalFlush());

        // Removing AoH but add AoS
        testRoyal.removeIf(c -> c.getValue().getCardValue() == 14);
        testRoyal.add(new Card(Value.ACE, Suit.SPADES));
        testHand.setHand(testRoyal);
        System.out.println(testHand);
        assertFalse(testHand.checkRoyalFlush());
    }

    @Test
    public void testStraightFlush(){

    }


}
