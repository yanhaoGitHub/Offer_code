/**
 *  2018-11-7
	输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
	路径定义为从树的根结点开始往下【一直到叶结点】所经过的结点形成一条路径。
 */
package Offer_25;
import java.util.ArrayList;
import java.util.Stack;
public class Solution2 {
	ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		this.FindPath2(root, target, paths, new ArrayList<Integer>());
		return paths;
	}
	
	public void FindPath2(TreeNode root,int target,ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path) {
		if (target < root.val) {
			return;
		}
		path.add(root.val);
		
		if (root.left==null && root.right==null) {
			if (target == root.val) {
				paths.add(path);
			}
			return;
		}
		ArrayList<Integer> path2 = new ArrayList<Integer>();
		path2.addAll(path);
		
		if (root.left != null) {
			this.FindPath2(root.left, target-root.val, paths, path);
		}
		if (root.right != null) {
			this.FindPath2(root.right, target-root.val, paths, path2);
		}
	}
	
	
	
	//测试用的先序遍历，和本题无关。
	public void pre(TreeNode root, ArrayList<Integer> list){
		if (root != null) {
			list.add(root.val);
		}
		if (root.left != null) {
			this.pre(root.left, list);
		}
		if (root.right != null) {
			this.pre(root.right, list);
		}
	}
	public static void main(String[] args) {
		Solution2 test = new Solution2();
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2= new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(10);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		node3.left = node7;
		
		ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
		paths = test.FindPath(root, 11);
		System.out.println("paths中有"+paths.size()+"个path!");
		for (int i = 0; i < paths.size(); i++) {
			ArrayList<Integer> path = paths.get(i);
			for (int j = 0; j < path.size(); j++) {
				System.out.print(path.get(j)+" ");
			}
			System.out.println();
		}
	}
}