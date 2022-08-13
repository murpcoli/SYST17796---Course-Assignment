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
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modifier Colin Murphy
 * @modifier Gagandeep Kooner
 */
public class Player{

    private int id;
    private int currentMoney;
    private int bet;
    private boolean hasBet = false;
    private boolean isAllIn = false;
    private Hand hand = new Hand();
    

    public Player(int id, int startingMoney){
        this.id = id;
        this.currentMoney = startingMoney;
    }

    public int getId() {
        return id;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney){
        this.currentMoney = currentMoney;
    }
    
    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public boolean getHasBet(){
        return this.hasBet;
    }

    public void setHasBet(boolean hasBet){
        this.hasBet = hasBet;
    }

    public boolean getIsAllIn() {
        return isAllIn;
    }

    public void setIsAllIn(boolean isAllIn) {
        this.isAllIn = isAllIn;
    }

    public Hand getHand(){
        return this.hand;
    }

    public void setHand(Hand hand){
        this.hand = hand;
    }

    @Override
    public String toString(){
        return "----------\nPlayer " + this.id + "\nMoney: " + this.currentMoney + "\nHand: " + this.hand.toString() + "\n----------\n";
    }

}
    


