/**
 * 
	AC!
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
public class Solution2 {
	//下面是自己第二次写的二叉树镜像代码！
    public void Mirror(TreeNode root) {  
    	if (root == null) {
			return;
		}
    	if (root.left != null || root.right != null) {
    		TreeNode temp = null;
        	temp = root.left;
        	root.left = root.right;
        	root.right = temp;
		}else {
			return;
		}
    	
    	if (root.left != null) {
			this.Mirror(root.left);
		}
    	if (root.right != null) {
			this.Mirror(root.right);
		}
    }
}