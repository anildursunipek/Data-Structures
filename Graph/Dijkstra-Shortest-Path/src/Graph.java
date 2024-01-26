import java.util.*;

public class Graph {
    private int[] dist;
    private Set<Integer> settled;
    private PriorityQueue<Node> pq;
    // number of vertices
    private int V;
    List<List<Node>> adjacentList;

    public Graph(int V){
        this.V = V;
        this.dist = new int[V];
        this.settled = new HashSet<Integer>();
        this.pq = new PriorityQueue<Node>(V, new Node());
    }

    public void dijkstra(List<List<Node>> adjacentList, int src){
        this.adjacentList = adjacentList;

        for(int i=0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        // add source node to priority queue
        pq.add(new Node(src, 0));
        // Distance to the source is 0
        dist[src] = 0;

        while(settled.size() != V){
            if(pq.isEmpty())
                return;

            System.out.println(settled);
            pq.forEach((t) -> System.out.println(t.node));
            int u = pq.remove().node;
            System.out.println("U -->" + u );
            System.out.println("-----------");

            if(settled.contains(u))
                continue;

            settled.add(u);
            e_Neighbours(u);
        }
    }
    private void e_Neighbours(int u){
        int edgeDistance = -1;
        int newDistance = -1;

        for(int i=0; i<this.adjacentList.get(u).size(); i++){
            Node v = this.adjacentList.get(u).get(i);

            if(!settled.contains(v.node)){
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                if(newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                pq.add(new Node(v.node, dist[v.node]));
            }
        }
    }

    public static void main(String args[])
    {
        // First example
        // int V = 5;
        //int source = 0;

        // Second Example
        int V = 6;
        int source = 0;

        // Adjacency list representation of the
        // connected edges by declaring List class object
        // Declaring object of type List<Node>
        List<List<Node> > adj = new ArrayList<List<Node> >();

        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        // Inputs for the GFG(dpq) graph

        // First example
      /*adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));

        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));*/

        // Second example
        adj.get(0).add(new Node(1, 50));
        adj.get(0).add(new Node(2, 45));
        adj.get(0).add(new Node(3, 10));

        adj.get(1).add(new Node(2, 10));
        adj.get(1).add(new Node(3, 15));

        adj.get(2).add(new Node(4, 30));

        adj.get(3).add(new Node(0, 10));
        adj.get(3).add(new Node(4, 15));

        adj.get(4).add(new Node(1, 20));
        adj.get(4).add(new Node(2, 35));

        adj.get(5).add(new Node(4, 3));

        // Calculating the single source shortest path
        Graph dpq = new Graph(V);
        dpq.dijkstra(adj, source);

        // Printing the shortest path to all the nodes
        // from the source node
        System.out.println("The shorted path from node :");

        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " to " + i + " is "
                    + dpq.dist[i]);
    }
}
