package upei.project.Space;

import upei.project.Player;

/**
 * Represents a utility space on the game board.
 * Players who land on this space must pay a utility tax.
 */
public class UtilitySpace extends Space {

    /**
     * The utility tax amount that players must pay when landing on this space.
     */
    private int tax;

    /**
     * Constructs a UtilitySpace with the specified name and tax amount.
     *
     * @param name the name of the utility space
     * @param tax  the tax amount to be paid by players
     */
    public UtilitySpace(String name, int tax) {
        super(name); // Initialize space name
        this.tax = tax; // Set the tax amount
    }

    /**
     * Executes the action for a player landing on the utility space.
     * Deducts the utility tax from the player's balance and logs the action.
     *
     * @param currentPlayer the player who landed on the utility space
     * @return true to indicate the action was successfully executed
     */
    @Override
    public boolean action(Player currentPlayer) {
        // Deducts the utility tax from the player's balance and logs the action
        System.out.println(currentPlayer.getName() + " pays a utility tax of " + tax);
        currentPlayer.makePayment(tax);
        return true; // Action is always successful
    }
}
