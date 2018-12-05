/**
	输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
	如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
package Offer_24;
public class Solution3 {
	//递归解法.
    public boolean judgeTree(int[] array, int start, int end) {
    	if (start >= end) {
			return true;
		}
    	
    	int tmp = end-1;
    	/*while (start<=end && (array[tmp]>array[end])) {  //这种写法也行
			tmp--;
		}*/
    	while (start<tmp &&(array[tmp-1]>array[end])) {
			tmp--;
		}
    	
    	for (int i = tmp-1; i >= start; i--) {
			if (array[i] > array[end]) {
				return false;
			}
		}
    	return this.judgeTree(array, start, tmp-1) && this.judgeTree(array, tmp, end-1);
    }
    //非递归解法,解法思路参见Solution中！
    public boolean judgeTree2(int[] array) {
    	int size = array.length;
    	int i = 0;
    	while (size>0) {
			while (array[i] < array[size-1]) {
				i++;
			}
			while (array[i] > array[size-1]) {
				i++;
			}
			if (i != size-1) {
				return false;
			}
			size--;
			i=0;
		}
    	return true;
    }
    public static void main(String[] args) {
		Solution3 test = new Solution3();
		int[] array1 = {3,5,4,7,9,8,6};
		System.out.println(test.judgeTree2(array1)); //true
		int[] array3 = {3,5,4,2,9,8,6};
		//true,注意，这里虽然自己把array1中的7改成了2希望结果能够为fasle,但是结果却为true，
		//仔细思考了下，发现此时二叉搜索树的结构已经发生了变化，但是却仍然是一颗搜索树。
		System.out.println(test.judgeTree2(array3)); 
		int[] array2 = {3,10,4,8,6};
		System.out.println(test.judgeTree2(array2)); //false
	}
}