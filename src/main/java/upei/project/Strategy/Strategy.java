package upei.project.Strategy;


import upei.project.Space.Property;

public interface Strategy {
    /**
     * Determines if the player should buy a property.
     *
     * @param property The property the player has landed on.
     * @param balance The current balance of the player.
     * @return true if the player decides to buy the property, false otherwise.
     */
    boolean shouldBuyLand(Property property, int balance);

    /**
     * Determines if the player should buy a house on a property they already own.
     *
     * @param property The property owned by the player.
     * @param balance The current balance of the player.
     * @return true if the player decides to buy a house, false otherwise.
     */
    boolean shouldBuyProperty(Property property, int balance);
}
