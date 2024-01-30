public class Main {
    public static void main(String[] args) {
        Integer INF = 9999;
        int[][] graph ={{ 0, 3, INF, 7 },
                        { 8, 0, 2, INF },
                        { 5, INF, 0, 1 },
                        { 2, INF, INF, 0 } };
        FloydWarshall.allPairsShortestPath(graph);
        /*
        * Output
        * The following matrix shows the shortest distances between every pair of vertices
          [ 0   3   5   6
            5   0   2   3
            3   6   0   1
            2   5   7   0 ]
        * */
    }
}