package Offer_7;
import java.util.Stack;
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();//push
    Stack<Integer> stack2 = new Stack<Integer>();//pop
    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
    	int temp = 0;
    	if (!stack2.isEmpty()) {
			temp = stack2.pop();
		}else {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			temp = stack2.pop();  
		}
    	return temp;
    }
    
    public static void main(String[] args) {
    	Solution test = new Solution();
    	test.push(1);
    	test.push(2);
    	test.push(3);
    	System.out.println(test.pop());
    	System.out.println(test.pop());
    	System.out.println(test.pop());
	}
}