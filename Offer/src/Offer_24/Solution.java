/**
	AC! ,参考别人的代码！
	输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
	如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
package Offer_24;
public class Solution {
	//方法一:递归解法
    public boolean VerifySquenceOfBST(int [] sequence) {
    	if (sequence.length == 0) {
			return false;
		}
    	return judgeTree(sequence, 0, sequence.length-1);
    }
    public boolean judgeTree(int[] array, int start, int end){
    	if (start >= end) {
			return true;
		}
    	int temp = end;
    	while ((temp>start) && array[temp-1] > array[end]) {
			temp--;
		}
    	for (int i = temp-1; i >= start; i--) {
    		if (array[i] > array[end]) {
				return false;
			}
		}
    	return judgeTree(array, start, temp-1) && judgeTree(array, temp, end-1);
    }
    
    //方法二:非递归解法
    public boolean VerifySquenceOfBST2(int[] sequence) {
    	int size = sequence.length;
    	if (size == 0) {
			return false;
		}
    	int i = 0;
    	while (size-->0) {
			while (sequence[i]<sequence[size]) {
				i++;
			}
			while (sequence[i]>sequence[size]) {
				i++;
			}	
    		if (i != size) {
				return false;
			}
    		i=0;
		}
    	return true;
    }
    
    public static void main(String[] args) {
		Solution test = new Solution();
		int[] array1 = {3,5,4,7,9,8,6};
		System.out.println(test.VerifySquenceOfBST2(array1)); //true
		int[] array3 = {3,5,4,2,9,8,6};
		//true,注意，这里虽然自己把array1中的7改成了2希望结果能够为fasle,但是结果却为true，
		//仔细思考了下，发现此时二叉搜索树的结构已经发生了变化，但是却仍然是一颗搜索树。
		System.out.println(test.VerifySquenceOfBST2(array3)); 
		int[] array2 = {3,10,4,8,6};
		System.out.println(test.VerifySquenceOfBST2(array2)); //false
	}
}