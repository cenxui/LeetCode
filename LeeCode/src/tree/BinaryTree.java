package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.right.left = new TreeNode(5);
		TreeNode treeNode2 = copyTree(treeNode);
		
		System.out.println(isSameTree(treeNode, treeNode2));
		
		System.out.println(maxDepth(treeNode));
	
		
	}
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        return null;
    }
	
	/**
	 * check the tree is symmetric or not
	 * @param root the tree node we want to check
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
	 * @param left left tree
	 * @param right right tree
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
	 * @param root the tree node we want to check
	 * @param sum the value we want to check if the tree node has the path sum 
	 * @return tree if the tree node has the path sum
	 */
	
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		List<Integer> result = new ArrayList<>();
		addPahSum(root, 0 , result);
		return result.contains(sum);
	}
	
	/**
	 * add all path sum of tree node to list
	 * @param treeNode the tree node we want to add path sum
	 * @param sum the value of all sum
	 * @param list the list contain all result
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
	 * @param root the tree node we want to check  
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
	 * @param root the root tree we want to get all paths
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
	 * @param treeNode the tree node we want to add all link
	 * @param stringBuilder previous tree node is contained in here before it got the end and add to list 
	 * @param list contain all tree node link
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
	 * @param root the root of tree
	 * @return the floor
	 */
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		ArrayList<Integer> result = new ArrayList<>();
		deep(root, 1, result);
		Collections.sort(result);
        return result.get(result.size()-1);
    }
	
	/**
	 * this method returns all the tree node length 
	 * @param treeNode the tree node we want ot check
	 * @param floor the begin floor of tree node
	 * @param result the list contain all the tree node length
	 */
	
	public static void deep(TreeNode treeNode ,int floor ,List<Integer> result) {
		if (treeNode.left == null && treeNode.right == null) {
			result.add(floor);
			return;
		}
		
		if (treeNode.left == null) {
			deep(treeNode.right, floor + 1, result);
			return;
		}
		
		if (treeNode.right == null) {
			deep(treeNode.left, floor+1, result);
			return;
		}
		deep(treeNode.left, floor+1, result);
		deep(treeNode.right, floor+1, result);
	}
	
	public static TreeNode copyTree(TreeNode treeNode) {
		if (treeNode == null) {
			return null;
		}
		TreeNode result  = new TreeNode(treeNode.val);
		copyTreeNode(result, treeNode);
		return result;
	}
	
	private static void copyTreeNode(TreeNode copy, TreeNode treeNode) {
		if (treeNode.left == null && treeNode.right == null ) {
			return;
		}
		
		if (treeNode.left != null && treeNode.right == null) {
			copy.left = new TreeNode(treeNode.left.val); 
			copyTreeNode(copy.left, treeNode.left );
			return;
		}
		
		if (treeNode.left == null && treeNode.right != null) {
			copy.right = new TreeNode(treeNode.right.val);
			copyTreeNode(copy.right, treeNode.right);
			return;
		}
		 
		copy.left = new TreeNode(treeNode.left.val);
		copyTreeNode(copy.left, treeNode.left );

		copy.right = new TreeNode(treeNode.right.val);
		copyTreeNode(copy.right, treeNode.right);
		return;
	}
	
	/**
	 * 
	 * @param p first tree is compared
	 * @param q second tree is used to compare
	 * @return true if both the same for all point and false for exiting at least one different point or value
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
		
		return isSameTree(p.left, q.left)&& isSameTree(p.right, q.right);
		
    }
	
	/**
	 * revert tree form left node to right node and right node to left not recursively
	 * @param root the tree root node
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
	 * @param treeNode the tree node we want to invert
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
	 * TreeNode class is standard tree node type
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
