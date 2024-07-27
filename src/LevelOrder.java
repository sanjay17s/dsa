import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class LevelOrder {

    public static void main(String[] args) {
        Node root = Traversal.constructor();
        levelOrder(root);
    }

    public static void levelOrder(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while(queue.size()>0){
            int cnt = queue.size();
            for(int i=0;i< cnt;i++) {
                node = queue.remove();
                System.out.print(node.data+" ");
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            System.out.println();
        }
    }
}
