using System.Text;

class Program
{
    public static void Main(String[] args)
    {
        // Palindrome algorithm with stack
        // Sample Codes
        Console.WriteLine("Result -> " + isPalindrome("Adana’da pideye", new StackUsingLinkedList()) + "\n---------------");
        Console.WriteLine("Result -> " + isPalindrome("adanada", new StackUsingArray(100)) + "\n---------------");
        Console.WriteLine("Result -> " + isPalindrome("784521125487", new StackUsingLinkedList()) + "\n---------------");
        Console.WriteLine("Result -> " + isPalindrome("repaper", new StackUsingArray(100)) + "\n---------------");
        Console.WriteLine("Result -> " + isPalindrome("Was it a car or a cat i saw?", new StackUsingLinkedList()) + "\n---------------");
        Console.WriteLine("Result -> " + isPalindrome("Rise to vote, sir!", new StackUsingArray(100)) + "\n---------------");
        Console.WriteLine("Result -> " + isPalindrome("There are 184 lines in this file.", new StackUsingArray(100)) + "\n---------------");

        /* Outputs
        Text -> adanadapideye
        Reverse Text -> eyedipadanada
        Result -> False
        ---------------
        Text -> adanada
        Reverse Text -> adanada
        Result -> True
        ---------------
        Text -> 784521125487
        Reverse Text -> 784521125487
        Result -> True
        ---------------
        Text -> repaper
        Reverse Text -> repaper
        Result -> True
        ---------------
        Text -> wasitacaroracatisaw
        Reverse Text -> wasitacaroracatisaw
        Result -> True
        ---------------
        Text -> risetovotesir
        Reverse Text -> risetovotesir
        Result -> True
        ---------------
        Text -> thereare184linesinthisfile
        Reverse Text -> elifsihtnisenil481eraereht
        Result -> False
        ---------------
         */

    }

    public static bool isPalindrome(String text, Stack stack)
    {
        String reverseText = "";
        // Clean the text
        text = text.ToLower();
        text = RemovePunctuations(text); // Delete all Punctuation characters
        text = text.Replace(" ", ""); // Delete all spaces
        Console.WriteLine("Text -> " + text);

        foreach (char c in text)
        {
            stack.push(c); // Add all chracters to stack one by one
        }

        while (!stack.isEmpty())
        {
            reverseText += stack.pop();
        }
        Console.WriteLine("Reverse Text -> " + reverseText);
        return text == reverseText; // Check the result. İf text is equal to reverseText, text is polindrom.
    }

    public static string RemovePunctuations(string input)
    {
        /*This function removes all punctuations from the text.*/
        StringBuilder sb = new StringBuilder();
        foreach (char c in input)
        {
            if (!char.IsPunctuation(c))
            {
                sb.Append(c);
            }
        }
        return sb.ToString();
    }
}

// STACK CODES
interface Stack
{
    public void push(Object data);
    public Object pop();
    public void printStack();
    public bool isEmpty();
}

// STACK USING LINKED LIST CODES
class StackNode
{
    public Object data;
    public StackNode next;
    public StackNode(object data)
    {
        this.data = data;
    }
}
class StackUsingLinkedList : Stack
{
    StackNode head;

    public void push(Object data)
    {
        StackNode node = new StackNode(data);
        node.next = this.head;
        head = node;
    }
    public Object pop()
    {
        StackNode temp = this.head;
        this.head = this.head.next;
        return temp.data;
    }

    public void printStack()
    {
        StackNode temp = this.head;
        while (temp != null)
        {
            Console.Write(temp.data);
            temp = temp.next;
        }
    }

    public bool isEmpty()
    {
        if (this.head == null)
        {
            return true;
        }
        return false;
    }
}

// STACK USING ARRAY CODES
class StackUsingArray : Stack
{
    int head = -1;
    Object[] array;
    int length;

    public StackUsingArray(int length)
    {
        this.length = length;
        this.array = new Object[length];
    }

    public void push(Object data)
    {
        if (this.head != length - 1)
        {
            this.head++;
            this.array[head] = data;
        }
    }
    public Object pop()
    {
        if (this.head != -1)
        {
            this.head--;
            return this.array[this.head + 1];
        }
        return null;
    }

    public void printStack()
    {
        for (int i = this.head; i >= 0; i--)
        {
            Console.Write(this.array[i]);
        }
    }

    public bool isEmpty()
    {
        if (this.head == -1)
        {
            return true;
        }
        return false;
    }
}