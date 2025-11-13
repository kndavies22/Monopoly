package upei.project.Strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import upei.project.Space.Property;

/**
 * Unit tests for the various strategy implementations (AggresivveBuyerStrategy, CautiousSaverStrategy,
 * CollectorStrategy, DisruptiveStrategy) in the Monopoly game.
 * This class tests how different strategies decide on buying land and upgrading properties.
 */
public class StrategyTest {

    private Property unownedCheapProperty;
    private Property unownedExpensiveProperty;
    private Property ownedProperty;
    private Property upgradableProperty;

    /**
     * Sets up the test properties before each test.
     * This ensures that different test cases use distinct property objects for strategy evaluation.
     */
    @BeforeEach
    public void setUp() {
        // Initialize different test properties with different prices, ownerships, and upgrade levels
        unownedCheapProperty = new Property("Cheap Property", 100, 50, "blue");
        unownedExpensiveProperty = new Property("Expensive Property", 400, 100, "red");
        ownedProperty = new Property("Owned Property", 200, 100, "green");
        ownedProperty.setOwned(true); // Set property as already owned
        upgradableProperty = new Property("Upgradable Property", 300, 150, "blue");
        upgradableProperty.setOwned(true); // Set property as owned
        upgradableProperty.setUpgradeLevel(1); // Set initial upgrade level
    }

    /**
     * Tests the behavior of the AggresivveBuyerStrategy when deciding on property acquisition.
     * Verifies that the strategy aggressively buys land and upgrades properties when possible.
     */
    @Test
    public void testAggresivveBuyerStrategy() {
        Strategy strategy = new AggresivveBuyerStrategy();

        // Aggressive buyer should buy affordable property and any property if funds allow
        assertTrue(strategy.shouldBuyLand(unownedCheapProperty, 150), "Aggressive buyer should buy affordable property.");
        assertTrue(strategy.shouldBuyLand(unownedExpensiveProperty, 500), "Aggressive buyer should buy any property if affordable.");

        // Should not buy property if already owned
        assertFalse(strategy.shouldBuyLand(ownedProperty, 500), "Aggressive buyer should not buy owned property.");

        // Aggressive buyer should also upgrade properties aggressively
        assertTrue(strategy.shouldBuyProperty(upgradableProperty, 1000), "Aggressive buyer should upgrade properties aggressively.");
    }

    /**
     * Tests the behavior of the CautiousSaverStrategy when deciding on property acquisition.
     * Verifies that the strategy is more cautious about purchases, only buying affordable properties
     * and upgrading when it is safe.
     */
    @Test
    public void testCautiousSaverStrategy() {
        Strategy strategy = new CautiousSaverStrategy();

        // Cautious saver buys affordable property above a safety threshold
        assertTrue(strategy.shouldBuyLand(unownedCheapProperty, 300), "Cautious saver should buy affordable property above safety threshold.");

        // Cautious saver should avoid expensive properties if it exceeds the safety threshold
        assertFalse(strategy.shouldBuyLand(unownedExpensiveProperty, 500), "Cautious saver should not buy expensive property if it violates threshold.");

        // Should not buy owned properties
        assertFalse(strategy.shouldBuyLand(ownedProperty, 300), "Cautious saver should not buy owned property.");

        // Cautious saver upgrades property if it meets the safety threshold
        assertTrue(strategy.shouldBuyProperty(upgradableProperty, 500), "Cautious saver should upgrade property if above safety threshold.");
        assertFalse(strategy.shouldBuyProperty(upgradableProperty, 200), "Cautious saver should not upgrade property if below safety threshold.");
    }

    /**
     * Tests the behavior of the CollectorStrategy when deciding on property acquisition.
     * Verifies that the strategy targets specific property colors and upgrades properties that match the color.
     */
    @Test
    public void testCollectorStrategy() {
        Strategy strategy = new CollectorStrategy("blue");

        // Collector should only buy properties of a specific target color
        assertTrue(strategy.shouldBuyLand(unownedCheapProperty, 200), "Collector should buy property matching target color.");
        assertFalse(strategy.shouldBuyLand(unownedExpensiveProperty, 500), "Collector should not buy property not matching target color.");

        // Collector should not buy already owned properties
        assertFalse(strategy.shouldBuyLand(ownedProperty, 300), "Collector should not buy already owned property.");

        // Collector should upgrade properties that match the target color
        assertTrue(strategy.shouldBuyProperty(upgradableProperty, 1000), "Collector should upgrade properties matching target color.");
        assertFalse(strategy.shouldBuyProperty(ownedProperty, 1000), "Collector should not upgrade property not matching target color.");
    }

    /**
     * Tests the behavior of the DisruptiveStrategy when deciding on property acquisition.
     * Verifies that the strategy aims to disrupt other players by acquiring new property colors
     * and avoids upgrading properties.
     */
    @Test
    public void testDisruptiveStrategy() {
        DisruptiveStrategy strategy = new DisruptiveStrategy();
        strategy.addOwnedColor("blue"); // Simulate owning the "blue" color set

        // Disruptive player should buy properties of unowned colors
        assertTrue(strategy.shouldBuyLand(unownedExpensiveProperty, 500), "Disruptive player should buy property of unowned color.");

        // Disruptive player should avoid buying properties of owned colors
        assertFalse(strategy.shouldBuyLand(unownedCheapProperty, 200), "Disruptive player should not buy property of already owned color.");

        // Should not buy already owned properties
        assertFalse(strategy.shouldBuyLand(ownedProperty, 300), "Disruptive player should not buy already owned property.");

        // Disruptive player should not prioritize upgrades
        assertFalse(strategy.shouldBuyProperty(upgradableProperty, 1000), "Disruptive player should not prioritize upgrades.");
    }
}
