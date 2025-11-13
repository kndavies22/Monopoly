package upei.project.Space;

import upei.project.Player;

/**
 * Represents a space on the game board.
 * This is an abstract class that serves as the base for all specific types of spaces.
 */
public abstract class Space {

    /**
     * The name of the space.
     * This is a common property for all subclasses.
     */
    protected String name;

    /**
     * Constructs a space with the specified name.
     *
     * @param name the name of the space
     */
    public Space(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the space.
     *
     * @return the name of the space
     */
    public String getName() {
        return name;
    }

    /**
     * Executes the action associated with the space.
     * This method is abstract and must be implemented by subclasses.
     *
     * @param player the player who landed on the space
     * @return true if the action was successfully executed, false otherwise
     */
    public abstract boolean action(Player player);
}
