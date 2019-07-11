package app;

public class BSTImplementation {

    public static void main(String[] args) {
        BSTImplementation b = new BSTImplementation();
        Node root = new Node(1);
        root.right = new Node(2);
        b.delete(root, 1);
        System.out.println("done");
    }

    Node root;

    public BSTImplementation() {
        root = null;
    }

    public void insert(int element) {
        insert(root, element);
    }

    private void insert(Node root, int element){
        if (root == null){
            root = new Node(element);
        }else{
            if (element <= root.value){
                if(root.left == null){
                    root.left = new Node(element);
                }else{
                    insert(root.left, element);
                }
                
            }else{
                if(root.right == null){
                    root.right = new Node(element);
                }else{
                    insert(root.right, element);
                }
            }
        }
    }

    public void delete(int element) {
        delete(root, element);
    }

    private Node delete(Node root, int element) {
        if (root == null) {
            return root;
        } else {
            if (root.value < element) {
                root.right = delete(root.right, element);
            } else if (root.value > element) {
                root.left = delete(root.left, element);
            } else {
                if (root.left == null) {
                    root = root.right;
                } else if (root.right == null) {
                    root = root.left;
                    
                }else{
                    root.value = minValue(root.right);
                    root.right = delete(root.right, root.value);
                }

                

            }
            return root;
        }
        
    }

    private int minValue(Node root) {
        int res = root.value;
        while (root.left != null) {
            root = root.left;
            res = root.value;
        }
        return res;
    }

}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}