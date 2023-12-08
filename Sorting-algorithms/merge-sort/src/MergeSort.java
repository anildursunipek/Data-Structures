public class MergeSort {
    public static void mergeSort(int[] array, int beg, int end){
        if(beg < end){
            int mid = (beg + end) / 2;
            mergeSort(array, beg, mid);
            mergeSort(array, mid + 1, end);
            merge(array, beg, mid, end);
        }
    }
    private static void merge(int array[], int beg, int mid, int end){
        int i, j, k;
        int n1 = mid - beg + 1; // left array  length
        int n2 = end - mid; // right array length

        // Temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temp arrays
        for(i=0; i < n1; i++){
            leftArray[i] = array[beg+i];
        }
        for(j=0; j < n2; j++){
            rightArray[j] = array[mid + 1 + j];
        }
        i = 0; // initial index for first sub-array
        j = 0; // initial index for second sub-array
        k = beg; // initial index for merged sub-array (result array)
        while(i < n1 && j < n2){
            if(leftArray[i] < rightArray[j]){
                array[k++] = leftArray[i++];
            }else{
                array[k++] = rightArray[j++];
            }
        }

        while(i < n1){
            array[k++] = leftArray[i++];
        }
        while(j < n2){
            array[k++] = rightArray[j++];
        }
    }
}
