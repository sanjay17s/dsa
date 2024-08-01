import java.util.*;

public class LeftView {
    public static void main(String[] args) {
        Node root = CreateTree.createTree();
       // System.out.println((leftView(root)));
        System.out.println(rightView(root));

    }

    public static List<Integer> leftView(Node root) {
        Queue<Node> q = new ArrayDeque<>();
       // LinkedList<Node> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        q.add(root);

        while(q.size() > 0){
            int cnt = q.size();
            Node top = q.peek();
            l.add(top.data);
            for(int i=0;i<cnt;i++) {
                Node rn = q.remove();
                if(rn.left != null) q.add(rn.left);
                if(rn.right != null) q.add(rn.right);
            }
        }
        return  l;
    }

    public static List<Integer> rightView(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        List<Integer> l = new ArrayList<>();
        q.add(root);

        while(q.size() > 0){
            int cnt = q.size();
            Node top = q.peek();
            l.add(top.data);
            for(int i=0;i<cnt;i++) {
                Node rn = q.remove();
                if(rn.right != null) q.add(rn.right);
                if(rn.left != null) q.add(rn.left);
            }
        }
        return  l;
    }


}
