public class LinkedList {
    Node head;

    public void Append(int data){
        if(head == null){
            head = new Node(data);
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void Prepend(int data){
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void Delete(int data){
        if(head == null) return;
        if(head.data == data){
            // Deleted firt node
            head = head.next;
            return;
        }
        Node current = head;
        while(current.next != null){
            if(current.next.data == data){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void PrintLinkedList(){
        if(head == null){
            System.out.println("Linked List is empty.");
            return;
        }
        Node current = head;
        while(current.next != null){
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }
}
