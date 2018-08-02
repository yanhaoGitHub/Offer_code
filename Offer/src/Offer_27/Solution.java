/**
	AC! 参考了别人的代码！
	输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
	要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
package Offer_27;
public class Solution {
	TreeNode leftHead = null;
	TreeNode rightHead = null;
	public TreeNode Convert(TreeNode pRootOfTree) {
    	if (pRootOfTree == null) {
			return null;
		}
    	Convert(pRootOfTree.left);
    	if (rightHead == null) {
			leftHead = rightHead = pRootOfTree;
		}else {
			rightHead.right = pRootOfTree;
			pRootOfTree.left = rightHead;
			rightHead = pRootOfTree;
		}
    	Convert(pRootOfTree.right);
    	return leftHead;
    }
    public static void main(String[] args) {
		Solution test = new Solution();
	}
}