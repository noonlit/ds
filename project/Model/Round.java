package project.Model;

/**
 * Represents a round in bowling game.
 */
public class Round
{
    /**
     * There are at most 2 rolls in a round.
     */
    public final static int MAX_ROLLS = 2;
    
    public final static int FIRST_ROLL_INDEX = 0;
    public final static int SECOND_ROLL_INDEX = 1;

    /**
     * There are at most 10 pins to knock down in a round.
     */
    public final static int MAX_SCORE = 10;
    
    /**
     * The number of rolls in the game.
     */
    private int size = 0;

    /**
     * Will hold the player's rolls in the context of this round.
     */
    private Roll[] rolls;

    /**
     * Constructs a round of maximum size (to hold 2 rolls).
     */
    public Round()
    {
        this.rolls = new Roll[MAX_ROLLS];
    }

    /**
     * Adds a roll to the game.
     * 
     * @param Roll
     * @return void 
     */
    public void add(Roll roll)
    {
        if (!canRoll(roll)) {
            throw new UnsupportedOperationException("Cannot add more rolls to this round!");
        }
        
        if (rolls[FIRST_ROLL_INDEX] == null) {
            rolls[FIRST_ROLL_INDEX] = roll;
        } else {
            rolls[SECOND_ROLL_INDEX] = roll;
        }
        
        size++;
    }
    
    /**
     * Retrieves the number of rolls for this round.
     */
    public int size()
    {
        return size;
    }


    /**
     * Retrieves the value of the i-th roll.
     * 
     * @param int i
     * @return Integer
     * @throws IndexOutOfBoundsException
     */
    public Integer getRollValue(int i)
    {
        if (i < 0 || i > MAX_ROLLS - 1) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }
        
        if (rolls[i] == null) {
            return null;
        }
        
        return rolls[i].getValue();
    }

    /**
     * Retrieves the value of the last roll.
     * 
     * @return Integer
     */
    public Integer getLastRollValue()
    {
        if (rolls[MAX_ROLLS - 1] == null) {
            return null;
        }
        
        return rolls[MAX_ROLLS - 1].getValue();
    }

    /**
     * Returns the value of the first roll.
     * 
     * @return Integer
     */
    public Integer getFirstRollValue()
    {
        if (rolls[FIRST_ROLL_INDEX] == null) {
            return null;
        }
        
        return rolls[FIRST_ROLL_INDEX].getValue();
    }

    /**
     * Checks whether the round has no rolls.
     * 
     * @return boolean
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Checks whether it is possible to add more rolls to this round.
     * 
     * @param Roll roll Current roll
     * @return boolean
     */
    public boolean canRoll(Roll roll)
    {
        if (size() == MAX_ROLLS) {
            return false;
        }

        if (getScore() == MAX_SCORE) {
            return false;
        }

        if ((roll.getValue() + getScore()) > MAX_SCORE) {
            return false;
        }

        return true;
    }

    /**
     * Retrieves the score for this round (cumulative value of rolls).
     * 
     * @return int
     */
    public int getScore()
    {
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += rolls[i].getValue();
        }

        return sum;
    }

    /**
     * Checks whether this round represents a strike.
     * 
     * @return boolean
     */
    public boolean isStrike()
    {
        return size() < MAX_ROLLS && getScore() == MAX_SCORE;
    }

    /**
     * Checks whether this round represents a spare.
     * 
     * @return boolean
     */
    public boolean isSpare()
    {
        return size() == MAX_ROLLS && getScore() == MAX_SCORE;
    }
    
    /**
     * Checks whether the round is complete.
     * 
     * A round is complete when it has reached the maximum number of rolls
     * or represents a strike.
     * 
     * @return bool
     */
    public boolean isComplete()
    {
        return size() == MAX_ROLLS || isStrike();
    }
}
