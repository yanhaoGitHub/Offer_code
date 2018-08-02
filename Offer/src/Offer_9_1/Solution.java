/**
 *  大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项, n<=39
	
	#斐波那契数列的排列是：1，1，2，3，5，8，13，21，34，55，89，144
	#注意，第一个数是1，这个数是第一项，并不是第0项！！
	#第11项是89，而不是144，注意下表是从1开始计算的，并不是从0开始计算！
	#第1项是1，第二项也是1，第三项是2，第0项是0！！！
	
	本道题使用递归方法，结果发现同样的代码java语言不会产生栈溢出，而python语言就栈溢出了，随意显然这道题递归是不行的，系统肯定会给一个特别大的n让递归代码出现栈溢出现象
	
	所以本道题考虑到性能原因，使用迭代来计算，也就是从头开始计算，一直计算到n，同时计算的每一步都要保存计算结果
 */
package Offer_9_1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int Fibonacci(int n) {  //递归方法，舍弃，性能太差
    	if (n==0) {
			return 0;
    	}else if (n == 1) {
			return 1;
		}
    	return Fibonacci(n-1) + Fibonacci(n-2);
    }
    public int Fibonacci2(int n) {  //迭代方法,效率比上面的方法高！
    	int target = 0, one=0, two=1;
    	if (n==0) {
			return 0;
		}
    	if (n==1) {
			return 1;
		}
    	for (int i = 2; i <= n; i++) {
    		target = one+two;
    		one = two;
    		two = target;
		}
    	return target;
    }
    
    public static void main(String[] args) {
		Solution test = new Solution();
		System.out.println(test.Fibonacci2(0));
		System.out.println(test.Fibonacci2(1));
		System.out.println(test.Fibonacci2(2));
		System.out.println(test.Fibonacci2(3));
		System.out.println(test.Fibonacci2(11));
	}
}