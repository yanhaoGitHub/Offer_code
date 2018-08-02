/**
 *  AC!
	定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
package Offer_21;
import java.util.Stack;
public class Solution {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
    	if (stack1.isEmpty()) {
			stack1.push(node);
			stack2.push(node);
		}else {
			int temp = stack2.peek();  //注意这里是取栈2的栈顶元素和新进来的元素进行比较，而不是栈1的栈顶元素！！
			stack1.push(node);
			if (temp > node) {
				stack2.push(node);
			}else {
				stack2.push(temp);
			}
		}
    }
    public void pop() {
    	if (!stack1.isEmpty()) {
			stack1.pop();
			stack2.pop();  //注意这里在弹出元素的时候,两个栈要同时弹出元素，之前自己忘记栈2弹出元素了！！
		}
    }
    public int top() {
    	return stack1.peek();
    }
    public int min() {
    	return stack2.peek();
    }
    
    public static void main(String[] args) {
		Solution test = new Solution();
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