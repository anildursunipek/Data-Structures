import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[8];
        Random rnd = new Random();
        for(int i = 0; i < 8; i++){
            array[i] = rnd.nextInt(100);
        }
        mergeSort(array);
    }
    public static void mergeSort(int[] array){
        // Time Complexity:  O(n * longn)
        // Space Complexity:  O(n)
        // One of the most efficient sorting algorithms
        mergeSort(array, new int[array.length], 0, array.length - 1);
    }
    public static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd){
        if(leftStart >= rightEnd){
            return;
        }
        printArray(array);
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(array, temp, leftStart, middle);
        mergeSort(array, temp, middle + 1, rightEnd);
        merge(array, temp, leftStart, rightEnd);
    }
    public static void merge(int[] array, int[] temp, int leftStart, int rightEnd){
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftStart + 1;
        int size = rightEnd - leftStart +1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while(left <= leftEnd && right <= rightEnd){
            if(array[left] <= array[right]){
                temp[index] = array[left];
                left++;
            } else{
                temp[index] = array[right];
                right++;
            }
            index++;
        }
    }
    public static void printArray(int[] array){
        System.out.println("Printing Array\n...............");
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i] + " ");
        }
    }
}