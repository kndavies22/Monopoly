package upei.project.Space;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import upei.project.Player;
import upei.project.Strategy.CollectorStrategy;

public class SpaceTest {

    private Player player1;
    private Player player2;
    private Jail jail;
    private GoToJail goToJail;
    private PlainSpace plainSpace;
    private Property property;
    private UtilitySpace utilitySpace;

    @BeforeEach
    public void setUp() {
        player1 = new Player("Player 1", 1, new CollectorStrategy("blue"));
        player2 = new Player("Player 2", 2, new CollectorStrategy("green"));

        jail = new Jail("Jail");
        goToJail = new GoToJail("Go to Jail!");
        plainSpace = new PlainSpace("Plain Space");
        property = new Property("Boardwalk", 400, 50, "blue");
        utilitySpace = new UtilitySpace("Electric Company", 45);
    }

    @Test
    public void testPlainSpaceAction() {
        assertTrue(plainSpace.action(player1), "Plain space should have no significant action.");
    }

    @Test
    public void testPropertyActionUnowned() {
        assertFalse(property.action(player1), "Unowned property should be purchasable.");
    }

    @Test
    public void testPropertyActionOwnedByAnother() {
        property.buy(player2);
        assertTrue(property.action(player1), "Owned property should trigger rent payment.");
        assertEquals(750 - 50, player1.getBalance(), "Rent should be deducted from the current player.");
        assertEquals(750 + 50, player2.getBalance(), "Rent should be added to the owner.");
    }

    @Test
    public void testPropertyActionOwnedBySelf() {
        property.buy(player1);
        assertTrue(property.action(player1), "Owned property by self should not trigger rent.");
        assertEquals(750, player1.getBalance(), "Balance should remain unchanged.");
    }

    @Test
    public void testGoToJailAction() {
        goToJail.action(player1);
        assertEquals(9, player1.getPosition(), "Player should be sent to the Jail space.");
        assertTrue(player1.isInJail(), "Player should have their jail status toggled.");
    }

    @Test
    public void testJailActionVisiting() {
        jail.action(player1);
        assertFalse(jail.isPlayerInJail(player1), "Player just visiting Jail should not be marked as in Jail.");
    }

    @Test
    public void testJailActionInJail() {
        jail.addPlayerToJail(player1);
        assertTrue(jail.isPlayerInJail(player1), "Player added to Jail should be marked as in Jail.");

        jail.action(player1); // First turn in Jail
        assertTrue(jail.isPlayerInJail(player1), "Player should still be in Jail after one turn.");

        jail.action(player1); // Second turn in Jail
        assertFalse(jail.isPlayerInJail(player1), "Player should be released after serving two turns in Jail.");
    }

    @Test
    public void testUtilitySpaceAction() {
        utilitySpace.action(player1);
        assertEquals(750 - 45, player1.getBalance(), "Utility tax should be deducted from player's balance.");
    }

    @Test
    public void testUtilitySpaceActionInsufficientFunds() {
        player1.setBalance(30); // Less than the tax amount
        utilitySpace.action(player1);
        assertEquals(0, player1.getBalance(), "Utility tax should result in a negative balance if insufficient funds.");
    }
}
