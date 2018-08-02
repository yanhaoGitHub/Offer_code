/**
 *  AC!
	从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
*/
package Offer_61;
import java.util.ArrayList;
import java.util.LinkedList;
public class Solution {
	//思路，这个题就是简单的层序遍历,只是需要把每一层的元素单独保存！
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) return lists;
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(pRoot);
		
		TreeNode curr = null;
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int index=0, queue_len = queue.size();
    	while (!queue.isEmpty()) {
    		index=0; //归零
    		queue_len = queue.size(); //重新赋值
    		temp.clear(); //清空用来暂存元素的list
    		
    		while (index++ < queue_len) {
    			curr = queue.poll();
    			temp.add(curr.val);
    			if (curr.left != null) {
    				queue.offer(curr.left);
    			}
        		if (curr.right != null) {
    				queue.offer(curr.right);
    			}
			}
    		lists.add(new ArrayList<>(temp));//注意这里必须重新new一个arrayList!
		}
    	return lists;
    }
	
	public static void main(String[] args) {
	 	Solution test = new Solution();
    	TreeNode root = new TreeNode(1);
    	TreeNode node2 = new TreeNode(2);
    	TreeNode node3 = new TreeNode(3);
    	TreeNode node4 = new TreeNode(4);
    	TreeNode node5 = new TreeNode(5);
    	TreeNode node6 = new TreeNode(6);
    	TreeNode node7 = new TreeNode(7);
    	TreeNode node8 = new TreeNode(8);
    	TreeNode node9 = new TreeNode(9);
    	root.left = node2;
    	root.right = node3;
    	node2.left = node4;
    	node2.right = node5;
    	node3.left = node6;
    	node3.right = node7;
    	node4.left = node8;
    	node4.right = node9;
    	
    	/**
 	        打印出结果为：
 	       1 
		   2 3 
		   4 5 6 7 
		   8 9 
   	    */
    	ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    	lists = test.Print(root);
    	for (int i = 0; i < lists.size(); i++) {
    		ArrayList<Integer> list = lists.get(i);
    		for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j) + " ");
			}
    		System.out.println();
    	}
    }
}