package project.Model;

/**
 * Represents a player's roll in a bowling game.
 * 
 * Holds the number of pins knocked down.
 */
public class Roll
{
    /**
     * There are at most 10 pins to knock down in a roll.
     */
    public static final int MAX_VALUE = 10;
    
    /**
     * Will hold the roll's value.
     */
    private int value;
    
    /**
     * Builds a roll from a given value.
     * 
     * This value cannot be updated (a mutator is not exposed).
     * 
     * Throws an exception when an invalid value is provided.
     * 
     * @param int value
     * @throws Exception
     */
    public Roll(int value) throws Exception
    {
        if (!isValid(value)) {
            throw new Exception("Invalid roll!");
        }
        
        this.value = value;
    }
    
    /**
     * A roll value cannot be negative or more than 10.
     * 
     * @param value
     * @return
     */
    public boolean isValid(int value) {
        return value >= 0 && value <= MAX_VALUE;
    }
    
    /**
     * Returns the roll's value.
     * 
     * @return int
     */
    public int getValue()
    {
        return value;
    }
}
