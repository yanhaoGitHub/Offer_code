/**
 * AC！ 2018/11/1
 *  【思路】使用一个队列，始终保存一个父节点，然后把这个父节点的左子树和右子树加进来，然后弹出这个父节点，
 *        再把这个父节点的左子树和右子树加进来，再弹出这个左子树，依此类推，即可达到层序遍历的目的！
 *  
	从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */



package Offer_23;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Solution2 {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		TreeNode tmp = root;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(tmp);
		while (!queue.isEmpty()) {
			if (tmp.left != null) {
				queue.offer(tmp.left);
			}
			if (tmp.right != null) {
				queue.offer(tmp.right);
			}
			res.add(queue.poll().val);
			tmp = queue.peek();
		}
		return res;
	}
    
    public static void main(String[] args) {
    	Solution2 test = new Solution2();
    	TreeNode root = new TreeNode(0);
    	TreeNode node1 = new TreeNode(1);
    	TreeNode node2 = new TreeNode(2);
    	TreeNode node3 = new TreeNode(3);
    	TreeNode node4 = new TreeNode(4);
    	TreeNode node5 = new TreeNode(5);
    	root.left = node1;
    	root.right = node2;
    	node1.left = node3;
    	node1.right = node4;
    	node2.left = node5;
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list = test.PrintFromTopToBottom(root);
    	for (int i = 0; i < list.size(); i++) {
    		System.out.print(list.get(i)+" ");
		}
    }
}