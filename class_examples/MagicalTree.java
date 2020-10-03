package class_examples;

/**
 * Un copac magic are două faze de creștere în fiecare an: în fiecare primăvară
 * își dublează înălțimea, iar în fiecare vară înălțimea sa crește cu 1. Laura
 * plantează un copac magic cu înălțimea 1 în Ianuarie. Ce înălțime va avea
 * copacul magic după N ani?
 */
public class MagicalTree
{
    public static void main(String[] args)
    {
        /* get tree height after n years */
        int finalHeight = getFinalTreeHeight(2);
        System.out.println(finalHeight + " is height we got with loops.");

        int finalHeightMath = getFinalTreeHeightMathematically(2);
        System.out.println(finalHeightMath + " is height we got with math :)");
    }

    /**
     * Gets a tree's height after a number of years.
     * 
     * The height doubles in the spring and increases by 1 in the summer.
     * 
     * @param int years
     * @return int
     */
    public static int getFinalTreeHeight(int years)
    {
        int finalHeight = 1;

        for (int i = 0; i < years; i++) {
            finalHeight = (finalHeight * 2) + 1;
        }

        return finalHeight;
    }

    /**
     * Is clever about getting the tree's height.
     * 
     * @param years
     * @return int
     */
    public static int getFinalTreeHeightMathematically(int years)
    {
        return (int) Math.pow(2, years + 1) - 1;
    }
}
