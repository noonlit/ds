package homework;

import java.util.*;

/*
 * Patrik este obsedat de ADN și vrea să construiască secvența pereche de baze 
 * pentru o secvența de ADN.
 *  
 * O secvență de ADN este un string alcătuit doar din caracterele A, C, T și G 
 * (ele reprezentând cele 4 baze posibile). 
 * 
 * Secvența pereche este un string de aceeași lungime care conține perechea pentru fiecare bază. 
 * Perechea pentru A este T (și pentru T este A) iar perechea pentru C este G (și pentru G este C).
 * 
 * a. Pentru o secvență ADN (dat sub forma unui string) construiți perechea. 
 * De exemplu, perechea lui AACTGAGT este TTGACTCA. 
 * Dacă secvența conține elemente invalide (caractere care nu sunt A, C, T sau G), afișați un mesaj.
 * 
 * b. Pentru 2 secvențe ADN, verificați dacă ele reprezintă o pereche. 
 * De exemplu AGTGGAGTA este pereche cu TCACCTCAT dar AAT nu este pereche cu TTC.
 */
public class DnaBasePairs
{
    public static void main(String[] args)
    {
        /*
         * Test that the examples in the problem work correctly.
         */
        try {
            runDefaultTests();
        } catch (Exception ex) {
            System.out.println("Tests fail. Do not proceed.");
            ex.printStackTrace();
            return;
        }

        String validElements = "ATCG";
        HashSet<Character> dna = convertToSet(validElements);

        /*
         * Test a valid & an invalid sequence for validity
         */
        String valid = "CATCATCAT";
        HashSet<Character> dnaCandidate = convertToSet(valid);
        String invalid = "CATXYZ";
        HashSet<Character> dnaCandidate1 = convertToSet(invalid);

        printValidityMessage(validElements, valid, isValidSequence(dna, dnaCandidate));
        printValidityMessage(validElements, invalid, isValidSequence(dna, dnaCandidate1));

        /*
         * Build sequence pair.
         */
        String original1 = "CAT";

        try {
            String pair1 = buildSequencePair(original1);
            System.out.println("The pair for " + original1 + " is " + pair1);
        } catch (Exception ex1) {
            System.out.println("Cannot build pair for " + original1);
        }

        /*
         * Check if sequences are pairs.
         */
        String original2 = "CAT";
        String pair2 = "GTA";
        String pair3 = "TCG";

        String isPair = isSequencePair(original2, pair2) ? "is a pair" : "is not a pair";
        System.out.println(pair2 + " " + isPair + " for " + original2);

        isPair = isSequencePair(original2, pair3) ? "is a pair" : "is not a pair";
        System.out.println(pair3 + " " + isPair + " for " + original2);
    }

    /**
     * Shows the user whether a string is a valid DNA sequence.
     */
    private static void printValidityMessage(String valid, String candidate, boolean isValid)
    {
        String isValidSequence = isValid ? "valid" : "invalid";
        System.out.println("The sequence " + candidate + " is " + isValidSequence);
    }

    /**
     * Converts a string to a set of characters.
     * 
     * @param String sequence
     * @return HashSet<Character>
     */
    private static HashSet<Character> convertToSet(String sequence)
    {
        HashSet<Character> result = new HashSet<Character>();

        for (int i = 0, n = sequence.length(); i < n; i++) {
            result.add(sequence.charAt(i));
        }

        return result;
    }

    /**
     * Checks whether a sequence's characters are all part of the given valid sequence.
     * 
     * @param HashSet<Character> validSequence
     * @param HashSet<Character> sequence
     * @return boolean
     */
    private static boolean isValidSequence(HashSet<Character> validSequence, HashSet<Character> sequence)
    {
        if (sequence.size() > validSequence.size()) {
            return false;
        }

        return validSequence.containsAll(sequence);
    }

    /**
     * Builds the pair for the given sequence.
     * 
     * @param String string
     * @return String
     * @throws Exception
     */
    private static String buildSequencePair(String string) throws Exception
    {
        String result = "";

        for (int i = 0, n = string.length(); i < n; i++) {
            result += getPair(string.charAt(i));
        }

        return result;
    }

    /**
     * Returns the DNA pair for the given character.
     * 
     * @param char c
     * @return char
     * @throws Exception
     */
    private static char getPair(char c) throws Exception
    {
        if (c == 'A') {
            return 'T';
        }

        if (c == 'T') {
            return 'A';
        }

        if (c == 'G') {
            return 'C';
        }

        if (c == 'C') {
            return 'G';
        }

        throw new Exception("There is no pair for the given character");
    }

    /**
     * Checks whether the given sequences are DNA pairs.
     * 
     * @param String original
     * @param String pairCandidate
     * @return boolean
     */
    private static boolean isSequencePair(String original, String pairCandidate)
    {
        int length = original.length();

        if (length != pairCandidate.length()) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (!isPair(original.charAt(i), pairCandidate.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks whether the candidate is the DNA pair for the original.
     * 
     * @param char original
     * @param char pairCandidate
     * @return boolean
     */
    private static boolean isPair(char original, char pairCandidate)
    {
        if (original == 'A' && pairCandidate == 'T') {
            return true;
        }

        if (original == 'T' && pairCandidate == 'A') {
            return true;
        }

        if (original == 'C' && pairCandidate == 'G') {
            return true;
        }

        if (original == 'G' && pairCandidate == 'C') {
            return true;
        }

        return false;
    }

    /**
     * Tests implementation with examples provided in problem text.
     * 
     * @throws Exception
     */
    private static void runDefaultTests() throws Exception
    {
        if (!buildSequencePair("AACTGAGT").contentEquals("TTGACTCA")) {
            throw new Exception("You're not building sequence pairs correctly!");
        }

        if (!isSequencePair("AGTGGAGTA", "TCACCTCAT") || isSequencePair("AAT", "TTC")) {
            throw new Exception("You're not comparing sequence pairs correctly!");
        }
    }
}
