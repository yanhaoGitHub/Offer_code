/**
	输入一个链表，输出该链表中倒数第k个结点。
 */
package Offer_15;
public class Solution2 {
    public ListNode FindKthToTail(ListNode head,int k) {
    	if (head == null || k < 0) {
    		return null;
    	}
    	int i = 0;
    	ListNode node = head;
    	while(node != null && i < k) {
    		node  = node.next;
    		i++;
    	}
		ListNode slow = head;
    	if (i==k) {
			while (node != null) {
				slow = slow.next;
				node = node.next;
			}
			return slow;
		}else {
			return null;
		}
    }
    public static void main(String[] args) {
		Solution2 test = new Solution2();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = null;

		ListNode node = test.FindKthToTail(node1, 0);
		if (node != null) {
			System.out.println(node.val);
		}
	}
    
}