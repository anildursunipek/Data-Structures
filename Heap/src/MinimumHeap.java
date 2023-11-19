public class MinimumHeap<T extends Comparable<T>> extends Heap<T> {
    @Override
    protected void fixUpward() {
        int index = this.position;
        int parentIndex = (index - 1) / 2;

        while(parentIndex >= 0 && this.heap[index].compareTo(this.heap[parentIndex]) < 0){
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    @Override
    protected void fixDownward(int endIndex) {
        // If there is no element in the array we dont need to do fixDonward. Because we deleted the last element.
        if(endIndex == -1){
            return;
        }
        int index = 0;
        while(index <= endIndex){
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            /*Since the index of the left child is always smaller than the index of the right child,
            we need to check if the index of the left child is greater than the last index.*/
            if(leftChildIndex > endIndex) break;
            int childToSwap;

            if(rightChildIndex > endIndex){
                childToSwap = leftChildIndex;
            }else{
                if(this.heap[leftChildIndex].compareTo(this.heap[rightChildIndex]) < 0){
                    childToSwap = leftChildIndex;
                }else{
                    childToSwap = rightChildIndex;
                }
            }
            if(this.heap[childToSwap].compareTo(this.heap[index]) < 0){
                swap(childToSwap, index);
                index = childToSwap;
            }else{
                break;
            }
        }
    }
}
