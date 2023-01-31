public class Stack {
    Node top; // Top is last element of the stack

    public boolean isEmpty(){
        return top == null;
    }

    public void Push(int data){
        if(top == null){
            top = new Node(data);
            return;
        }
        Node newTop = new Node(data);
        newTop.next = top;
        top = newTop;
    }

    public int Pop(){
        if(top == null) return -1;
        int tempData = top.data;
        top = top.next;
        return tempData;
    }

    public int Peek(){
    /*return: Top element of the stack*/
        return top.data;
    }

    public void PrintStack(){
        if(this.isEmpty()){
            System.out.println("Stack is empty...");
            return;
        }
        System.out.println("Printing Stack...");
        Node current = top;
        while(current.next != null){
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }
}
