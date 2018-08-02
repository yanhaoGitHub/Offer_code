/**
 * AC!
 * @author Think Different_YH
 *把只包含因子2、3和5的数称作丑数（Ugly Number）。
 *例如6、8都是丑数，但14不是，因为它包含因子7。 
 *习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
package Offer_34;
import java.util.ArrayList;
public class Solution {
	//笨办法，需要判断每个数是不是丑数
	public boolean judgeChouShu(int n) {
		while (n%2==0) {n /= 2;}
		while (n%3==0) {n /= 3;}
		while (n%5==0) {n /= 5;}
		if (n == 1) {
			return true;
		}else {
			return false;
		}
	}
	public int judge(int n) {
		int num = 0;
		int ChouShuNum = 0;
		while (ChouShuNum < n) { //循环条件
			num++;
			if (this.judgeChouShu(num) == true) {
				ChouShuNum++;
			}
		}
		return num;
	}
	
	//方法二，空间换时间
	//该思路： 我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的
	public int judge2(int index) {
		if (index <= 0) {
			return 0;
		}
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		int i2=0, i3=0, i5 = 0;
		while (list.size() < index) {
			int m2 = list.get(i2)*2;
			int m3 = list.get(i3)*3;
			int m5 = list.get(i5)*5;
			int min = Math.min(m2, Math.min(m3, m5));
			list.add(min);
			if (min == m2) {
				i2++;
			}
			if (min == m3) {
				i3++;
			}
			if (min == m5) {
				i5++;
			}
		}
		return list.get(list.size() - 1);
	}
	
	public static void main(String[] args) {
		Solution test = new Solution();
		System.out.println(test.judge(1500));//859963392
		System.out.println(test.judge(1500));//859963392
	}
}
