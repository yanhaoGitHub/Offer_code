/**
 *  AC!
	在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
	请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
package Offer_3;
public class Solution {
    public boolean Find(int target, int [][] array) {
    	int arr_rows = array.length-1;
    	boolean flag = false;
    	int columns = array[0].length-1;
    	int rows = 0;
    	while (columns>=0 && rows<=arr_rows) {  //这里的两个条件必须满足，否则下标会越界！
			if (array[rows][columns] == target) {
				//System.out.println("找到了！");
				flag = true;
				break;
			}else if (array[rows][columns] < target) {
				rows++;
			}else {
				columns--;
			}
		}
    	return flag;
    }
    public static void main(String[] args) {
		int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		Solution test = new Solution();
		System.out.println(test.Find(30, arr));
	}
}	
