package ca.sheridancollege.project;

/**
 * SYST17796 Deliverable 3
 * Blackjack
 * August 12, 2022
 * @author Colin Murphy
 * @author Gagandeep Kooner
 */

import java.util.ArrayList;

public class BlackjackRound {

    //contains the collected bets for the round
    private static int pot;

    public static void play(ArrayList<Player> players, Deck deck){
        getBet(players);
        pot = createPot(players);
        deck.shuffle();
        dealStartingHand(players, deck, 2);
        hitOrStay(players, deck);
        ArrayList<Player> winners = determineRoundWinner(players);
        awardPot(players, winners, pot);
        InputOutput.showOutput("Press Enter to continue");
        InputOutput.getStringInput();
        returnHandsToDeck(players, deck);
    }

    //get bets from players
    public static void getBet(ArrayList<Player> players){

        //require all players to bet
        for (int i = 0; i < players.size(); i++){
            players.get(i).setHasBet(false);
            players.get(i).setIsAllIn(false);
        }
        int minBet = 20; //default minimum bet is 20
        int playerBet;
        boolean hasEveryoneBet = true;
        do {
            for (int i = 0; i < players.size(); i++){ //iterate through players
                if (!players.get(i).getHasBet() && !players.get(i).getIsAllIn()){ //if a player hasn't bet yet and isn't set to be all-in, ask them for a bet
                    InputOutput.showOutput("----------");
                    if (players.get(i).getCurrentMoney() >= minBet){ //if a player has enough money to make a bet, ask them for a bet
                        InputOutput.showOutput("Player " + players.get(i).getId() + ", How much will you bet? (Minimum bet: " + minBet + ")");
                        InputOutput.showOutput("Current Money: " + players.get(i).getCurrentMoney());
                        playerBet = InputOutput.getIntInput(minBet, players.get(i).getCurrentMoney());
                        players.get(i).setBet(playerBet);
                        players.get(i).setHasBet(true);
                        if (playerBet > minBet){ //if a player bets higher than the minimum, all other players must bet again to match the new minimum bet
                            for (int j = 0; j < players.size(); j++){ 
                               players.get(j).setHasBet(false);
                            }
                            minBet = playerBet;
                            players.get(i).setHasBet(true);
                        }
                    } else { //if a player doesn't have enough money to make a bet, set them to be all-in for the round
                        InputOutput.showOutput("Player " + players.get(i).getId() + ", you do not have enough money to reach the minumum bet.");
                        InputOutput.showOutput("You will be all-in this round. Press Enter to continue.");
                        InputOutput.getStringInput();
                        players.get(i).setBet(players.get(i).getCurrentMoney());
                        players.get(i).setIsAllIn(true);
                    }
                }
            }   
            hasEveryoneBet = true;

            //check if all players have either reached the maximum bet or have been declared all-in
            for (int i = 0; i < players.size(); i++){
                if (!players.get(i).getHasBet() && !players.get(i).getIsAllIn()){
                    hasEveryoneBet = false;
                } 
            }
        } while (hasEveryoneBet == false);
    }

    public static int createPot(ArrayList<Player> players){
        int pot = 0;

        //create the pot for this round based off of player bets
        for (int i = 0; i < players.size(); i++){
            if (players.get(i).getBet() >= 0){
                players.get(i).setCurrentMoney(players.get(i).getCurrentMoney() - players.get(i).getBet());
                pot += players.get(i).getBet();
            }
        }
        return pot;
    }

    //deals starting hands to players from the deck
    public static boolean dealStartingHand(ArrayList<Player> players, Deck deck, int handSize){
        boolean wereCardsDealtSuccessfully = false;
        if (players.size() > 0 && handSize > 0 && deck.getSize() >= (players.size() * handSize)){
            for (int i = 0; i < players.size(); i++){
                for (int j = 0; j < handSize; j++){
                    players.get(i).getHand().addCard(deck.removeCard());
                }
            }
            wereCardsDealtSuccessfully = true;
        }
        return wereCardsDealtSuccessfully;
    }

    //allow players to hit or stay
    public static void hitOrStay(ArrayList<Player> players, Deck deck){
        for (int i = 0; i < players.size(); i++){
            InputOutput.showOutput("-----------------------");

            //enter loop that exits upon user choosing to stay, or having their total hand points go over 21
            boolean stay = false;
            do {
                InputOutput.showOutput("Player " + players.get(i).getId() +  ": " + (players.get(i).getCurrentMoney() 
                        + players.get(i).getBet()) + " money | " + players.get(i).getBet() + " bet" );
                InputOutput.showOutput("Player " + players.get(i).getId() +  "'s hand is:");
                InputOutput.showOutput(players.get(i).getHand().toString()); 

                //if player's current score is less or equal to 21, ask them if they want to hit or stay
                if (players.get(i).getHand().getBlackjackScore() <= 21){
                    InputOutput.showOutput("Would you like to (1)Hit, or (2)Stay?");
                    int hitOrStay = InputOutput.getIntInput(1, 2);
                    switch (hitOrStay){
                        case 1:
                            players.get(i).getHand().addCard(deck.removeCard());
                            break;
                        case 2:
                            stay = true;
                            break;
                        default:
                            break;
                    }
                } else { //if hand's score goes over 21, the player busts
                    InputOutput.showOutput("Bust! Your hand went over 21!");
                    InputOutput.showOutput("Press Enter to continue");
                    InputOutput.getStringInput();
                    stay = true;
                }
            } while (stay == false);
        }
    }

    //determines which player(s) won the round 
    public static ArrayList<Player> determineRoundWinner(ArrayList<Player> players){
        ArrayList<Player> winners = new ArrayList<Player>();
        for (int i = 0; i < players.size(); i++){

            //look at all players' hands that didnt bust
            if (players.get(i).getHand().getBlackjackScore() <= 21){ 
                //if the winners ArrayList is empty, add the first player with a valid hand
                if (winners.isEmpty()){
                    winners.add(players.get(i));

                //if a player had a better hand than the player(s) in the winners ArrayList, empty winners, and add the new player
                } else if (winners.get(0).getHand().getBlackjackScore() < players.get(i).getHand().getBlackjackScore()) {
                    winners.clear();
                    winners.add(players.get(i));

                //if a player got the same score as the player(s) in the winners ArrayList, add them to winners
                } else if (winners.get(0).getHand().getBlackjackScore() == players.get(i).getHand().getBlackjackScore()){
                    winners.add(players.get(i));
                }
            }
        }

        //display the winners of the round
        if (!winners.isEmpty()){
            InputOutput.showOutput("The winner(s) for this round with " + winners.get(0).getHand().getBlackjackScore() + " pts");
            for (int i = 0; i < winners.size(); i++){
                InputOutput.showOutput("Player " + winners.get(i).getId() + ((i < winners.size() - 1) ? ", " : ""));
            }
        } else {
            InputOutput.showOutput("There was no winner this round.");
        }
        return winners;
    }

    public static void awardPot(ArrayList<Player> players, ArrayList<Player> winners, int pot){

        //if there was 1 winner, they get the whole pot
        if (winners.size() == 1){
            InputOutput.showOutput("Player " + winners.get(0).getId() + " is awarded a pot of " + pot);
            winners.get(0).setCurrentMoney(winners.get(0).getCurrentMoney() + pot);

        
        //if there were no winners, the individual bets are returned to the players
        } else if (winners.size() == 0){
            InputOutput.showOutput("The pot of " + pot + " is returned to the players.");
            for (int i = 0; i < players.size(); i++){
                players.get(i).setCurrentMoney(players.get(i).getCurrentMoney() + players.get(i).getBet());
            }
        
        //if there were multiple winners, the pot is evenly split amongst them
        } else {
            int splitPot = (int)(pot / winners.size());
            InputOutput.showOutput("The winning players are awarded a split pot of " + splitPot + " each.");
            for (int i = 0; i < winners.size(); i++){
                winners.get(i).setCurrentMoney(winners.get(i).getCurrentMoney() + splitPot);
            }
        }
    }

    //returns all cards in a player's hand to the deck
    public static boolean returnHandsToDeck(ArrayList<Player> players, Deck deck){
        boolean wereCardsReturned = false;
        if (players.size() > 0){
            for (int i = 0; i < players.size(); i++){
                if (players.get(i).getHand().getSize() > 0){
                    players.get(i).getHand().discardHand(deck);
                    wereCardsReturned = true;
                }
            }
        }
        return wereCardsReturned;
    }
}
