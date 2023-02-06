public class Main {
    public static void main(String[] args) {
        queueTestCodes();
    }
    public static void queueTestCodes(){
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(130);
        queue.enqueue(410);
        queue.enqueue(1550);
        queue.enqueue(12310);
        queue.printQue();
        System.out.println("Deleted element ->" + queue.dequeue());
        System.out.println("Deleted element ->" + queue.dequeue());
        System.out.println("Deleted element ->" + queue.dequeue());
        queue.printQue();
    }
}