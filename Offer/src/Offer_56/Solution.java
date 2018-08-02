/**
 * AC!
 * 一个链表中包含环，请找出该链表的环的入口结点。
*/
package Offer_56;
public class Solution {
	public ListNode EntryNodeOfLoop(ListNode pHead){
		if (pHead == null || pHead.next==null || pHead.next.next==null) {
			return null;
		}
		ListNode fast = pHead.next.next;
		ListNode slow = pHead.next;
		//先判断有没有环,注意这里的循环条件以及while循环中的几个条件！
		while (fast != slow) {
			if (fast.next!=null && fast.next.next!=null) {
				fast = fast.next.next;
				slow = slow.next;
			}else {
				//没有换，返回
				return null;
			}
		}
		//循环出来的话就是有环，且此时fast==slow
		fast = pHead;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
}