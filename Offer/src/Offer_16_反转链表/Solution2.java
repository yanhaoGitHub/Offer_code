/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
	AC!
 */
package Offer_16_反转链表;
public class Solution2 {
    public ListNode ReverseList(ListNode head) {
    	if (head == null) {  //链表头节点为空
			return null;
		}
    	if (head.next == null) {  //链表只有一个头节点
			return head;
		}
    	if (head.next.next == null) {  //链表只有两个节点
			ListNode res = head.next;
    		res.next = head;
			head.next = null;
			return res;
    	}
    	ListNode slow = head;
    	ListNode mid = head.next;
    	ListNode fast = head.next.next;
    	
    	
    	while (fast != null) {
    		if (head == slow) {
				slow.next = null;
			}
    		mid.next =slow;
			slow = mid;
			mid = fast;
			if (fast.next != null) {
				fast = fast.next;
			}else {
				fast.next = slow;   //这个小问题好久才解决！这个时候，fast和mid已经重合了，应该让fast指向slow才对。
		    	return fast;
			}
    	}
    	return fast;
    }
    
    public static void main(String[] args) {
    	Solution2 test = new Solution2();
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