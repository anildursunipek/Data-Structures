public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        // create() Test Codes
        tree.create(50);
        tree.create(70);
        tree.create(30);
        tree.create(120);
        tree.create(220);
        tree.create(35);
        tree.create(99);
        tree.create(45);
        tree.create(76);
        tree.create(20);

        System.out.println("\n----------------find() Test Codes");
        System.out.println("find(120): " + tree.find(120));
        System.out.println("find(30): " + tree.find(30));
        System.out.println("find(70): " + tree.find(70));
        System.out.println("find(10): " + tree.find(10));

        System.out.println("\n----------------findMinNode() Test Codes");
        System.out.println(tree.findMinNode());

        System.out.println("\n----------------findMaxNode() Test Codes");
        System.out.println(tree.findMaxNode());

        System.out.println("\n----------------printInOrder() Test Codes");
        tree.printInOrder();
    }
}