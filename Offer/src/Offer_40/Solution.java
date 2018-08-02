/**
 *  AC!
 *  @author Think Different_YH
	输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
package Offer_40;
public class Solution {
	//由于上一个练习已经可以求出二叉树的深度，因此这个方法只需要递归比较左子树和右子树是不是平衡树即可.
	//但是这个方法会多次遍历同一个节点，时间复杂度高一点，面试官并不会满意.
	//124573624574577366，通过打印出遍历过程中经过的节点值，可以发现每个节点都会被遍历多次！
	public boolean IsBalanced_Solution(TreeNode root) {
		if (root == null) {
			return true;
		}else {
			System.out.print(root.val);
		}
		int leftDepth = this.getTreeDepth(root.left);
		int rightDepth = this.getTreeDepth(root.right);
		int temp = leftDepth - rightDepth;
		if (temp > 1 || temp < -1) {
			return false;
		}
		return this.IsBalanced_Solution(root.left) && this.IsBalanced_Solution(root.right);
	}
	//求一个树的深度
	public int getTreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}else {
			System.out.print(root.val);
		}
		int leftDepth = this.getTreeDepth(root.left);
		int rightDepth = this.getTreeDepth(root.right);
		return leftDepth>rightDepth? leftDepth+1 : rightDepth+1;
	}
	
	/** 方法二
		上面方法一这种做法有很明显的问题，在判断上层结点的时候，会多次重复遍历下层结点，增加了不必要的开销。
		如果改为从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；
		如果发现子树不是平衡二叉树，则直接停止遍历，这样至多只对每个结点访问一次。
	 */
	public boolean IsBalanced_Solution2(TreeNode root) {
		return this.getDepth(root) != -1;
    }
	public int getDepth(TreeNode root) {
		if (root == null) return 0;
		int leftDepth = this.getDepth(root.left);//得到左子树的深度
		if (leftDepth == -1) return -1;
		
		int rightDepth = this.getDepth(root.right);//得到右子树的深度
		if (rightDepth == -1) return -1;
		
		return Math.abs(leftDepth-rightDepth)>1 ? -1:1+Math.max(leftDepth, rightDepth);
	}
	
	public static void main(String[] args) {
		Solution test = new Solution();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node5.left = node7;
		node3.right = node6;
		System.out.println(test.IsBalanced_Solution(node1));
	}
}