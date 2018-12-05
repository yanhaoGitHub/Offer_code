/**
	AC!   2018-10-24!
	定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
package Offer_21;
import java.util.Stack;
public class Solution3 {
	Stack<Integer> data = new Stack<>();
	Stack<Integer> minStack = new Stack<>();
	public void push(int num) {
		if (!minStack.isEmpty() && !data.isEmpty()) {
			if (minStack.peek() > num) {
				data.push(num);
				minStack.push(num);
			}else {
				data.push(num);
				minStack.push(minStack.peek());
			}
		}else {
			data.push(num);
			minStack.push(num);
		}
	}
	
	public void pop() {
		if (!data.isEmpty()) {
			data.pop();
		}
		if (!minStack.isEmpty()) {
			minStack.pop();
		}
	}
	
	public int min() {
		return minStack.peek();
	}
    public static void main(String[] args) {
		Solution3 test = new Solution3();
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