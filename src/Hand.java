import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Hand {

    private ArrayList<Card> hand;
    public Hand(Deck d){
        this.hand = new ArrayList<>();
        this.hand.add(d.draw());
        this.hand.add(d.draw());
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

    public boolean checkStraightFlush(){
        // Ace to 5 is the lowest, but other than that you can probably use the corresponding value in the enum
        int countSF = 0;
        // https://stackoverflow.com/questions/530208/function-to-determine-whether-a-poker-hand-is-a-straight
        // Create a new arraylist for sorting hand
        ArrayList<Card> temp = new ArrayList<>(this.hand);
        Collections.sort(temp);
        // Sorting by value will make Ace go to the back
        // We check for 10 J Q K "A"
        // idx len-5 to -2
        // if not we check
        // "A" 2 3 4 5
        // idx 0 to 4 (Because right now A is currently at the back len-1)

        if(){

        }

        for (Card card: temp){
            if(card.getSuit() == Suit.HEARTS){

            }
        }
        return false;
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
        if(checkStraightFlush()){
            return 50;
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
