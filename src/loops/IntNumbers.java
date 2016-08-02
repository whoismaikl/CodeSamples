package loops; /**
 * Created by mihails_nikitins on 26.07.2016.
 */

import java.util.Scanner;

public class IntNumbers {

    public static void main(String[] args) {

        int even = 0;
        int odd = 0;
        System.out.println("Enter any numbers you want (to exit enter 0):");
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        while (number != 0)
        {
            if ((number % 2) == 0)
                even++;
            else
                odd++;
            number = sc.nextInt();
        }
        System.out.println("You have entered " + even + " even numbers and " + odd + " odd numbers!");
    }
}