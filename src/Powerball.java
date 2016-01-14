import java.util.Arrays;
import java.util.Random;

// Powerball lottery simulator. Doesn't feature Powerplay (yet?).
public class Powerball {
	public static void main(String[] args) {
		// User variables
		// If you're running high numbers, you may want to comment out some System.out
		// statements of higher probability outcomes
		int   tries   = 10000;					// $2 per try, mind you
		int   jackpot = 1500000000;			    // Amount won in the jackpot
		int[] winning = {4, 8, 19, 27, 34, 10}; // Winning numbers, last being Powerball
		
		// Non-user variables
		int randomNum;
		int payout          = 0;
		int[] choices       = new int[5]; 		// the non-Powerball #'s
		int[] winningCombos = new int[9]; 		// 9 different ways to win
		for (int i = 0; i < tries; i++) {
			Arrays.fill(choices, 0);			// reset
			Random rand = new Random();
			
			// Generate five unique pseudo-random numbers 1-69
			choices[0] = rand.nextInt(69) + 1;
			while (choices[1] == 0) {
				randomNum = rand.nextInt(69) + 1;
				if (randomNum != choices[0]) {
					choices[1] = randomNum;
				}
			}
			while (choices[2] == 0) {
				randomNum = rand.nextInt(69) + 1;
				if (randomNum != choices[0] && randomNum != choices[1] ) {
					choices[2] = randomNum;
				}
			}
			while (choices[3] == 0) {
				randomNum = rand.nextInt(69) + 1;
				if (randomNum != choices[0] && randomNum != choices[1] && randomNum != choices[2] ) {
					choices[3] = randomNum;
				}
			}
			while (choices[4] == 0) {
				randomNum = rand.nextInt(69) + 1;
				if (randomNum != choices[0] && randomNum != choices[1] && randomNum != choices[2] && randomNum != choices[3]) {
					choices[4] = randomNum;
				}
			}
			
			// Generate the Powerball (1-26)
			int powerball = rand.nextInt(26) + 1;
			
			// Sort 'em
			Arrays.sort(choices, 0, 5);
			
			// See if you're a winner
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
				System.out.format("%2d %2d %2d %2d %2d %2d | JACKPOT on attempt %d%n", choices[0], choices[1], choices[2], choices[3], choices[4], powerball, i);
				payout += jackpot;
				winningCombos[0]++;
			} else if (matches == 5) {
				System.out.format("%2d %2d %2d %2d %2d %2d | 5+0 on attempt %d%n", choices[0], choices[1], choices[2], choices[3], choices[4], powerball, i);
				payout += 1000000;
				winningCombos[1]++;
			} else if (matches == 4 && powerball == winning[5]) {
				System.out.format("%2d %2d %2d %2d %2d %2d | 4+1 on attempt %d%n", choices[0], choices[1], choices[2], choices[3], choices[4], powerball, i);
				payout += 50000;
				winningCombos[2]++;
			} else if (matches == 4) {
				System.out.format("%2d %2d %2d %2d %2d %2d | 4+0 on attempt %d%n", choices[0], choices[1], choices[2], choices[3], choices[4], powerball, i);
				payout += 100;
				winningCombos[3]++;
			} else if (matches == 3 && powerball == winning[5]) {
				System.out.format("%2d %2d %2d %2d %2d %2d | 3+1 on attempt %d%n", choices[0], choices[1], choices[2], choices[3], choices[4], powerball, i);
				payout += 100;
				winningCombos[4]++;
			} else if (matches == 3) {
				System.out.format("%2d %2d %2d %2d %2d %2d | 3+0 on attempt %d%n", choices[0], choices[1], choices[2], choices[3], choices[4], powerball, i);
				payout += 7;
				winningCombos[5]++;
			} else if (matches == 2 && powerball == winning[5]) {
				System.out.format("%2d %2d %2d %2d %2d %2d | 2+1 on attempt %d%n", choices[0], choices[1], choices[2], choices[3], choices[4], powerball, i);
				payout += 7;
				winningCombos[6]++;
			} else if (matches == 1 && powerball == winning[5]) {
				System.out.format("%2d %2d %2d %2d %2d %2d | 1+1 on attempt %d%n", choices[0], choices[1], choices[2], choices[3], choices[4], powerball, i);
				payout += 4;
				winningCombos[7]++;
			} else if (powerball == winning[5]) {
				System.out.format("%2d %2d %2d %2d %2d %2d | 0+1 on attempt %d%n", choices[0], choices[1], choices[2], choices[3], choices[4], powerball, i);
				payout += 4;
				winningCombos[8]++;
			}
		}
		
		// Print out final statistics by type of win
		int totalWins =  winningCombos[8] + winningCombos[7]+ winningCombos[6] + winningCombos[5] + winningCombos[4] +
			     winningCombos[3] + winningCombos[2] + winningCombos[1] + winningCombos[0];
		if (totalWins > 0) {
			System.out.println("\nTitle    |          # |          % | Winnings");
			if (winningCombos[8] > 0) {
				System.out.format ("0+1      | %10d | %1.8f | $%d%n", winningCombos[8], (float) winningCombos[8]/tries, winningCombos[8]*4);
			}
			if (winningCombos[7] > 0) {
				System.out.format ("1+1      | %10d | %1.8f | $%d%n", winningCombos[7], (float) winningCombos[7]/tries, winningCombos[7]*4);
			}
			if (winningCombos[6] > 0) {
				System.out.format ("2+1      | %10d | %1.8f | $%d%n", winningCombos[6], (float) winningCombos[6]/tries, winningCombos[6]*7);
			}
			if (winningCombos[5] > 0) {
				System.out.format ("3        | %10d | %1.8f | $%d%n", winningCombos[5], (float) winningCombos[5]/tries, winningCombos[5]*7);
			}
			if (winningCombos[4] > 0) {
				System.out.format ("3+1      | %10d | %1.8f | $%d%n", winningCombos[4], (float) winningCombos[4]/tries, winningCombos[4]*100);
			}
			if (winningCombos[3] > 0) {
				System.out.format ("4        | %10d | %1.8f | $%d%n", winningCombos[3], (float) winningCombos[3]/tries, winningCombos[3]*100);
			}
			if (winningCombos[2] > 0) {
				System.out.format ("4+1      | %10d | %1.8f | $%d%n", winningCombos[2], (float) winningCombos[2]/tries, winningCombos[2]*50000);
			}
			if (winningCombos[1] > 0) {
				System.out.format ("5        | %10d | %1.8f | $%d%n", winningCombos[1], (float) winningCombos[1]/tries, winningCombos[1]*1000000);
			}
			if (winningCombos[0] > 0) {
				System.out.format ("5+1      | %10d | %1.8f | $%d%n", winningCombos[0], (float) winningCombos[0]/tries, winningCombos[0]*jackpot);
			}
			float totalPercent = (float) (winningCombos[8] + winningCombos[7]+ winningCombos[6] + winningCombos[5] + winningCombos[4] +
							     winningCombos[3] + winningCombos[2] + winningCombos[1] + winningCombos[0])/tries;
			int totalWinnings = winningCombos[8]*4 + winningCombos[7]*4 +  winningCombos[6]*7 +  winningCombos[5]*7 + winningCombos[4]*100 + 
								winningCombos[3]*100 + winningCombos[2]*50000 + winningCombos[1]*1000000 + winningCombos[0]*jackpot;
			System.out.format("Total    | %10d | %1.8f | $%d%n%n", totalWins, totalPercent, totalWinnings);
		}
		
		// Print out summary
		System.out.format("You started $%d, and now you have $%d.%n", tries*2, payout);
		if (payout > tries*2) {
			System.out.format("Wowie, a %f%% profit!%n", (100 * (float) payout)/((float) tries*2));
		} else {
			System.out.format("You lost %f%% of your money.%n", (float) 100*(1-((float) payout/((float) tries*2))));
		}
	}
}