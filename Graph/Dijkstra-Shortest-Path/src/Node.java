import java.util.Comparator;

public class Node implements Comparator<Node> {
    public int node;
    public int cost;

    public Node() {
    }

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node o1, Node o2) {
        // This implementation is suitable for sorting nodes based on their cost attribute in ascending order.
        if (o1.cost < o2.cost) {
            return -1;
        }
        if (o1.cost > o2.cost) {
            return 1;
        }
        return 0;
    }
}
