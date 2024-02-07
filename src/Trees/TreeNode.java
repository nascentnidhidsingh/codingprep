package Trees;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;

    public TreeNode(TreeNode left, TreeNode right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public TreeNode(int data) {
        this.data = data;
    }
}
