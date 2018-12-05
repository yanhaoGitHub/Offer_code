/**
 *  AC  2018/10/31
 *  	输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
	假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
	序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
	（注意：这两个序列的长度是相等的）
	【思路】借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，这里是1，
	然后判断栈顶元素是不是出栈顺序的第一个元素，这里是4，很显然1≠4，所以我们继续压栈，
	直到相等以后开始出栈，出栈一个元素，则将出栈顺序向后移动一位，直到不相等，
	这样循环等压栈顺序遍历完成，如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。
	举例：
	入栈1,2,3,4,5
	出栈4,5,3,2,1
	首先1入辅助栈，此时栈顶1≠4，继续入栈2
	此时栈顶2≠4，继续入栈3
	此时栈顶3≠4，继续入栈4
	此时栈顶4＝4，出栈4，弹出序列向后一位，此时为5，,辅助栈里面是1,2,3
	此时栈顶3≠5，继续入栈5
	此时栈顶5=5，出栈5,弹出序列向后一位，此时为3，,辅助栈里面是1,2,3
	….
	依次执行，最后辅助栈为空。如果不为空说明弹出序列不是该栈的弹出顺序。
 */
package Offer_22;
import java.util.Stack;
public class Solution2 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	Stack<Integer> stack = new Stack<Integer>();
    	int index = 0;
    	for (int i = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while ((!stack.isEmpty()) && (stack.peek() == popA[index])) {
				stack.pop();
				index++;
			}
		}
    	return stack.isEmpty();
    }
    public static void main(String[] args) {
		Solution2 test =  new Solution2();
		int[] pushA = {1,2,3,4,5};
		int[] popA1 = {4,5,3,2,1};
		int[] popA2 = {4,3,5,1,2};
		System.out.println(test.IsPopOrder(pushA, popA1)); //true
		System.out.println(test.IsPopOrder(pushA, popA2)); //false
    }
}