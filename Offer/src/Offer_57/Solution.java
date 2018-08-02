/**
 *  AC!
	在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
	 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 	           链表1->1->1->1->1->1处理后为{}
*/
package Offer_57;
public class Solution {
	//常规解法，使用三个指针进行遍历！
    public ListNode deleteDuplication(ListNode pHead){
    	if (pHead == null || pHead.next == null) 	return pHead;
    	ListNode newHead = new ListNode(-1);//创建新的头节点，防止phead被删除
    	newHead.next = pHead;
    	
    	ListNode pre = newHead;
    	ListNode cur = pHead;
    	ListNode next = null;
    	
    	while (cur != null && cur.next != null) {
    		next = cur.next;
    		if (cur.val == next.val) {
    			int temp = cur.val;
				while (next != null && cur.val == next.val) {
					next = next.next;
				}
				pre.next = next;
				cur = next;
			}else {
				pre = cur;
				cur = cur.next;
			}
		}
    	return newHead.next;//返回新创建头节点的下一个节点即为新链表的头节点！
    }
    public static void main(String[] args) {
		Solution test = new Solution();
		ListNode pHead = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(5);
		pHead.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = null;
		ListNode temp = test.deleteDuplication(pHead);
		while (temp != null) {
			System.out.print(temp.val+" ");  //1，2，5
			temp = temp.next;
		}
	}
}