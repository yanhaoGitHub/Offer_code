/**
	输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
package Offer_18_判断二叉树B是不是A的子结构;
public class Solution2 {
	public boolean HasSubTree(TreeNode root1, TreeNode root2) {
		boolean res = false;
		if (root1!=null && root2!=null) {
			if (root1.val == root2.val) {
				res = this.isSame(root1, root2);
			}
			if (!res) {
				res = this.HasSubTree(root1.left, root2);
			}
			if (!res) {
				res = this.HasSubTree(root1.right, root2);
			}
		}
		return res;
	}
	
	public boolean isSame(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		
		if (root1.val != root2.val) {
			return false;
		}
		return this.isSame(root1.left, root2.left) && this.isSame(root1.right, root2.right);
	}
	
    public static void main(String[] args) {
    	TreeNode root1 = new TreeNode(8);
    	TreeNode node1 = new TreeNode(8);
    	TreeNode node2 = new TreeNode(7);
    	TreeNode node3 = new TreeNode(9);
    	TreeNode node4 = new TreeNode(2);
    	TreeNode node5 = new TreeNode(4);
    	TreeNode node6 = new TreeNode(7);
    	
    	root1.left = node1;
    	root1.right = node2;
    	node1.left = node3;
    	node1.right = node4;
    	node4.left = node5;
    	node4.right = node6;
    	
    	TreeNode root2 = new TreeNode(8);
    	TreeNode node10 = new TreeNode(9);
    	TreeNode node11 = new TreeNode(2);
    	root2.left = node10;
    	root2.right = node11;
    	
    	Solution2 test = new Solution2();
    	System.out.println(test.HasSubTree(root1, root2));
    }
}