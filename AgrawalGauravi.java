import java.util.*;

/**
 * AgrawalGauravi implements Player
 * Strategy: Starts with rock, counters opponent's most frequent move, and adds random moves every third round.
 */
public class AgrawalGauravi implements Player {
    private static String name = "AgrawalGauravi";
    private Random rand = new Random();

    /**
     * Returns the name of the player
     * 
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Determines the player's move for each round.
     * 
     * @param myMoves       Array of moves played by this player
     * @param opponentMoves Array of moves played by the opponent
     * @param myScore       Current score of this player
     * @param opponentScore Current score of the opponent
     * @return "r" for rock, "p" for paper, or "s" for scissors
     */
    public String move(String[] myMoves, String[] opponentMoves, int myScore, int opponentScore) {
        if (myMoves.length == 0) {
            // First move is always "rock"
            return "r";
        }

        // Every third move, play randomly
        if (myMoves.length % 3 == 0) {
            return randomMove();
        }

        // Analyze opponent's moves and counter their most frequent move
        String opponentFrequentMove = findMostFrequent(opponentMoves);
        return counterMove(opponentFrequentMove);
    }

    /**
     * Generates a random move: "r", "p", or "s".
     * 
     * @return A random valid move
     */
    private String randomMove() {
        int choice = rand.nextInt(3);
        if (choice == 0) return "r";
        else if (choice == 1) return "p";
        else return "s";
    }

    /**
     * Counters the opponent's move.
     * 
     * @param move The opponent's most frequent move
     * @return The move that beats the opponent's move
     */
    private String counterMove(String move) {
        if (move == null) return randomMove(); // If no opponent moves yet, return random
        switch (move) {
            case "r": return "p"; // Paper beats Rock
            case "p": return "s"; // Scissors beat Paper
            case "s": return "r"; // Rock beats Scissors
            default: return randomMove(); // Fallback
        }
    }

    /**
     * Finds the opponent's most frequent move.
     * 
     * @param moves Array of moves played by the opponent
     * @return The most frequent move ("r", "p", or "s")
     */
    private String findMostFrequent(String[] moves) {
        int rockCount = 0, pap
