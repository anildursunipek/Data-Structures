using static System.Math;

namespace tree
{
    class program
    {
        public static void Main(String[] args)
        {
            /*
             Binary Tree
                Methods
                -------
                * Add
                * Search
                * Preorder
                * Inorder
                * Postorder
                * Search
             */
            Console.WriteLine("Insertion Order");
            /*
            Insertion Order
            69 | 47 | 58 | 16 | 41 | 2 | 66 | 76 | 36 | 54 | 88 | 25 | 27 | 28 | 57 | 62 | 90 | 48 |
            84 | 10 | 50 | 16 | 82 | 24 | 81 | 75 | 17 | 51 | 40 | 57 | 26 |
            */
            BinaryTree tree = createRandomTree(depth: 5);
            Console.WriteLine("\nSHOW PREORDER -> NLR");
            tree.preorder(tree.root);
            /*
             SHOW PREORDER -> NLR
             69 | 47 | 16 | 2 | 10 | 41 | 36 | 25 | 16 | 24 | 17 | 27 | 26 | 28 | 40 | 58 | 54 | 48 | 
             50 | 51 | 57 | 57 | 66 | 62 | 76 | 75 | 88 | 84 | 82 | 81 | 90 |
             */
            Console.WriteLine("\nSHOW INORDER -> LNR");
            tree.inorder(tree.root);
            /*
             SHOW INORDER -> LNR
             2 | 10 | 16 | 16 | 17 | 24 | 25 | 26 | 27 | 28 | 36 | 40 | 41 | 47 | 48 | 50 | 51 | 54 | 
             57 | 57 | 58 | 62 | 66 | 69 | 75 | 76 | 81 | 82 | 84 | 88 | 90 |
             */
            Console.WriteLine("\nSHOW POSTORDER -> LRN");
            tree.postorder(tree.root);
            /*
             SHOW POSTORDER -> LRN
             10 | 2 | 17 | 24 | 16 | 26 | 28 | 27 | 25 | 40 | 36 | 41 | 16 | 51 | 50 | 48 | 57 | 57 | 
             54 | 62 | 66 | 58 | 47 | 75 | 81 | 82 | 84 | 90 | 88 | 76 | 69 |
             */
        }

        public static BinaryTree createRandomTree(int depth)
        {
            /* 
             This function creates a random binary tree with a given depth.
             Node Count = 2 * Depth - 1
             Example
             -------
             Depth 5; 2 * 5 - 1 = 31
             Total creating node count = 31

             Node.key is between 0 to 99
             */
            BinaryTree tree = new BinaryTree();
            Random random = new Random();
            int nodeCount = (int)(Pow(2, depth) - 1);
            int key;

            for(int i=0; i< nodeCount; i++)
            {
                key = random.Next(100);
                Console.Write(key + " | ");
                tree.add(key);
            }
            return tree;
        }
    }

    class Node
    {
        public int key;
        public Node left;
        public Node right;
        public Node(int key)
        {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    class BinaryTree
    {
        public Node root;
        public BinaryTree()
        {
            this.root = null;
        }

        public void add(int key)
        {
            Node newNode = new Node(key);
            Node temp = this.root;
            Node temp2 = null;

            while(temp != null)
            {
                temp2 = temp;
                if(temp.key > key) {
                    temp = temp.left;
                }
                else
                {
                    temp = temp.right;
                }
            }
            
            if(temp2 == null)
            {
                this.root = newNode;
            }
            else
            {
                if (temp2.key > key)
                    temp2.left = newNode;
                else
                    temp2.right = newNode;
            }
        }

        public bool search(int data, Node node)
        {
            if(node == null)
            {
                return false;
            }

            if(node.key == data)
            {
                return true;
            }
            else
            {
                if (node.key > data)
                    return search(data, node.left);
                else
                    return search(data, node.right);
            }
        }


        public void inorder(Node node)
        {
            // inorder -> LNR
            if (node == null)
                return;

            if (node.left != null)
                inorder(node.left);

            Console.Write(node.key + " | ");

            if (node.right != null)
                inorder(node.right);
        }

        public void preorder(Node node)
        {
            // preorder -> NLR
            if (node == null)
                return;

            Console.Write(node.key + " | ");

            if (node.left != null)
                preorder(node.left);

            if (node.right != null)
                preorder(node.right);
        }

        public void postorder(Node node)
        {
            // postorder -> LRN
            if (node == null)
                return;

            if (node.left != null)
                postorder(node.left);

            if (node.right != null)
                postorder(node.right);

            Console.Write(node.key + " | ");
        }

    }
}