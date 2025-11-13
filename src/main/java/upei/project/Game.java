package upei.project;

import upei.project.Space.GoToJail;
import upei.project.Space.Jail;
import upei.project.Space.Property;
import upei.project.Space.Space;

import java.util.ArrayList;
import java.util.List;

/**
 * Game class represents the core game logic for simulating a Monopoly-style game.
 * It handles the turns, player actions, winning conditions, and game management.
 */
public class Game {
    private Board board;
    private List<Player> players;
    private int currentPlayerIndex;
    private final int MAX_TURNS = 100; // Maximum number of turns before the game ends
    private int turnCounter;
    private Player winner;

    /**
     * Constructor to initialize the game with a list of players.
     * It creates a new board and initializes game variables like current player index, turn counter, and winner.
     *
     * @param players List of players participating in the game
     */
    public Game(List<Player> players) {
        this.board = new Board(players);
        this.players = players;
        this.currentPlayerIndex = 0;
        this.turnCounter = 0;
        this.winner = null;
    }

    /**
     * Returns the current winner of the game.
     *
     * @return the player who has won the game
     */
    public Player getWinner() {
        return winner; // Replace this with actual winner determination logic
    }

    /**
     * Resets the state of all players (e.g., balances, properties, etc.) at the start of a new simulation.
     */
    public void resetPlayerStates() {
        for (Player player : players) {
            player.reset();
        }
    }

    /**
     * Starts the game and simulates the rounds of play.
     * It runs the game loop where players take turns, land on spaces, and perform actions (buying properties, paying rent, etc.).
     * The game ends when a player reaches a certain balance or after a predefined maximum number of turns.
     */
    public void startGame() {
        System.out.println("Starting the game!");
        boolean gameIsActive = true;

        // Find the Jail space (assumed to be at position 9)
        Jail jailSpace = (Jail) board.getSpaceAt(9); // Assuming Jail is at position 9

        while (gameIsActive) {
            Player currentPlayer = players.get(currentPlayerIndex);

            // Check if the player is eliminated (balance is zero)
            if (currentPlayer.getBalance() == 0) {
                System.out.println(currentPlayer.getName() + " has been eliminated!");
                players.remove(currentPlayerIndex);
                determineWinner(); // Immediately determine the winner from the remaining players
                break; // End the game
            }

            System.out.println("\nIt's " + currentPlayer.getName() + "'s turn.");

            // If the player is in jail, they must perform the jail action
            if (jailSpace.isPlayerInJail(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " is in Jail.");
                jailSpace.action(currentPlayer); // Call Jail's action method
                // Skip the rest of the turn
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
                continue;
            }

            // Normal turn for players not in jail
            int roll = currentPlayer.takeTurn(); // The player rolls the dice
            int newPosition = board.movePlayer(currentPlayer, roll); // Move the player based on the dice roll
            Space landedSpace = board.getSpaceAt(newPosition); // Get the space the player landed on
            System.out.println(currentPlayer.getName() + " rolled a " + roll + " and landed on " + landedSpace.getName());

            // Handle "Go to Jail" logic
            if (landedSpace instanceof GoToJail) {
                System.out.println(currentPlayer.getName() + " is sent to Jail!");
                jailSpace.addPlayerToJail(currentPlayer); // Send player to jail
                continue;
            }

            // Handle the action on the landed space
            if (!landedSpace.action(currentPlayer)) {
                if (landedSpace instanceof Property) {
                    Property property = (Property) landedSpace;
                    if (currentPlayer.considerBuyingHouse(property)) {
                        System.out.println(currentPlayer.getName() + " bought " + property.getName());
                    }
                }
            }

            // Check if the player has won (balance of $1500 or more)
            if (currentPlayer.getBalance() >= 1500) {
                System.out.println(currentPlayer.getName() + " wins by reaching $1500!");
                break;
            }

            turnCounter++;
            if (turnCounter >= MAX_TURNS) {
                gameIsActive = false;
                determineWinner(); // Determine the winner after the maximum number of turns
                break;
            }

            // Move to the next player
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    /**
     * Determines the winner at the end of the game by sorting players based on their balance and the number of properties they own.
     * The player with the highest balance (and then the most properties) is declared the winner.
     */
    public void determineWinner() {
        // Sort players by balance first, then by number of owned properties
        players.sort((p1, p2) -> {
            int balanceDiff = p2.getBalance() - p1.getBalance(); // Compare by balance
            if (balanceDiff != 0) {
                return balanceDiff; // If balances are different, sort by balance
            }
            return p2.getNumberOwned() - p1.getNumberOwned(); // Otherwise, sort by properties owned
        });

        System.out.println("Game Over! Evaluating the remaining players:");

        // Print the standings
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            System.out.println((i + 1) + ": " + player.getName() + " - Balance: $"
                    + player.getBalance() + ", Properties Owned: " + player.getNumberOwned());
        }

        // Announce the winner
        winner = players.get(0);
        System.out.println("The winner is " + winner.getName() + " with a balance of $"
                + winner.getBalance() + " and " + winner.getNumberOwned() + " properties!");
    }
}
