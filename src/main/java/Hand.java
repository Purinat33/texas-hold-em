import java.util.*;

public class Hand {



    private ArrayList<Card> hand;
    public Hand(Deck d){
        this.hand = new ArrayList<>();
        this.hand.add(d.draw());
        this.hand.add(d.draw());
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    // Helper Function
    public boolean isSameCard(Card card, Value v, Suit s){
        return card.getValue().getCardValue() == v.getCardValue() && card.getSuit() == s;
    }


    public boolean checkRoyalFlush(){
        int countRoyalFlush = 0;
        boolean aceFound = false, kingFound = false, tenFound = false, queenFound = false, jackFound = false;
        for(Card card : this.hand){
            if(card.getSuit() == Suit.HEARTS){
                if(card.getValue() == Value.ACE && !aceFound){
                    countRoyalFlush+=1;
                    aceFound=true;
                }
                if(card.getValue() == Value.KING && !kingFound){
                    countRoyalFlush+=1;
                    kingFound=true;
                }
                if(card.getValue() == Value.QUEEN && !queenFound){
                    countRoyalFlush+=1;
                    queenFound=true;
                }
                if(card.getValue() == Value.TEN && !tenFound){
                    countRoyalFlush+=1;
                    tenFound=true;
                }
                if(card.getValue() == Value.JACK && !jackFound){
                    countRoyalFlush+=1;
                    jackFound=true;
                }
            }
            if(countRoyalFlush == 5){
                return true;
            }
        }
        countRoyalFlush = 0;
        aceFound = false;
        kingFound = false;
        tenFound = false;
        queenFound = false;
        jackFound = false;
        for(Card card : this.hand){
            if(card.getSuit() == Suit.DIAMONDS){
                if(card.getValue() == Value.ACE && !aceFound){
                    countRoyalFlush+=1;
                    aceFound=true;
                }
                if(card.getValue() == Value.KING && !kingFound){
                    countRoyalFlush+=1;
                    kingFound=true;
                }
                if(card.getValue() == Value.QUEEN && !queenFound){
                    countRoyalFlush+=1;
                    queenFound=true;
                }
                if(card.getValue() == Value.TEN && !tenFound){
                    countRoyalFlush+=1;
                    tenFound=true;
                }
                if(card.getValue() == Value.JACK && !jackFound){
                    countRoyalFlush+=1;
                    jackFound=true;
                }
            }
            if(countRoyalFlush == 5){
                return true;
            }
        }
        countRoyalFlush = 0;
        aceFound = false;
        kingFound = false;
        tenFound = false;
        queenFound = false;
        jackFound = false;
        for(Card card : this.hand){
            if(card.getSuit() == Suit.SPADES){
                if(card.getValue() == Value.ACE && !aceFound){
                    countRoyalFlush+=1;
                    aceFound=true;
                }
                if(card.getValue() == Value.KING && !kingFound){
                    countRoyalFlush+=1;
                    kingFound=true;
                }
                if(card.getValue() == Value.QUEEN && !queenFound){
                    countRoyalFlush+=1;
                    queenFound=true;
                }
                if(card.getValue() == Value.TEN && !tenFound){
                    countRoyalFlush+=1;
                    tenFound=true;
                }
                if(card.getValue() == Value.JACK && !jackFound){
                    countRoyalFlush+=1;
                    jackFound=true;
                }
            }
            if(countRoyalFlush == 5){
                return true;
            }
        }
        countRoyalFlush = 0;
        aceFound = false;
        kingFound = false;
        tenFound = false;
        queenFound = false;
        jackFound = false;
        for(Card card : this.hand){
            if(card.getSuit() == Suit.CLUBS){
                if(card.getValue() == Value.ACE && !aceFound){
                    countRoyalFlush+=1;
                    aceFound=true;
                }
                if(card.getValue() == Value.KING && !kingFound){
                    countRoyalFlush+=1;
                    kingFound=true;
                }
                if(card.getValue() == Value.QUEEN && !queenFound){
                    countRoyalFlush+=1;
                    queenFound=true;
                }
                if(card.getValue() == Value.TEN && !tenFound){
                    countRoyalFlush+=1;
                    tenFound=true;
                }
                if(card.getValue() == Value.JACK && !jackFound){
                    countRoyalFlush+=1;
                    jackFound=true;
                }
            }
            if(countRoyalFlush == 5){
                return true;
            }
        }
        return false;
    }


    public int checkStraightFlush() {
        // Group cards by suit
        Map<Suit, ArrayList<Card>> suitGroups = new HashMap<>();
        for (Card card : this.hand) {
            suitGroups.computeIfAbsent(card.getSuit(), k -> new ArrayList<>()).add(card);
        }

        int maxSum = -1;

        for (Map.Entry<Suit, ArrayList<Card>> entry : suitGroups.entrySet()) {
            List<Card> suitedCards = entry.getValue();
            if (suitedCards.size() < 5) continue;

            // Collect values and allow low-Ace as 1 if Ace is present
            Set<Integer> values = new HashSet<>();
            for (Card card : suitedCards) {
                values.add(card.getValue().getCardValue());
                if (card.getValue() == Value.ACE) {
                    values.add(1);  // Low-Ace case
                }
            }

            // Check for straight flush from the highest down to lowest (Started from 13 as to not count a royal flush)
            for (int high = 13; high >= 5; high--) {
                boolean isStraight = true;
                int sum = 0;

                for (int i = 0; i < 5; i++) {
                    if (!values.contains(high - i)) {
                        isStraight = false;
                        break;
                    }
                    sum += high - i;
                }

                if (isStraight) {
                    maxSum = Math.max(maxSum, sum);
                    break; // Only need the max straight flush for this suit
                }
            }
        }

        return maxSum;
    }

    int fourOfAKind(){
        int score = -1;
        for(Card c: this.hand){
            int count = 1; // Itself
            for(Card card: this.hand){
                if(isSameCard(card, c.getValue(), c.getSuit())){
                    // Skip first one
                    continue;
                }

                if(card.getValue().getCardValue() == c.getValue().getCardValue()){
                    count++;
                }
            }
            if(count == 4 && ( (c.getValue().getCardValue()*4) > score)){
               score = c.getValue().getCardValue()*4;
            }
        }

        return score;
    }


    public int calculateHand(Card f1, Card f2, Card f3, Card t1, Card r1){
        // Use only 5 out of 2Hands+5Tables
        this.hand.add(f1);
        this.hand.add(f2);
        this.hand.add(f3);
        this.hand.add(t1);
        this.hand.add(r1);
        // https://gldproducts.com/blogs/all/poker-hand-rankings
        // There are probably better ways to optimize this
        // -----------------------------------------------
        // Royal Flush
        if(this.checkRoyalFlush()){
            return 100;
        }
        // -----------------------------------------------
        // Straight Flush
        if(checkStraightFlush() != -1){
            return checkStraightFlush();
        }


        // High hand
        return 0;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "hand=" + this.hand +
                '}';
    }

}
