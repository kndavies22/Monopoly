package upei.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import upei.project.Space.*;
import upei.project.Strategy.CollectorStrategy;
import upei.project.Strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit tests for the Board class in the Monopoly game.
 * This class ensures the correct initialization and functionality of the Board, including space retrieval,
 * player movement, and the type of spaces on the board.
 */
public class BoardTest {

    private Board board; // Board instance to test
    private List<Player> players; // List of players in the game

    /**
     * Initializes the test environment by creating players with strategies and setting up the board.
     * This method is run before each test to ensure that tests are independent and start with a clean state.
     */
    @BeforeEach
    public void setUp() {
        // Create a list of players with specific strategies (CollectorStrategy for this example)
        players = new ArrayList<>();
        Strategy strategy1 = new CollectorStrategy("purple");
        Strategy strategy2 = new CollectorStrategy("blue");
        players.add(new Player("Player 1", 1, strategy1));
        players.add(new Player("Player 2", 2, strategy2));

        // Initialize the board with the players
        board = new Board(players);
    }

    /**
     * Tests the board initialization and ensures that the spaces are set up correctly.
     * Verifies that the space names at specific positions match the expected values.
     */
    @Test
    public void testBoardInitialization() {
        // Assert that the board is not null
        assertNotNull(board);

        // Test specific space names to ensure they match expected values
        assertNotNull(board.getSpaceAt(0)); // "Go" space
        assertEquals("Go", board.getSpaceAt(0).getName());
        assertEquals("Connecticut Ave", board.getSpaceAt(1).getName());
        assertEquals("Water Works", board.getSpaceAt(4).getName());
        assertEquals("Go to Jail!", board.getSpaceAt(5).getName());
        assertEquals("Jail", board.getSpaceAt(9).getName());
        assertEquals("Boardwalk", board.getSpaceAt(13).getName());
    }

    /**
     * Tests retrieving a space at a valid position and ensures the correct space is returned.
     * Verifies that the correct space object is retrieved from the board.
     */
    @Test
    public void testGetSpaceAtValidPosition() {
        // Retrieve space at position 1 and ensure it is not null and matches expected name
        Space space = board.getSpaceAt(1);
        assertNotNull(space);
        assertEquals("Connecticut Ave", space.getName());
    }

    /**
     * Tests retrieving a space at an invalid position and ensures the appropriate exception is thrown.
     * Verifies that the board correctly handles requests for out-of-bounds positions.
     */
    @Test
    public void testGetSpaceAtInvalidPosition() {
        // Expect an exception when trying to access a non-existing space at position 20
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            board.getSpaceAt(20); // Invalid index
        });
        // Assert the exception message matches the expected error message
        assertEquals("Invalid position: 20", exception.getMessage());
    }

    /**
     * Tests player movement within the bounds of the board.
     * Verifies that a player moves correctly based on the roll and position updates.
     */
    @Test
    public void testMovePlayerWithinBounds() {
        Player player = players.get(0);
        player.setPosition(0); // Start at "Go"
        int newPosition = board.movePlayer(player, 3); // Move 3 spaces
        // Assert that the new position is correct
        assertEquals(3, newPosition);
        assertEquals("Oriental Ave", board.getSpaceAt(newPosition).getName());
    }

    /**
     * Tests player movement with wrap-around functionality.
     * Verifies that if a player moves beyond the last space, they correctly wrap around to earlier spaces.
     */
    @Test
    public void testMovePlayerWithWrapAround() {
        Player player = players.get(0);
        player.setPosition(16); // Near the end of the board
        int newPosition = board.movePlayer(player, 3); // Move past the last space
        // Assert the player correctly wraps around to the start of the board
        assertEquals(1, newPosition); // Should wrap to "Connecticut Ave"
        assertEquals("Connecticut Ave", board.getSpaceAt(newPosition).getName());
    }

    /**
     * Tests that the spaces on the board are of the expected types.
     * Verifies that the correct types of spaces are present at the specified positions on the board.
     */
    @Test
    public void testSpacesContainExpectedTypes() {
        // Assert that spaces at specific positions are of the expected types (Property, UtilitySpace, GoToJail, Jail)
        assertTrue(board.getSpaceAt(1) instanceof Property);
        assertTrue(board.getSpaceAt(4) instanceof UtilitySpace);
        assertTrue(board.getSpaceAt(5) instanceof GoToJail);
        assertTrue(board.getSpaceAt(9) instanceof Jail);
        assertTrue(board.getSpaceAt(15) instanceof Property);
    }
}
