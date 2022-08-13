/**
 * SYST17796 Deliverable 3
 * Blackjack
 * August 12, 2022
 */

/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @modifier Colin Murphy
 * @modifier Gagandeep Kooner
 */
public class Card{

    private final Suit suit;
    private final Number number;

    public Card(Suit suit, Number number) {
        this.suit = suit;
        this.number = number;
    }

    public Suit getSuit() {
        return suit;
    }

    public Number getNumber() {
        return number;
    }

    public int getValue(){
        return number.getValue();
    }

    @Override
    public String toString(){

        String stringNum = number + "";
        String stringSuit = suit + "";
        stringNum = stringNum.substring(0,1).toUpperCase() 
            + stringNum.substring(1).toLowerCase();
        stringSuit = stringSuit.substring(0,1).toUpperCase() 
            + stringSuit.substring(1).toLowerCase();

        return "The " + stringNum + " of " + stringSuit;
    }

}