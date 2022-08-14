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
public class BlackjackTest {
    
    public BlackjackTest() {
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
    public void testCreatePlayersGood() {
        System.out.println("Testing createPlayersGood");
        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Testing numPlayers = 4, startingMoney = 50");
        int numPlayers = 4;
        int startingMoney = 50;
        boolean result = Blackjack.createPlayers(players, numPlayers, startingMoney);
        boolean expResult = true;
        assertEquals(expResult, result);
    }
    
    @Test 
    public void testCreatePlayersBad(){
        System.out.println("Testing createPlayersBad");
        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Testing numPlayers = -20, startingMoney = -20");
        int numPlayers = -20;
        int startingMoney = -20;
        boolean result = Blackjack.createPlayers(players, numPlayers, startingMoney);
        boolean expResult = false;
        assertEquals(expResult, result);
    }
    
        @Test 
    public void testCreatePlayersBoundary(){
        System.out.println("Testing createPlayersBoundary");
        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Testing numPlayers = 1, startingMoney = 1");
        int numPlayers = 1;
        int startingMoney = 1;
        boolean result = Blackjack.createPlayers(players, numPlayers, startingMoney);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckForLosersGood() {
        System.out.println("Testing checkForLosersGood");
        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Testing Player 1 = 0, Player 2 = 0, Player 3 = 0, Player 4 = 0");
        players.add(new Player(1, 0));
        players.add(new Player(2, 0));
        players.add(new Player(3, 0));
        players.add(new Player(4, 0));
        boolean result = Blackjack.checkForLosers(players);
        boolean expResult = true;
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckForLosersBad() {
        System.out.println("Testing checkForLosersBad");
        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Testing Player 1 = 100, Player 2 = 100, Player 3 = 100, Player 4 = 100");
        players.add(new Player(1, 100));
        players.add(new Player(2, 100));
        players.add(new Player(3, 100));
        players.add(new Player(4, 100));
        boolean result = Blackjack.checkForLosers(players);
        boolean expResult = false;
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckForLosersBoundary() {
        System.out.println("Testing checkForLosersBoundary");
        ArrayList<Player> players = new ArrayList<Player>();
        System.out.println("Testing Player 1 = 100, Player 2 = 100, Player 3 = 0, Player 4 = 100");
        players.add(new Player(1, 100));
        players.add(new Player(2, 100));
        players.add(new Player(3, 0));
        players.add(new Player(4, 100));
        boolean result = Blackjack.checkForLosers(players);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    
}
