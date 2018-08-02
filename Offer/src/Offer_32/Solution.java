/**
 * AC!
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */
package Offer_32;
public class Solution {
	//最直观的解法，但是复杂度比较高！
	//分别计算每个数中1出现的个数，然后进行累加！
    public int NumberOf1Between1AndN_Solution(int n) {
    	int count = 0;
    	if (n<=0) {
			return 0;
		}
    	for (int i = 1; i <= n; i++) {
			count += this.compute(i);
		}
    	return count;
    }
    //将一个数对10取余，若余数等于1则说明该数的个位数是1，然后将该数除以10，
    //再对10取余，判断余数是否等于1，若等于1，则说明该数的十位上数字为1！
    public int compute(int n) {
    	int num = 0;
    	while (n>0) {
			if (n%10 == 1) {
				num++;
			}
			n/=10;
		}
    	return num;
    }
    
    /**
		方法二，左神的解法
     */
    public int NumberOf1Between1AndN_Solution2(int n){
    	if (n<1) {
			return 0;
		}
    	int len = lenOfN(n);
    	if (len == 1) {
			return 1;
		}
    	int tmp1 = powerBaseOf10(len-1);
    	int first = n/tmp1; //得到数字的最高位的那个数！
    	int firstOneNum = first==1? n%tmp1+1 : tmp1;
    	int otherOneNum = first * (len-1) * (tmp1/10);
    	return firstOneNum + otherOneNum + NumberOf1Between1AndN_Solution2(n%tmp1);
    }
    public int lenOfN(int n){  //求一个整数有几位！
    	int len = 0;
    	while (n != 0) {
    		len++;
    		n/=10;
		}
    	return len;
    }
    public int powerBaseOf10(int base){
    	return (int)Math.pow(10, base);
    }
    
    public static void main(String[] args) {
		Solution test = new Solution();
		System.out.println(test.NumberOf1Between1AndN_Solution2(10));
    }
}