import java.util.Scanner;
import java.util.Random;
public class Game
{
    static boolean playerWins = false;
    static int remainingTries = 10;
    static Random rnd = new Random();
    static int secretNumber = rnd.nextInt(1000) + 1;

    public static void Play(int userGuess)
    {
        while (remainingTries > 0)
        {
            if (secretNumber == userGuess)
            {
                System.out.println("Correct!");
                playerWins = true;
                remainingTries = 0;
            }
            else if (secretNumber > userGuess)
            {
                if (secretNumber - userGuess <= 50)
                {
                    System.out.println("Close! A little higher!");
                }
                else
                {
                    System.out.println("Higher.");
                }
            }
            else if (secretNumber < userGuess)
            {
                if (userGuess - secretNumber <= 50)
                {
                    System.out.println("Close! A little lower!");
                }
                else
                {
                    System.out.println("Lower.");
                }
            }

            if (remainingTries > 0)
            {
                remainingTries--;
                Guess();
            }
        }
    }

    public static void Guess()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 1000: ");

        if (sc.hasNextInt())
        {
            int userGuess = sc.nextInt();
            if (userGuess >= 1 && userGuess <= 1000)
            {
                Play(userGuess);
            }
            else
            {
                String invalidInput = sc.next();
                System.out.println(invalidInput + " not a valid input. Please try again with an integer between 1 and 1000.");
                Guess();
            }
        }
        else
        {
            String invalidInput = sc.next();
            System.out.println(invalidInput + " not a valid input. Please try again with an integer between 1 and 1000.");
            Guess();
        }
        sc.close();
    }

    public static void main(String[] args)
    {
        System.out.println
                ("Hello! This is a number guessing game. " +
                        "The game will generate a secret random number between 1 and 1000."
                        + "If you can guess the number within 10 tries, you win!");
        Guess();

        if (playerWins)
        {
            System.out.println("Congratulations, you win!");
        }
        else
        {
            System.out.println("Sorry, you lost! The secret number was: " + secretNumber);
        }
    }
}

