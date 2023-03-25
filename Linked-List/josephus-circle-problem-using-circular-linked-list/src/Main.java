public class Main {
    public static void main(String[] args) {
        CircularLinkedList list;
        list = new CircularLinkedList(1);
        list.josephusProblem();
        // Outputs
        /*Total Number Of Soldiers: 1
        Winner Soldier Position --> 1
        */
        list = new CircularLinkedList(2);
        list.josephusProblem();
        /*
        Total Number Of Soldiers: 2
        Winner Soldier Position --> 2
        */
        list = new CircularLinkedList(3);
        list.josephusProblem();
        /*
        Total Number Of Soldiers: 3
        Winner Soldier Position --> 2"
        */
        list = new CircularLinkedList(4);
        list.josephusProblem();
        /*
        Total Number Of Soldiers: 4
        Winner Soldier Position --> 1
         */
        list = new CircularLinkedList(5);
        list.josephusProblem();
        /*
        Total Number Of Soldiers: 5
        Winner Soldier Position --> 4
         */
        list = new CircularLinkedList(6);
        list.josephusProblem();
        /*
        Total Number Of Soldiers: 6
        Winner Soldier Position --> 1
         */
        list = new CircularLinkedList(14);
        list.josephusProblem();
        /*
        Total Number Of Soldiers: 14
        Winner Soldier Position --> 2
         */
        list = new CircularLinkedList(20);
        list.josephusProblem();
        /*
        Total Number Of Soldiers: 20
        Winner Soldier Position --> 20
         */
    }
}

class Node{
    int position;
    Node next;

    public Node(int position){
        this.position = position;
        this.next = null;
    }
}

class CircularLinkedList{
    Node head;
    int listLength;

    public CircularLinkedList(int numberOfSoliders){
        this.head = null;
        this.generateList(numberOfSoliders);
        this.listLength = numberOfSoliders;
    }

    public void generateList(int numberOfSoliders){
        for(int position=1; position<=numberOfSoliders; position++){
            this.add(position);
        }
    }

    public void josephusProblem(){
        System.out.println("Total Number Of Soldiers: " + this.listLength);

        // Problem Solving
        Node temp = this.head;
        while(temp.next != temp){
            temp = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        System.out.println("Winner Soldier Position --> " + temp.position);
    }
    public void add(int position){
        Node node = new Node(position);

        if(this.head == null){
            this.head = node;
            node.next = head;
            return;
        }

        Node temp = this.head;
        while(temp.next != this.head){
            temp = temp.next;
        }
        temp.next = node;
        node.next = head;
    }

    public void printList(){
        Node temp = this.head;
        while(temp.next != this.head){
            System.out.println(temp.position);
            temp = temp.next;
        }
        System.out.println(temp.position);
    }
}