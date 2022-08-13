/**
 * SYST17796 Deliverable 3
 * Blackjack
 * August 12, 2022
 * @author Colin Murphy
 * @author Gagandeep Kooner
 */
package ca.sheridancollege.project;

public class Hand extends GroupOfCards{

    public Hand(Card... card){
        for (int i = 0; i < card.length; i++){
            cards.add(card[i]);
        }
        setBlackjackScore();
    }

    public void discardHand(Deck deck){
        while (cards.size() != 0){
            deck.addCard(removeCard());
        }
    }

    @Override
    public String toString(){
        String handString = "";
        int index = 0;
        for (Card card : this.cards){
            handString += card.toString() + (index == (cards.size() - 1)? "" : ", ");
            index++;
        }
        return "(" + getBlackjackScore()+ " pts) " + handString;
    }
    
}