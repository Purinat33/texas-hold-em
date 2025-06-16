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
        Card temp1 = new Card(Value.TWO, Suit.DIAMONDS); // Added 2 to make it actually 7
        Card temp2 = new Card(Value.FIVE, Suit.SPADES);

        ArrayList<Card> testRoyal = new ArrayList<>();
        testRoyal.add(a);
        testRoyal.add(t);
        testRoyal.add(j);
        testRoyal.add(q);
        testRoyal.add(k);
        testRoyal.add(temp1);
        testRoyal.add(temp2);

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
        // Ace
        testHand = new Hand(new Deck());
        ArrayList<Card> sf = new ArrayList<>();
        Card a = new Card(Value.ACE, Suit.HEARTS);
        Card t = new Card(Value.TWO, Suit.HEARTS);
        Card j = new Card(Value.FIVE, Suit.HEARTS);
        Card q = new Card(Value.THREE, Suit.HEARTS);
        Card k = new Card(Value.FOUR, Suit.HEARTS);
        Card t1 = new Card(Value.SEVEN, Suit.DIAMONDS);
        Card t2 = new Card(Value.FOUR, Suit.SPADES);


        sf.add(t);
        sf.add(j);
        sf.add(q);
        sf.add(k);
        sf.add(t1);
        sf.add(t2);
        sf.add(a);

        testHand.setHand(sf);
        System.out.println(testHand);
        int result = testHand.checkStraightFlush();
        assertEquals(15,result);

        sf.remove(q); // 3 of H
        sf.add(new Card(Value.THREE, Suit.CLUBS));
        testHand.setHand(sf);
        System.out.println(testHand);

        assertEquals(-1, testHand.checkStraightFlush());

        // 3 4 5 6 7 => 25
        sf.clear();
        sf.add(new Card(Value.SEVEN, Suit.SPADES));
        sf.add(new Card(Value.FIVE, Suit.SPADES));
        sf.add(new Card(Value.THREE, Suit.SPADES));
        sf.add(new Card(Value.SIX, Suit.SPADES));
        sf.add(new Card(Value.FOUR, Suit.SPADES));
        sf.add(new Card(Value.ACE, Suit.DIAMONDS));
        sf.add(new Card(Value.JACK, Suit.CLUBS));

        testHand.setHand(sf);
        System.out.println(testHand);
        assertEquals(25, testHand.checkStraightFlush());

        // Royal Flush case, should be -1 for this function
        sf.clear();
        sf.add(new Card(Value.ACE, Suit.DIAMONDS));
        sf.add(new Card(Value.KING, Suit.DIAMONDS));
        sf.add(new Card(Value.QUEEN, Suit.DIAMONDS));
        sf.add(new Card(Value.TEN, Suit.DIAMONDS));
        sf.add(new Card(Value.JACK, Suit.DIAMONDS));
        sf.add(new Card(Value.THREE, Suit.DIAMONDS));
        sf.add(new Card(Value.JACK, Suit.CLUBS));

        testHand.setHand(sf);
        System.out.println(testHand);
        assertEquals(-1, testHand.checkStraightFlush());

    }

    @Test
    public void testDuplicateCardValuesAndMultipleStraights() {
        Hand testHand = new Hand(new Deck());
        ArrayList<Card> cards = new ArrayList<>();

        // Straight flush 3♠ 4♠ 5♠ 6♠ 7♠ → 25
        cards.add(new Card(Value.THREE, Suit.SPADES));
        cards.add(new Card(Value.FOUR, Suit.SPADES));
        cards.add(new Card(Value.FIVE, Suit.SPADES));
        cards.add(new Card(Value.SIX, Suit.SPADES));
        cards.add(new Card(Value.SEVEN, Suit.SPADES));

        // Duplicate card value, different suit
        cards.add(new Card(Value.FIVE, Suit.HEARTS)); // Duplicate value = OK
        cards.add(new Card(Value.TWO, Suit.SPADES));  // Makes 2♠-3♠-4♠-5♠-6♠ also valid → 20

        testHand.setHand(cards);
        System.out.println(testHand);

        // Expect the best (highest sum) straight flush → 3♠ 4♠ 5♠ 6♠ 7♠ → sum = 25
        assertEquals(25, testHand.checkStraightFlush());
    }


}
