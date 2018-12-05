/**
	本题考查复杂图像下找规律的能力,同时还需要极其严谨的边界值判断,本题涉及到大量的数组边界值判断!
	
	输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
	例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
	 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
package Offer_20;
import java.util.ArrayList;
public class Solution2 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
    	int rows = matrix.length;
    	int columns = matrix[0].length;
    	int start = 0;
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	while (rows>start*2 && columns>start*2) {
			this.printRowOrColumn(matrix, start, rows, columns, res);
			start++;
		}
    	return res;
    }
    public void printRowOrColumn(int[][] array, int start, int rows, int columns, ArrayList<Integer> res){
    	int endX = columns - 1 - start;
    	int endY = rows - 1 - start;
    	for (int i = 0; i < endX; i++) {
			res.add(array[start][i]);
		}
    	if (start<endY) {
    		for (int i = start; i <= endY; i++) {
				res.add(array[i][endX]);
			}
		}
    	if (start<endX && start<endY) {
    		for (int i = endX; i >= start; i--) {
				res.add(array[i][endY]);
			}
		}
    	if (start < endX && start < endY-1) {
			for (int i = endY-1; i > start; i--) {
				res.add(array[i][start]);
			}
		}
    }
    public static void main(String[] args) {
    	Solution2 test = new Solution2();
		int[][] array = {{1},{2},{3},{4},{5}};
		ArrayList<Integer> list = test.printMatrix(array);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
    }
}