class Program
{
    public static void Main(String[] args)
    {
        // RADIX SORT WITH QUEUE

        // Test codes
        QueueUsingLinkedList queueu = new QueueUsingLinkedList();
        int[] array = { 91, 48, 85, 15, 3232, 92, 35, 31, 22,300 };
        foreach (int element in array)
        {
            queueu.enqueue(element);
        }
        Console.WriteLine("Before sorting");
        queueu.printQueue();
        Console.WriteLine("After sorting");
        queueu = RadixSort(queueu);
        queueu.printQueue();

        QueueUsingLinkedList queueu2 = new QueueUsingLinkedList();
        int[] array2 = { 17, 14, 39, 1230, 45, 3204, 34, 56, 55, 67, 86, 999 };
        foreach (int element in array)
        {
            queueu2.enqueue(element);
        }
        Console.WriteLine("Before sorting");
        queueu2.printQueue();
        Console.WriteLine("After sorting");
        queueu2 = RadixSort(queueu2);
        queueu2.printQueue();
        /* Outputs
        QUEUE - 1
        Before sorting
        Data -> 91
        Data -> 48
        Data -> 85
        Data -> 15
        Data -> 3232
        Data -> 92
        Data -> 35
        Data -> 31
        Data -> 22
        Data -> 300
        ----------------------
        After sorting
        Data -> 15
        Data -> 22
        Data -> 31
        Data -> 35
        Data -> 48
        Data -> 85
        Data -> 91
        Data -> 92
        Data -> 300
        Data -> 3232
        ----------------------
        QUEUE - 2
        Before sorting
        Data -> 91
        Data -> 48
        Data -> 85
        Data -> 15
        Data -> 3232
        Data -> 92
        Data -> 35
        Data -> 31
        Data -> 22
        Data -> 300
        ----------------------
        After sorting
        Data -> 15
        Data -> 22
        Data -> 31
        Data -> 35
        Data -> 48
        Data -> 85
        Data -> 91
        Data -> 92
        Data -> 300
        Data -> 3232
        ----------------------*/
    }
    public static QueueUsingLinkedList RadixSort(QueueUsingLinkedList queue)
    {
        QueueUsingLinkedList tempQue = queue;
        QueueUsingLinkedList tempQue2 = new QueueUsingLinkedList();
        int max = tempQue.getMax();
        int div = 1;

        for(int i=max; i>0; i /= 10) // In this loop, as many iterations as the number of digits take place
        {
            // First iteration input example = { 91, 48, 85, 15, 3232, 92, 35, 31, 22,300 } 
            for (int j=0; j < 10; j++) // 0,1,2,...,9
            {
                
                Node tempNode = tempQue.getHeadNode();

                while(tempNode != null)
                {
                    if ((tempNode.data / div) % 10 == j)
                        // Example
                        // (92 / 1) % 10 = 1 ---> Ones digit
                        // (92 / 10) % 10 = 9 ---> Tens digit
                        tempQue2.enqueue(tempNode.data);
                    tempNode = tempNode.next;
                }
            }
            // First iteration output example = {300, 91, 31, 3232, 92, 22, 85, 15, 35, 48}
            tempQue = tempQue2;
            tempQue2 = new QueueUsingLinkedList();
            div *= 10;
        }
        return tempQue;
    }
}
interface Queue
{
    public void enqueue(int data);
    public int dequeue();
    public bool isEmpty();
    public void printQueue();
    public int getMax();
    public Node getHeadNode();
}
public class Node
{
    public int data;
    public Node next;
    public Node(int data)
    {
        this.data = data;
    }
}
class QueueUsingLinkedList : Queue
{
    Node head;
    public void enqueue(int data)
    {
        Node node = new Node(data);
        if(this.head == null)
        {
            this.head = node;
            return;
        }

        Node temp = this.head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = node;
    }

    public int dequeue()
    {
        if (this.head != null)
        {
            Node temp = this.head;
            this.head = this.head.next;
            return temp.data;
        }
        return -1;
    }

    public bool isEmpty()
    {
        if (this.head == null)
        {
            return true;
        }
        return false;
    }

    public Node getHeadNode()
    {
        return this.head;
    }
    public int getMax()
    {
        int max = 0;
        Node temp = this.head;
        while (temp != null)
        {
            if(temp.data > max)
            {
                max = temp.data;
            }
            temp = temp.next;
        }
        return max;
    }
    public void printQueue()
    {
        Node temp = this.head;
        while (temp != null)
        {
            Console.WriteLine("Data -> " + temp.data);
            temp = temp.next;
        }
        Console.WriteLine("----------------------");
    }
}