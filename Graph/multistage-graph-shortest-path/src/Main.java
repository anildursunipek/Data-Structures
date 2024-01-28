public class Main {
    public static void main(String[] args) {
        int[][] matrixOfGraph = {{0,2,1,3,0,0,0,0},
                                 {0,0,0,0,2,3,0,0},
                                 {0,0,0,0,6,7,0,0},
                                 {0,0,0,0,6,8,9,0},
                                 {0,0,0,0,0,0,0,6},
                                 {0,0,0,0,0,0,0,4},
                                 {0,0,0,0,0,0,0,5},
                                 {0,0,0,0,0,0,0,0}};
        int stage = 4;
        Graph multiStageGraph = new Graph(matrixOfGraph, stage);
        multiStageGraph.printGraphMatrix();
        multiStageGraph.shortestPath();
    }
}