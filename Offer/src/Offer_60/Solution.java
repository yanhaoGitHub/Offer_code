/**
	AC!
	请实现一个函数，用来判断一颗二叉树是不是对称的。
	注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
*/
package Offer_60;
import java.util.ArrayList;
public class Solution {
	/**
	 思路一：
		递归版：首先根节点及其左、右子树相同，然后左子树的左子树和右子树的右子树相同，
		左子树的右子树和右子树的左子树相同即可。显然是个递归的过程
	*/
	boolean isSymmetrical(TreeNode pRoot){
		if (pRoot == null) {
			return true;
		}
		return this.judge(pRoot.left, pRoot.right);
    }
	boolean judge(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 != null && node2 != null) {
			return node1.val == node2.val && (this.judge(node1.left, node2.right) && this.judge(node1.right, node2.left));
		}
		return false;
	}

	/**
	  思路二：
		二叉树是否对称，只要采用前序、中序、后序、层次遍历等任何一种遍历方法，分为先左后右和先右后左两种方法，
		只要两次结果相等就说明这棵树是一颗对称二叉树。（这里采用递归的方式进行前序遍历）
	 	即【根左右】和【根右左】这样的规律去进行判断
	*/
	ArrayList<Integer> list1 = new ArrayList<Integer>();
	ArrayList<Integer> list2 = new ArrayList<Integer>();
	boolean isSymmetrical2(TreeNode pRoot){
		if (pRoot == null) {
			return true;
		}
		this.preOrder(pRoot, list1);
		this.preOrder2(pRoot, list2);
		if (list1.size() != list2.size()) {
			return false;
		}
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != list2.get(i)) {
				return false;
			}
		}
		return true;
	}
	//【根左右】
	public void preOrder(TreeNode node, ArrayList<Integer> list1) {
		if (node != null) {
			list1.add(node.val);
			this.preOrder(node.left, list1);
			this.preOrder(node.right, list1);
		}else {
			//这个操作很精髓，也就是说只要node不为空，那么他的左右子节点都必须加入到list之中。
			/**
				    5
				5       5
			  5   #   5   #
			  在上面这种情况下，如果不把#也加入到list之中，则【根左右】和【根右左】的值是一样的，但明显，这个树并不对称！
  			 */
			list1.add(-100);  
		}
	}
	//【根右左】
	public void preOrder2(TreeNode node, ArrayList<Integer> list2) {
		if (node != null) {
			list2.add(node.val);
			this.preOrder2(node.right, list2);
			this.preOrder2(node.left, list2);
		}else {
			list2.add(-100);
		}
	}
	
	
	
	public static void main(String[] args) {
		Solution test = new Solution();
		/*
		测试代码一：
		TreeNode root = new TreeNode(8);
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(7);
		TreeNode node5 = new TreeNode(7);
		TreeNode node6 = new TreeNode(5);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		System.out.println(test.isSymmetrical(root));
		*/
		
		//测试代码二：
		TreeNode root2 = new TreeNode(5);
		TreeNode node21 = new TreeNode(5);
		TreeNode node22 = new TreeNode(5);
		root2.left = node21;
		root2.right = node22;
		TreeNode node23 = new TreeNode(5);
		TreeNode node25 = new TreeNode(5);
		node21.left = node23;
		node21.right = null;
		node22.left = null;
		node22.right = node25;
		TreeNode node26 = new TreeNode(5);
		TreeNode node27 = new TreeNode(5);
		node23.left = node26;
		node23.right = null;
		node25.left = node27;
		node25.right = null;
		System.out.println(test.isSymmetrical(root2));//false
		System.out.println(test.isSymmetrical2(root2));//false
	}
}