public class Quick {
    public static void QuickSort(int[] array, int start, int end){
        if(start < end){
            int p = partition(array, start, end);
            QuickSort(array, start, p -1 );
            QuickSort(array, p + 1, end);
        }
    }
    private static int partition(int[] array, int start, int end){
         /* function that consider last element as pivot,
            place the pivot at its exact position, and place
            smaller elements to left of pivot and greater
            elements to right of pivot.
         */
        int pivot = array[end];
        int i = start - 1;

        for(int j = start; j <= end - 1; j++){
            // if current element is smaller then the pivot
            if(array[j] < pivot){
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);
        return (i + 1);
    }
    private static void swap(int[] array, int firstElement, int secondElement){
        int temp = array[firstElement];
        array[firstElement] = array[secondElement];
        array[secondElement] = temp;
    }
    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " -> ");
        }
        System.out.println();
    }
}