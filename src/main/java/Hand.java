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

    public int checkStraightFlush(){
        // https://stackoverflow.com/questions/530208/function-to-determine-whether-a-poker-hand-is-a-straight
        // Create a new arraylist for sorting hand
        ArrayList<Card> temp = new ArrayList<>(this.hand);
        Collections.sort(temp);
        // Ace situation
        // Sorting by value will make Ace go to the back
        // We check for 10 J Q K "A"
        // idx len-5 to -2
        // if not we check
        // "A" 2 3 4 5
        // idx 0 to 3 (Because right now A is currently at the back @ len-1)

        int size = temp.size();
        Suit suitToCheck = Suit.HEARTS;
        if(
                isSameCard(temp.get(size-5), Value.TEN, suitToCheck) &&
                isSameCard(temp.get(size-4), Value.JACK, suitToCheck) &&
                isSameCard(temp.get(size-3), Value.QUEEN, suitToCheck) &&
                isSameCard(temp.get(size-2), Value.KING, suitToCheck) &&
                isSameCard(temp.get(size-1), Value.ACE, suitToCheck)
        ){
            return 99;
        }
        suitToCheck = Suit.DIAMONDS;
        if(
                isSameCard(temp.get(size-5), Value.TEN, suitToCheck) &&
                        isSameCard(temp.get(size-4), Value.JACK, suitToCheck) &&
                        isSameCard(temp.get(size-3), Value.QUEEN, suitToCheck) &&
                        isSameCard(temp.get(size-2), Value.KING, suitToCheck) &&
                        isSameCard(temp.get(size-1), Value.ACE, suitToCheck)
        ){
            return 99;
        }
        suitToCheck = Suit.SPADES;
        if(
                isSameCard(temp.get(size-5), Value.TEN, suitToCheck) &&
                        isSameCard(temp.get(size-4), Value.JACK, suitToCheck) &&
                        isSameCard(temp.get(size-3), Value.QUEEN, suitToCheck) &&
                        isSameCard(temp.get(size-2), Value.KING, suitToCheck) &&
                        isSameCard(temp.get(size-1), Value.ACE, suitToCheck)
        ){
            return 99;
        }
        suitToCheck = Suit.CLUBS;
        if(
                isSameCard(temp.get(size-5), Value.TEN, suitToCheck) &&
                        isSameCard(temp.get(size-4), Value.JACK, suitToCheck) &&
                        isSameCard(temp.get(size-3), Value.QUEEN, suitToCheck) &&
                        isSameCard(temp.get(size-2), Value.KING, suitToCheck) &&
                        isSameCard(temp.get(size-1), Value.ACE, suitToCheck)
        ){
            return 99;
        }

        // Lower bound
        suitToCheck = Suit.HEARTS;
        if(
                isSameCard(temp.get(0), Value.TWO, suitToCheck) &&
                        isSameCard(temp.get(1), Value.THREE, suitToCheck) &&
                        isSameCard(temp.get(2), Value.FOUR, suitToCheck) &&
                        isSameCard(temp.get(3), Value.FIVE, suitToCheck) &&
                        isSameCard(temp.get(size-1), Value.ACE, suitToCheck)
        ){
            return 15;
        }
        suitToCheck = Suit.DIAMONDS;
        if(
                isSameCard(temp.get(0), Value.TWO, suitToCheck) &&
                        isSameCard(temp.get(1), Value.THREE, suitToCheck) &&
                        isSameCard(temp.get(2), Value.FOUR, suitToCheck) &&
                        isSameCard(temp.get(3), Value.FIVE, suitToCheck) &&
                        isSameCard(temp.get(size-1), Value.ACE, suitToCheck)
        ){
            return 15;
        }
        suitToCheck = Suit.SPADES;
        if(
                isSameCard(temp.get(0), Value.TWO, suitToCheck) &&
                        isSameCard(temp.get(1), Value.THREE, suitToCheck) &&
                        isSameCard(temp.get(2), Value.FOUR, suitToCheck) &&
                        isSameCard(temp.get(3), Value.FIVE, suitToCheck) &&
                        isSameCard(temp.get(size-1), Value.ACE, suitToCheck)
        ){
            return 15;
        }
        suitToCheck = Suit.CLUBS;
        if(
                isSameCard(temp.get(0), Value.TWO, suitToCheck) &&
                        isSameCard(temp.get(1), Value.THREE, suitToCheck) &&
                        isSameCard(temp.get(2), Value.FOUR, suitToCheck) &&
                        isSameCard(temp.get(3), Value.FIVE, suitToCheck) &&
                        isSameCard(temp.get(size-1), Value.ACE, suitToCheck)
        ){
            return 15;
        }

        //Non Ace case
        // Check if an array is consecutive logic
//        int countSF = 1; // If 5 then yes. Started at 1 because the first card of the count is already there
//        for(int i = 1; i < size; i++){
//            if(temp.get(i).getValue().getCardValue() == temp.get(i-1).getValue().getCardValue()+1 && temp.get(i).getSuit() == temp.get(i-1).getSuit()){
//                countSF++;
//            }
//            else{
//                break;
//            }
//        }
//        if(countSF >= 5) return 50;

        // Go backward for higher to lower score
        // idx Size-1 to Size-5
        // idx Size-2 to Size-6
        // idx Size-3 to Size-7
        // Can probably do it manually
        // Return sum as score
        // n*(n+1)/2
        // TODO: Implement this ^
        int sum=0;
        int countSF = 0;
        for(int i = size-1; i >= size-5; i--){
            if(i == size-1){
                sum += temp.get(i).getValue().getCardValue();
                countSF+=1;
            }
            else{
                if((temp.get(i).getValue().getCardValue() == temp.get(i-1).getValue().getCardValue()+1) && (temp.get(i).getSuit() == temp.get(i-1).getSuit())){
                    sum += temp.get(i).getValue().getCardValue();
                    countSF+=1;
                }
                else{
                    break;
                }
            }
        }
        if(countSF==5){
            return sum;
        }

        countSF=0;
        sum=0;
        for(int i = size-2; i >= size-6; i--){
            if(i == size-2){
                sum += temp.get(i).getValue().getCardValue();
                countSF+=1;
            }
            else{
                if((temp.get(i).getValue().getCardValue() == temp.get(i-1).getValue().getCardValue()+1) && (temp.get(i).getSuit() == temp.get(i-1).getSuit())){
                    sum += temp.get(i).getValue().getCardValue();
                    countSF+=1;
                }
                else{
                    break;
                }
            }
        }
        if(countSF==5){
            return sum;
        }

        countSF=0;
        sum=0;
        for(int i = size-3; i >= size-7; i--){
            if(i == size-3){
                sum += temp.get(i).getValue().getCardValue();
                countSF+=1;
            }
            else{
                if((temp.get(i).getValue().getCardValue() == temp.get(i-1).getValue().getCardValue()+1) && (temp.get(i).getSuit() == temp.get(i-1).getSuit())){
                    sum += temp.get(i).getValue().getCardValue();
                    countSF+=1;
                }
                else{
                    break;
                }
            }
        }
        if(countSF==5){
            return sum;
        }

        return -1;
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
