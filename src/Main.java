public class Main {

    public static class Node {
        int data ;
        Node left;
        Node right;

        public Node(int data,Node left,Node right) {
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    public static void main(String[] args) {
            Node node = new Node(1,null,null);
    }
}