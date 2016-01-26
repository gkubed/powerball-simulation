import java.util.Arrays;
import java.util.Random;

// Powerball lottery simulator. Doesn't feature Powerplay (yet?).
public class Powerball {
    public static void main(String[] args) {
        // User variables
        // If you're running high numbers, you may want to comment out some System.out
        // statements of higher probability outcomes
        int   tries   = 50;                     // $2 per try, mind you
        int   jackpot = 1500000000;             // Amount won in the jackpot
        int[] winning = {4, 8, 19, 27, 34, 10}; // Winning numbers, last being Powerball
        boolean presetWin = true;               // if you don't want to use the winning numbers
                                                // above, set to false and winning numbers will
                                                // be generated
        // Non-user variables
        int randomNum;
        int payout          = 0;
        int[] choices       = new int[5];       // the non-Powerball #'s
        int[] winningCombos = new int[9];       // 9 different ways to win
        int[] comboAmounts  = {jackpot, 1000000, 50000, 100, 100, 7, 7, 4, 4};                    // Amount won per combination
        String[] comboNames    = {"5+1", "5+0", "4+1", "4+0", "3+1", "3+0", "2+1", "1+1", "0+1"}; // Different combinations
        
        for (int i = 0; i < tries; i++) {
            Arrays.fill(choices, 0);            // reset the array
            Random rand = new Random();
            
            // Generate five unique pseudo-random numbers 1-69 (Inclusive)
            choices[0] = rand.nextInt(69) + 1;
            while (choices[1] == 0) {
                randomNum = rand.nextInt(69) + 1;
                if (randomNum != choices[0]) {
                    choices[1] = randomNum;
                }
            }
            while (choices[2] == 0) {
                randomNum = rand.nextInt(69) + 1;
                if (randomNum != choices[0] && randomNum != choices[1]) {
                    choices[2] = randomNum;
                }
            }
            while (choices[3] == 0) {
                randomNum = rand.nextInt(69) + 1;
                if (randomNum != choices[0] && randomNum != choices[1] && randomNum != choices[2]) {
                    choices[3] = randomNum;
                }
            }
            while (choices[4] == 0) {
                randomNum = rand.nextInt(69) + 1;
                if (randomNum != choices[0] && randomNum != choices[1] && randomNum != choices[2] && randomNum != choices[3]) {
                    choices[4] = randomNum;
                }
            }
            
            // Generate the Powerball (1-26, Inclusive)
            int powerball = rand.nextInt(26) + 1;
            
            // Sort 'em
            Arrays.sort(choices, 0, 5);
            
            // If the user didn't want the winning numbers to be preset,
            // use the first generation as the winning number choice
            if (!presetWin) {
                // Steal each ball
                for (int j = 0; j < 5; j++) {
                    winning[j] = choices[j];
                }
                // Steal the Powerball
                winning[5] = powerball;
                // Make sure we don't do this again
                presetWin = true;
                // Give this turn back
                i--;
                // Bail
                continue;
            }
            
            // Check if any of the winning numbers (sans Powerball)
            // were in our set
            int matches = 0;
            if (Arrays.binarySearch(choices, winning[0]) >= 0) {
                matches++;
            }
            if (Arrays.binarySearch(choices, winning[1]) >= 1) {
                matches++;
            }
            if (Arrays.binarySearch(choices, winning[2]) >= 2) {
                matches++;
            }
            if (Arrays.binarySearch(choices, winning[3]) >= 3) {
                matches++;
            }
            if (Arrays.binarySearch(choices, winning[4]) >= 4) {
                matches++;
            }
            
            // Print out if you won any money
            if (matches == 5 && powerball == winning[5]) {
                System.out.format("%2d %2d %2d %2d %2d %2d | %s on attempt %d%n", choices[0], choices[1], choices[2], choices[3], choices[4], powerball, comboNames[0], i);
                payout += comboAmounts[0];
                winningCombos[0]++;
            } else if (matches == 5) {
                System.out.format("%2d %2d %2d %2d %2d %2d | %s on attempt %d%n", choices[0], choices[1], choices[2], choices[3], choices[4], powerball, comboNames[1], i);
                payout += comboAmounts[1];
                winningCombos[1]++;
            } else if (matches == 4 && powerball == winning[5]) {
                System.out.format("%2d %2d %2d %2d %2d %2d | %s on attempt %d%n", choices[0], choices[1], choices[2], choices[3], choices[4], powerball, comboNames[2], i);
                payout += comboAmounts[2];
                winningCombos[2]++;
            } else if (matches == 4) {
                System.out.format("%2d %2d %2d %2d %2d %2d | %s on attempt %d%n", choices[0], choices[1], choices[2], choices[3], choices[4], powerball, comboNames[3], i);
                payout += comboAmounts[3];
                winningCombos[3]++;
            } else if (matches == 3 && powerball == winning[5]) {
                System.out.format("%2d %2d %2d %2d %2d %2d | %s on attempt %d%n", choices[0], choices[1], choices[2], choices[3], choices[4], powerball, comboNames[4], i);
                payout += comboAmounts[4];
                winningCombos[4]++;
            } else if (matches == 3) {
                System.out.format("%2d %2d %2d %2d %2d %2d | %s on attempt %d%n", choices[0], choices[1], choices[2], choices[3], choices[4], powerball, comboNames[5], i);
                payout += comboAmounts[5];
                winningCombos[5]++;
            } else if (matches == 2 && powerball == winning[5]) {
                System.out.format("%2d %2d %2d %2d %2d %2d | %s on attempt %d%n", choices[0], choices[1], choices[2], choices[3], choices[4], powerball, comboNames[6], i);
                payout += comboAmounts[6];
                winningCombos[6]++;
            } else if (matches == 1 && powerball == winning[5]) {
                System.out.format("%2d %2d %2d %2d %2d %2d | %s on attempt %d%n", choices[0], choices[1], choices[2], choices[3], choices[4], powerball, comboNames[7], i);
                payout += comboAmounts[7];
                winningCombos[7]++;
            } else if (powerball == winning[5]) {
                System.out.format("%2d %2d %2d %2d %2d %2d | %s on attempt %d%n", choices[0], choices[1], choices[2], choices[3], choices[4], powerball, comboNames[8], i);
                payout += comboAmounts[8];
                winningCombos[8]++;
            }
        }
        
        System.out.println("\nWinning numbers: " + winning[0] + " " + winning[1] + " " + winning[2] + 
                                             " " + winning[3] + " " + winning[4] + " " + winning[5]);
        
        // Print out final statistics by type of win
        int totalWins =  winningCombos[8] + winningCombos[7]+ winningCombos[6] + winningCombos[5] + winningCombos[4] +
                 winningCombos[3] + winningCombos[2] + winningCombos[1] + winningCombos[0];
        if (totalWins > 0) {
            System.out.println("\nTitle    |          # |          % | Winnings");
            
            for (int i = 0; i < 9; i++) {
                if (winningCombos[i] > 0) {
                    System.out.format ("%s      | %10d | %1.8f | $%d%n", comboNames[i], winningCombos[i],
                                       (float) winningCombos[i]/tries, winningCombos[i]*comboAmounts[i]);
                }
            }

            float totalPercent = (float) (winningCombos[8] + winningCombos[7]+ winningCombos[6] + winningCombos[5] + winningCombos[4] +
                                 winningCombos[3] + winningCombos[2] + winningCombos[1] + winningCombos[0])/tries;
            int totalWinnings = winningCombos[8]*comboAmounts[8] + winningCombos[7]*comboAmounts[7] + winningCombos[6]*comboAmounts[6] + 
                                winningCombos[5]*comboAmounts[5] + winningCombos[4]*comboAmounts[4] + winningCombos[3]*comboAmounts[3] +
                                winningCombos[2]*comboAmounts[2] + winningCombos[1]*comboAmounts[1] + winningCombos[0]*comboAmounts[0];
            System.out.format("Total    | %10d | %1.8f | $%d%n%n", totalWins, totalPercent, totalWinnings);
        }
        
        // Print out summary
        System.out.format("You started with $%d, and now you have $%d.%n", tries*2, payout);
        if (payout > tries*2) {
            System.out.format("Wowie, a %f%% profit!%n", (100 * (float) payout)/((float) tries*2));
        } else {
            System.out.format("You lost %f%% of your money.%n", (float) 100*(1-((float) payout/((float) tries*2))));
        }
    }
}
