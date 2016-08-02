package minigames; /**
 * Created by mihails_nikitins on 26.07.2016.
 */

import java.util.Scanner;

public class ProgramGuesses
{
    public static void main(String[] args)
    {
        System.out.println("Imagine a number from 1 to 100. Program will try to guess your number. Enter 'g' if your number is greater, 'l' - if less and 'ok' if the program guessed.");
        Scanner sc = new Scanner(System.in);
        int number = 50;
        int min = 1;
        int max = 100;
        System.out.println("Is this number " + number + "?");
        String answer = sc.nextLine();
        while (!answer.equals("ok"))
        {
            if (answer.equals("g"))
            {
                if (number == 99){
                    number = 100;
                } else {
                    min = number;
                    number = (int)Math.ceil((min + max) / 2);
                }
            }
            else if (answer.equals("l")) {
                max = number;
                number = (min + max) / 2;
            }
            System.out.println("Is this number " + number + "?");
            answer = sc.nextLine();
        }

    }
}