/**
 * AC!
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
package Offer_43;
import java.util.ArrayList;
public class Solution {
	ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
	ArrayList<Integer> list = new ArrayList<>();
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		int start = 0;
		int end = array.length-1;
		while (start <= end) {
			if (array[start]+array[end] == sum) {
				ArrayList<Integer> tempList = new ArrayList<>();
				tempList.add(array[start]);
				tempList.add(array[end]);
				lists.add(tempList);
				start++;
				end--;
			}else if (array[start]+array[end] > sum) {
				end--;
			}else if (array[start]+array[end] < sum) {
				start++;
			}
		}
		//System.out.println("lists.size="+lists.size());
		return this.result(lists);
    }
	/**
		注意本题有个细节，下面这个函数用来求和相同的一组值中乘积最小的一组值
		其实有个窍门a+b=sum,a和b越远乘积越小，而一头一尾两个指针往内靠近的方法找到的就是乘积最小的情况。
		如果是乘积最大的情况就是一直找到两个指针重合，每次找到一个就将之前返回的结果向量清空然后更新为新找到的。
		也就是说，如果最后要求返回乘积最小的一组值，则第一次查找到的就是要返回的那组值，但是如果是要求返回乘积最大的一组值
		则需要遍历到start和end指针重合为止才行！
		【注】a小b大，b-a>0;a+b=sum;a+n+b-n=sum;(a+n)(b-n)=ab+n(b-a)>ab;所以和相同时ab越远乘积越小.
	 */
	public ArrayList<Integer> result(ArrayList<ArrayList<Integer>> lists) {
		int Minji = 10000;
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < lists.size(); i++) {
			ArrayList<Integer> temp = lists.get(i);
			if (this.getJiFromArrayList(temp) < Minji) {
				Minji = this.getJiFromArrayList(temp);
				result = temp;
			}
		}
		return result;
	}
	public int getJiFromArrayList(ArrayList<Integer> list) {
		return list.get(0)*list.get(1);
	}
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] array = {0,1,2,4,7,11,15};
		ArrayList<Integer> list = test.FindNumbersWithSum(array, 15);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}