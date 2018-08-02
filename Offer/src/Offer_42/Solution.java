/**
 *  AC!
	小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
	但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
	没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
	现在把问题交给你,你能不能也很快的找出所有和为S的【连续正数序列】? Good Luck!
	输出描述:
		输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
package Offer_42;
import java.util.ArrayList;
public class Solution {
	ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
	ArrayList<Integer> numberList = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
    	int start = 1;
    	int end = 2;
    	numberList.add(start);
    	numberList.add(end);
    	while (numberList.size() >= 2) {
    		if (this.sumOfList(numberList) == sum) {
    			lists.add(this.copyList(numberList));
    			numberList.add(++end);
    		}else if (this.sumOfList(numberList) < sum) {
				numberList.add(++end);
			}else {
				numberList.remove(0);
			}
		}
    	return lists;
	}
	public int sumOfList(ArrayList<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum+=list.get(i);
		}
		return sum;
	}
	public ArrayList<Integer> copyList(ArrayList<Integer> list2) {
		ArrayList<Integer> list1 = new ArrayList<>();
		for (int i = 0; i < list2.size(); i++) {
			list1.add(list2.get(i));
		}
		return list1;
	}
	public static void main(String[] args) {
		Solution test = new Solution();
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		lists = test.FindContinuousSequence(100);
		for (int i = 0; i < lists.size(); i++) {
			ArrayList<Integer> temp = lists.get(i);
			for (int j = 0; j < temp.size(); j++) {
				System.out.print(temp.get(j)+" ");
			}
			System.out.println();
		}
	}
}