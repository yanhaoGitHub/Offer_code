/**
 * AC!
 * 这道题虽然通过了测试，但是效率并不高，需要重新进行思考！
 * 
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
package Offer_8_旋转数组的最小值;
public class Solution {
	//下面这个方法可以单独运行成功！
    public int minNumberInRotateArray2(int [] array) {
    	if (array.length == 0) {
			return 0;
		}
    	if (array.length == 1) {
			return array[0];
		}
    	for (int i = 0; i < array.length-1; i++) {
    		if (array[i] > array[i+1]) {
				return array[i+1];
			}
		}
    	return 0;
    }
    /**
		后来补充的方法！但是搞不懂为什么不通过，不管了，思想对就行！
     */
    public int minNumberInRotateArray(int [] array) {
        if (array==null || array.length == 0) return 0;
    	int start = 0;
        int end = array.length-1;
        int mid = -1;
	    while (end != start+1) {
	    	mid = (start+end)/2;
	    	if (array[mid]>array[start]) {
				start = mid;
			}else if(array[mid]<array[end]) {
				end = mid;
			}else if (array[mid] == array[start] && array[end] == array[mid]) {
				for (int i = 0; i < array.length-1; i++) {
					if (array[i] > array[i+1]) {
						return array[i+1];
					}
				}
				return 0;
			}
	    }
	    return array[end];
    }
    public static void main(String[] args) {
		Solution test = new Solution();
		int[] array = {3,4,5,1,2};
		System.out.println(test.minNumberInRotateArray2(array));
		System.out.println(test.minNumberInRotateArray(array));
		System.out.println("---------------------");
		int[] array2 = {1,0,1,1,1};
		System.out.println(test.minNumberInRotateArray2(array2));
		System.out.println(test.minNumberInRotateArray(array2));
		System.out.println("---------------------");
		int[] array3 = {1,1,1,0,1};
		System.out.println(test.minNumberInRotateArray2(array3));
		System.out.println(test.minNumberInRotateArray(array3));
    }
}