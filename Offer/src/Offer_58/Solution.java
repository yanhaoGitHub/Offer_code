/**
	AC!
	给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
	注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
	
	具体思路见牛客网！
*/
package Offer_58;
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
    	if (pNode == null) return null;
    	if (pNode.right != null) {  //有右子树，则返回右子树最左边的节点
			TreeLinkNode right = pNode.right;
    		while (right.left != null) {  //注意这里是right.left!=null而不是left!=null
				right = right.left;
			}
    		return right;
		}
    	//pNode.next != null，这个判断条件不能忘记！
    	if (pNode.next != null && pNode.next.left == pNode) {//该节点是父节点的左子树节点，则返回父节点即可
			return pNode.next;
		}
    	//pNode.next != null这个判断条件不能忘记，该节点是父节点的右子树节点，并且该节点没有右子树，则返回第一个左子树节点是该节点祖宗节点的节点
    	if (pNode.next != null && pNode.next.right == pNode) {
			//pNode.next != null这个判断条件不能忘记
    		while (pNode.next != null && pNode.next.left != pNode) {
				pNode = pNode.next;
			}
    		return pNode.next;
		}
    	return pNode.next;//如果到了这一步，说明节点无父节点，即节点为根节点.
    }
}