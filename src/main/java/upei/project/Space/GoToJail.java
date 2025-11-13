package upei.project.Space;

import upei.project.Player;

/**
 * Represents a "Go To Jail" space on the game board.
 * When a player lands on this space, they are sent to Jail.
 */
public class GoToJail extends Space {

    /**
     * Creates a "Go To Jail" space with the specified name.
     *
     * @param name the name of the space
     */
    public GoToJail(String name) {
        super(name);
    }

    /**
     * Executes the action associated with the "Go To Jail" space.
     * Sends the current player to Jail, updates their position to
     * the Jail's location, and toggles their Jail status.
     *
     * @param currentPlayer the player who landed on this space
     * @return true to indicate that the action was successfully executed
     */
    @Override
    public boolean action(Player currentPlayer) {
        System.out.println(currentPlayer.getName() + " is sent to Jail!");
        currentPlayer.setPosition(9); // Assume Jail is at position 9
        currentPlayer.toggleJailStatus();

        return true;
    }
}
