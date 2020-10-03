package project.Service;

import project.Model.Game;

/**
 * Prints game data to the console.
 */
public class GameStatsWriter
{
    /**
     * Prints the game's total score.
     * 
     * @param Game game
     */
    public void printTotalScore(Game game)
    {
        System.out.println(String.format("\tTotal score is: %s.", game.getScore()));
    }
    
    /**
     * Prints every round's score.
     * 
     * @param Game game
     */
    public void printScorePerRound(Game game)
    {
        int[] scoresPerRound = game.getScoresPerRound();
        for (int i = 0, n = scoresPerRound.length; i < n; i++) {
            System.out.println(String.format("\tScore for round %s is %s.", i+1, scoresPerRound[i]));
        }
    }
    
    /**
     * Prints the number of strikes and spares in the game.
     * 
     * @param Game game
     */
    public void printStrikesAndSparesCount(Game game)
    {
        System.out.println(String.format("\tNumber of strikes: %s.", game.getStrikesCount()));
        System.out.println(String.format("\tNumber of spares: %s.", game.getSparesCount()));
    }
}
