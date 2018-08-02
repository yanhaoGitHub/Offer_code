/**
 * AC!
 * 
 * 连续子数组的最大和？
 */
package Offer_31;
public class Solution {
	//普通算法
	public int FindGreatestSumOfSubArray(int[] array) {
    	if(array.length==0){
    		return 0;
    	}else {
    		int total = array[0];
 			int result = array[0];
 			for (int i = 1; i < array.length; i++) {
 				if (total >= 0) {
					total += array[i];
				}else {
					total = array[i];
				}
 				if (total > result) {
					result = total;
				}
 			}
 			return result;
		}
    }
    //动态规划
	public int FindGreatestSumOfSubArray2(int[] array) {
		if (array==null || array.length==0) {
			return 0;
		}
		int temp = array[0];
		int result = array[0];
		for (int i = 1; i < array.length; i++) {
			temp = Math.max(temp+array[i], array[i]);
			result = Math.max(temp, result);
		}
		return result;
	}
	
    public static void main(String[] args) {
		Solution test = new Solution();
		int[] array = {1,-2,3,10,-4,7,2,-5};
		System.out.println(test.FindGreatestSumOfSubArray2(array));
		 
		int[] array2 = {-2,-8,-1,-5,-9};
		System.out.println(test.FindGreatestSumOfSubArray2(array2));
		
		int[] array3 = {2,8,1,5,9};
		System.out.println(test.FindGreatestSumOfSubArray2(array3));
    }
}