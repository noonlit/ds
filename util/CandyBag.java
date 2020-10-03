package util;

public class CandyBag implements Comparable<CandyBag>
{
    private int candies;

    public CandyBag(int candies)
    {
        this.candies = candies;
    }

    public int getCandies()
    {
        return this.candies;
    }

    /**
     * A bag with more candy pieces should be sorted before one with fewer.
     */
    public int compareTo(CandyBag candyBag)
    {
        return candyBag.candies - this.candies;
    }
}
