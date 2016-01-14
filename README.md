# powerball-simulation
Simulation of the Powerball lottery in Java

This is a tiny little project I made in my spare time to better observe how hilariously unlikely you are to make money playing the lottery. It's by no means a work of art, but is hopefully very clear.

Powerball is a trademark belonging to someone I don't know with lawyers I don't want to meet.

# Setup
1. Edit the few variables there are (# tries, jackpot value, winning numbers)
2. Execute the java program using whatever your favorite Java environment is.

#####Sample Execution:

     1 17 19 61 65 10 | 1+1 on attempt 8
     5 29 36 54 61 10 | 0+1 on attempt 11
     6  9 16 41 46 10 | 0+1 on attempt 29

    Title    |          # |          % | Winnings
    0+1      |          2 | 0.04000000 | $8
    1+1      |          1 | 0.02000000 | $4
    Total    |          3 | 0.06000000 | $12
    
    You started with $100, and now you have $12.
    You lost 88.000000% of your money.
