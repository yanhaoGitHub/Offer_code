/**
	AC!
	给定一颗二叉搜索树，请找出其中的第k大的结点。
	例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
			5
		   / \
		  3   7
	 	 / \ / \
	    2  4 6  8
*/
package Offer_63;
import java.util.ArrayList;
public class Solution {
    /**
		方法一，直接在中序遍历的过程中找到第k个节点，并返回，不需要遍历全部的节点！
     */
	int index = 0;//计数器，表示目前遍历到了哪个节点！
	TreeNode KthNode3(TreeNode pRoot, int k){
    	//采用中序遍历的思路
		if (pRoot != null) {
			//若在根节点的左子树找到了最终的结果则直接返回
    		TreeNode temp = this.KthNode(pRoot.left, k);
    		if (temp != null) {
				return temp;
			}
        	//若根节点更好就是最终的结果，则直接返回
        	if (++index == k) {
        		return pRoot;
    		}
        	//否则，就在根节点的右子树查找最终的结果
        	return this.KthNode(pRoot.right, k--);
		}
		//没有找到最后的结果，返回null
    	return null;
    }
    
    /**
		方法二，使用中序遍历的方法，先将所有的数据放进list中，最后直接返回第k个元素！
		优点是简单直观，但是耗费空间！
     */
    ArrayList<TreeNode> KthNode2(TreeNode pRoot, ArrayList<TreeNode> list){
    	//采用中序遍历的思路
    	if (pRoot == null) {
			return null;
		}
    	this.KthNode2(pRoot.left, list);
    	//进行判断
    	list.add(pRoot);
    	this.KthNode2(pRoot.right, list);
    	return list;
    }
    TreeNode KthNode(TreeNode pRoot, int k){
    	if (pRoot == null || k<=0) {
			return null;
		}
    	ArrayList<TreeNode> list = new ArrayList<TreeNode>();
    	list = this.KthNode2(pRoot, list);
    	if (k <= list.size()) {  //这里这么做的原因是，k值可能大于list的长度，所以需要进行判断！
        	return list.get(k-1);
		}else {
			return null;
		}
    }
    
    public static void main(String[] args) {
    	Solution test = new Solution();
    	TreeNode root = new TreeNode(5);
    	TreeNode node2 = new TreeNode(3);
    	TreeNode node3 = new TreeNode(7);
    	TreeNode node4 = new TreeNode(2);
    	TreeNode node5 = new TreeNode(4);
    	TreeNode node6 = new TreeNode(6);
    	TreeNode node7 = new TreeNode(8);
    	root.left = node2;
    	root.right = node3;
    	node2.left = node4;
    	node2.right = node5;
    	node3.left = node6;
    	node3.right = node7;
    	TreeNode res = test.KthNode3(root, 3);
    	System.out.println("res.val="+res.val);
	}
}