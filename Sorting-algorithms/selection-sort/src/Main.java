import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int upperBound = 100; // 0 to 99
        int[] array = new int[10];

        for(int i=0; i < array.length; i++){
            array[i] = rand.nextInt(upperBound);
        }

        // Test Codes
        // Print array
        System.out.println("Before Selection Sort\n........................");
        for (int num : array) {
            System.out.print(num + " ");
        }

        selectionSort(array);
        // Print after selection sort
        System.out.println("\nAfter Selection Sort\n........................");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void selectionSort(int[] array){
        // Time Complexity = O(n^2)
        // Space Complexity = O(1) -> constant

        for(int i=0; i < array.length - 1; i++){
            int index = i;
            for(int j= i+1; j < array.length; j++){
                if(array[index] > array[j]){
                    index = j;
                }
            }
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
    }
}