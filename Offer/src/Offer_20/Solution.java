/**
 *  AC!
	本题考查复杂图像下找规律的能力,同时还需要极其严谨的边界值判断,本题涉及到大量的数组边界值判断!
	
	输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
	例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
	 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
package Offer_20;
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
    	if (matrix == null) {
			return null;
		}
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	int rows = matrix.length;
    	int columns = matrix[0].length;
    	
    	int start = 0;
    	while (rows > 2*start && columns > 2*start) {
    		printRowOrColumn(matrix, start, rows, columns,list);
    		start++;
		}
    	return list;
    }
    public void printRowOrColumn(int[][] array, int start, int rows, int columns, ArrayList<Integer> list){
    	int endX = columns-1-start;
    	int endY = rows-1-start;
    	
    	//从左到右打印一行
		for (int i = start; i <= endX; i++) {
			list.add(array[start][i]);
		}
    	//从上到下打印一列
    	if (start < endY) {
    		for (int i = start+1; i <= endY; i++) {
				list.add(array[i][endX]);
    		}
		}
    	//从右到左打印一行
    	if (start < endX && start < endY) {
    		for (int i = endX-1; i >= start; i--) {
    			list.add(array[endY][i]);
    		}
		}
    	//从下到上打印一列
    	//注意这里的start<endX不可缺少，如果少了，对于int[][] array = {{1},{2},{3},{4},{5}};
    	//则会输出1，2，3，4，5，4，3，2不正确，正确输出应该是1，2，3，4，5  
    	//自己体会差别!
    	if (start < endX && start < endY-1) {  
			for (int i = endY-1; i >= start+1; i--) {
				list.add(array[i][start]);
			}
		}
    }
    public static void main(String[] args) {
    	Solution test = new Solution();
		int[][] array = {{1},{2},{3},{4},{5}};
		ArrayList<Integer> list = test.printMatrix(array);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
    }
}