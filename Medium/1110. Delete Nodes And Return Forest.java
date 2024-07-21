// 1110. Delete Nodes And Return Forest
// https://leetcode.com/problems/delete-nodes-and-return-forest/description/
// Given the root of a binary tree, each node in the tree has a distinct value.

// After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

// Return the roots of the trees in the remaining forest. You may return the result in any order.

// Example 1:

// Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
// Output: [[1,2,null,4],[6],[7]]
// Example 2:

// Input: root = [1,2,4,null,3], to_delete = [3]
// Output: [[1,2,4]]

// Constraints:

// The number of nodes in the given tree is at most 1000.
// Each node has a distinct value between 1 and 1000.
// to_delete.length <= 1000
// to_delete contains distinct values between 1 and 1000.

// Solution : 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {
    private List<TreeNode> ans;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        dfs(root, toDeleteSet, true);
        return ans;
    }

    private void dfs(TreeNode root, Set<Integer> toDeleteSet, boolean isRoot) {
        if (root == null)
            return;
        boolean deleted = toDeleteSet.contains(root.val);
        if (isRoot && !deleted) {
            ans.add(root);
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        if (root.left != null && toDeleteSet.contains(root.left.val)) {
            root.left = null;
        }
        if (root.right != null && toDeleteSet.contains(root.right.val)) {
            root.right = null;
        }
        dfs(leftNode, toDeleteSet, deleted);
        dfs(rightNode, toDeleteSet, deleted);
    }
}