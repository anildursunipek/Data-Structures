public class Graph {
    int[][] matrixOfGraph;
    int stage;
    public Graph(int[][] multistageGraph, int stage){
        this.matrixOfGraph = multistageGraph;
        this.stage = stage;
    }

    public void printGraphMatrix(){
        if(this.matrixOfGraph.length == 0){
            System.out.println("[Warning] Graph is empty!!!");
            return;
        }
        System.out.println("[INFO] Matrix of Graph is printing...");
        for(int i=0; i < this.matrixOfGraph.length; i++){
            System.out.print("Vertex " + i + " --> ");
            for(int j=0; j < this.matrixOfGraph.length; j++){
                System.out.print(this.matrixOfGraph[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public void shortestPath(){
        // Veriables defining here.
        int n = this.matrixOfGraph.length;
        Integer min;
        int[] cost, d;
        cost = new int[n];
        d = new int[n];

        cost[n-1] = 0;
        d[n-1] = -1;

        for(int i=n-2; i >= 0; i--){
            min = Integer.MAX_VALUE;
            for(int j=i+1; j < n; j++){
                if(this.matrixOfGraph[i][j] != 0 && this.matrixOfGraph[i][j] + cost[j] < min){
                    min = this.matrixOfGraph[i][j] + cost[j];
                    d[i] = j;
                }
            }
            cost[i] = min;
            System.out.println("Vertex --> " + i);
            printArray("Cost", cost);
            printArray("Vertex", d);
        }
        printShortestPath(d);
    }

    private void printArray(String nameOfTheArray, int[] costArray){
        System.out.println(nameOfTheArray + " Array printing");
        System.out.print("| ");
        for(int i=0; i < costArray.length; i++){
            System.out.print(costArray[i] + " | ");
        }
        System.out.println();
    }

    public void printShortestPath(int[] d){
        int[] path = new int[this.stage];
        int nextStage;
        int currentStage = 0;
        path[0] = currentStage;
        for(int i=1; i < this.stage; i++){
            nextStage = d[currentStage];
            path[i] = nextStage;
            currentStage = nextStage;
        }
        printArray("Path", path);
    }
}
