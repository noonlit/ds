package project.Model;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Game container for Rounds.
 * 
 * Represents a Bowling Game.
 */
public class Game 
{
    /**
     * A game is made up of N rounds.
     * 
     * The rounds will be stored in this list.
     */
    private ArrayList<Round> rounds;

    /**
     * The list's default capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Default constructor.
     */
    public Game()
    {
        this.rounds = new ArrayList<Round>(DEFAULT_CAPACITY);
    }

    /**
     * Constructs a game of given size (number of rounds).
     * 
     * @param int size
     */
    public Game(int size)
    {
        this.rounds = new ArrayList<Round>(size);
    }

    /**
     * Adds a round to the game.
     * 
     * The round is placed on the last position.
     * 
     * @param Round round
     * @return boolean
     */
    public boolean add(Round round)
    {
        return rounds.add(round);
    }

    /**
     * Retrieves the number of rounds in the game.
     * 
     * @return int
     */
    public int size()
    {
        return rounds.size();
    }

    /**
     * Checks whether the game contains no rounds.
     * 
     * @return boolean
     */
    public boolean isEmpty()
    {
        return rounds.isEmpty();
    }

    /**
     * Returns the number of spares in the current game.
     * 
     * @return int
     */
    public int getSparesCount()
    {
        int spares = 0;

        ListIterator<Round> iterator = rounds.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().isSpare()) {
                spares++;
            }
        }

        return spares;
    }

    /**
     * Returns the number of strikes in the current game.
     * 
     * @return int
     */
    public int getStrikesCount()
    {
        int strikes = 0;

        ListIterator<Round> iterator = rounds.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().isStrike()) {
                strikes++;
            }
        }

        return strikes;
    }

    /**
     * Calculates the scores per round for the game.
     * 
     * Format: round => score
     * 
     * @return int[]
     */
    public int[] getScoresPerRound()
    {
        int[] scores = new int[size()];
        ListIterator<Round> iterator = rounds.listIterator();

        int i = 0;
        Round previousRound = null;
        while (iterator.hasNext()) {
            Round round = iterator.next();
            scores[i] = round.getScore();

            if (previousRound != null) {
                scores[i - 1] += getBonus(round, previousRound);
            }

            previousRound = round;
            i++;
        }

        return scores;
    }

    /**
     * Calculates the score for the round at the i-th position.
     * 
     * Accounts for any bonus applicable to the round.
     * 
     * @param int i
     * @return int
     * @throws IndexOutOfBoundsException
     */
    public int getScorePerRound(int i)
    {
        Round round = rounds.get(i);
        int score = round.getScore();

        /*
         * If the round is the last one, it cannot receive a bonus.
         */
        if (i == size() - 1) {
            return score;
        }

        return score + getBonus(rounds.get(i + 1), round);
    }

    /**
     * Calculates the total score for the game.
     * 
     * @return int
     */
    public int getScore()
    {
        int score = 0;
        ListIterator<Round> iterator = rounds.listIterator();

        Round previousRound = null;
        while (iterator.hasNext()) {
            Round round = iterator.next();
            score += round.getScore();

            if (previousRound != null) {
                score += getBonus(round, previousRound);
            }
            
            previousRound = round;
        }

        return score;
    }

    /**
     * Calculates the bonus for the previous round based on the current one.
     * 
     * @param Round currentRound
     * @param Round previousRound
     * @return int
     */
    private int getBonus(Round currentRound, Round previousRound)
    {
        if (previousRound.isStrike()) {
            return currentRound.getScore();
        }

        if (previousRound.isSpare()) {
            return currentRound.getFirstRollValue();
        }

        return 0;
    }
}