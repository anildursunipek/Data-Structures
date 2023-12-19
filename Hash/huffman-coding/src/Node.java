public class Node {
    Character ch; // Storing character
    Integer freq; // Storing frequency of character in string

    Node left = null;
    Node right = null;

    public Node(Character ch, Integer freq){
        this.ch = ch;
        this.freq = freq;
    }

    public Node(Character ch, Integer freq, Node left, Node right) {
        this(ch, freq);
        this.left = left;
        this.right = right;
    }
}
