package algorhytms;

/**
 * Created by mihails_nikitins on 26.07.2016.
 */
public class SwapLargestElementWithFirst {

        public static void main(String[] args)
        {
            System.out.println("Before Swap:");
            int[] arr = {1, 12, 3, 4, 5, 17};
            System.out.println("First and largest elements will be swapped");
            for (int i = 0; i < arr.length; i++)
                System.out.println(arr[i]);
            int max = arr[0];
            int maxPos = 0;
            int tmp;
            for (int i = 1; i < arr.length; i++)
            {
                if (max < arr[i])
                {
                    max = arr[i];
                    maxPos = i;
                }
            }
            for (int i = maxPos; i > 0; i--)
            {
                tmp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = tmp;
            }
            System.out.println("After Swap");
            for (int i = 0; i < arr.length; i++)
                System.out.println(arr[i]);
        }

}
