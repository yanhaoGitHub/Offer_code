package Offer_59;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
/**
 * 本类实现了二叉树的先序遍历，中序遍历，后序遍历，层序遍历的递归解法以及非递归解法！
 */
import java.util.LinkedList;
import java.util.Stack;
public class PreOrder_MidOrder_PosOrder {
	//层序遍历，非递归
	public void levelIterator(TreeNode root){  
	     if(root == null){  
	         return;  
	     }  
	     LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  
	     TreeNode current = null;  
	     queue.offer(root);//将根节点入队  
	     while(!queue.isEmpty()){  
	          current = queue.poll();//出队队头元素并访问  
	          System.out.print(current.val + " ");  
	          if(current.left != null){//如果当前节点的左节点不为空入队  
	              queue.offer(current.left);  
	          }  
	          if(current.right != null){//如果当前节点的右节点不为空，把右节点入队  
	              queue.offer(current.right);  
	          }  
	     }  
	}  
	//先序遍历，递归
	public void preOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.val+" ");//这一行目前只是输出，可以修改作为他用！
			if (root.left != null) {
				this.preOrder(root.left);
			}
			if (root.right != null) {
				this.preOrder(root.right);
			}
		}
	}
	//中序遍历，递归
	public void midOrder(TreeNode root) {
		if (root != null) {
			if (root.left != null) {
				this.midOrder(root.left);
			}
			System.out.print(root.val+" ");//这一行目前只是输出，可以修改作为他用！
			if (root.right != null) {
				this.midOrder(root.right);
			}
		}
	}
	//后序遍历，递归
	public void postOrder(TreeNode root) {
		if (root != null) {
			if (root.left != null) {
				this.postOrder(root.left);
			}
			if (root.right != null) {
				this.postOrder(root.right);
			}
			System.out.print(root.val+" ");//这一行目前只是输出，可以修改作为他用！
		}
	}
	//===================================下面为上面的非递归实现=========================================
	//先序遍历，非递归，根->左->右
	public void preOrder2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = null;
		if (root != null) {
			stack.push(root);
			while (!stack.isEmpty()) {
				temp = stack.pop();
				System.out.print(temp.val+" ");
				if (temp.right != null) {
					stack.push(temp.right);
				}
				if (temp.left != null) {
					stack.push(temp.left);
				}
			}
		}
	}
	//中序遍历，非递归
	//思想：沿着根节点向左一直向下走，然后当栈不空的时候，弹出一个元素，打印，并换到这个节点的右边节点，不断重复！
	public void midOrder2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();  
        TreeNode temp = root;
		while (temp != null || !stack.empty()) {  
            while (temp != null) {  
                stack.push(temp);  
                temp = temp.left;  
            }  
            if (!stack.empty()) {  
            	temp = stack.pop();  
                System.out.print(temp.val + " ");  
                temp = temp.right;  
            }  
        }  
	}
	//后序遍历，非递归实现1
	public void postOrder2(TreeNode root) {
		Stack<TreeNode> stack1 = new Stack<TreeNode>();  
        Stack<Integer> stack2 = new Stack<Integer>();  
        TreeNode temp = root;
        int i = 1;
        while (temp != null || !stack1.empty()) {  
            while (temp != null) {  
                stack1.push(temp);  
                stack2.push(new Integer(0));  
                temp = temp.left;  
            }  
            while (!stack1.empty() && stack2.peek().equals(i)) {  
                stack2.pop();  
                System.out.print(stack1.pop().val + " ");  
            }  
            if (!stack1.empty()) {  
                stack2.pop();  
                stack2.push(new Integer(1));  
                temp = stack1.peek();  
                temp = temp.right;  
            }  
        }  
	}
	/**
	后序遍历，非递归实现2
	二叉树的后序非递归遍历就比较难写，因为涉及到判断节点的访问状态…

	现在有个很巧妙的方法：
	前序：根->左->右 
	后序：左->右->根
	那么可以把后序当作：根->右->左，然后再反转一下即可。
	*/
	public ArrayList<Integer> postOrder3(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = root;
		if (root != null) {
			stack.push(root);
			while (!stack.isEmpty()) {
				temp = stack.pop();
				list.add(temp.val);
				//System.out.print(temp.val + " ");
				if (temp.left != null) {//这段代码和先序遍历的非递归写法基本一致，只是这里是先左后右。
					stack.push(temp.left);
				}
				if (temp.right != null) {
					stack.push(temp.right);
				}
			}
			Collections.reverse(list);
		}
		return list;
	}
	
	public static void main(String[] args) {
		 	PreOrder_MidOrder_PosOrder test = new PreOrder_MidOrder_PosOrder();
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
	    	//test.levelIterator(root); //层序遍历输出: 1 2 3 4 5 6 7 8 9 
	    	//test.preOrder(root); //先序遍历输出: 1 2 4 8 9 5 3 6 7 
	    	//test.midOrder(root); //中序遍历输出: 8 4 9 2 5 1 6 3 7 
	    	//test.postOrder(root); //后序遍历输出: 8 9 4 5 2 6 7 3 1 
	    	//test.preOrder2(root); //先序遍历非递归输出: 1 2 4 8 9 5 3 6 7 
	    	//test.midOrder2(root); //中序遍历非递归输出: 8 4 9 2 5 1 6 3 7 
	    	//test.postOrder2(root); //后序遍历非递归输出: 8 9 4 5 2 6 7 3 1 
	    	
	    	ArrayList<Integer> list = test.postOrder3(root); //后序遍历非递归输出: 8 9 4 5 2 6 7 3 1 
	    	for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
	}
}
