package tree;

public class CountTreeNode {
    public int countTreeNode(TreeNode root) {
        if (root == null) return 0;

        return 1 + countTreeNode(root.left) + countTreeNode(root.right);

    }

    public static void main(String[] args) {
        CountTreeNode countTreeNode = new CountTreeNode();

        TreeNode treeNode = new TreeNode();
        treeNode.left = new TreeNode();
        treeNode.right = new TreeNode();

        System.out.println(countTreeNode.countTreeNode(treeNode));

    }

}
