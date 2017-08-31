package tree;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;

        return isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);

    }

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

    }
}
