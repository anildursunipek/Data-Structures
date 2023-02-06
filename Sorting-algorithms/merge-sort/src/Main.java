public class Main {
    public static void main(String[] args) {

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
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(array, temp, leftStart, middle);
        mergeSort(array, temp, middle + 1, rightEnd);
        mergeHelves(array, temp, leftStart, rightEnd);
    }
    public static void mergeHelves(int[] array, int[] temp, int leftStart, int rightEnd){
        int leftEnd = (rightEnd + leftStart) / 2;
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
}