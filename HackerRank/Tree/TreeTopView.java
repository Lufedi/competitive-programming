import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    static class Pair {
        Node node;
        int diff;

        public Pair(Node node, int diff) {
            this.node = node;
            this.diff = diff;
        }
    }

    public static void topView(Node root) {

        LinkedList<Integer> response = new LinkedList<>();
        if (root == null) {
            System.out.println("");
        }

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.addLast(new Pair(root, 0));
        response.add(root.data);
        int left = 0;
        int right = 0;
        while (!queue.isEmpty()) {
            Pair top = queue.removeFirst();
            Node node = top.node;

            if (top.diff < left) {
                response.addFirst(node.data);
                left = top.diff;
            }
            if (top.diff > right) {
                response.addLast(node.data);
                right = top.diff;
            }

            if (node.left != null) {
                queue.addLast(new Pair(node.left, top.diff - 1));
            }
            if (node.right != null) {
                queue.addLast(new Pair(node.right, top.diff + 1));
            }
        }

        /*
         * return response.stream() .map(n -> n.toString())
         * .collect(Collectors.joining(","));
         */
        // System.out.println(response.stream().map(n ->
        // n.toString()).collect(Collectors.joining(" ")));

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (Integer value : response) {
            sb.append(value.toString());
            if (index != response.size() - 1) {
                sb.append(" ");
            }
            index++;
        }
        System.out.println(sb.toString());
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}