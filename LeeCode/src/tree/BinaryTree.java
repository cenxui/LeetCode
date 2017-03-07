package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.right.left = new TreeNode(5);

	}

	@Deprecated
	public static int maxPathSum(TreeNode root) {
		return 0;
	}

	@Deprecated
	private static void checkPathSum(TreeNode treeNode, int sum, int max) {
		if (treeNode.left == null && treeNode.right == null) {

		}
	}

	/**
	 * add all node value in tree
	 * 
	 * @param root
	 * @return
	 */

	public static int allPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return root.val;
		}

		if (root.left != null && root.right == null) {
			return root.val + allPathSum(root.left);
		}

		if (root.left == null && root.right != null) {
			return root.val + allPathSum(root.right);
		}

		return root.val + allPathSum(root.left) + allPathSum(root.right);
	}

	/**
	 * Given a binary tree containing digits from 0-9 only, each root-to-leaf
	 * path could represent a number. An example is the root-to-leaf path
	 * 1->2->3 which represents the number 123. Find the total sum of all
	 * root-to-leaf numbers Example The root-to-leaf path 1->2 represents the
	 * number 12. The root-to-leaf path 1->3 represents the number 13. Return
	 * the sum = 12 + 13 = 25.
	 * 
	 * @param root
	 * @return the sum of all root to leaf numbers
	 */

	public static int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return sumNumbers(root, 0);
	}

	/**
	 * 
	 * @param treeNode
	 * @param sum
	 * @return
	 */

	private static int sumNumbers(TreeNode treeNode, int sum) {
		if (treeNode.left != null && treeNode.right != null) {
			return sumNumbers(treeNode.left, sum * 10 + treeNode.val)
					+ sumNumbers(treeNode.right, sum * 10 + treeNode.val);
		}

		if (treeNode.left != null && treeNode.right == null) {
			return sumNumbers(treeNode.left, sum * 10 + treeNode.val);
		}

		if (treeNode.left == null && treeNode.right != null) {
			return sumNumbers(treeNode.right, sum * 10 + treeNode.val);
		}
		return sum * 10 + treeNode.val;
	}

	/**
	 * get all level of tree in the order bottom
	 * 
	 * @param root
	 *            the tree we want to get order
	 * @return the result of the tree count level from bottom
	 */

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new Stack<>();
		if (root == null) {
			return result;
		}

		List<Integer> list = new ArrayList<>();
		list.add(root.val);
		result.add(list);
		addTree(result, root, 1);
		List<List<Integer>> newResult = new ArrayList<>();
		for (int i = result.size() - 1; i >= 0; i--) {
			newResult.add(result.get(i));
		}
		return newResult;
	}

	/**
	 * 
	 * @param root
	 * @return
	 */

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		List<Integer> list = new ArrayList<>();
		list.add(root.val);
		result.add(list);
		addTree(result, root, 1);
		return result;
	}

	/**
	 * the method is used for {@code levelOrder()}
	 * 
	 * @param result
	 *            the list contain all depth of tree value
	 * @param treeNode
	 *            the tree node we want to check
	 * @param depth
	 *            the depth of leaves form the root
	 */

	private static void addTree(List<List<Integer>> result, TreeNode treeNode, int depth) {
		if (treeNode.left == null && treeNode.right == null) {
			return;
		}

		if (treeNode.left != null && treeNode.right == null) {
			if (result.size() > depth) {
				List<Integer> list = result.get(depth);
				list.add(treeNode.left.val);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(treeNode.left.val);
				result.add(list);
			}
			depth++;
			addTree(result, treeNode.left, depth);
			return;
		}

		if (treeNode.left == null && treeNode.right != null) {
			if (result.size() > depth) {
				List<Integer> list = result.get(depth);
				list.add(treeNode.right.val);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(treeNode.right.val);
				result.add(list);
			}
			depth++;
			addTree(result, treeNode.right, depth);
			return;
		}

		if (result.size() > depth) {
			List<Integer> list = result.get(depth);
			list.add(treeNode.left.val);
			list.add(treeNode.right.val);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(treeNode.left.val);
			list.add(treeNode.right.val);
			result.add(list);
		}

		depth++;
		addTree(result, treeNode.left, depth);
		addTree(result, treeNode.right, depth);
		return;
	}

	/**
	 * check the tree is symmetric or not
	 * 
	 * @param root
	 *            the tree node we want to check
	 * @return true if it is symmetric
	 */

	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		return checkSymmetric(root.left, root.right);
	}

	/**
	 * check symmetric
	 * 
	 * @param left
	 *            left tree
	 * @param right
	 *            right tree
	 * @return true if they are symmetric
	 */

	private static boolean checkSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left != null && right == null) {
			return false;
		}
		if (left == null && right != null) {
			return false;
		}
		if (left.val != right.val) {
			return false;
		}
		return checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
	}

	/**
	 * check if tree node has same {@value sum} number
	 * 
	 * @param root
	 *            the tree node we want to check
	 * @param sum
	 *            the value we want to check if the tree node has the path sum
	 * @return tree if the tree node has the path sum
	 */

	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		List<Integer> result = new ArrayList<>();
		addPahSum(root, 0, result);
		return result.contains(sum);
	}

	/**
	 * add all path sum of tree node to list
	 * 
	 * @param treeNode
	 *            the tree node we want to add path sum
	 * @param sum
	 *            the value of all sum
	 * @param list
	 *            the list contain all result
	 */

	private static void addPahSum(TreeNode treeNode, int sum, List<Integer> list) {
		if (treeNode.left == null && treeNode.right == null) {
			list.add(sum + treeNode.val);
			return;
		}

		if (treeNode.left != null && treeNode.right == null) {
			addPahSum(treeNode.left, sum + treeNode.val, list);
			return;
		}

		if (treeNode.left == null && treeNode.right != null) {
			addPahSum(treeNode.right, sum + treeNode.val, list);
			return;
		}
		addPahSum(treeNode.left, sum + treeNode.val, list);
		addPahSum(treeNode.right, sum + treeNode.val, list);
	}

	/**
	 * get the minimum tree node length of the root tree
	 * 
	 * @param root
	 *            the tree node we want to check
	 * @return the minimum depth of the root tree
	 */

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		List<Integer> resultList = new ArrayList<>();
		deep(root, 1, resultList);
		Collections.sort(resultList);
		return resultList.get(0);
	}

	/**
	 * get all the path on binary tree
	 * 
	 * @param root
	 *            the root tree we want to get all paths
	 * @return the list contain all the tree point in string type
	 */
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> resultList = new ArrayList<>();
		if (root == null) {
			return resultList;
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(root.val);
		getbinaryTreePaths(root, stringBuilder, resultList);
		return resultList;
	}

	/**
	 * add all path tree node link to {@value list}
	 * 
	 * @param treeNode
	 *            the tree node we want to add all link
	 * @param stringBuilder
	 *            previous tree node is contained in here before it got the end
	 *            and add to list
	 * @param list
	 *            contain all tree node link
	 */

	private static void getbinaryTreePaths(TreeNode treeNode, StringBuilder stringBuilder, List<String> list) {
		if (treeNode.left == null && treeNode.right == null) {
			list.add(stringBuilder.toString());
			return;
		}
		if (treeNode.left != null && treeNode.right == null) {
			stringBuilder.append("->").append(treeNode.left.val);
			getbinaryTreePaths(treeNode.left, stringBuilder, list);
			return;
		}
		if (treeNode.left == null && treeNode.right != null) {
			stringBuilder.append("->").append(treeNode.right.val);
			getbinaryTreePaths(treeNode.right, stringBuilder, list);
			return;
		}

		StringBuilder stringBuilderLeft = new StringBuilder(stringBuilder.toString());
		stringBuilderLeft.append("->").append(treeNode.left.val);
		getbinaryTreePaths(treeNode.left, stringBuilderLeft, list);

		stringBuilder.append("->").append(treeNode.right.val);
		getbinaryTreePaths(treeNode.right, stringBuilder, list);
		return;
	}

	/**
	 * give a tree and return the maxDepth floor
	 * 
	 * @param root
	 *            the root of tree
	 * @return the floor
	 */
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		ArrayList<Integer> result = new ArrayList<>();
		deep(root, 1, result);
		Collections.sort(result);
		return result.get(result.size() - 1);
	}

	/**
	 * this method returns all the tree node length
	 * 
	 * @param treeNode
	 *            the tree node we want ot check
	 * @param floor
	 *            the begin floor of tree node
	 * @param result
	 *            the list contain all the tree node length
	 */

	public static void deep(TreeNode treeNode, int floor, List<Integer> result) {
		if (treeNode.left == null && treeNode.right == null) {
			result.add(floor);
			return;
		}

		if (treeNode.left == null) {
			deep(treeNode.right, floor + 1, result);
			return;
		}

		if (treeNode.right == null) {
			deep(treeNode.left, floor + 1, result);
			return;
		}
		deep(treeNode.left, floor + 1, result);
		deep(treeNode.right, floor + 1, result);
	}

	public static TreeNode copyTree(TreeNode treeNode) {
		if (treeNode == null) {
			return null;
		}
		TreeNode result = new TreeNode(treeNode.val);
		copyTreeNode(result, treeNode);
		return result;
	}

	private static void copyTreeNode(TreeNode copy, TreeNode treeNode) {
		if (treeNode.left == null && treeNode.right == null) {
			return;
		}

		if (treeNode.left != null && treeNode.right == null) {
			copy.left = new TreeNode(treeNode.left.val);
			copyTreeNode(copy.left, treeNode.left);
			return;
		}

		if (treeNode.left == null && treeNode.right != null) {
			copy.right = new TreeNode(treeNode.right.val);
			copyTreeNode(copy.right, treeNode.right);
			return;
		}

		copy.left = new TreeNode(treeNode.left.val);
		copyTreeNode(copy.left, treeNode.left);

		copy.right = new TreeNode(treeNode.right.val);
		copyTreeNode(copy.right, treeNode.right);
		return;
	}

	/**
	 * 
	 * @param p
	 *            first tree is compared
	 * @param q
	 *            second tree is used to compare
	 * @return true if both the same for all point and false for exiting at
	 *         least one different point or value
	 */
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}

		if (p == null && q != null) {
			return false;
		}

		if (p != null && q == null) {
			return false;
		}

		if (p.val != q.val) {
			return false;
		}

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

	}

	/**
	 * revert tree form left node to right node and right node to left not
	 * recursively
	 * 
	 * @param root
	 *            the tree root node
	 * @return the reverted tree root node
	 */
	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		invert(root);
		return root;
	}

	/**
	 * invert the tree nod that means right to left and left to right
	 * 
	 * @param treeNode
	 *            the tree node we want to invert
	 */

	private static void invert(TreeNode treeNode) {
		if (treeNode.left == null && treeNode.right == null) {
			return;
		}
		if (treeNode.left == null) {
			treeNode.left = treeNode.right;
			treeNode.right = null;
			invert(treeNode.left);
			return;
		}
		if (treeNode.right == null) {
			treeNode.right = treeNode.left;
			treeNode.left = null;
			invert(treeNode.right);
			return;
		}
		TreeNode temp = treeNode.right;
		treeNode.right = treeNode.left;
		treeNode.left = temp;
		invert(treeNode.left);
		invert(treeNode.right);
	}

	/**
	 * preorder method of binary tree
	 * 
	 * @param treeNode
	 */

	public static void preorder(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		System.out.println(treeNode.val);
		preorder(treeNode.left);
		preorder(treeNode.right);
	}

	/**
	 * inorder method of binary tree
	 * 
	 * @param treeNode
	 */

	public static void inorder(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		inorder(treeNode.left);
		System.out.println(treeNode.val);
		inorder(treeNode.right);
	}

	/**
	 * postorder method of binary tree
	 * 
	 * @param treeNode
	 */

	public static void postorder(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		postorder(treeNode.left);
		postorder(treeNode.right);
		System.out.println(treeNode.val);
	}

	/**
	 * TreeNode class is standard tree node type
	 * 
	 * @author xenxui
	 *
	 */

	public static class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}
