/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * SYST17796 Deliverable 3
 * Blackjack
 * August 12, 2022
 * @author Colin Murphy
 * @author Gagandeep Kooner
 */
public class BlackjackRoundTest {
    
    public BlackjackRoundTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreatePotGood() {
        System.out.println("Testing createPotGood");
        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Testing Player 1 = bet 50, Player 2 = bet 50, Player 3 = bet 50, Player 4 = bet 50");
        players.add(new Player(1, 100));
        players.get(0).setBet(50);
        players.add(new Player(2, 100));
        players.get(1).setBet(50);
        players.add(new Player(3, 100));
        players.get(2).setBet(50);
        players.add(new Player(4, 100));
        players.get(3).setBet(50);
        
        int expResult = 200;
        int result = BlackjackRound.createPot(players);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreatePotBad() {
        System.out.println("Testing createPotBad");
        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Testing Player 1 = bet -50, Player 2 = bet -50, Player 3 = bet -50, Player 4 = bet -50");
        players.add(new Player(1, 100));
        players.get(0).setBet(-50);
        players.add(new Player(2, 100));
        players.get(1).setBet(-50);
        players.add(new Player(3, 100));
        players.get(2).setBet(-50);
        players.add(new Player(4, 100));
        players.get(3).setBet(-50);
        
        int expResult = 0;
        int result = BlackjackRound.createPot(players);
        assertEquals(expResult, result);
    }
    
        @Test
    public void testCreatePotBoundary() {
        System.out.println("Testing createPotBoundary");
        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Testing Player 1 = bet 0, Player 2 = bet 0, Player 3 = bet 0, Player 4 = bet 0");
        players.add(new Player(1, 100));
        players.get(0).setBet(0);
        players.add(new Player(2, 100));
        players.get(1).setBet(0);
        players.add(new Player(3, 100));
        players.get(2).setBet(0);
        players.add(new Player(4, 100));
        players.get(3).setBet(0);
        
        int expResult = 0;
        int result = BlackjackRound.createPot(players);
        assertEquals(expResult, result);
    }

    @Test
    public void testDealStartingHandGood() {
        System.out.println("Testing dealStartingHandGood");
                ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Testing 4 players, deck size = 52, handSize = 2");
        players.add(new Player(1, 100));
        players.add(new Player(2, 100));
        players.add(new Player(3, 100));
        players.add(new Player(4, 100));
        Deck deck = new Deck();
        deck.shuffle();
        int handSize = 2;
        boolean result = BlackjackRound.dealStartingHand(players, deck, handSize);
        
        boolean expResult = true;
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDealStartingHandBad() {
        System.out.println("Testing dealStartingHandBad");
                ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Testing 4 players, deck size = 52, handSize = 100");
        players.add(new Player(1, 100));
        players.add(new Player(2, 100));
        players.add(new Player(3, 100));
        players.add(new Player(4, 100));
        Deck deck = new Deck();
        deck.shuffle();
        int handSize = 100;
        boolean result = BlackjackRound.dealStartingHand(players, deck, handSize);
        
        boolean expResult = false;
        assertEquals(expResult, result);
    }
    
        @Test
    public void testDealStartingHandBoundary() {
        System.out.println("Testing dealStartingHandBoundary");
        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Testing 3 players, deck size = 52, handSize = 13");
        players.add(new Player(1, 100));
        players.add(new Player(2, 100));
        players.add(new Player(3, 100));
        players.add(new Player(4, 100));
        Deck deck = new Deck();
        deck.shuffle();
        int handSize = 13;
        boolean result = BlackjackRound.dealStartingHand(players, deck, handSize);
        
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void testDetermineRoundWinnerBoundary() {
        System.out.println("Testing determineRoundWinnerBoundary");
        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Testing Player 1 Score = 21, Player 2 Score = 18, Player 3 Score = 20, Player 4 Score = 15");
        players.add(new Player(1, 100));
        players.get(0).setHand(new Hand(new Card(Suit.HEARTS, Number.QUEEN), new Card(Suit.SPADES, Number.KING), new Card(Suit.CLUBS, Number.ACE)));
        players.add(new Player(2, 100));
        players.get(1).setHand(new Hand(new Card(Suit.HEARTS, Number.THREE), new Card(Suit.SPADES, Number.EIGHT), new Card(Suit.CLUBS, Number.SEVEN)));
        players.add(new Player(3, 100));
        players.get(2).setHand(new Hand(new Card(Suit.HEARTS, Number.JACK), new Card(Suit.SPADES, Number.TEN)));
        players.add(new Player(4, 100));
        players.get(3).setHand(new Hand(new Card(Suit.HEARTS, Number.ACE), new Card(Suit.SPADES, Number.FIVE), new Card(Suit.CLUBS, Number.NINE)));
        System.out.println("Player 1 = " + players.get(0).getHand().getBlackjackScore());
        System.out.println("Player 2 = " + players.get(1).getHand().getBlackjackScore());
        System.out.println("Player 3 = " + players.get(2).getHand().getBlackjackScore());
        System.out.println("Player 4 = " + players.get(3).getHand().getBlackjackScore());
        
        ArrayList<Player> output = BlackjackRound.determineRoundWinner(players);
        int result = output.size();
        int expResult = 1;
        assertEquals(expResult, result);
    }
    
        @Test
    public void testDetermineRoundWinnerBad() {
        System.out.println("Testing determineRoundWinnerBad");
        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Testing Player 1 Score = 31, Player 2 Score = 28, Player 3 Score = 30, Player 4 Score = 25");
        players.add(new Player(1, 100));
        players.get(0).setHand(new Hand(new Card(Suit.HEARTS, Number.QUEEN), new Card(Suit.SPADES, Number.KING), new Card(Suit.CLUBS, Number.ACE), new Card(Suit.DIAMONDS, Number.TEN)));
        players.add(new Player(2, 100));
        players.get(1).setHand(new Hand(new Card(Suit.HEARTS, Number.THREE), new Card(Suit.SPADES, Number.EIGHT), new Card(Suit.CLUBS, Number.SEVEN), new Card(Suit.DIAMONDS, Number.JACK)));
        players.add(new Player(3, 100));
        players.get(2).setHand(new Hand(new Card(Suit.HEARTS, Number.JACK), new Card(Suit.SPADES, Number.TEN), new Card(Suit.DIAMONDS, Number.QUEEN)));
        players.add(new Player(4, 100));
        players.get(3).setHand(new Hand(new Card(Suit.HEARTS, Number.ACE), new Card(Suit.SPADES, Number.FIVE), new Card(Suit.CLUBS, Number.NINE), new Card(Suit.DIAMONDS, Number.KING)));
        System.out.println("Player 1 = " + players.get(0).getHand().getBlackjackScore());
        System.out.println("Player 2 = " + players.get(1).getHand().getBlackjackScore());
        System.out.println("Player 3 = " + players.get(2).getHand().getBlackjackScore());
        System.out.println("Player 4 = " + players.get(3).getHand().getBlackjackScore());
        
        ArrayList<Player> output = BlackjackRound.determineRoundWinner(players);
        int result = output.size();
        int expResult = 0;
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDetermineRoundWinnerGood() {
        System.out.println("Testing determineRoundWinnerGood");
        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Testing Player 1 Score = 21, Player 2 Score = 21, Player 3 Score = 21, Player 4 Score = 21");
        players.add(new Player(1, 100));
        players.get(0).setHand(new Hand(new Card(Suit.HEARTS, Number.TEN), new Card(Suit.HEARTS, Number.JACK), new Card(Suit.HEARTS, Number.ACE)));
        players.add(new Player(2, 100));
        players.get(1).setHand(new Hand(new Card(Suit.SPADES, Number.TEN), new Card(Suit.SPADES, Number.JACK), new Card(Suit.SPADES, Number.ACE)));
        players.add(new Player(3, 100));
        players.get(2).setHand(new Hand(new Card(Suit.DIAMONDS, Number.TEN), new Card(Suit.DIAMONDS, Number.JACK), new Card(Suit.DIAMONDS, Number.ACE)));
        players.add(new Player(4, 100));
        players.get(3).setHand(new Hand(new Card(Suit.CLUBS, Number.TEN), new Card(Suit.CLUBS, Number.JACK), new Card(Suit.CLUBS, Number.ACE)));
        System.out.println("Player 1 = " + players.get(0).getHand().getBlackjackScore());
        System.out.println("Player 2 = " + players.get(1).getHand().getBlackjackScore());
        System.out.println("Player 3 = " + players.get(2).getHand().getBlackjackScore());
        System.out.println("Player 4 = " + players.get(3).getHand().getBlackjackScore());
        
        ArrayList<Player> output = BlackjackRound.determineRoundWinner(players);
        int result = output.size();
        int expResult = 4;
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAwardPotBoundary() {
        System.out.println("Testing awardPotBoundary");
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Player> winners = new ArrayList<Player>();
        int pot = 400;
        System.out.println("Testing Player 1 = winner, Player 2 = loser, Player 3 = loser, Player 4 = loser");
        players.add(new Player(1, 100));
        players.get(0).setBet(100);
        winners.add(players.get(0));
        players.add(new Player(2, 100));
        players.get(1).setBet(100);
        players.add(new Player(3, 100));
        players.get(2).setBet(100);
        players.add(new Player(4, 100));
        players.get(3).setBet(100);
        
        BlackjackRound.awardPot(players, winners, pot);
        
        int expResult = 500;
        int result = players.get(0).getCurrentMoney();
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAwardPotBad() {
        System.out.println("Testing awardPotBad");
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Player> winners = new ArrayList<Player>();
        int pot = 400;
        System.out.println("Testing Player 1 = loser, Player 2 = loser, Player 3 = loser, Player 4 = loser");
        players.add(new Player(1, 100));
        players.get(0).setBet(100);
        players.add(new Player(2, 100));
        players.get(1).setBet(100);
        players.add(new Player(3, 100));
        players.get(2).setBet(100);
        players.add(new Player(4, 100));
        players.get(3).setBet(100);
        
        BlackjackRound.awardPot(players, winners, pot);
        
        int expResult = 200;
        int result = players.get(0).getCurrentMoney();
        
        assertEquals(expResult, result);
    }
    
        @Test
    public void testAwardPotGood() {
        System.out.println("Testing awardPotGood");
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Player> winners = new ArrayList<Player>();
        int pot = 400;
        System.out.println("Testing Player 1 = winner, Player 2 = winner, Player 3 = winner, Player 4 = winner");
        players.add(new Player(1, 100));
        players.get(0).setBet(100);
        winners.add(players.get(0));
        players.add(new Player(2, 100));
        players.get(1).setBet(100);
        winners.add(players.get(1));
        players.add(new Player(3, 100));
        players.get(2).setBet(100);
        winners.add(players.get(2));
        players.add(new Player(4, 100));
        players.get(3).setBet(100);
        winners.add(players.get(3));
        
        BlackjackRound.awardPot(players, winners, pot);
        
        int expResult = 200;
        int result = players.get(0).getCurrentMoney();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testReturnHandsToDeckGood() {
        System.out.println("Testing returnHandsToDeckGood");
                ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Testing Player 1  = 3 cards, Player 2 = 3 cards, Player 3 = 3 cards1, Player 4 = 3 cards");
        Deck deck = new Deck();
        deck.shuffle();
        players.add(new Player(1, 100));
        players.add(new Player(2, 100));
        players.add(new Player(3, 100));
        players.add(new Player(4, 100));
        
        BlackjackRound.dealStartingHand(players, deck, 3);
        
        for (int i = 0; i < players.size(); i++){
            System.out.print("Player " + players.get(i).getId() + " hand size: " + players.get(i).getHand().getSize() + "\t");
        }
        System.out.println();
 
        boolean result = BlackjackRound.returnHandsToDeck(players, deck);
        
        for (int i = 0; i < players.size(); i++){
            System.out.print("Player " + players.get(i).getId() + " hand size: " + players.get(i).getHand().getSize() + "\t");
        }
        System.out.println();
        
        boolean expResult = true;
        assertEquals(expResult, result);
    }
    
    @Test
    public void testReturnHandsToDeckBad() {
        System.out.println("Testing returnHandsToDeckBad");
                ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Testing Player 1  = 0 cards, Player 2 = 0 cards, Player 3 = 0 cards1, Player 4 = 0 cards");
        Deck deck = new Deck();
        deck.shuffle();
        players.add(new Player(1, 100));
        players.add(new Player(2, 100));
        players.add(new Player(3, 100));
        players.add(new Player(4, 100));
        
        BlackjackRound.dealStartingHand(players, deck, 0);
        
        for (int i = 0; i < players.size(); i++){
            System.out.print("Player " + players.get(i).getId() + " hand size: " + players.get(i).getHand().getSize() + "\t");
        }
        System.out.println();
 
        boolean result = BlackjackRound.returnHandsToDeck(players, deck);
        
        for (int i = 0; i < players.size(); i++){
            System.out.print("Player " + players.get(i).getId() + " hand size: " + players.get(i).getHand().getSize() + "\t");
        }
        System.out.println();
        
        boolean expResult = false;
        assertEquals(expResult, result);
    }
    
    @Test
    public void testReturnHandsToDeckBoundary() {
        System.out.println("Testing returnHandsToDeckBoundary");
                ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Testing Player 1  = 0 cards, Player 2 = 0 cards, Player 3 = 0 cards1, Player 4 = 0 cards");
        Deck deck = new Deck();
        deck.shuffle();
        players.add(new Player(1, 100));
        players.add(new Player(2, 100));
        players.add(new Player(3, 100));
        players.add(new Player(4, 100));
        
        BlackjackRound.dealStartingHand(players, deck, 1);
        
        for (int i = 0; i < players.size(); i++){
            System.out.print("Player " + players.get(i).getId() + " hand size: " + players.get(i).getHand().getSize() + "\t");
        }
        System.out.println();
 
        boolean result = BlackjackRound.returnHandsToDeck(players, deck);
        
        for (int i = 0; i < players.size(); i++){
            System.out.print("Player " + players.get(i).getId() + " hand size: " + players.get(i).getHand().getSize() + "\t");
        }
        System.out.println();
        
        boolean expResult = true;
        assertEquals(expResult, result);
    }
}
