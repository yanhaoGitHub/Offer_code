/**
 * 	AC!
 * 	本题使用方法一:快速排序法查找k值！

	输入n个整数，找出其中最小的K个数。
	例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

	注意:按照题目中的要求，如果输入数组的长度刚好等于k的话，则将数组中的元素封装进list，返回即可。
					 如果输入数组的长度小于k的话，则返回一个空的list。
					 如果输入数组的长度大于k的话，正常使用下面的两个辅助函数进行求解。
 */
package Offer_30_快排_堆排序;
import java.util.*;
public class Solution {
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (input.length == k) {
			for (int i = 0; i < input.length; i++) {
				list.add(input[i]);
			}
			return list;
		}else if (input.length < k) {
			return list;
		}else {
			this.digui(input, 0, input.length-1, k,list);
			return list;
		}
    }
	//自己写的递归函数，仿照快排的方法查找k值。
	public void digui(int[] array, int start, int end,int k, ArrayList<Integer> list){
		int dp = this.partition(array, start, end);
		if (dp == k) {
			for (int i = 0; i < k; i++) {
				list.add(array[i]);
			}
			return;
		}else if (dp<k) {
			this.digui(array, dp+1, end, k, list);
		}else{
			this.digui(array, start, dp-1, k, list);
		}
	}
    public int partition(int[] array, int start, int end) {
    	int temp = array[start];
    	int i = start;
    	int j = end;
    	while (i != j) {
			while (array[j]>=temp && i<j) {
				j--;
			}
			while (array[i]<=temp && i<j) {
				i++;
			}
    		if (i<j) {
				int temp2 = array[j];
				array[j] = array[i];
				array[i] = temp2;
			}
		}
    	array[start] = array[i];
    	array[i] = temp;
    	return i;
    }
    
    public static void main(String[] args) {
    	Solution test = new Solution();
    	int[] array1 = {4,5,1,6,2,7,3,8};
    	ArrayList<Integer> list = test.GetLeastNumbers_Solution(array1, 4);
    	for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
    	System.out.println();
    	int[] array2 = {4,5,1,6,2,7,3,8};
    	ArrayList<Integer> list2 = test.GetLeastNumbers_Solution(array2, 8);
    	for (int i = 0; i < list2.size(); i++) {
			System.out.print(list2.get(i)+" ");
		}
    	System.out.println();
    	int[] array3 = {4,5,1,6,2,7,3,8};
    	ArrayList<Integer> list3 = test.GetLeastNumbers_Solution(array3, 10); //返回空list
    	for (int i = 0; i < list3.size(); i++) {
			System.out.print(list3.get(i)+" ");
		}
    }
}