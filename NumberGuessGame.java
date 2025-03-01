import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void playGame(int min, int max, int maxAttempts, int[] score, Scanner scanner) {
        Random rand = new Random();
        int target = rand.nextInt(max - min + 1) + min;
        int attempts = 0;
        
        System.out.println("\nA number has been chosen between " + min + " and " + max + ". Can you guess it?");
        
        while (attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Consume invalid input
                continue;
            }
            
            int guess = scanner.nextInt();
            
            if (guess < min || guess > max) {
                System.out.println("Please enter a number between " + min + " and " + max + ".");
                continue;
            }
            
            if (guess == target) {
                System.out.println("Congratulations! You guessed the number in " + (attempts + 1) + " attempts.");
                score[0]++;
                return;
            } else if (guess < target) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
            attempts++;
        }
        
        System.out.println("Sorry, you've run out of attempts. The number was " + target + ".");
    }
    
    public static void main(String[] args) {
        int min = 1, max = 100, maxAttempts = 5;
        int[] score = {0};
        Scanner scanner = new Scanner(System.in);
        char playAgain;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        do {
            playGame(min, max, maxAttempts, score, scanner);
            System.out.println("Your current score: " + score[0]);
            System.out.println("----------------------------------");
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next().charAt(0);
        } while (playAgain == 'y' || playAgain == 'Y');
        
        System.out.println("Thanks for playing! Your final score is: " + score[0]);
        scanner.close();
    }
}

