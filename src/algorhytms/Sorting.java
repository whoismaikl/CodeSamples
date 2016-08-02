package algorhytms;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by mihails_nikitins on 01.08.2016.
 */

public class Sorting
{
    public static void main(String[] args)
    {
        Sorting sort = new Sorting();
        int[] numbers = sort.randomArray();
        System.out.println("Unsorted array:");
        sort.printArr(numbers);
        System.out.println("Enter '1' if you want to use QuickSort, '2' if MergeSort and '3' for exit:");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number != 3)
        {
            if (number == 1)
            {
                System.out.println("Sorted array by QuickSort:");
                sort.quickSort(numbers, 0, numbers.length - 1);
                sort.printArr(numbers);
            }
            else if (number == 2)
            {
                System.out.println("Sorted array by MergeSort:");
                sort.mergeSort(numbers);
                sort.printArr(numbers);
            }
            else
            {
                System.out.println("Wrong number!");
            }
        }
    }

    private int[] randomArray()
    {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = (int)(Math.random() * 20 - 10);
        }
        return arr;
    }

    private void printArr(int[] arr)
    {
        System.out.println(Arrays.toString(arr));
    }

    private void quickSort(int[] arr, int low, int high)
    {
        if (arr.length == 0)
            return;
        if (low >= high)
            return;

        int i = low;
        int j = high;
        int pivot = arr[low + (high - low)/2];

        while (i <= j)
        {
            while (arr[i] < pivot)
            {
                i++;
            }
            while (arr[j] > pivot)
            {
                j--;
            }
            if (i <= j)
            {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(arr, low, j);
        if (high > i)
            quickSort(arr, i, high);

    }

    private void mergeSort(int[] arr)
    {
        if (arr.length <= 1)
            return;

        int[] left = new int[arr.length / 2];
        int[] right = new int[arr.length - left.length];

        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, left.length, right, 0, right.length);

        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }

    private void merge(int[] left, int[] right, int[] arr)
    {
        int l = 0;
        int r = 0;
        int a = 0;

        while (l < left.length && r < right.length)
        {
            if (left[l] < right[r])
            {
                arr[a] = left[l];
                l++;
            }
            else
            {
                arr[a] = right[r];
                r++;
            }
            a++;
        }

        System.arraycopy(left, l, arr, a, left.length - l);
        System.arraycopy(right, r, arr, a, right.length - r);
    }

}

