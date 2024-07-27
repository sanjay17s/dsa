import java.util.Stack;

public class Traversal {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data ,Node left,Node right) {
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        public Pair(Node node,int state) {
            this.node=node;
            this.state=state;
        }
    }


    public static void main(String[] args) {

        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Node root = new Node(arr[0],null,null);

        Pair rootPair = new Pair(root,1);
        Stack<Pair> st = new Stack<>();
        st.push(rootPair);
        int i=0;
        while(st.size() >0){
            Pair top =st.peek();
            if(top.state ==1){
                i++;
                if(arr[i] != null) {
                    top.node.left = new Node(arr[i],null,null);
                    Pair lp = new Pair(top.node.left,1);
                    st.push(lp);
                }
                top.state++;

            } else if (top.state == 2 ) {
                i++;
                if(arr[i] != null) {
                    top.node.right = new Node(arr[i],null,null);
                    Pair rp = new Pair(top.node.right,1);
                    st.push(rp);
                }
                top.state++;
            }
            else{
                st.pop();
            }
        }
        traversalPost(root);
    }

    public static void traversalPre(Node root) {
        if(root == null) return;
        System.out.println(root.data);
        traversalPre(root.left);
        traversalPre(root.right);
    }

    public static void traversalIn(Node root) {
        if(root == null) return;
        traversalIn(root.left);
        System.out.println(root.data);
        traversalIn(root.right);
    }

    public static void traversalPost(Node root) {
        if(root == null) return;
        traversalPost(root.left);
        traversalPost(root.right);
        System.out.println(root.data);

    }


}
