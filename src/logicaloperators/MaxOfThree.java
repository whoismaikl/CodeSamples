package logicaloperators;

import java.util.Scanner;

/**
 * Created by mihails_nikitins on 26.07.2016.
 */
public class MaxOfThree {

    public static void main(String[] args) {
        System.out.println("Enter three numbers:");
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        System.out.println(biggest(n1, n2, n3));
    }

    private static int biggest(int a, int b, int c) {
        if (a >= b) {
            if (a >= c) return a;
            else return c;
        } else {
            if (b >= c) return b;
            else return c;
        }
    }
}
