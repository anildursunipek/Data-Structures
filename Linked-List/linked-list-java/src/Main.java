public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        // Append method test codes
        linkedList.Append(10);
        linkedList.Append(20);
        linkedList.Append(30);
        linkedList.Append(40);
        linkedList.Append(50);
        linkedList.Append(340);
        linkedList.Append(530);

        // Prepend method test code
        linkedList.Prepend(400);
        linkedList.PrintLinkedList();
        System.out.println("-------------------");

        // Delete method test codes
        linkedList.Delete(40);
        linkedList.Delete(400);
        linkedList.Delete(530);
        linkedList.PrintLinkedList();
    }
}