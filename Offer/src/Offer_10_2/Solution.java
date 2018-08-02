/**
   AC!
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分(！！！并保证奇数和奇数，偶数和偶数之间的相对位置不变！！！本题暂时不要括号里面的要求)。
 */
package Offer_10_2;
public class Solution {
    public void reOrderArray(int [] array) {
    	int start = 0;
    	int end = array.length-1;
    	int temp;
    	while (start < end) {
    		//注意下面的(start<end)&&条件必须要加上，否则最中间的相邻的两个数会出现位置问题
			while ((start<end)&&(array[start]%2) != 0) {  //让start指针始终寻找从左到右的第一个偶数，并指向它
				start++;
			}
    		while ((start<end)&&(array[end]%2) == 0) {  //让end指针始终寻找从右向左的第一个奇数，并指向它  
				end--;
			}
    		if (start < end) {   //这个判断条件也要加上
        		temp = array[end];
        		array[end] = array[start];
        		array[start] = temp;
			}
		}
    	for (int i = 0; i < array.length; i++) {
			System.out.print(" "+array[i]);
		}
    }
    public static void main(String[] args) {
    	int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
    	Solution test = new Solution();
    	test.reOrderArray(array);
    }
}