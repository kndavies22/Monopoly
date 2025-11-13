package upei.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import upei.project.Space.GoToJail;
import upei.project.Space.Jail;
import upei.project.Space.Property;
import upei.project.Space.Space;
import upei.project.Strategy.CollectorStrategy;
import upei.project.Strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit tests for the Game class, ensuring that the game's initialization, player management,
 * scenarios (such as Jail and Go to Jail), and winner determination work as expected.
 */
public class GameTest {

    private Game game; // Game instance to test
    private List<Player> players; // List of players in the game

    /**
     * Initializes the test environment by creating players with strategies and setting up the game.
     * This method is run before each test to ensure the tests start with a clean state.
     */
    @BeforeEach
    public void setUp() {
        // Initialize players with specific strategies
        Strategy strategy1 = new CollectorStrategy("green");
        Strategy strategy2 = new CollectorStrategy("blue");
        Player player1 = new Player("Player 1", 1, strategy1);
        Player player2 = new Player("Player 2", 2, strategy2);
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        // Initialize the game with the players
        game = new Game(players);
    }

    /**
     * Tests the game initialization to ensure the game object and players are correctly initialized.
     * Verifies that the game and players are properly set up.
     */
    @Test
    public void testGameInitialization() {
        // Assert that the game is not null and players are initialized correctly
        assertNotNull(game);
        assertEquals(2, players.size());
        assertEquals("Player 1", players.get(0).getName());
        assertEquals("Player 2", players.get(1).getName());
    }

    /**
     * Tests the player elimination scenario where a player goes bankrupt and is eliminated from the game.
     * Verifies that the player is removed from the game and the remaining player is the winner.
     */
    @Test
    public void testPlayerElimination() {
        // Simulate Player 1 going bankrupt
        players.get(0).setBalance(-200);
        game.startGame();

        // Assert that only one player remains in the game
        assertEquals(1, players.size());
        assertEquals("Player 2", players.get(0).getName()); // Player 2 should be the only remaining player
    }

    /**
     * Tests the Jail scenario where a player is placed in Jail.
     * Verifies that the player is correctly added to jail and remains there after an action is taken.
     */
    @Test
    public void testJailScenario() {
        Jail jail = new Jail("Jail"); // Create Jail space at position 9
        players.get(0).setPosition(9); // Place Player 1 in Jail
        jail.addPlayerToJail(players.get(0));

        // Assert that Player 1 is in jail
        assertTrue(jail.isPlayerInJail(players.get(0)));

        // Perform an action on the Jail space (e.g., staying in jail)
        jail.action(players.get(0));

        // Assert that Player 1 remains in jail after the action
        assertTrue(players.get(0).isInJail());
    }

    /**
     * Tests the Go to Jail scenario where a player lands on a "Go to Jail" space.
     * Verifies that the player is sent to jail correctly when they land on the "Go to Jail" space.
     */
    @Test
    public void testGoToJailScenario() {
        GoToJail goToJail = new GoToJail("Go to Jail"); // "Go to Jail" space at position 30

        // Trigger the action that sends the player to jail
        goToJail.action(players.get(0));

        // Assert that the player is in jail
        assertTrue(players.get(0).isInJail());
    }

    /**
     * Tests the winning condition in the game.
     * Verifies that the game correctly identifies the winner when a player's balance reaches the winning threshold.
     */
    @Test
    public void testWinningCondition() {
        // Simulate Player 1 reaching the winning balance
        players.get(0).setBalance(1500);
        game.determineWinner();

        // Assert that Player 1 is the winner
        assertEquals(2, players.size()); // Player count should be 2 (no one eliminated yet)
        assertEquals("Player 1", players.get(0).getName()); // Player 1 should be the winner
    }

    /**
     * Tests the winner determination logic where the game determines the winner based on the player's balance and properties.
     * Verifies that the game correctly identifies the player with the highest value, including balance and properties.
     */
    @Test
    public void testDetermineWinner() {
        // Simulate player balances and properties
        players.get(0).setBalance(1000);
        players.get(1).setBalance(1200);

        // Simulate property ownership
        players.get(0).addSpace(new Property("Boardwalk", 400, 500, "blue"));
        players.get(1).addSpace(new Property("Park Place", 350, 500, "blue"));

        // Start the game and determine the winner
        game.startGame();

        // Assert that Player 2 is the winner because they have the higher balance
        assertEquals("Player 2", players.get(0).getName()); // Player 2 should be the winner based on balance
    }
}
