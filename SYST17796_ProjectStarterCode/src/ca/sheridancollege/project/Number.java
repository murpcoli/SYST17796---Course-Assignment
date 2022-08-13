/**
 * SYST17796 Deliverable 3
 * Blackjack
 * August 12, 2022
 * @author Colin Murphy
 * @author Gagandeep Kooner
 */
package ca.sheridancollege.project;

public enum Number {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    public final int numValue;

    private Number(int numValue) {
        this.numValue = numValue;
    }

    public int getValue(){
        return numValue;
    }
}