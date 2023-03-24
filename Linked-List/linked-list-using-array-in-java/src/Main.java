public class Main {
    public static void main(String[] args) {
        LinkedListUsingArray list = new LinkedListUsingArray(100);
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        list.add(2500);
        list.add(3200);
        list.displayList();
    }
}
class Node{
    int data;
    int next;
    int previous;
    public Node(int data){
        this.data = data;
        this.next = -1;
        this.previous = -1;
    }
}
class LinkedListUsingArray{
    int headIndex;
    Node[] array;

    public LinkedListUsingArray(int length){
        this.array = new Node[length];
        this.headIndex = -1;
    }
    public void add(int data){
        int idx = availableIndex();
        if(this.headIndex == -1){
            this.headIndex = idx;
            this.array[idx] = new Node(data);
            this.array[idx].next = -1;
            this.array[idx].previous = -1;
            return;
        }
        int temp = headIndex;
        while(this.array[temp].next != -1){
            temp++;
        }
        this.array[temp].next = idx;
        this.array[idx] = new Node(data);
        this.array[idx].next = -1;
        this.array[idx].previous = temp;
    }

    public void displayList(){
        int temp = this.headIndex;
        while(this.array[temp].next != -1){
            System.out.println("Data: " + this.array[temp].data + " Next Index: " + this.array[temp].next + " Previous Index: " + this.array[temp].previous);
            temp++;
        }
        System.out.println("Data: " + this.array[temp].data + " Next Index: " + this.array[temp].next + " Previous Index: " + this.array[temp].previous);
    }

    public int availableIndex(){
        int idx=0;
        while(this.array[idx] != null){
            idx++;
        }
        return idx;
    }

}