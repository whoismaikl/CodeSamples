package arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mihails_nikitins on 02.08.2016.
 */
public class StringsInArrays {
    public static void main(String[] args)
    {
        System.out.println("Enter any symbols you want (to exit enter blank line):");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] original = new String[1];
        original[0] = text;
        while (!text.equals(""))
        {
            text = sc.nextLine();
            if (!text.equals(""))
            {
                String[] temp = new String[original.length + 1];
                int i;
                for (i = 0; i < original.length; i++)
                    temp[i] = original[i];

                temp[i] = text;
                original = temp;
            }
        }
        Arrays.sort(original);
        System.out.println(Arrays.toString(original));
    }
}
