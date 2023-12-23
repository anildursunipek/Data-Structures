import java.util.*;

public class PrimAlgorithm {
    static class Edge implements Comparable<Edge> {
        int src, dst, weight;

        public Edge(int src, int dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    static class Graph {
        int V;
        List<List<Edge>> adjList;

        public Graph(int V) {
            // Initialize the graph
            this.V = V;
            adjList = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int src, int dst, int weight){
            Edge edge = new Edge(src, dst, weight);
            adjList.get(src).add((edge));
            edge = new Edge(dst, src, weight);
            adjList.get(dst).add(edge);
        }

        public void primMST(){
            boolean[] visited = new boolean[V];
            PriorityQueue<Edge> minHeap = new PriorityQueue<>();
            List<Edge> result = new ArrayList<>();

            int startNode = 0;
            visited[startNode] = true;
            minHeap.addAll(this.adjList.get(startNode));

            while(!minHeap.isEmpty()){
                Edge edge = minHeap.poll();
                System.out.println("Selected edge src: " + edge.src + " dst: " + edge.dst + " weight: " + edge.weight);
                int currentVertex = edge.dst;

                if(!visited[currentVertex]){
                    result.add(edge);
                    System.out.println("Added edge src: " + edge.src + " dst: " + edge.dst + " weight: " + edge.weight);
                    visited[currentVertex] = true;
                    minHeap.addAll(adjList.get(currentVertex));
                }
            }

            System.out.println("Minimum Spanning Tree:");
            for (Edge edge : result) {
                System.out.println(edge.src + " - " + edge.dst + " : " + edge.weight);
            }
        }
    }
    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(V);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 1);
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 3);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 6);

        graph.primMST();
    }
}
