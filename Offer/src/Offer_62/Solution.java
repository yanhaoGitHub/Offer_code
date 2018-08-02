/**
 * AC!
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 本题思路参见左神，第三章中的这个题！
*/
package Offer_62;
import java.util.LinkedList;
import java.util.Queue;
public class Solution {
	//方法一，先序序列化方法！
	String Serialize2(TreeNode root) {
		if (root == null) {
			return "#!";
		}
		String str = root.val + "!";
		str += this.Serialize2(root.left);
		str += this.Serialize2(root.right);
		return str;
	}
	//反序列化方法
	TreeNode Deserialize2(String str) {
		//把上面方法产生的str转化为数组
		String[] strs = str.split("!");
		Queue<String> queue = new LinkedList<String>();
		for (int i = 0; i < strs.length; i++) {
			queue.offer(strs[i]);
		}
		return this.reconPreOrder(queue);
	}
	//下面这个方法根据提供的queue参数重建二叉树
	public TreeNode reconPreOrder(Queue<String> queue) {
		String value = queue.poll();
		if (value.equals("#")) {
			return null;
		}
		TreeNode head = new TreeNode(Integer.parseInt(value));
		head.left = reconPreOrder(queue);
		head.right = reconPreOrder(queue);
		return head;
	}
	
	/**
	 * 方法二，通过层序遍历实现序列化和反序列化
	 */
	String Serialize(TreeNode root) {
		if (root == null) return "#!";
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		String res = root.val + "!";
		queue.offer(root);
		TreeNode temp = null;
		while (!queue.isEmpty()) {
			temp = queue.poll();
			if (temp.left != null) {
				queue.offer(temp.left);
				res += temp.left.val + "!";
			}else {
				res += "#!";
			}
			if (temp.right != null) {
				queue.offer(temp.right);
				res += temp.right.val + "!";
			}else {
				res += "#!";
			}
		}
		return res;
	}

	TreeNode Deserialize(String str) {
		String[] strs = str.split("!");
		int index = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		//生成头节点
		TreeNode head = this.generateNode(strs[index++]); //注意这里是index++,而不是index
		if (head != null) {
			queue.offer(head);
		}
		TreeNode temp = null;
		while (!queue.isEmpty()) {
			temp = queue.poll();
			temp.left = this.generateNode(strs[index++]);
			temp.right = this.generateNode(strs[index++]);
			if (temp.left != null) {
				queue.offer(temp.left);
			}
			if (temp.right != null) {
				queue.offer(temp.right);
			}
		}
		return head;
	}
	//下面这个方法根据提供的节点值返回对应的新生成的节点
	public TreeNode generateNode(String value) {
		if (value.equals("#")) {
			return null;
		}
		return new TreeNode(Integer.parseInt(value));
	}
	
}