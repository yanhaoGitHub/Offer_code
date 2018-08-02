/**
 *  AC! 参考了别人一些代码！
	输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
	路径定义为从树的根结点开始往下【一直到叶结点】所经过的结点形成一条路径。
 */
package Offer_25;
import java.util.ArrayList;
public class Solution {
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
		if (root == null) {//入口条件判断！
			return paths;
		}
		FindPath2(root, target, paths, new ArrayList<Integer>());
		return paths;
	}
	public void FindPath2(TreeNode root,int target,ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path) {
		if (target < root.val) {
			return;
		}
		path.add(root.val);
		if (root.left == null && root.right == null) {
			if (root.val == target) {
				paths.add(path);
			}
			return;
		}
		ArrayList<Integer> path2 = new ArrayList<Integer>(); //精髓！本行代码和下行代码参看的别人的！
		path2.addAll(path); //path2把path路径中的数据全部拷贝一份，然后走右子树！
		if (root.left != null) {
			FindPath2(root.left, target-root.val, paths, path);
		}
		if (root.right != null) {
			FindPath2(root.right, target-root.val, paths, path2); //注意区别，这里是path2
		}
	}
	public static void main(String[] args) {
		Solution test = new Solution();
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