/**	#斐波那契数列的排列是：1，1，2，3，5，8，13，21，34，55，89，144
	#注意，第一个数是1，这个数是第一项，并不是第0项！！
	#第11项是89，而不是144，注意下表是从1开始计算的，并不是从0开始计算！
	#第1项是1，第二项也是1，第三项是2，第0项是0！！！
	
	我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
	请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
package Offer_9_4;
public class Solution {
	public int RectCover(int target) {
		int[] array = {0,1,2};
		if (target <= 2) {
			return array[target];
		}
		return RectCover(target-1)+RectCover(target-2);
    }
	public static void main(String[] args) {
    	Solution test = new Solution();
    	System.out.println(test.RectCover(0));
    	System.out.println(test.RectCover(1));
    	System.out.println(test.RectCover(2));
    	System.out.println(test.RectCover(3));
    	System.out.println(test.RectCover(4));
	}
}
