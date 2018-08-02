/**
 *  AC!
 *  【思路】使用一个队列，始终保存一个父节点，然后把这个父节点的左子树和右子树加进来，然后弹出这个父节点，
 *        再把这个父节点的左子树和右子树加进来，再弹出这个左子树，依此类推，即可达到层序遍历的目的！
 *  
	从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
package Offer_23;
import java.util.ArrayList;
public class Solution {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		TreeNode index = null;
		if (root == null) {
			return result;   //注意这里，刚开始自己写的return null,只通过了80%的测试用例，如果给个空树，不能返回null的，而应该返回一个result，只不过这个result是空的而已！
    	}
		index = root;   //索引，始终用来保存queue的第一个元素，这个时候可以保证不破坏原始树的结构，因为root我们并没有动！
    	queue.add(index);
    	while (queue.size() != 0) { //！！！注意这里的判断条件不是queue!=null,自己刚开始写成这种形式错了，后来意识到queue永远不会为空的，除非垃圾收集器收集它，判断的条件应该是queue队列中的元素个数不为0！！！
        	if (index.left != null) { //左子树非空，加进队列
    			queue.add(index.left);
    		}
        	if (index.right != null) { //右子树非空，加进队列
    			queue.add(index.right);
    		}
        	result.add(index.val);  //将这两颗子树节点的父节点加进result队列
        	queue.remove(index);  //将这两颗子树节点的父节点移除
        	if (queue.size() != 0) { //！！！这个判断很重要，不然如果一个几点没有子节点的话，上面已经把它移除了，这个时候queue就是空的，会报空指针异常，所以必须进行判断！
            	index = queue.get(0);
			}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	Solution test = new Solution();
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
    	list = test.PrintFromTopToBottom(null);
    	for (int i = 0; i < list.size(); i++) {
    		System.out.print(list.get(i)+" ");
		}
    }
}