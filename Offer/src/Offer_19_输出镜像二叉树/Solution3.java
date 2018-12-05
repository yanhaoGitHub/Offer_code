/**
 * 
	操作给定的二叉树，将其变换为源二叉树的镜像。
	二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 */
package Offer_19_输出镜像二叉树;
public class Solution3 {
    public static void Mirror(TreeNode root) {  
    	TreeNode tmp = null;
    	if (root != null && (root.left!=null || root.right!=null)) {
    		tmp = root.left;
    		root.left = root.right;
    		root.right = tmp;
    		tmp = null;
		}
    	if (root.left != null) {
        	Mirror(root.left);
		}
    	if (root.right != null) {
        	Mirror(root.right);
		}
    }
    public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(10);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(7);
		TreeNode node5 = new TreeNode(9);
		TreeNode node6 = new TreeNode(11);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		
		Mirror(root);
		
		printNodeNum(root);
	}
    
    public static void printNodeNum(TreeNode root) {
    	if (root != null) {
			System.out.println(root.val);
		}
    	if (root.left != null) {
    		printNodeNum(root.left);
		}
    	if (root.right != null) {
    		printNodeNum(root.right);
		}
    }
}