import java.util.Scanner;

public class CreateTree {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Node root = createTree();

        System.out.println("Height of the tree is :" + heightOfTree(root));
        System.out.println("size of a binary tree is "+sizeOfTree(root));
    }

    public static Node createTree() {
        /*
        * ill ask user for data ,if user enters -1 i.e, they dont want a node so return null
        * in other cases: root -----> data (root will point to this Node with data)
        * node needs a left and right
        * so another createTree call which will fetch me root.left iiy for root.right
        * */
        Node root = null;
        System.out.print("Enter data for the node: ");
        int data = sc.nextInt();
        if(data == -1) return null;
        root = new Node(data);
        System.out.println("\tEnter left for "+data);
        root.left=createTree();
        System.out.println("Enter right for "+data);
        root.right=createTree();
        return root;
    }

    public static int heightOfTree(Node root) {
        if(root == null) return 0;
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        return Math.max(lh,rh) + 1;
    }

    public static int sizeOfTree(Node root) {
        if(root == null) return 0;
        int lh = sizeOfTree(root.left);
        int rh = sizeOfTree(root.right);
        return lh + rh + 1;

    }


}
