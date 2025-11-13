package upei.project.Space;

import upei.project.Player;

/**
 * Represents a plain space on the game board.
 * A plain space has no special effects or actions; players simply pass through.
 */
public class PlainSpace extends Space {

    /**
     * Creates a plain space with the specified name.
     *
     * @param name the name of the space
     */
    public PlainSpace(String name) {
        super(name); // Initialize the space with a name
    }

    /**
     * Performs the action for a player landing on the plain space.
     * Since this is a plain space, no specific action is performed.
     *
     * @param player the player who landed on this space
     * @return true to indicate the action was performed (even though no action is taken)
     */
    @Override
    public boolean action(Player player) {
        return true; // No specific action; player simply passes through
    }
}
