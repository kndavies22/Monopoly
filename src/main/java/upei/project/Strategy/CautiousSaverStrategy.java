package upei.project.Strategy;

import upei.project.Space.Property;

/**
 * CautiousSaverStrategy
 * This strategy represents a player who is cautious with their spending.
 * The player only buys or upgrades properties if doing so keeps their balance above a defined safety threshold.
 */
public class CautiousSaverStrategy implements Strategy {

    /**
     * The minimum balance the player wants to maintain after purchases or upgrades.
     * If the player's balance falls below this threshold, they will not buy or upgrade properties.
     */
    private static final int SAFETY_THRESHOLD = 200;

    /**
     * Determines whether the player should buy a property they land on.
     * The player buys the property only if it is unowned and purchasing it keeps their balance above the safety threshold.
     *
     * @param property the property the player landed on
     * @param balance  the player's current balance
     * @return true if the property should be bought, false otherwise
     */
    @Override
    public boolean shouldBuyLand(Property property, int balance) {
        // Buy land only if it's unowned and the balance stays above the safety threshold
        return !property.IsOwned() && (balance - property.getPrice() >= SAFETY_THRESHOLD);
    }

    /**
     * Determines whether the player should upgrade a property they already own.
     * The player upgrades the property only if the upgrade cost keeps their balance above the safety threshold.
     *
     * @param property the property to be upgraded
     * @param balance  the player's current balance
     * @return true if the property should be upgraded, false otherwise
     */
    @Override
    public boolean shouldBuyProperty(Property property, int balance) {
        // Upgrade property only if balance after upgrade cost remains above the safety threshold
        int upgradeCost = 10 * (property.getUpgradeLevel() + 1);
        return (balance - upgradeCost) >= SAFETY_THRESHOLD;
    }
}
