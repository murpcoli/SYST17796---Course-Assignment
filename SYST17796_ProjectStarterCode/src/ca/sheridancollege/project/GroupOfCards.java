/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */

package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modifier Colin Murphy
 * @modifier Gagandeep Kooner
 */
abstract class GroupOfCards {

    ArrayList<Card> cards = new ArrayList<Card>();
    int score;

    public Card getCard(int i){
        return this.cards.get(i);
    }

    public void addCard(Card newCard){
        this.cards.add(newCard);
        setBlackjackScore();
    }

    public Card removeCard(){
        Card card = this.cards.get(0);
        this.cards.remove(0);
        setBlackjackScore();
        return card;
    }

    public Card removeCard(int i){
        Card card = this.cards.get(i);
        this.cards.remove(i);
        setBlackjackScore();
        return card;
    }

    public int getSize(){
        return this.cards.size();
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public int getBlackjackScore(){
        return this.score;
    }

    public void setBlackjackScore(){
        int score = 0;
        for (int i = 0; i < cards.size(); i++){
            score += cards.get(i).getValue();
        }
        this.score = score;
    }


}//end class