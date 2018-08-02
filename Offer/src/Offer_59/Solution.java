/**
 * AC!
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
*/
package Offer_59;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
public class Solution {
	/**
	 * 方法一，使用两个栈以及列表的辅助完成！，这个方法比较简单，容易理解！
	 */
	 public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		 ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		 if (pRoot == null) return result;
		 int layer = 1;
		 //s1存奇数层节点
		 Stack<TreeNode> s1 = new Stack<>();
		 s1.add(pRoot);
		 //s2层存偶数层节点
		 Stack<TreeNode> s2 = new Stack<>();
		 //下面创建的list只创建一次，但是可以被下面两个栈使用，相比于不停的重新创建list要高效！
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 while (!s1.isEmpty() || !s2.isEmpty()) {
			 if (layer%2 == 1) { //此时layer是奇数层
				 while (!s1.isEmpty()) {
					 TreeNode temp = s1.pop();
					 if (temp != null) {
						 list.add(temp.val);
						 //System.out.print(temp.val+" ");
						 s2.push(temp.left);//这里很巧妙，在奇数层的时候，给偶数层添加元素的顺序是先左后右，由于栈的性质，所以在s2出栈的时候，就是先右后左了，很巧妙！
						 s2.push(temp.right);
					 }
				 }
				 if (!list.isEmpty()) {//若list中存在元素，则加入最终的result中！
					 /**
						这个代码并不是每次new 一个ArrayList用来存储，如果每次new 一个ArrayList，会在堆建立数据，
						在栈创建地址引用，该代码使用匿名内部类，没有创建栈中的引用，对于大量数据来说，
						确实省去了很多在栈中的内存开销
					 */
					 result.add(new ArrayList<>(list));//注意这里，是使用匿名函数对list中的元素进行复制，同时还必须有下面一句clear，否则list中的元素会越来越多！
					 list.clear();
					 layer++;	
				 }
			 }else { //此时layer是偶数层
				// ArrayList<Integer> list = new ArrayList<Integer>();
				 while (!s2.isEmpty()) {
					 TreeNode temp = s2.pop();
					 if (temp != null) {
						 list.add(temp.val);
						 //System.out.print(temp.val+" ");
						 s1.push(temp.right);//这里很巧妙，在偶数层的时候，给奇数层添加元素的顺序是先右后左，由于栈的性质，所以在s1出栈的时候，就是先左后右了，很巧妙！
						 s1.push(temp.left);
					 }
				 }
				 if (!list.isEmpty()) {//若list中存在元素，则加入最终的result中！
					 result.add(new ArrayList<>(list));
					 list.clear();
					 layer++;	
				 }
			 }
		 }
		 return result;
	 }
	
	/**
	 * 方法二：
	 * 下面这个方法在个别地方的代码很难理解！
	 * 大家的实现很多都是将每层的数据存进ArrayList中，偶数层时进行reverse操作，
	 * 在海量数据时，这样效率太低了。
	 * （我有一次面试，算法考的就是之字形打印二叉树，用了reverse，
	 * 直接被鄙视了，面试官说海量数据时效率根本就不行。）
	 *
	 * 下面的实现：不必将每层的数据存进ArrayList中，偶数层时进行reverse操作，直接按打印顺序存入
	 * 思路：利用Java中的LinkedList的底层实现是双向链表的特点。
	 *     1)可用做队列,实现树的层次遍历
	 *     2)可双向遍历,奇数层时从前向后遍历，偶数层时从后向前遍历
	
		下面这个代码，还是有优化的，。1. 这个代码并不是每次new 一个ArrayList用来存储，如果每次new 一个ArrayList，
		会在堆建立数据，在栈创建地址引用，该代码使用匿名内部类，没有创建栈中的引用，对于大量数据来说，
		确实省去了很多在栈中的内存开销 2. 该代码利用Java中的LinkedList的底层实现是双向链表的特点，由于是链表是双向的，
		所以他在实现反向遍历的时候和正向是一样的，这一点之前面试阿里的时候提到过。
	 */
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (pRoot == null) return result;
    	ArrayList<Integer> list = new ArrayList<>();//用来记录每一层的节点值。
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();//使用linkedlist来存放每一层的节点，linkedlist既可以从前向后遍历也可以从后向前遍历。
    	queue.addLast(null);//层分隔符
    	queue.addLast(pRoot);
    	boolean left2right = true;//用来表示从左到右遍历还是从右向左遍历。
    	
    	while (queue.size() != 1) {
    		TreeNode temp = queue.removeFirst();//得到队头的第一个节点
			if (temp == null) {//若temp为空，则说明已经遍历到了该层的最后。
				Iterator<TreeNode> iter = null;
				if (left2right) {
					iter = queue.iterator();
				}else {
					iter = queue.descendingIterator();
				}
				left2right = !left2right;
				while (iter.hasNext()) {
					TreeNode node = iter.next();
					list.add(node.val);
				}
				//注意下面这句话，这里必须new ArrayList<Integer>(list)，而不是result.add(list),否则不会打印出任何结果！
				result.add(new ArrayList<Integer>(list));
				list.clear();//清空list。
				queue.addLast(null);//添加层分隔符。
				continue;//continue是如果node为null的话就不用检测它的左右孩子了 直接进入对队列中下一个元素的检测。
			}
			if (temp.left != null) { //若temp不为空，则说明还没到这层的最后节点，则继续将temp的左孩子加入队列中。
				queue.addLast(temp.left);
			}
			if (temp.right != null) { //若temp不为空，则说明还没到这层的最后节点，则继续将temp的右孩子加入队列中。
				queue.addLast(temp.right);
			}
		}
    	return result;
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
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	result = test.Print(root);
    	for (int i = 0; i < result.size(); i++) {
    		ArrayList<Integer> temp = result.get(i);
    		for (int j = 0; j < temp.size(); j++) {
				System.out.print(temp.get(j)+" ");//1 3 2 4 5 6 7 9 8 
			}
		}
    }
}