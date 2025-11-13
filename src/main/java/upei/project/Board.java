package upei.project;

import upei.project.Space.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Board class represents the game board, consisting of a collection of spaces.
 * Each space on the board could represent different types of spaces like properties, utilities, or special spaces like Jail.
 */
public class Board {
    private ArrayList<Space> spaces;

    /**
     * Constructor to initialize the board with a predefined set of spaces.
     * It sets up the properties, utilities, and other special spaces in a predefined order.
     *
     * @param players the list of players in the game (currently not used in the constructor)
     */
    public Board(List<Player> players) {
        spaces = new ArrayList<>();
        // Initialize board spaces
        spaces.add(new PlainSpace("Go"));  // "Go" space, where players start
        spaces.add(new Property("Connecticut Ave", 120, 50, "purple"));
        spaces.add(new Property("Vermont Ave", 100, 50, "purple"));
        spaces.add(new Property("Oriental Ave", 100, 50, "purple"));
        spaces.add(new UtilitySpace("Water Works", 25));
        spaces.add(new GoToJail("Go to Jail!"));
        spaces.add(new Property("Pennsylvania Ave", 320, 20, "green"));
        spaces.add(new Property("North Carolina Ave", 300, 20, "green"));
        spaces.add(new Property("Pacific Avenue", 300, 20, "green"));
        spaces.add(new Jail("Jail"));
        spaces.add(new Property("Marvin Gardens", 280, 200, "blue"));
        spaces.add(new UtilitySpace("Electric Company", 45));
        spaces.add(new Property("Park Place", 350, 200, "blue"));
        spaces.add(new Property("Boardwalk", 400, 200, "blue"));
        spaces.add(new UtilitySpace("Luxury Tax", 50));
        spaces.add(new Property("Kentucky Ave", 220, 16, "red"));
        spaces.add(new Property("Indiana Ave", 220, 17, "red"));
        spaces.add(new Property("Illinois Ave", 240, 18, "red"));
    }

    /**
     * Returns the space at the given position on the board.
     * If the position is invalid, an exception is thrown.
     *
     * @param position the position on the board (index of the space)
     * @return the Space object at the given position
     * @throws IndexOutOfBoundsException if the position is invalid (out of bounds)
     */
    public Space getSpaceAt(int position) {
        if (position >= 0 && position < spaces.size()) {
            return spaces.get(position);
        } else {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
    }

    /**
     * Moves the player a certain number of steps around the board.
     * The position is updated based on the number of steps taken.
     * If the player moves beyond the last space, they wrap around to the beginning.
     *
     * @param player the player to move
     * @param steps  the number of steps to move
     * @return the new position of the player after moving
     */
    public int movePlayer(Player player, int steps) {
        int currentPosition = player.getPosition();
        // Calculate new position, wrapping around if necessary
        int newPos = (currentPosition + steps) % spaces.size();
        player.setPosition(newPos);
        return newPos;
    }
}
