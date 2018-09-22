import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(8);
        c.lChild = b;
        c.lChild.lChild = a;
        c.rChild = d;
        c.rChild.lChild = e;
        c.rChild.rChild = f;
        Method.preIterator(c);
        System.out.println();
        Method.midIterator(c);
        System.out.println();
        Method.posIterator(c);
    }
}

class Method {


    public static void preIterator(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while(!s.isEmpty() || p != null) {
            while (p != null) {
                System.out.print(p.val + "       ");
                s.push(p);
                p = p.lChild;
            }
            if(!s.isEmpty()) {
                p = s.pop();
                p = p.rChild;
            }
        }
    }

    public static void midIterator(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (!s.isEmpty() || p != null) {
            while (p!= null) {
                s.push(p);
                p = p.lChild;
            }
            if(!s.isEmpty()) {
                p = s.pop();
                System.out.print(p.val + "       ");
                p = p.rChild;
            }
        }
    }

    public static void posIterator(TreeNode root) {
        Stack<TreeNode> s = new Stack<>(); //用于遍历
        Stack<TreeNode> temp = new Stack<>(); //用于记录
        TreeNode p = root;

        while ( p != null || !s.isEmpty()) {
            while (p != null) {
                s.push(p);
                temp.push(p);
                p = p.lChild;
            }
            if(!s.isEmpty()) {
                p = s.pop();
                p = p.rChild;
            }
        }
        while (!temp.isEmpty()) {
            p = temp.pop();
            System.out.print(p.val + "       ");
        }

    }

}

class TreeNode {

    public int val;

    public TreeNode lChild;

    public TreeNode rChild;

    TreeNode(int v) {
        this.val = v;
    }

}
