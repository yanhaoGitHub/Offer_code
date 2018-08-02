/**
 * AC!
 * @author Think Different_YH
 * 输入两个链表，找出它们的第一个公共结点。
 * 本题思路，查看剑指offer!
 */
package Offer_37;
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	ListNode resultNode = null;
    	int len1 = 0;
    	int len2 = 0;
    	ListNode temp = pHead1;
    	while (temp != null) {
			len1++;
    		temp = temp.next;
		}
    	temp = pHead2;
    	while (temp != null) {
			len2++;
    		temp = temp.next;
		}
    	ListNode node1 = pHead1;
    	ListNode node2 = pHead2;
    	if (len1 > len2) {
    		int len = len1-len2;
    		while (len > 0) {
    			node1 = node1.next;
    			len--;
			}
    	}else {
    		int len = len2-len1;
    		while (len>0) {
				node2 = node2.next;
				len--;
			}
    	}
    	while (node1 != null) {
			if (node1.val == node2.val) {
				resultNode = node1;
				break;
			}else {
				node1 = node1.next;
				node2 = node2.next;
			}
		}
    	return resultNode;
    }
    public static void main(String[] args) {
		Solution test = new Solution();
		ListNode head1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(6);
		ListNode node5 = new ListNode(7);
		ListNode head2 = new ListNode(4);
		ListNode node6 = new ListNode(5);
		head1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		head2.next = node6;
		node6.next = node4;
		ListNode node = test.FindFirstCommonNode(head1, head2);
		System.out.println(node.val);
    }
}