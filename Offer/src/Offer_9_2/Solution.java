/**	#斐波那契数列的排列是：1，1，2，3，5，8，13，21，34，55，89，144
	#注意，第一个数是1，这个数是第一项，并不是第0项！！
	#第11项是89，而不是144，注意下表是从1开始计算的，并不是从0开始计算！
	#第1项是1，第二项也是1，第三项是2，第0项是0！！！
	
	一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	思路：首先考虑n等于0、1、2时的特殊情况，f(0) = 0   f(1) = 1  f(2) = 2
        其次，当n=3时，青蛙的第一跳有两种情况：跳1级台阶或者跳两级台阶
        假如跳一级，那么 剩下的两级台阶就是f(2)；假如跳两级，那么剩下的一级台阶就是f(1)，因此f(3)=f(2)+f(1)
        当n = 4时，f(4) = f(3) +f(2),以此类推...........可以联想到Fibonacci数列

 	另外，注意本题和9.1题的差别，9.1题只需要知道前两个数0和1即可，在此之后就呈现Fibonacci数列的规律
 	而本题需要知道前三个数，0，1，2才可以，在此之后才呈现Fibonacci数列的规律
 	注意分析题目！
 */
package Offer_9_2;
public class Solution {
    public int JumpFloor(int target) {  //递归，效率不高！
    	if (target == 0) {
			return 0;
		}else if (target == 1) {
			return 1;
		}else if (target == 2) {
			return 2;
		}
    	return JumpFloor(target-1)+JumpFloor(target-2);
    }
    public int JumpFloor2(int target) { //循环，效率高！
    	int[] array = {0,1,2};
    	if (target <= 2) {
    		return array[target];
		}
    	int steps = 0;
    	int stepOne = 1;  //注意
    	int stepTwo = 2;  //注意
    	for (int i = 3; i <= target; i++) {
    		steps = stepOne + stepTwo;
    		stepOne = stepTwo;
    		stepTwo = steps;
		}
    	return steps;
    }
    	
    public static void main(String[] args) {
    	Solution test = new Solution();
    	System.out.println(test.JumpFloor2(0));
		System.out.println(test.JumpFloor2(1));
		System.out.println(test.JumpFloor2(2));
		System.out.println(test.JumpFloor2(3));
		System.out.println(test.JumpFloor2(11));
    }
}
