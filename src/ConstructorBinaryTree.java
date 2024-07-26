import java.util.Stack;

public class ConstructorBinaryTree {
    public static class Node {
        int data ;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }

 public static class Pair {
     Node node;
     int state;

     Pair(Node node, int state) {
         this.node=node;
         this.state=state;
     }

    }
    public static void main(String[] args) {
        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Node root = new Node(arr[0],null,null);
        Pair rootPair = new Pair(root,1);
        Stack<Pair> stack = new Stack<>();
        stack.push(rootPair);
        int i =0;
        while(stack.size() > 0) {
            Pair top = stack.peek();
            if(top.state == 1) {
                i++;
                if(arr[i] != null) {
                    top.node.left = new Node(arr[i],null,null);
                    Pair lp = new Pair(top.node.left,1);
                    stack.push(lp);
                }
                top.state++;

            } else if (top.state == 2) {
                i++;
                if(arr[i] != null) {
                    top.node.right = new Node(arr[i],null,null);
                    Pair rp = new Pair(top.node.right,1);
                    stack.push(rp);
                }
                top.state++;
            } else {
                stack.pop();
            }

        }

        display(root);


    }

    public static void display(Node node ) {
        // self work
        if(node == null) return ;
        String s="";
        s+=  node.left == null ? "." : node.left.data+"";
        s+=" <- " + node.data + " -> ";
        s+= node.right == null ? "." : node.right.data+"";
        System.out.println(s);
        display(node.left);
        display(node.right);
    }
}
