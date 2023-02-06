public class Queue {
    Node head;

    public int peek(){
        // head first element of the queue
        return head.data;
    }
    public void enqueue(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = node;
    }

    public int dequeue(){
        if(head == null){
            return -1;
        }
        int tempData = head.data;
        head = head.next;
        return tempData;
    }

    public void printQue(){
        System.out.println("Printing Queue......");
        Node current = head;
        while(current.next != null){
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }
}
