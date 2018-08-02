/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变!!!
 */
package Offer_10_3;
public class Solution {
	//  AC! 方法一:重新建一个数组，遍历原数组，将奇数和偶数分别插入即可，好处是时间复杂度小，但是需要多余空间！
	//时间复杂度O(N),空间复杂度O(N)
	public void reOrderArray(int [] array) {
		int[] array2 = new int[array.length];
		int index = 0; //遍历原数组得到有多少个奇数
		for (int i = 0; i < array.length; i++) {
			if ((array[i]%2) == 1) {
				index++;
			}
		}
		int jishuIndex = 0;  //采用新数组存放奇数的开始下标
		int oushuIndex = index;  //采用新数组存放偶数的开始下标
		for (int i = 0; i < array.length; i++) {
			if ((array[i]%2) == 1) {
				array2[jishuIndex] = array[i];
				jishuIndex++;
			}else if ((array[i]%2) == 0) {
				array2[oushuIndex] = array[i];
				oushuIndex++;
			}
		}
		for (int i = 0; i < array2.length; i++) {  //把array2的值给array,注意这里之前写array = array2,并没有把array2的值给array!
			array[i] = array2[i];
		}
	}
	//方法二:不额外申请数组，但是时间复杂度会比较大！
	//空间复杂度O(1),时间复杂度O(N^2)
    public void reOrderArray2(int [] array) {
    	for (int i = 0; i < array.length; i++) {
    		if ((array[i]%2) == 1) { //若当前数是偶数
    			int temp = array[i]; //！！！注意这里必须先把array[i]这个奇数保存起来，不然一会偶数后移之后就找不到了！
    			int j = i; //暂时记下这个奇数的位置
    			while (j>0 && (array[j-1]%2)==0) {  //把这个奇数之前所有的偶数都后移一位
					array[j] = array[j-1];
					j--;
				}
    			array[j] = temp; //将这个奇数放在后移偶数的最前面位置，即它的最终位置
			}
		}
    }
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		Solution test = new Solution();
		test.reOrderArray2(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
}