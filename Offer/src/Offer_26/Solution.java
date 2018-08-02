/**
	AC!大量参考了别人的思路和代码！
	输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
	返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
package Offer_26;
public class Solution {
    public RandomListNode Clone(RandomListNode pHead){
    	if (pHead == null) {
			return null;
		}
    	RandomListNode curnode = pHead;
    	//复制.next指针
    	while (curnode != null) {
    		RandomListNode node = new RandomListNode(curnode.label);
    		node.next = curnode.next;
    		curnode.next = node;
    		curnode = node.next;
		}
    	curnode = pHead;
    	//复制.random指针
    	while (curnode != null) {
    		RandomListNode node = curnode.next;
    		if (curnode.random != null) {
				node.random = curnode.random.next;
			}
    		curnode = node.next;
		}
    	//拆分链表
    	RandomListNode head = pHead.next;
    	RandomListNode cur = head;
    	RandomListNode pCur = pHead;
    	while (pCur != null) {
    		pCur.next = pCur.next.next;
    		if(cur.next!=null){
    			 cur.next = cur.next.next;
    		}
    		cur = cur.next;
            pCur = pCur.next;
		}
    	/*while (cur != null) {  错误代码，对比上面的while循环，找差别！
    		pCur.next = cur.next;
    		cur = cur.next.next;
    		pCur = pCur.next;
    		cur = cur.next;
    	}*/
    	return head;
    }
}