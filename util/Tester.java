package util;

import java.util.Random;

public class Tester
{
    public static void main(String[] args)
    {
        int elems = 10000000;
        int[] nrs = generateVector(elems, elems / 2);

        long start = System.nanoTime();

        // call method you want to test

        System.out.println("Time: " + (System.nanoTime() - start) / 1000000000.0);
    }
    
    private static int[] generateVector(int n, int limit)
    {
        int[] vector = new int[n];
        Random randomNrGenerator = new Random();

        for (int i = 0; i < n; i++) {
            vector[i] = randomNrGenerator.nextInt(limit);
        }
        return vector;
    }
}
