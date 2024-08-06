import java.util.Random;
import java.util.Scanner;

public class GameRandomNumBer {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Random random = new Random();
            int score = 0;
            boolean playAgain = true;

            while (playAgain) {
                int min = 1;
                int max = 100;
                int randomNumber = random.nextInt((max - min) + 1) + min;
                int attempts = 10;
                boolean Correctguess = false;

                System.out.println("A new number has been generated between " + min + " and " + max + ".");
                System.out.println("You have " + attempts + " attempts left to guess the number.");

                while (attempts > 0 && !Correctguess) {
                    System.out.print("Enter your guess number : ");
                    int userGuess = sc.nextInt();
                    attempts--;

                    switch (Integer.compare(userGuess, randomNumber)) {
                        case 0:
                            System.out.println("Congratulations! You guessed the correct number.");
                            Correctguess = true;
                            score++;
                            break;
                        case 1:
                            System.out.println("Your guess is too high.");
                            break;
                        case -1:
                            System.out.println("Your guess is too low.");
                            break;
                    }

                    if (!Correctguess && attempts > 0) {
                        System.out.println("You have " + attempts + " attempts left.");
                    }
                }

                if (!Correctguess) {
                    System.out.println("Sorry, you have no attempts left. The correct number was " + randomNumber + ".");
                }

                System.out.print("Do you want to play again? (yes/no): ");
                String response = sc.next();
                playAgain = response.equalsIgnoreCase("yes");
            }

            System.out.println("Game over! Your total score is: " + score);
            sc.close();
        }
}
