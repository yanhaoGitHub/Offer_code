/**
 *  AC!
	写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 	思路：位运算
	考虑位运算，分三步：
	第一步：不进位加 num1
	第二步：计算进位 num2
	第三步：num1 和 num2求和（重复第一步，直到进位为0，即num2=0)
	在第一步中，采用异或
	第二步中，采用按位与，左移一位
 */
package Offer_49;
public class Solution {
    public int Add(int num1,int num2) {
    	while (num2 != 0) {
    		int sum = num1 ^ num2;
    		int carry = (num1 & num2)<<1;
    		num1 = sum;
    		num2 = carry;
    	}
    	return num1;
    }
}