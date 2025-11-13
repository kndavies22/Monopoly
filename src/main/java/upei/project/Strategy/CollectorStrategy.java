package upei.project.Strategy;

import upei.project.Space.Property;

/**
 * The CollectorStrategy class implements the Strategy interface.
 * This strategy focuses on collecting and upgrading properties of a specific target color.
 */
public class CollectorStrategy implements Strategy {
    private final String targetColor; // The color of properties this strategy aims to collect

    /**
     * Constructs a CollectorStrategy with a specified target color.
     *
     * @param targetColor the color of the properties to collect (e.g., "green")
     */
    public CollectorStrategy(String targetColor) {
        this.targetColor = targetColor;
    }

    /**
     * Determines whether the player should buy a given property based on the strategy.
     * The player will buy properties of the target color only if they are not owned and are affordable.
     *
     * @param property the property to consider for purchase
     * @param balance  the player's available balance to buy the property
     * @return true if the property is of the target color, not owned, and affordable; false otherwise
     */
    @Override
    public boolean shouldBuyLand(Property property, int balance) {
        // Buy only properties of the target color and if they are affordable
        return !property.IsOwned() && property.getColor().equals(targetColor) && balance >= property.getPrice();
    }

    /**
     * Determines whether the player should upgrade a given property based on the strategy.
     * The player will upgrade properties of the target color if they can afford the upgrade cost.
     *
     * @param property the property to consider for upgrade
     * @param balance  the player's available balance to upgrade the property
     * @return true if the property belongs to the target color and the player can afford the upgrade; false otherwise
     */
    @Override
    public boolean shouldBuyProperty(Property property, int balance) {
        // Upgrade properties only if they belong to the target color
        if (property.getColor().equals(targetColor)) {
            int upgradeCost = 10 * (property.getUpgradeLevel() + 1);
            return balance >= upgradeCost; // Check if the player can afford the upgrade
        }
        return false;
    }
}
