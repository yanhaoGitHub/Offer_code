/**
 * AC!
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
public class Solution {
	//自己写的版本,AC! 注意体会两个方法的不同之处!
    public void Mirror(TreeNode root) {  
    	if (root == null) {  //入口判断1，不能少
			return;  
    	}
    	if (root.left == null && root.right == null) { //入口判断2，不能少
    		return;
		}
    	if (root.left != null && root.right != null) {
    		TreeNode temp = root.left;
    		root.left = root.right;
    		root.right = temp;
    	}else if (root.left != null && root.right == null) {
    		root.right = root.left;
    		root.left = null;
		}else if (root.left == null && root.right != null) {
			root.left = root.right;
			root.right = null;
		}
    	Mirror(root.left);
    	Mirror(root.right);
    }
    //剑指Offer给的版本,AC!
    public void Mirror2(TreeNode root) {
    	if (root == null) {  //入口判断1，不能少
			return;  
    	}
    	if (root.left == null && root.right == null) { //入口判断2，不能少
    		return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		if (root.left != null) {
			Mirror(root.left);
		}
		if (root.right != null) {
			Mirror(root.right);
		}
    }
}