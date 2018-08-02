/**
 *  AC!
	输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
package Offer_18;
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    	boolean flag = false;
    	if (root2 == null || root1==null) { //初步判断！
    		return false;	
		}
    	if (root1 != null && root2 != null) {  //注意这里刚开始忘记这个条件了！
        	if (root1.val == root2.val) {
        		flag = judgeIsSame(root1, root2);
        	}
        	if (flag == false) {
            	flag = HasSubtree(root1.left, root2); //注意这里最开始自己忘记写flag=
    		}
        	if (flag == false) {
    			flag = HasSubtree(root1.right, root2); //注意这里最开始自己忘记写flag=
    		}
		}
    	return flag;
    }
    
    public boolean judgeIsSame(TreeNode node1, TreeNode node2){
    	if (node2 == null) {
			return true;
		}
    	if (node1 == null) {
			return false;
		}
    	if (node1.val != node2.val) {
			return false;
		}
		return judgeIsSame(node1.left, node2.left) && judgeIsSame(node1.right, node2.right);
    }
}