import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] samples = new int[20];

        for (int i = 0; i < samples.length; i++) {
            samples[i] = rand.nextInt(100);
        }
        System.out.println("Before sorting array elements\n------");
        /*
        Before sorting array elements
        ------
        26 -> 97 -> 67 -> 91 -> 71 -> 87 -> 98 -> 34 -> 22 -> 89 -> 63 -> 33 -> 90 -> 51 -> 47 -> 17 -> 57 -> 84 -> 31 -> 24 ->
        */
        printArray(samples);
        System.out.println("After sorting array elements\n------");
        /*
        After sorting array elements
        ------
        17 -> 22 -> 24 -> 26 -> 31 -> 33 -> 34 -> 47 -> 51 -> 57 -> 63 -> 67 -> 71 -> 84 -> 87 -> 89 -> 90 -> 91 -> 97 -> 98 ->
        */
        MergeSort.mergeSort(samples,0, samples.length - 1);// merging happening here
        printArray(samples);

    }
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " -> ");
        }
        System.out.println();
    }
}