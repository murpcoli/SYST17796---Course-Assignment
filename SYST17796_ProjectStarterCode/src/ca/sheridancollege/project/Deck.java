/**
 * SYST17796 Deliverable 3
 * Blackjack
 * August 12, 2022
 * @author Colin Murphy
 * @author Gagandeep Kooner
 */

package ca.sheridancollege.project;

public class Deck extends GroupOfCards{

    public Deck(){
        generateDeck();
        setBlackjackScore();
    }

    public void generateDeck(){
        for (Suit s : Suit.values()){
            for (Number n : Number.values()){
                this.cards.add(new Card(s, n));
            }
        }
    }

    @Override
    public String toString(){
        String cardListOutput = "";
        int i = 0;
        for(Card card : this.cards){
            cardListOutput += "\n" + i + ": " + card.toString();
            i++;
        }
        return cardListOutput;
    }
}