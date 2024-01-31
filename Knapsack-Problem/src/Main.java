public class Main {
    public static void main(String[] args) {
        // input arrays
        int values[] = new int[] { 100, 60, 120 };
        int weight[] = new int[] { 20, 10, 30 };
        // capacity of the knapsack
        int C = 50;
        // length of the input arrays
        int l = values.length;
        // instantiating the class KnapsackExample
        Knapsack knapObj = new Knapsack();
        // invoking the method maxValueKnapsack()
        int maxVal = knapObj.maxValueKnapsack(C, weight, values, l);
        // displaying the final result
        System.out.println("The maximum value is: " + maxVal);
    }
}