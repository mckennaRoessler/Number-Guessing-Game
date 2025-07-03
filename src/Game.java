import java.util.Scanner;
import java.util.Random;
public class Game
{
    public static void Play(int userGuess)
    {
        Random rnd = new Random();
        int secretNumber = rnd.nextInt(1000) + 1;
        int remainingTries = 10;

        while (remainingTries > 0)
        {
            //Change to switch case
            if (userGuess < secretNumber)
            {
                System.out.println("Too low");
                remainingTries--;
                Guess();
            }
        }
    }

    public static void Guess()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 1000: ");
        int userGuess = sc.nextInt();

        Play(userGuess);
    }

    public static void main(String[] args)
    {
        System.out.println
                ("Hello! This is a number guessing game. " +
                        "The game will generate a secret random number between 1 and 1000."
                        + "If you can guess the number within 10 tries, you win!");
        Guess();
    }
}

