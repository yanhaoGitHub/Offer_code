/**
 * 	AC!
	定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
package Offer_21;
import java.util.Stack;
public class Solution2 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
	public void push(int node) {
        stack1.push(node);
        if (stack2.isEmpty()) {
        	stack2.push(node);
		}else {
			if (node < stack2.peek()) {
				stack2.push(node);
			}else {
				stack2.push(stack2.peek());
			}
		}
    }
    public void pop() {
    	if (!stack1.isEmpty()) {
			stack1.pop();
			stack2.pop();
		}
    }
    public int top() {
    	return stack1.peek();
    }
    public int min() {
    	return stack2.peek();
    }
    
    public static void main(String[] args) {
		Solution2 test = new Solution2();
		test.push(3);
		System.out.println(test.min());
		test.push(4);
		System.out.println(test.min());
		test.push(2);
		System.out.println(test.min());
		test.push(3);
		System.out.println(test.min());
		test.pop();
		System.out.println(test.min());
		test.pop();
		System.out.println(test.min());
		test.pop();
		System.out.println(test.min());
		test.push(0);
		System.out.println(test.min());
	}
}