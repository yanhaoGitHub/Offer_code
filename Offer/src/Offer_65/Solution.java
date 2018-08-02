/**
	给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
	例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
	他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
	{[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，{2,3,[4,2,6],2,5,1}，
	 {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
	 
	 思路：这道题可以用双向队列解决(就是头尾都可以push，pop的队列)，时间复杂度 O(N)
*/
package Offer_65;
import java.util.ArrayList;
import java.util.LinkedList;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> result = new ArrayList<Integer>();
    	if (num.length == 0 || size<=0 || num.length < size) {
        	return result;
		}
    	//双端队列，用来记录每个窗口的最大值下标
    	LinkedList<Integer> queue = new LinkedList<Integer>();
    	for (int i = 0; i < num.length; i++) {
    		//当我们遇到新数时候，将新的数和双向队列的末尾比较，如果末尾比新数小，则把末尾pop_back，直到末尾比新数大或者队列为空才停止；
    		while (!queue.isEmpty() && (num[queue.peekLast()]<num[i])) {
				queue.pollLast();
			}
    		queue.addLast(i);
    		//判断队首元素是否过期
    		if (queue.peekFirst() == i-size) {
				queue.pollFirst();
			}
    		//向result列表中加入元素
    		if (i >= size-1) {
				result.add(num[queue.peekFirst()]);
			}
		}
    	return result;
    }
    public static void main(String[] args) {
		Solution test = new Solution();
		int[] num = {2,3,4,2,6,2,5,1};
		ArrayList<Integer> list = test.maxInWindows(num, 3);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}