/**
	AC!
	输入一个链表，输出该链表中倒数第k个结点。
 */
package Offer_15;
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
    	if (head == null || k==0) {  //对非法输入的初步判断！
			return null;
		}
    	ListNode node1 = head;
    	ListNode node2 = head; 
    	int i = 0;
    	//！！！注意下面括号中的这个条件&& node1 != null，刚开始自己没加这个条件，导致空指针异常，不可大意!
    	while (i<k && node1 != null) {  //让node1指向从左到右第k个节点
			node1 = node1.next;
			i++;
		}
    	while (node1 != null) {  //此时node1和node2一起走，当node1走到最后时，node2即指向倒数第k个节点.
 			node1 = node1.next;
			node2 = node2.next;
			i++;
    	}
    	if (i < k) {   //k值用来记录node1节点走到链表末尾总共走了多少步，若i<k，则说明给的k值大于链表程度，不合理！
    		System.out.println("您输入的k值不合理，请重新输入！");
    		return null;
    	}else {
    		return node2;
		}
    }
    public static void main(String[] args) {
		Solution test = new Solution();
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