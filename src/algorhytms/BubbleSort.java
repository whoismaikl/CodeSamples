package algorhytms;

/**
 * Created by mihails_nikitins on 26.07.2016.
 */

public class BubbleSort {

    public static void main(String[] args) {

        int[] myArray = generateRandomArray();
        System.out.println("Array Before Sort");
        printArray(myArray);
        bubbleSort(myArray);
        System.out.println("Array After Sort");
        printArray(myArray);
    }

    private static void printArray(int[] myArray) {
        for (int x : myArray) {
            System.out.println(x);
        }
    }

    private static int[] generateRandomArray() {
        int[] numberArray = new int[10];
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = (int) (Math.random() * 10 + 1);
        }
        return numberArray;
    }

    private static void bubbleSort(int[] myArray) {
        int temp;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 1; j < (myArray.length - i); j++) {

                if (myArray[j - 1] > myArray[j]) {
                    temp = myArray[j - 1];
                    myArray[j - 1] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }
    }

}

