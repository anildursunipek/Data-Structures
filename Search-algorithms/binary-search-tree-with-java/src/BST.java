public class BST {
    Node root; // first node of the tree

    public BST(){
        this.root = null;
    }

    public void create(int data){
        Node newNode = new Node(data);
        if(this.root == null){
            this.root = newNode;
            return;
        }else{
            this.insertNode(this.root, newNode);
        }
    }

    public void insertNode(Node currentNode, Node newNode){
        if(currentNode.data > newNode.data){
            if(currentNode.left == null){
                currentNode.left = newNode;
            }else{
                insertNode(currentNode.left, newNode);
            }
        }else{
            if(currentNode.right == null){
                currentNode.right = newNode;
            }else{
                insertNode(currentNode.right, newNode);
            }
        }
    }

    public boolean find(int data){
        if(this.root == null){
            System.out.println("This tree is empty. There is no Root.");
            return true;
        }else{
            return this.findNode(this.root, data);
        }
    }

    private boolean findNode(Node currentNode, int data){
        if(currentNode.data == data){
            return true;
        }
        if(currentNode.data > data){
            if(currentNode.left == null){
                return false;
            }else{
                return this.findNode(currentNode.left, data);
            }
        }else{
            if(currentNode.right == null){
                return false;
            }else{
                return this.findNode(currentNode.right, data);
            }
        }
    }

    public int findMinNode(){
        Node currentNode = this.root;
        while(currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.data;
    }

    public int findMaxNode(){
        Node currentNode = this.root;
        while(currentNode.right != null){
            currentNode = currentNode.right;
        }
        return currentNode.data;
    }

    public void printInOrder(){
        if(this.root == null){
            System.out.println("Tree is empty. There is no Root.");
            return;
        }
        Node currentNode = this.root;
        print(currentNode);
    }
    private void print(Node currentNode){
        if(currentNode.left != null){
            print(currentNode.left);
        }

        System.out.print(currentNode.data + " ");

        if(currentNode.right != null){
            print(currentNode.right);
        }
    }
}
