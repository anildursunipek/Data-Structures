// Java program for Floyd Warshall All Pairs Shortest Path
public class FloydWarshall {
    final static Integer INF = 9999;

    public static void allPairsShortestPath(int[][] graph){
        int V = graph.length;
        int i,j,k;
        // k is intermediate
        int result;

        printSolution(graph);


        for(k = 0; k < V; k++){
            for(i = 0; i < V; i++){
                for(j = 0; j < V; j++){
                    result = graph[i][k] + graph[k][j];
                    if(result < graph[i][j]){
                        graph[i][j] = result;
                    }
                }
            }
        }
        printSolution(graph);
    }

    private static void printSolution(int[][] graph)
    {
        int V = graph.length;
        System.out.println("The following matrix shows the shortest distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (graph[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(graph[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
