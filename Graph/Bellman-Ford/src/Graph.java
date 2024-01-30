// A class to represent a connected, directed and weighted
public class Graph {
    class Edge{
        int src, dest, weight;
        public Edge(){
            src = dest = weight = 0;
        }
    };
    int V, E;
    Edge edge[];

    public Graph(int v, int e){
        this.V = v;
        this.E = e;
        this.edge = new Edge[e];
        for(int i=0; i < e; i++){
            edge[i] = new Edge();
        }
    }

    // The main function that finds shortest distances from src to all other vertices using Bellman-Ford
    // algorithm. The function also detects negative weight cycle

    public void bellmanFord(int src){
        int INF = 99999;
        int dist[] = new int[this.V];

        // Step 1 -> initialize distances
        for(int i=1; i < V; i++)
            dist[i] = INF;
        dist[src] = 0;

        // Step 2 -> relax all edges |V| - 1 time
        for(int i=0; i < this.V - 1; i++){
            for(int j=0; j< this.E; j++){
                int u = this.edge[j].src;
                int v = this.edge[j].dest;
                int weight = this.edge[j].weight;
                if(dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        // Step 3: check for negative-weight cycles. The above step guarantees shortest distances if graph
        // doesn't contain negative weight cycle. If we get a shorter path, then there is a cycle.

        for (int j = 0; j < E; ++j) {
            int u = this.edge[j].src;
            int v = this.edge[j].dest;
            int weight = this.edge[j].weight;
            if (dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        this.printArr(dist, V);
    }

    // A utility function used to print the solution
    void printArr(int dist[], int V)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }
}
