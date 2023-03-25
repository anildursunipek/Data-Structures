import java.util.Random;
public class Main {
    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();
        list.generateList();
        list.printList();
        System.out.println(list.middleNode(list.head, list.last).data);
    }
}

class Node{
    int data;
    Node next;
    Node previous;
    public Node(int data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}

class SortedLinkedList{
    Node head;
    Node last;
    int length;
    Random rnd;

    public SortedLinkedList(){
        this.head = null;
        this.last = null;
        this.rnd = new Random();
        this.length = rnd.nextInt(10,30);
    }

    public void generateList(){
        for(int i=0;i<this.length; i++){
            int data = rnd.nextInt(100);
            //System.out.println(data);
            this.add(data);
            /*if(this.last != null){
                System.out.println("Last --> " + this.last.data + "\n Head --> " + this.head.data);
            }*/
            System.out.println("I -> " + i);
        }
    }
    private void add(int data){
        Node node = new Node(data);

        if(this.head == null){
            this.head = node;
            this.last = node;
            return;
        }

        if(this.head.data >= data){
            node.next = this.head;
            this.head.previous = node;
            this.head = node;
            return;
        }

        Node temp = this.head;
        while(temp.next != null && temp.data < data){
            temp = temp.next;
        }
        if(temp.data > data){
            node.next = temp;
            node.previous = temp.previous;
            temp.previous.next = node;
            temp.previous = node;
            return;
        }
        if(temp.next == null){
            temp.next = node;
            node.previous = temp;
            this.last = node;
            return;
        }
    }

    public void binarySearch(int data){

    }

    public Node middleNode(Node start, Node last){
        if (start == null)
            return null;

        Node slow = start;
        Node fast = start.next;

        while (fast != last)
        {
            fast = fast.next;
            if (fast != last)
            {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
    public void printList(){
        Node temp = this.head;
        System.out.println("List length --> " + this.length);
        int counter = 0;
        while(temp.next != null){
            System.out.println("INDEX --> " + counter + "  DATA --> " + temp.data);
            temp = temp.next;
            counter++;
        }
        System.out.println("INDEX --> " + counter + "  DATA --> " + temp.data);
    }
}