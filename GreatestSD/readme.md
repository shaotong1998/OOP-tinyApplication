Once upon a time in the land of Asgard there lived 3 wizards Gandalf, Merlin and Dumbledore. These 3 wizards often had an argument over which one of them was the greatest software developer of all time. To end the argument once and for all, they agreed on a fight to the death. Gandalf was a poor shooter and only hit his target with a probability of 1/3. Merlin was a bit better and hit his target with a probability of 1/2. Dumbledore was an expert marksman and never missed. A hit means a kill and the person hit drops out of the duel.
To compensate for the inequities in their marksmanship skills, the three decided that they would fire in turns, starting with Gandalf, followed by Merlin, and then by Dumbledore. The cycle would repeat until there was one man or creature standing, and that man or creature would be the greatest software developer of All Time.
An obvious and reasonable strategy is for each wizard to shoot at the most accurate shooter still alive, on the grounds that this shooter is the deadliest and has the best chance of hitting back.
Write a program to simulate the duel using this strategy. Your program should use random numbers and the probabilities given in the problem to determine whether a shooter hits the target.
Create a class named Fighter that contains the wizard’s name and shooting accuracy, a Boolean indicating whether the fighter is still alive, and a method shootAtTarget(Fighter target) that sets the target to dead if the fighter hits his target (using a random number and the shooting accuracy) and does nothing otherwise.
Once you can simulate a single fight, add a loop to your program that simulates 10,000 fights. Count the number of times that each contestant wins and print the probability of winning for each contestant in a tabular format. For example:
LEADERBOARD – AFTER 10000 DUELS
Contestant Number of Wins Winning Percentag

Gandalf 3595 35.95%

Merlin 1355 13.55

Dumbledore 5050 50.50%

An alternate strategy is for Gandalf to intentionally miss on his first shot. Modify the program to accommodate this new strategy and output the probability of winning for each contestant after 10000 fights.
What strategy is better for Gandalf, to intentionally miss on the first shot or to try and hit the best shooter? Who has the best chance of winning, the best shooter or the worst shooter?
