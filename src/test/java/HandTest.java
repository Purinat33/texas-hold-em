import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HandTest {
    @Test
    public void testSameCard(){
        Hand h = new Hand(new Deck());
        Card a1 = new Card(Value.THREE, Suit.CLUBS);
        System.out.println(a1);
        assertFalse(h.isSameCard(a1, Value.THREE, Suit.HEARTS));
        assertTrue(h.isSameCard(a1, Value.THREE, Suit.CLUBS));
    }
}
