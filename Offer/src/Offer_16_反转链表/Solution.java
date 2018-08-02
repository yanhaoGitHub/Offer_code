/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
	AC!
 */
package Offer_16_反转链表;
public class Solution {
    public ListNode ReverseList(ListNode head) {
    	ListNode pReversedHead = null;
    	ListNode cur = head;
    	ListNode curBefo = null;
    	while (cur != null) {   //注意这里，自己之前写的是cur.next != null，导致报错空指针！
			ListNode pNext = cur.next;
			if (pNext == null) {
				pReversedHead = cur;
			}
    		
			cur.next = curBefo;
			curBefo = cur;
			cur = pNext;
		}
    	return pReversedHead;
    }
    
    public static void main(String[] args) {
    	Solution test = new Solution();
    	ListNode node1 = new ListNode(1);
    	ListNode node2 = new ListNode(2);
    	ListNode node3 = new ListNode(3);
    	ListNode node4 = new ListNode(4);
    	ListNode node5 = new ListNode(5);
    	node1.next = node2;
    	node2.next = node3;
    	node3.next = node4;
    	node4.next = node5;
    	node5.next = null;
    	
    	ListNode node = test.ReverseList(node1);
    	while (node != null) {
    		System.out.println(node.val+" ");
    		node = node.next;
    	}
    }
}