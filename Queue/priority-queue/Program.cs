class Program
{
    public static void Main(String[] args)
    {
        // PRIORITY QUEUE
        // Test Codes
        PriorityQueue queue = new PriorityQueue();
        queue.enqueue(1, 40);
        queue.enqueue(0, 60);
        queue.enqueue(0, 20);
        queue.enqueue(1, 30);
        queue.enqueue(3, 50);
        queue.enqueue(2, 70);
        queue.enqueue(2, 550);
        queue.enqueue(4, 350);
        queue.enqueue(0, 650);
        queue.enqueue(3, 950);
        queue.enqueue(3, 750);
        queue.enqueue(3, 850);
        queue.printQueue();

        /* Outputs of the above codes
   
        Data -> 60 Priority -> 0
        Data -> 20 Priority -> 0
        Data -> 650 Priority -> 0
        Data -> 40 Priority -> 1
        Data -> 30 Priority -> 1
        Data -> 70 Priority -> 2
        Data -> 550 Priority -> 2
        Data -> 50 Priority -> 3
        Data -> 950 Priority -> 3
        Data -> 750 Priority -> 3
        Data -> 850 Priority -> 3
        Data -> 350 Priority -> 4

         */
    }
}
interface Queue
{
    public void enqueue(int priority, Object data);
    public Object dequeue();
    public bool isEmpty();
    public void printQueue();
}
public class Node
{
    public int priority;
    public Object data;
    public Node next;
    public Node(int priority, Object data)
    {
        this.priority = priority;
        // Priorty order
        // 0 is the highest priority.
        // 0 -> 1 -> 2 -> ...
        this.data = data;
    }
}
class PriorityQueue : Queue
{
    Node head;
    
    public void enqueue(int priority, Object data)
    {
        Node node = new Node(priority, data);

        if(this.head == null) // İf head is null, Add new node to head
        {
            this.head = node;
            return;
        }
        if(this.head.priority > node.priority) // If New node has a more priority queue, Prepend the new node
        {
            node.next = this.head;
            this.head = node;
            return;
        }

        Node temp = this.head;
        while(temp.next != null && temp.next.priority <= node.priority)
        {
            // Find the available place for new node
            temp = temp.next;
        }

        node.next = temp.next;
        temp.next = node;
    }

    public object dequeue()
    {
        if (this.head != null)
        {
            Node temp = this.head;
            this.head = this.head.next;
            return temp.data;
        }
        return null;
    }

    public bool isEmpty()
    {
        if(this.head == null)
        {
            return true;
        }
        return false;
    }

    public void printQueue()
    {
        Node temp = this.head;
        while(temp != null)
        {
            Console.WriteLine("Data -> " + temp.data + " Priority -> " + temp.priority);
            temp = temp.next;
        }
        Console.WriteLine("----------------------");
    }
}