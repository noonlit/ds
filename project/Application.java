package project;

import java.util.Scanner;
import project.Model.Game;
import project.Model.Roll;
import project.Model.Round;
import project.Service.GameStatsWriter;

/**
 * Application entry point.
 */
public class Application
{
    /**
     * Will build a new (Bowling) Game and display its stats.
     * @param args
     */
    public static void main(String[] args)
    {        
        /*
         * Build game.
         */
        
        /*
         * Get game data from the user.
         */
        Scanner scan = new Scanner(System.in);
        
        System.out.println("How many rounds?");
        int rounds = scan.nextInt();

        try {
            Game game = new Game();
            
            for (int i = 0; i < rounds; i++) {
                System.out.println(String.format("This is round %s.", i+1));
                Round round = new Round();
                
                /*
                 * Add Rolls (representing pins knocked down) to the current round.
                 */
                while (!round.isComplete()) {
                    System.out.println("Roll, please!");
                    int value = scan.nextInt();
                                  
                    Roll roll;
                    try {
                        roll = new Roll(value);
                    } catch (Exception e) {
                        System.out.println("Invalid roll. Try again.");
                        continue;
                    }
                    
                    if (!round.canRoll(roll)) {
                        System.out.println("Cannot roll this value. Try again.");
                        continue;
                    }

                    round.add(roll);               
                   
                    if (round.isComplete()) {
                        System.out.println("End of round.");
                    }
                }

                /*
                 * Add complete Round to game.
                 */
                game.add(round);
            }
            
            System.out.println("The game has been finalised!");
            System.out.println(String.format("The game has %s rounds.",  game.size()));
            
            /*
             * Display game stats.
             */
            printGameStats(scan, game);
        } catch (Exception e) {
            System.out.println("Cannot build game.");
            System.out.println(e.toString());
        } finally {
            scan.close();
        }
    }
    
    /**
     * Displays game stats requested by the user.
     * 
     * @param Scanner scan
     * @param Game game
     */
    private static void printGameStats(Scanner scan, Game game)
    {
        int option = getUserOption(scan);
        GameStatsWriter writer = new GameStatsWriter();
        
        while (option != 0) {
            switch (option) {
                case 1:
                    writer.printTotalScore(game);
                    break;
                case 2:
                    writer.printScorePerRound(game);
                    break;
                case 3:
                    writer.printStrikesAndSparesCount(game);
                    break;
                default:
                    System.out.println("No clue what you need, try again.");
            }
            
            option = getUserOption(scan);
        }
        
        System.out.println("Thanks for playing!");
    }
    
    /**
     * Retrieves user option regarding which stats to display.
     * 
     * @param Scanner scan
     * @return int
     */
    private static int getUserOption(Scanner scan)
    {
        System.out.println("What would you like to do now?");
        System.out.println("1. Show total score.");
        System.out.println("2. Show score per rounds.");
        System.out.println("3. Show strikes and spares count.");
        System.out.println("0. Exit.");
        
        int option = scan.nextInt();
        
        return option;
    }
}
