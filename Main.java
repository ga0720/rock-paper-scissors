import java.util.*;

/**
 * Driver class, sets up the Rock Paper Scissors game.
 */
public class Main {
    public static void main(String[] args) {
        Player[] players = new Player[2];  // Array to hold players
        boolean printsRun = false;        // Enable/disable debug print statements.

        // Add players to the game
        players[0] = new Example1();   // Example opponent
        players[1] = new AgrawalGauravi();


        // Construct the game with the players array
        Game newGame = new Game(players, printsRun);
        newGame.play();
        newGame.displayScore();
    }
}
