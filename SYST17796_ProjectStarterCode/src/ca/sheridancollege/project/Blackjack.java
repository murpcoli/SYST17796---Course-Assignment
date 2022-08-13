/**
 * SYST17796 Deliverable 3
 * Blackjack
 * August 12, 2022
 * @author Colin Murphy
 * @author Gagandeep Kooner
 */

package ca.sheridancollege.project;

import java.util.ArrayList;
public class Blackjack {
    public static void main(String[] args) throws Exception {

        //Welcome message and menu
        int mainMenuChoice;
        do {
            showMainMenu();
            mainMenuChoice = InputOutput.getIntInput(1, 3);
            switch (mainMenuChoice){
                case 1:
                    break;
                case 2:
                displayInstructions();
                InputOutput.showOutput("Press Enter to continue");
                InputOutput.getStringInput(); //press enter to continue
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (mainMenuChoice != 1);


        //create player list and deck
        ArrayList<Player> players = new ArrayList<Player>();
        Deck deck = new Deck();
        int playAgain = 1;
        do {

            //create players and set starting money
            int numPlayers = getNumPlayers();
            int startingMoney = getStartingMoney();
            createPlayers(players, numPlayers, startingMoney);

            //play blackjack rounds
            do {
                BlackjackRound.play(players, deck);
                checkForLosers(players);
                
                //keep playing rounds until all but one player has been eliminated
            } while (players.size() > 1);

            //declare blackjack winner, check if a new game is desired
            declareGameWinner(players);

            InputOutput.showOutput("What would you like to do?");
            InputOutput.showOutput("(1)Start a new game, (2)Exit game");
            playAgain = InputOutput.getIntInput(1, 2);
        } while (playAgain == 1);
        InputOutput.showOutput("Thank you for playing!");
    }

    private static void showMainMenu() {
        InputOutput.showOutput("Welcome to Blackjack!");
        InputOutput.showOutput("Please select an option:");
        InputOutput.showOutput("(1) Play Blackjack");
        InputOutput.showOutput("(2) Show Blackjack Instructions");
        InputOutput.showOutput("(3) Exit Program");
    }

    //displays instructions to blackjack
    public static void displayInstructions(){
        InputOutput.showOutput("-------------------------------------------");
        InputOutput.showOutput("B L A C K J A C K   I N S T R U C T I O N S");
        InputOutput.showOutput("-------------------------------------------");
        InputOutput.showOutput("The object of the game is to have your hand's value reach as close to 21 as possible, without going over.");
        InputOutput.showOutput("Players place a bet on who will win the round. The money is collected into a pot.");
        InputOutput.showOutput("Every player is dealt 2 cards. The player can choose to hit, which will draw another card into their hand.");
        InputOutput.showOutput("When a player is satisfied with their hand, they may choose to stay.");
        InputOutput.showOutput("The player with the hand closest to 21 wins the pot.");
        InputOutput.showOutput("The game ends when there is only 1 Player left with money.");
        InputOutput.showOutput("");
    }

    //sets number of players as well as starting money
    public static boolean createPlayers(ArrayList<Player> players, int numPlayers, int startingMoney){
        players.clear();

        //create players based on numPlayers and startingScore, deal all players 2 cards
        if (numPlayers > 0 && startingMoney >=0){
            for (int i = 0; i < numPlayers; i++){
                players.add(new Player(i + 1, startingMoney));
            }
            return true;
        }
        return false;
    }

    private static int getStartingMoney() {
        InputOutput.showOutput("How much money should each player start with? (minimum value is 20)");
        int startingMoney = InputOutput.getIntInput(20);
        return startingMoney;
    }

    private static int getNumPlayers() {
        InputOutput.showOutput("How many players? (2 to 5 players)");
        int numPlayers = InputOutput.getIntInput(2, 5);
        return numPlayers;
    }

    //if any players have a current money value of 0, they are removed from the ArrayList
    public static boolean checkForLosers(ArrayList<Player> players){
        boolean werePlayersRemoved = false;
        for (int i = 0; i < players.size(); i++){
            if (players.get(i).getCurrentMoney() == 0){
                InputOutput.showOutput("Player " + players.get(i).getId() + " has run out of money. They are removed from the game.");
                players.remove(i);
                werePlayersRemoved = true;
                i--;
            }
        }
        return werePlayersRemoved;
    }

    //once the players ArrayList has 1 entry in it, a winner is declared
    public static void declareGameWinner(ArrayList<Player> players){
        InputOutput.showOutput("----------");
        InputOutput.showOutput("Congratulations, Player " + players.get(0).getId() + "! You've won the game!");
        InputOutput.showOutput("Your finishing money total is: " + players.get(0).getCurrentMoney());
        InputOutput.showOutput("");
    }
}