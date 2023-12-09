import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        int arraySize = 20;
        int[] array = new int[arraySize];

        for(int i = 0; i < arraySize; i++){
            array[i] = rnd.nextInt(100);
        }

        System.out.println("Before Quick Sort Algorithm\n---------------------------");
        Quick.printArray(array);
        /*
        Before Quick Sort Algorithm
        ---------------------------
        48 -> 73 -> 39 -> 59 -> 92 -> 4 -> 51 -> 31 -> 95 -> 85 -> 8 -> 45 -> 2 -> 42 -> 74 -> 76 -> 12 -> 31 -> 53 -> 50 ->
        */
        System.out.println("After Quick Sort Algorithm\n---------------------------");
        Quick.QuickSort(array, 0, array.length - 1);
        Quick.printArray(array);
        /*
        After Quick Sort Algorithm
        ---------------------------
        2 -> 4 -> 8 -> 12 -> 31 -> 31 -> 39 -> 42 -> 45 -> 48 -> 50 -> 51 -> 53 -> 59 -> 73 -> 74 -> 76 -> 85 -> 92 -> 95 ->
        */
        // Time Complexities
        // Avarage Case = O(n*logn)
        // Worst Case = O(n^2)
        // Best Case = O(n*logn)
        /*
        * Choosing the pivot
        * Pivot can be random, i.e. select the random pivot from the given array.
        * Pivot can either be the rightmost element of the leftmost element of the given array.
        * Select median as the pivot element.
        */
    }
}