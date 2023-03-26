import java.util.Random;
public class Main {
    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();
        list.generateList();
        list.printList();
        //System.out.println(list.middleNode(list.head, list.last).data);
        int searchValue = 15;
        System.out.println("Searched Value -> " + searchValue + " Returned Value -> " + list.binarySearch(searchValue));
        searchValue = 30;
        System.out.println("Searched Value -> " + searchValue + " Returned Value -> " + list.binarySearch(searchValue));
        searchValue = 100;
        System.out.println("Searched Value -> " + searchValue + " Returned Value -> " + list.binarySearch(searchValue));
        searchValue = 5;
        System.out.println("Searched Value -> " + searchValue + " Returned Value -> " + list.binarySearch(searchValue));
        searchValue = 26;
        System.out.println("Searched Value -> " + searchValue + " Returned Value -> " + list.binarySearch(searchValue));

        // Sample Outputs
        /*
        List length --> 28
        INDEX --> 1  DATA --> 1
        INDEX --> 2  DATA --> 1
        INDEX --> 3  DATA --> 5
        INDEX --> 4  DATA --> 8
        INDEX --> 5  DATA --> 12
        INDEX --> 6  DATA --> 14
        INDEX --> 7  DATA --> 14
        INDEX --> 8  DATA --> 16
        INDEX --> 9  DATA --> 17
        INDEX --> 10  DATA --> 17
        INDEX --> 11  DATA --> 19
        INDEX --> 12  DATA --> 19
        INDEX --> 13  DATA --> 23
        INDEX --> 14  DATA --> 29
        INDEX --> 15  DATA --> 30
        INDEX --> 16  DATA --> 31
        INDEX --> 17  DATA --> 31
        INDEX --> 18  DATA --> 31
        INDEX --> 19  DATA --> 32
        INDEX --> 20  DATA --> 33
        INDEX --> 21  DATA --> 35
        INDEX --> 22  DATA --> 37
        INDEX --> 23  DATA --> 39
        INDEX --> 24  DATA --> 40
        INDEX --> 25  DATA --> 40
        INDEX --> 26  DATA --> 43
        INDEX --> 27  DATA --> 44
        INDEX --> 28  DATA --> 49
        Searched Value -> 15 Returned Value -> -1
        Searched Value -> 30 Returned Value -> 30
        Searched Value -> 100 Returned Value -> -1
        Searched Value -> 5 Returned Value -> 5
        Searched Value -> 26 Returned Value -> -1
        */
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
            int data = rnd.nextInt(50);
            this.add(data);
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
        while(temp.next != null && temp.data <= data){
            temp = temp.next;
        }
        if(temp.data >= data){
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

    public int binarySearch(int key){
        Node start = this.head;
        Node end = this.last;
        do{
            Node mid = this.middleNode(start, end);
            if(mid == null)
                return -1;

            if(mid.data == key){
                return mid.data;
            }else if(mid.data < key){
                start = mid.next;
            }else{
                end = mid;
            }
        }while(end == null ||  end != start);

        return -1;
    }

    public Node middleNode(Node start, Node last){
        if (start == null)
            return null;

        Node slow = start;
        Node fast = start;

        while (fast != last)
        {
            fast = fast.next;
            if (fast != last    )
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
        int counter = 1;
        while(temp.next != null){
            System.out.println("INDEX --> " + counter + "  DATA --> " + temp.data);
            temp = temp.next;
            counter++;
        }
        System.out.println("INDEX --> " + counter + "  DATA --> " + temp.data);
    }
}