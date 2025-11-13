package upei.project.Space;

import upei.project.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the Jail space on the game board.
 * Tracks players who are in Jail and manages their time served.
 */
public class Jail extends Space {

    /**
     * Tracks players currently in Jail and the number of turns they have served.
     * The key is the player, and the value is the number of turns served.
     */
    private Map<Player, Integer> playersInJail;

    /**
     * Creates a Jail space with the specified name.
     *
     * @param name the name of the space
     */
    public Jail(String name) {
        super(name);
        this.playersInJail = new HashMap<>();
    }

    /**
     * Performs the action for a player landing on the Jail space.
     * If the player is in Jail, their turn count is updated.
     * If the player has served 2 turns, they are released from Jail.
     * If the player is not in Jail, they are just visiting.
     *
     * @param player the player who landed on the Jail space
     * @return true to indicate the action was performed
     */
    @Override
    public boolean action(Player player) {
        if (playersInJail.containsKey(player)) {
            int turnsInJail = playersInJail.get(player);

            if (turnsInJail >= 2) {
                System.out.println(player.getName() + " has served their time and is released from Jail!");
                releasePlayer(player);
            } else {
                System.out.println(player.getName() + " remains in Jail (Turn " + (turnsInJail + 1) + " of 2)");
                playersInJail.put(player, turnsInJail + 1); // Increment turn count
            }
        } else {
            System.out.println(player.getName() + " is just visiting Jail.");
        }
        return true;
    }

    /**
     * Adds a player to Jail and initializes their turn count.
     * If the player is already in Jail, no changes are made.
     *
     * @param player the player to add to Jail
     */
    public void addPlayerToJail(Player player) {
        if (!playersInJail.containsKey(player)) {
            System.out.println(player.getName() + " is sent to Jail!");
            playersInJail.put(player, 1); // First turn in Jail
            player.toggleJailStatus();
        } else {
            System.out.println(player.getName() + " is already in Jail.");
        }
    }

    /**
     * Releases a player from Jail and removes them from the tracking map.
     * Also updates the player's Jail status.
     *
     * @param player the player to release from Jail
     */
    public void releasePlayer(Player player) {
        if (playersInJail.containsKey(player)) {
            playersInJail.remove(player);
            player.toggleJailStatus();
            System.out.println(player.getName() + " has been released from Jail!");
        }
    }

    /**
     * Checks if a player is currently in Jail.
     *
     * @param player the player to check
     * @return true if the player is in Jail, false otherwise
     */
    public boolean isPlayerInJail(Player player) {
        return playersInJail.containsKey(player);
    }
}
