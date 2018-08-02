/**AC!
	题目：如果字符串一的所有字符按其在字符串中的顺序出现在另外一个字符串二中，
则字符串一称之为字符串二的子串。
注意，并不要求子串（字符串一）的字符必须连续出现在字符串二中。
请编写一个函数，输入两个字符串，求它们的最长公共子串，并打印出最长公共子串。
例如：输入两个字符串 BDCABA 和 ABCBDAB，字符串 BCBA 和 BDAB 都是是它们的最
长公共子序列，则输出它们的长度 4，并打印任意一个子序列
*/
package Offer_66_动态规划_最长公共子序列;
public class Solution {
	public static void main(String[] args){
		String x = "BDCABA";
		String y = "ABCBDAB";
		int x_len = x.length();
		int y_len = y.length(); //具体大小可自行设置
		System.out.println("字符串1:"+x);
		System.out.println("字符串2:"+y);
		Long startTime = System.nanoTime();
		// 构造二维数组记录子问题 x[i]和 y[i]的 LCS 的长度
		int[][] opt = new int[x_len + 1][y_len + 1];
		// 动态规划计算所有子问题
		for (int i = x_len - 1; i >= 0; i--){
			for (int j = y_len - 1; j >= 0; j--){
				if (x.charAt(i) == y.charAt(j)) {
					opt[i][j] = opt[i + 1][j + 1] + 1; //参考上文我给的公式。
				}else {
					opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]); //参考上文我给的公式。
				}
			}
		}
		//打印出这个二维数组！
		for (int i = 0; i < opt.length; i++) {
			for (int j = 0; j < opt[0].length; j++) {
				System.out.print(opt[i][j]);
			}
			System.out.println();
		}
		
		System.out.print("LCS:");
		int i = 0, j = 0;
		while (i < x_len && j < y_len){
			if (x.charAt(i) == y.charAt(j)){
				System.out.print(x.charAt(i));
				i++;	
				j++;
			} else if (opt[i + 1][j] >= opt[i][j + 1]) { //注意这里如果把=去掉，则最终的结果就是BDAB了，而不是现在的BCBA.
				i++;
			}else {
				j++;
			}
		}
		Long endTime = System.nanoTime();
		System.out.println();
		System.out.println("总耗时:" + (endTime - startTime) + " ns");
	}
}