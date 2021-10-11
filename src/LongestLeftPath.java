import java.util.ArrayList;

// Class to create and populate node
class Node {
    int data;
    Node left, right;

    // Parameterized constructor to create Node when creating object with given
    // argument
    public Node(int intValue) {
        data = intValue;
        left = null;
        right = null;
    }

}

public class LongestLeftPath {

    // Function to find longest path
    static ArrayList<Integer> findLongestPath(Node root) {

        // If node given in argument is null, max height is 0. Tree does not exist
        if (root == null) {
            return new ArrayList<Integer>();
        }

        else {
            ArrayList<Integer> rightPath = findLongestPath(root.right);
            ArrayList<Integer> leftPath = findLongestPath(root.right);

            // Compare path sizes (left and right) and add depending on which side our
            // pointer goes
            if (rightPath.size() < leftPath.size()) {
                leftPath.add(root.data);
            }

            else {
                rightPath.add(root.data);
            }

            return (leftPath.size() > rightPath.size() ? leftPath : rightPath);

        }

    }

    public static void main(String[] args) {

        // Hardcode nodes
        Node node1 = new Node(100);
        Node node2 = new Node(20);
        Node node3 = new Node(130);
        Node node4 = new Node(10);
        Node node5 = new Node(50);
        Node node6 = new Node(110);
        Node node7 = new Node(140);
        Node node8 = new Node(5);

        // Create binary tree (this is not a BST)
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;

        ArrayList<Integer> longestPath = findLongestPath(node1);

        // Consider if tree is empty
        if (longestPath.size() == 0) {
            System.out.println("The tree is empty");
        } else {
            System.out.print("The longest path has the following nodes: ");
            for (int i : longestPath) {
                System.out.println(i);
            }
        }
    }
}
