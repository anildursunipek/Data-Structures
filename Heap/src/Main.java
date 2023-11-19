public class Main {
    public static void main(String[] args) {
        Heap<Integer> maximumHeap = new MaximumHeap<>();
        maximumHeap.insert(50).insert(30).insert(100).insert(20).insert(15).insert(35).insert(75).insert(200);
        maximumHeap.print(); // 200 -> 100 -> 75 -> 30 -> 15 -> 35 -> 50 -> 20
        System.out.println("Maximum element -> " + maximumHeap.getRoot()); // Maximum element -> 200
        maximumHeap.print(); // 100 -> 30 -> 75 -> 20 -> 15 -> 35 -> 50
        maximumHeap.sort();
        maximumHeap.print(); // 100 -> 75 -> 50 -> 35 -> 30 -> 20 -> 15
    }
}