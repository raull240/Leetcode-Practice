package thirtyDaysofCode;

/*
 * Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
*/
public class BinaryTreeMaximumPathSum {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		int result = Integer.MIN_VALUE;

		public int maxPathSum_Util(TreeNode root) {
			if (root == null)
				return 0;
			int left = maxPathSum_Util(root.left);
			int right = maxPathSum_Util(root.right);

			int max_straight = Math.max(Math.max(left, right) + root.val, root.val);
			int max_caseVal = Math.max(max_straight, left + right + root.val);
			result = Math.max(result, max_caseVal);

			return max_straight;
		}

		public int maxPathSum(TreeNode root) {

			maxPathSum_Util(root);
			return result;
		}
	}
}