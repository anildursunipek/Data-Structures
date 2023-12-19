import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCode {
    public static void main(String[] args) {
        String text = "abracadabra";

        HuffmanCode huffmanCode = new HuffmanCode();
        huffmanCode.createHuffmanTree(text);
    }

    public void createHuffmanTree(String text){
        if(text == null || text.length() == 0){
            return;
        }
        Map<Character, Integer> freq = new HashMap<Character, Integer>();

        for(char c: text.toCharArray()){
            freq.put(c, freq.getOrDefault(c,0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(I -> I.freq));

        for(var entry: freq.entrySet()){
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }
        while(pq.size() != 1){
            Node left = pq.poll();
            Node right = pq.poll();
            int sum = left.freq + right.freq;

            pq.add(new Node(null, sum, left, right));
        }
        Node root = pq.peek();

        Map<Character, String> huffmanCode = new HashMap<>();
        encodeData(root, "", huffmanCode);

        System.out.println("Huffman Codes of the characters are: " + huffmanCode);
        System.out.println("Initial string is: \"" + text + "\"");

        StringBuilder sb = new StringBuilder();

        for(char c: text.toCharArray()){
            sb.append(huffmanCode.get(c));
        }

        System.out.println("The encoded string is: " + sb);
        System.out.print("The decoded string is:");

        if(isLeafNode(root)){
            //special case: For input like a, aa, aaa, etc.
            while(root.freq > 0){
                System.out.print(root.ch);
                --root.freq;
            }
        }else{
            int index = -1;
            while(index < sb.length() -1 ){
                index = decodeData(root, index, sb);
            }
        }

    }

    public void encodeData(Node root, String str, Map<Character, String> huffmanCode){
        if(root == null){
            return;
        }
        if(isLeafNode(root)){
            huffmanCode.put(root.ch, str.length() > 0 ? str : "1");
            //System.out.println("Char: " + root.ch + " Code: " + str);
        }
        encodeData(root.left, str + '0', huffmanCode);
        encodeData(root.right, str + '1', huffmanCode);
    }

    public int decodeData(Node root, int index, StringBuilder sb){
        if(root == null)
            return index;
        if(isLeafNode(root)){
            System.out.print(root.ch);
            return index;
        }
        index++;
        root = (sb.charAt(index) == '0') ? root.left : root.right;
        index = decodeData(root, index, sb);
        return index;
    }

    public boolean isLeafNode(Node node){
        return node.right == null && node.right == null;
    }
}
