import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        while (playAgain) {
            int attempts = 0;
            int maxAttempts = 7;
            int numberToGuess = random.nextInt(100) + 1;
            boolean hasGuessedCorrectly = false;

            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1); // More points for fewer attempts
                    hasGuessedCorrectly = true;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }

                if (attempts == maxAttempts && !hasGuessedCorrectly) {
                    System.out.println("Sorry! You've used all your attempts. The correct number was " + numberToGuess + ".");
                }
            }

            System.out.print("Would you like to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Game over! Your total score is: " + totalScore);
        scanner.close();
    }
}

/*I'm thinking of a number between 1 and 100.
You have 7 attempts to guess the correct number.

Enter your guess: 50
Congratulations! You guessed the correct number in X attempts.

Enter your guess: 75
Your guess is too high.

Enter your guess: 25
Your guess is too low.*/
