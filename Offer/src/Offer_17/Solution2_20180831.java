/**
	输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
package Offer_17_合并两个递增链表;
public class Solution2_20180831 {
	//方法一:不破坏原始两个链表的结构，重新建个新链表！
	public ListNode Merge(ListNode list1,ListNode list2) {
		ListNode head = null;
    	if (list1 == null) {
    		return list2;
		}else if (list2 == null) {
			return list1;
		}
		ListNode merge1  = list1;
    	ListNode merge2  = list2;
		if (merge1.val < merge2.val) { //注意这里，刚开始的时候自己是>号，导致最后的链表结果是先连接list1的所有节点，再连接list2的所有节点！！
			head = new ListNode(merge1.val);
			merge1 = merge1.next;
		}else {
			head = new ListNode(merge2.val);
			merge2 = merge2.next;
		}
		ListNode head2 = head;
    	while (merge1 != null && merge2 != null) {
    		if (merge1.val < merge2.val) {//注意这里，刚开始的时候自己是>号，导致最后的链表结果是先连接list1的所有节点，再连接list2的所有节点！！
    			ListNode node = new ListNode(merge1.val);
    			head2.next = node;
    			head2 = head2.next;
    			merge1 = merge1.next;
    		}else {
				ListNode node = new ListNode(merge2.val);//细心！之前写成了merge1.val
    			head2.next = node;
    			head2 = head2.next;
    			merge2 = merge2.next;
    		}
    	}
    	if (merge1 == null) {
    		while (merge2 != null) {
    			head2.next = merge2;
    			head2 = head2.next;
    			merge2 = merge2.next;
			}
		}else {
			while (merge1 != null) {
    			head2.next = merge1;
    			head2 = head2.next;
    			merge1 = merge1.next;
			}
		}
    	return head;
	}   
	
	//方法二:破坏原始链表结构，使用递归的方法
	public ListNode Merge2(ListNode list1,ListNode list2) {
		if (list1 == null) {
			return list2;
		}else if (list2 == null) {
			return list1;
		}

		ListNode node = null;
		if (list1.val < list2.val) {
			node = list1;
			node.next = Merge2(list1.next, list2);
		}else {
			node = list2;
			node.next = Merge2(list1, list2.next);
		}
		return node;
    }
	
    public static void main(String[] args) {
    	//主函数测试代码块
    	Solution2_20180831 test = new Solution2_20180831();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(7);
		ListNode node5 = new ListNode(9);
		ListNode node6 = new ListNode(11);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = null;
		ListNode node7 = new ListNode(2);
		ListNode node8 = new ListNode(4);
		ListNode node9 = new ListNode(6);
		ListNode node10 = new ListNode(8);
		ListNode node11 = new ListNode(10);
		ListNode node12 = new ListNode(12);
		ListNode node13 = new ListNode(20);
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		node10.next = node11;
		node11.next = node12;
		node12.next = node13;
		node13.next = null;
		ListNode node = test.Merge2(node1, node7);
		while (node != null) {
			System.out.print(node.val+" ");
			node = node.next;
		}
	}
}