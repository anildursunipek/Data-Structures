import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        LinkedListUsingArray list = new LinkedListUsingArray(100);
        System.out.println("--->>> Add Method Test Outputs");
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(400);
        list.add(2500);
        list.add(3200);
        list.displayList();
        System.out.println("--->>> Add Head Method Test Outputs | --->>> 50 Added");
        list.addHead(50);
        list.displayList();
        System.out.println("--->>> Delete Method Test Outputs | 400 and 50 Deleted");
        list.delete(400);
        list.delete(50);
        list.displayList();
        System.out.println("--->>> Pop Method Test Outputs");
        System.out.println("Returned data --> "  + list.pop());
        list.displayList();

        // Sample Outputs
        /*
        --->>> Add Method Test Outputs
        List Head Index --> 0
        Data: 100 Next Index: 1 Previous Index: -1
        Data: 200 Next Index: 2 Previous Index: 0
        Data: 300 Next Index: 3 Previous Index: 1
        Data: 400 Next Index: 4 Previous Index: 2
        Data: 2500 Next Index: 5 Previous Index: 3
        Data: 3200 Next Index: -1 Previous Index: 4
        ----------------------------------
        --->>> Add Head Method Test Outputs | --->>> 50 Added
        List Head Index --> 6
        Data: 50 Next Index: 0 Previous Index: -1
        Data: 100 Next Index: 1 Previous Index: 6
        Data: 200 Next Index: 2 Previous Index: 0
        Data: 300 Next Index: 3 Previous Index: 1
        Data: 400 Next Index: 4 Previous Index: 2
        Data: 2500 Next Index: 5 Previous Index: 3
        Data: 3200 Next Index: -1 Previous Index: 4
        ----------------------------------
        --->>> Delete Method Test Outputs | 400 and 50 Deleted
        List Head Index --> 0
        Data: 100 Next Index: 1 Previous Index: -1
        Data: 200 Next Index: 2 Previous Index: 0
        Data: 300 Next Index: 4 Previous Index: 1
        Data: 2500 Next Index: 5 Previous Index: 2
        Data: 3200 Next Index: -1 Previous Index: 4
        ----------------------------------
        --->>> Pop Method Test Outputs
        Returned data --> 3200
        List Head Index --> 0
        Data: 100 Next Index: 1 Previous Index: -1
        Data: 200 Next Index: 2 Previous Index: 0
        Data: 300 Next Index: 4 Previous Index: 1
        Data: 2500 Next Index: -1 Previous Index: 2
        ----------------------------------
        */
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
            temp = this.array[temp].next;
        }
        this.array[temp].next = idx;
        this.array[idx] = new Node(data);
        this.array[idx].next = -1;
        this.array[idx].previous = temp;
    }
    public void addHead(int data){
        int idx = availableIndex();
        Node node = new Node(data);

        if(this.headIndex == -1){
            this.headIndex = idx;
            this.array[idx] = node;
            this.array[idx].next = -1;
            this.array[idx].previous = -1;
            return;
        }

        this.array[idx] = node;
        this.array[headIndex].previous = idx;
        this.array[idx].next = headIndex;
        this.headIndex = idx;
    }

    public int pop() throws Exception{
        int temp = this.headIndex;
        if(this.headIndex == -1){
            throw new Exception("List is empty");
        }

        while(this.array[temp].next != -1){
            temp = this.array[temp].next;
        }

        int previous = this.array[temp].previous;
        int returnedData = this.array[temp].data;
        this.array[previous].next = -1;
        this.array[temp] = null;
        return returnedData;
    }
    public void delete(int data) throws Exception {
        int temp = this.headIndex;

        if(this.headIndex == -1){
            throw new Exception("List is empty");
        }

        if(this.array[this.headIndex].data == data){
            this.headIndex = this.array[headIndex].next;
            this.array[headIndex].previous = -1;
            this.array[temp] = null;
            return;
        }

        while(this.array[temp].next != -1){
            if(this.array[temp].data == data){
                break;
            }
            temp = this.array[temp].next;
        }

        int previous = this.array[temp].previous;
        int next = this.array[temp].next;
        this.array[temp] = null;
        this.array[previous].next = next;
        this.array[next].previous = previous;
    }

    public void displayList(){
        int temp = this.headIndex;
        System.out.println("List Head Index --> " + this.headIndex);
        while(this.array[temp].next != -1){
            System.out.println("Data: " + this.array[temp].data + " Next Index: " + this.array[temp].next + " Previous Index: " + this.array[temp].previous);
            temp = this.array[temp].next;
        }
        System.out.println("Data: " + this.array[temp].data +
                " Next Index: " + this.array[temp].next +
                " Previous Index: " + this.array[temp].previous +
                "\n----------------------------------");
    }

    public int availableIndex(){
        int idx=0;
        while(this.array[idx] != null){
            idx++;
        }
        return idx;
    }
}