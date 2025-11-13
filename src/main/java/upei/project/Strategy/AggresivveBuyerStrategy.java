package upei.project.Strategy;

import upei.project.Space.Property;

/**
 * AggresivveBuyerStrategy
 * This player tries to buy every property they land on if affordable
 * and aggressively upgrades properties once they own all of a color.
 * Implements the Strategy interface.
 */
public class AggresivveBuyerStrategy implements Strategy {

    /**
     * Determines whether the player should buy a given property based on the strategy.
     * The player will buy any unowned property if they can afford it.
     *
     * @param property the property to consider for purchase
     * @param balance  the player's available balance to buy the property
     * @return true if the property is unowned and affordable; false otherwise
     */
    @Override
    public boolean shouldBuyLand(Property property, int balance) {
        // Buys any unowned property if the player can afford it
        return !property.IsOwned() && balance >= property.getPrice();
    }

    /**
     * Determines whether the player should upgrade a given property based on the strategy.
     * The player always considers upgrading properties, regardless of the balance.
     *
     * @param property the property to consider for upgrade
     * @param balance  the player's available balance to upgrade the property
     * @return true if the player should upgrade the property (always true for this strategy)
     */
    @Override
    public boolean shouldBuyProperty(Property property, int balance) {
        // Always considers upgrading properties, regardless of balance
        return true;
    }
}
