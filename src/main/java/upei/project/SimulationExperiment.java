package upei.project;

import java.util.ArrayList;

/**
 * Simulates a series of Monopoly games with multiple players, collecting various statistics
 * such as wins, balances, properties owned, and houses owned across multiple trials.
 */
public class SimulationExperiment {
    private ArrayList<Player> players; // Players in the game
    private int trials; // Number of games to simulate
    private int[] wins; // Number of wins for each player
    private int totalBalance; // Cumulative balance for all players
    private int totalProperties; // Cumulative properties owned by all players
    private int[] totalHouses; // Cumulative number of houses for each player
    private int[] totalPlayerBalance; // Cumulative balance for each player

    /**
     * Constructor to initialize the simulation with the given players and number of trials.
     *
     * @param players The list of players participating in the simulation
     * @param trials The number of trials (games) to simulate
     */
    public SimulationExperiment(ArrayList<Player> players, int trials) {
        this.players = players;
        this.trials = trials;
        this.wins = new int[players.size()];
        this.totalBalance = 0;
        this.totalProperties = 0;
        this.totalHouses = new int[players.size()];
        this.totalPlayerBalance = new int[players.size()];
    }

    /**
     * Runs the simulation for the specified number of trials, playing a full game in each trial.
     * Collects and updates statistics such as the number of wins, balances, and properties owned.
     */
    public void runSimulation() {
        for (int i = 0; i < trials; i++) {
            // Create a deep copy of the players list for each simulation run
            ArrayList<Player> playersCopy = new ArrayList<>();
            for (Player player : players) {
                playersCopy.add(new Player(player.getName(), player.getId(), player.getStrategy()));
            }

            // Create and play a new game with the copied list of players
            Game game = new Game(playersCopy);
            game.resetPlayerStates(); // Reset player states before starting the game
            game.startGame(); // Start the game

            // Determine the winner of the game
            Player winner = game.getWinner();
            int winnerIndex = winner.getId() - 1;

            // Safely update the wins array for the winner
            if (winnerIndex >= 0 && winnerIndex < wins.length) {
                wins[winnerIndex]++;
            } else {
                System.out.println("Error: Winner ID is invalid.");
            }

            // Collect metrics from each player after the game
            for (int j = 0; j < playersCopy.size(); j++) {
                Player player = playersCopy.get(j);
                totalBalance += player.getBalance();
                totalProperties += player.getNumberOwned();
                totalHouses[j] += player.getNumberOwned();
                totalPlayerBalance[j] += player.getBalance();
            }
        }

        // Display results after all trials have completed
        displayResults();
    }

    /**
     * Displays the results of the simulation after all trials have been run.
     * This includes the total wins, average balance, and average number of houses owned for each player.
     */
    public void displayResults() {
        System.out.println("Simulation Results:");
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            System.out.println(player.getName() + " - Wins: " + wins[i]);
            System.out.println("Average Balance: " + (totalPlayerBalance[i] / trials));
            System.out.println("Average properties Owned: " + (totalHouses[i] / trials));
            System.out.println();
        }
        System.out.println("Overall Average Balance: " + (totalBalance / (trials * players.size())));
        System.out.println("Overall Average Properties Owned: " + (totalProperties / (trials * players.size())));
    }
}
