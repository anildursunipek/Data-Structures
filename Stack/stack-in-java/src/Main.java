public class Main {
    public static void main(String[] args) {
        StackTestCodes();
    }
    public static void StackTestCodes(){
        Stack stack = new Stack();
        stack.Push(10);
        stack.Push(20);
        stack.Push(30);
        stack.Push(40);
        stack.Push(50);
        stack.Push(60);
        stack.Push(99);
        stack.PrintStack();
        stack.Pop();
        stack.Pop();
        stack.Pop();
        stack.Pop();
        stack.PrintStack();
        stack.Pop();
        stack.Pop();
        stack.Pop();
        stack.Pop();
        stack.PrintStack();
    }
}