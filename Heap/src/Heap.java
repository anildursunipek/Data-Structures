public abstract class Heap<T extends Comparable<T>> implements IHeap<T> {
    protected T[] heap;
    protected int position = -1; // Keep track of the last element inside the heap

    public Heap(){
        this.heap = (T[]) new Comparable[2];
    }

    protected abstract void fixUpward();
    protected abstract void fixDownward(int endIndex);

    @Override
    public IHeap<T> insert(T data){
        if(isFull()){
            resize(2 * heap.length);
        }
        heap[++this.position] = data;
        fixUpward();
        return this;
    }

    @Override
    public T getRoot(){
        if(isEmpty()){
            return null;
        }
        T result = this.heap[0];
        heap[0] = this.heap[this.position--];
        this.heap[this.position + 1] = null;
        fixDownward(this.position);
        return result;
    }

    @Override
    public void sort(){
        // Maximum heap: print in ascending oder
        // Minimum heap: print in descending order
        int temp = this.position;
        for(int i=0; i <= temp; i++){
            T data = getRoot();
            System.out.print(data + " -> ");
        }
        System.out.println();
    }

    public void print(){
        for(T data:this.heap){
            if(data == null) break;
            System.out.print(data + " -> ");
        }
        System.out.println();
    }

    private boolean isFull(){
        return this.position == heap.length - 1;
    }

    private boolean isEmpty(){
        return this.heap.length == 0;
    }

    protected void swap(int firstIndex, int secondIndex){
        T temp = this.heap[firstIndex];
        this.heap[firstIndex] = this.heap[secondIndex];
        this.heap[secondIndex] = temp;
    }

    private void resize(int capacity){
        T[] temp = (T[])new Comparable[capacity];
        System.arraycopy(heap, 0, heap=temp, 0, position + 1);
        /*
        System.arraycopy method explanation;
        public static void arraycopy (Object src, int srcPos, Object dest, int destPos, int length)
        Parameters
        ----------
        src - Source array (Object type)
        srcPos - Starting position in Source array (Integer type)
        dest - Destination array (Object Type)
        destpos - Starting position in destination array (Integer type)
        length - Number of elements to be copied (Integer type)
         */
    }
}
