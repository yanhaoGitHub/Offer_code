/**
 * AC!
 * @author Think Different_YH
 * 统计一个数字在[排序数组]中出现的次数。
 */
package Offer_38;
public class Solution {
	//笨办法，时间复杂度O（n）
    public int GetNumberOfK2(int [] array , int k) {
    	int count = 0;
    	for (int i = 0; i < array.length; i++) {
			if (array[i] == k) {
				count++;
			}
		}
    	return count;
    }
    //方法二，使用二分查找法找出k第一次出现的下标以及最后一次出现的下标，时间复杂度较方法一小！
    public int GetNumberOfK(int [] array , int k) {
        int firstIndex = this.getFirstIndex(array, k,0,array.length-1);
        int lastIndex = this.getLastIndex(array, k, 0, array.length-1);
        if (firstIndex == -1) {  //数组中没有找到这个数。
			return 0;
		}else {
	        return lastIndex-firstIndex+1;
		}
    }
    //递归找出k第一次出现的下标
    public int getFirstIndex(int[] array, int k, int start, int end) {
    	if (start <= end) {
    		int mid = (start+end)>>1;
    		if (array[mid] == k) { //在这里需要动些手脚.
				int temp = mid-1;
    			if (temp<start || array[temp] != k) {//如果temp<start或者mid的前一个数字不是k了，则mid是k第一次出现的位置。
					return mid;
				}else {
					return this.getFirstIndex(array, k, start, temp);
				}
			}else if (array[mid] < k){
				return this.getFirstIndex(array, k, mid+1, end);
			}else {
				return this.getFirstIndex(array, k, start, mid-1);
			}
		}else {
			return -1;
		}
    }
    //找出k最后一次出现的位置
    public int getLastIndex(int[] array, int k, int start, int end) {
    	if (start <= end) {
			int mid = (start+end)>>1;
    		if (array[mid] == k) {
    			int temp = mid+1;
    			if (temp>end || array[temp]!=k) {
					return mid;
				}else {
					return this.getLastIndex(array, k, temp, end);
				}
			}else if (array[mid] < k) {
				return this.getLastIndex(array, k, mid+1, end);
			}else {
				return this.getFirstIndex(array, k, start, mid-1);
			}
		}else {
			return -1;
		}
    }
    public static void main(String[] args) {
		Solution test = new Solution();
		int[] array = {1,2,3,3,3,3,4,4,4,5};
		System.out.println(test.GetNumberOfK(array, 3));
    }
}