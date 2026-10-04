import javax.swing.tree.TreeNode;

public class Solution98 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        TreeNode temp = root;

        while(temp != null) {
            if(temp.val>p.val && temp.val>q.val) {
                temp = temp.left;
            } else if(temp.val<p.val && temp.val<q.val) {
                temp = temp.right;
            }else {
                break;
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        Solution98 solution = new Solution98();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.left.right; // Node with value 4

        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lca.val); // Output: 2
    }
}
